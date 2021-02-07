package watchMovie.service.manage;

import org.springframework.beans.factory.annotation.Autowired;
import watchMovie.VO.MovieVO;
import watchMovie.VO.UserLikeMovieVO;
import watchMovie.dao.MovieRepo;
import watchMovie.dao.UserLikeMovieRepo;
import watchMovie.entity.Movie;
import watchMovie.entity.UserLikeMovie;
import watchMovie.form.MovieForm;

import java.util.*;

public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private UserLikeMovieRepo userLikeMovieRepo;

    @Override
    public List<MovieVO> getUnreleaseMovie(){
        List<Movie> movieList=movieRepo.findAllByOnShowIsFalse();
        List<MovieVO> res=new ArrayList<>();
        for(Movie movie:movieList){
            MovieVO movieVO=new MovieVO();
            movieVO.setMovieName(movie.getName());
            movieVO.setPosterURL(movie.getPosterURL());
            movieVO.setId(movie.getId());
            res.add(movieVO);
        }
        return res;
    }

    @Override
    public String releaseMovie(List<MovieForm> movieForms) {
        if(movieForms.isEmpty()){
            return "false";
        }
        for(MovieForm movieForm : movieForms){
            int id=movieForm.getId();
            Movie movie=movieRepo.findById(id);
            movie.setOnShow(true);
            movieRepo.save(movie);
        }
        return "success";
    }

    @Override
    public UserLikeMovieVO userLikeMovieCount(MovieForm movieForm) {
        UserLikeMovieVO userLikeMovieVO=new UserLikeMovieVO();

        userLikeMovieVO.setMovieId(movieForm.getId());
        userLikeMovieVO.setMovieName(movieForm.getName());
        userLikeMovieVO.setUserLikeMovieCount(userLikeMovieRepo.countDistinctByMovieId(movieForm.getId()));
        return userLikeMovieVO;
    }

    @Override
    public UserLikeMovieVO userLikeMovieChangeCount(MovieForm movieForm, Date date) {
        UserLikeMovieVO userLikeMovieVO=new UserLikeMovieVO();

        userLikeMovieVO.setMovieId(movieForm.getId());
        userLikeMovieVO.setMovieName(movieForm.getName());
        userLikeMovieVO.setUserLikeMovieCount(userLikeMovieRepo.countDistinctByMovieIdAndCurrentDate(movieForm.getId(),date));
        return userLikeMovieVO;
    }

    @Override
    public List<UserLikeMovieVO> userLikeMovieCounts() {
        List<Movie> movieList=movieRepo.findAll();
        List<UserLikeMovieVO> userLikeMovieVOList=new ArrayList<>();
        for(Movie movie:movieList){
            UserLikeMovieVO userLikeMovieVO=new UserLikeMovieVO();
            userLikeMovieVO.setMovieId(movie.getId());
            userLikeMovieVO.setMovieName(movie.getName());
            userLikeMovieVO.setUserLikeMovieCount(userLikeMovieRepo.countDistinctByMovieId(movie.getId()));
            userLikeMovieVOList.add(userLikeMovieVO);
        }
        return userLikeMovieVOList;
    }

    @Override
    public List<UserLikeMovieVO> userLikeMovieChangeCounts(Date date) {
        List<Movie> movieList=movieRepo.findAll();
        List<UserLikeMovieVO> userLikeMovieVOList=new ArrayList<>();
        for(Movie movie:movieList){
            UserLikeMovieVO userLikeMovieVO=new UserLikeMovieVO();
            userLikeMovieVO.setMovieId(movie.getId());
            userLikeMovieVO.setMovieName(movie.getName());
            userLikeMovieVO.setUserLikeMovieCount(userLikeMovieRepo.countDistinctByMovieIdAndCurrentDate(movie.getId(),date));
            userLikeMovieVOList.add(userLikeMovieVO);
        }
        return userLikeMovieVOList;
    }

    @Override
    public List<MovieVO> getReleasedMovie(int userId) {
        List<MovieVO> movieVOList=new ArrayList<>();
        List<Movie> movieList=movieRepo.findAllByOnShowIsTrue();
        for(Movie movie:movieList){
            MovieVO movieVO=new MovieVO();

            UserLikeMovie userLikeMovie=userLikeMovieRepo.findByUserIdAndAndMovieId(userId,movie.getId());
            if(userLikeMovie!=null){
                //已经标记过喜欢
                movieVO.setLike(true);
            }
            movieVO.setId(movie.getId());
            movieVO.setPosterURL(movie.getPosterURL());
            movieVO.setMovieName(movie.getName());
            movieVO.setActor(movie.getActor());
            movieVO.setStartDate(movie.getStartDate());

            movieVOList.add(movieVO);
        }
        return movieVOList;
    }

    @Override
    public Movie getDetailedMovie(MovieForm movieForm,int userId) {

        Movie movie=movieRepo.findById(movieForm.getId()).get();
        UserLikeMovie userLikeMovie=userLikeMovieRepo.findByUserIdAndAndMovieId(userId,movieForm.getId());
        if(userLikeMovie!=null){
            movie.setLike(true);
        }
        return movie;
    }

    @Override
    public void likeMovie(MovieForm movieForm, int userId) {
        UserLikeMovie userLikeMovie=userLikeMovieRepo.findByUserIdAndAndMovieId(userId,movieForm.getId());
        if(userLikeMovie!=null){
            //如果已经标注过喜欢，则取消
            userLikeMovieRepo.delete(userLikeMovie);
        }else{
            //标注为喜欢
            userLikeMovie=new UserLikeMovie();
            userLikeMovie.setUserId(userId);
            userLikeMovie.setMovieId(movieForm.getId());
            userLikeMovie.setCurrentDate(Calendar.getInstance());
            userLikeMovieRepo.save(userLikeMovie);
        }
    }
}

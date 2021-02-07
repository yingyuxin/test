package watchMovie.controller.Manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import watchMovie.VO.MovieVO;
import watchMovie.VO.UserLikeMovieVO;
import watchMovie.entity.Movie;
import watchMovie.form.MovieForm;
import watchMovie.service.manage.MovieService;
import java.util.Date;
import java.util.List;

@RestController
public class MovieController {

    private final static String RELEASEMOVIE_ERROR = "上架电影不能为空";

    @Autowired
    private MovieService movieService;

    /**
     * 得到所有未上架的电影
     * @return
     */
    @RequestMapping("movie/getUnreleaseMovie")
    public List<MovieVO> getUnreleaseMovie(){
        return movieService.getUnreleaseMovie();
    }

    /**
     * 管理员上架电影
     * @param movieForms
     * @return
     */
    @PostMapping ("movie/releaseMovie")
    public String releaseMovie(List<MovieForm> movieForms){
        String res = movieService.releaseMovie(movieForms);
        if(!res.equals("success")){
            return RELEASEMOVIE_ERROR;
        }else{
            return res;
        }
    }

//    /**
//     * 统计某个电影的想看人数
//     * @param movieForm
//     * @return
//     */
//    @RequestMapping("movie/userLikeMovieCount")
//    public UserLikeMovieVO userLikeMovieCount(MovieForm movieForm){
//        return movieService.userLikeMovieCount(movieForm);
//    }

    /**
     * 统计某个电影在某天的想看人数
     * @param movieForm
     * @param date
     * @return
     */
    @RequestMapping("movie/userLikeMovieChangeCount")
    public UserLikeMovieVO userLikeMovieChangeCount(MovieForm movieForm, Date date){
        return movieService.userLikeMovieChangeCount(movieForm,date);
    }

    /**
     * 统计所有电影的想看人数
     * @return
     */
    @RequestMapping("movie/userLikeMovieCounts")
    public List<UserLikeMovieVO> userLikeMovieCounts(){
        return movieService.userLikeMovieCounts();
    }

//    /**
//     * 统计所有电影在某一天的喜欢人数
//     * @param date
//     * @return
//     */
//    @RequestMapping("movie/userLikeMovieChangeCounts")
//    public List<UserLikeMovieVO> userLikeMovieChangeCounts(Date date){
//        return movieService.userLikeMovieChangeCounts(date);
//    }

    /**
     * 得到所有已经上架的电影
     */
    @RequestMapping("movie/getReleasedMovie")
    public List<MovieVO> getReleasedMovie(int userId){
        return movieService.getReleasedMovie(userId);
    }

    /**
     * 得到某个电影的详情页
     * @param movieForm
     * @param userId
     * @return
     */
    @RequestMapping("movie/getDetailedMovie")
    public Movie getDetailedMovie(MovieForm movieForm,int userId){
        return movieService.getDetailedMovie(movieForm,userId);
    }

    /**
     * 标注或者取消想看
     * @param movieForm
     * @param userId
     */
    @PostMapping("movie/like")
    public void likeMovie(MovieForm movieForm,int userId){
        movieService.likeMovie(movieForm,userId);
    }
}

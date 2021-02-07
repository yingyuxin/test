package watchMovie.service.manage;

import watchMovie.VO.MovieVO;
import watchMovie.VO.UserLikeMovieVO;
import watchMovie.entity.Movie;
import watchMovie.form.MovieForm;

import java.util.Date;
import java.util.List;

public interface MovieService {
    //得到所有未上架电影的列表
    List<MovieVO> getUnreleaseMovie();

    //上架电影
    String releaseMovie(List<MovieForm> movieForms);

    //统计某电影的想看人数
    UserLikeMovieVO userLikeMovieCount(MovieForm movieForm);

    //查看某电影的某天想看人数
    UserLikeMovieVO userLikeMovieChangeCount(MovieForm movieForm, Date date);

    //统计所有电影的想看人数
    List<UserLikeMovieVO> userLikeMovieCounts();

    //统计某天所有电影的想看人数
    List<UserLikeMovieVO> userLikeMovieChangeCounts(Date date);

    //得到所有已经上架的电影
    List<MovieVO> getReleasedMovie(int userId);

    //得到某个电影的详细信息
    Movie getDetailedMovie(MovieForm movieForm,int userId);

    //用户标注喜欢电影或者取消标注
    void likeMovie(MovieForm movieForm,int userId);

}

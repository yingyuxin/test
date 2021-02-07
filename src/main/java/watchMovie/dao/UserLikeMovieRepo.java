package watchMovie.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import watchMovie.entity.UserLikeMovie;

import java.util.Date;
import java.util.List;

@Repository
public interface UserLikeMovieRepo extends CrudRepository<UserLikeMovie,Integer> {
    List<UserLikeMovie> findByUserId(int userId);       //某用户喜欢的电影列表
    int countDistinctByMovieId(int movieId);      //可以统计某电影的想看人数

    //统计某一天某电影的想看人数
    int countDistinctByMovieIdAndCurrentDate(int movieId, Date date);
    Iterable<UserLikeMovie> findAll();

    UserLikeMovie findByUserIdAndAndMovieId(int userId,int movieId);

}

package watchMovie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import watchMovie.entity.Movie;
import watchMovie.form.MovieForm;

import java.util.List;

@Repository
public interface MovieRepo extends CrudRepository<Movie,Integer>{
    Movie findByName(String name);
    Movie findById(int id);

    //统计所有未上架的电影
    List<Movie> findAllByOnShowIsFalse();

    //统计所有已经上架的电影
    List<Movie> findAllByOnShowIsTrue();

    //统计所有电影
    List<Movie> findAll();

}

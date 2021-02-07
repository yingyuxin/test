package watchMovie.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
@Data
public class UserLikeMovie {
    private Integer movieId;
    private Integer userId;
    private Calendar currentDate;     //用户标注为想看电影的日期
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}

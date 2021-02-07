package watchMovie.VO;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
public class MovieVO {
    private String movieName;
    private Integer id;
    private String posterURL;      //海报
    private String actor;     //主演
    private Calendar startDate;     //上映日期
    private boolean like;
}

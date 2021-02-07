package watchMovie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.List;

@Entity
@Data
public class Movie {
    //名称、电影宣传海报、导演、编剧、主演、类型、制片国家/地区、语言、上映日期、片长和下映日期
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Calendar startDate;   //上映日期
    private Calendar endDate;     //下映日期
    private Integer timeLength;   //时长，以分钟为单位
    private String posterURL;    //海报存放地址
    private String language;     //语言
    private String country;      //国家
    private String director;     //导演
    private String actor;     //主演
    private String type;    //电影类型
    private boolean OnShow;   //上映状态
    private boolean like;       //是否喜欢，默认false
}

package watchMovie.entity;

import lombok.Data;
import watchMovie.constant.UserType;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    //private int type;
    private String name;
    private String password;
    //private ArrayList<String> wantWatch;
    @Id
    private String id;
    public UserType userType;
}

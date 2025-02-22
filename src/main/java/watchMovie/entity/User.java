package watchMovie.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    private String name;
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //public UserType userType;
    private String type;     //要么manager，要么staff，要么user
}

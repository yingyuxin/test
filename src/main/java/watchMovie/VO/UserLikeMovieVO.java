package watchMovie.VO;

import lombok.Data;

@Data
public class UserLikeMovieVO {
    private String movieName;
    private int movieId;
    private int userLikeMovieCount;
}

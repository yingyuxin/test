package watchMovie.service;

import watchMovie.dao.UserRepo;
import watchMovie.entity.User;

public class UserServiceImpl implements UserService{
    private UserRepo userRepo;
    @Override
    public String login(User user){
        if(userRepo.findByName(user.getName())!=null){
            return "success";
        }else{
            return "wrong";
        }
    }
}

package watchMovie.controller;

import watchMovie.constant.UserType;
import watchMovie.dao.UserRepo;
import watchMovie.entity.Manager;
import watchMovie.entity.Staff;
import watchMovie.entity.User;
import watchMovie.service.ManagerService;
import watchMovie.service.StaffService;
import watchMovie.service.UserService;

public class UserController {
    private UserService userService;
    private StaffService staffService;
    private ManagerService managerService;
    public String login(User user){
        if(user.userType.getDesc().equals("user")){
            return userService.login(user);
        }else if(user.userType.getDesc().equals("staff")){
            return staffService.login(user);
        }else{
            return managerService.login(user);
        }
    }
}

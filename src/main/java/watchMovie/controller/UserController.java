package watchMovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import watchMovie.form.UserForm;
import watchMovie.service.account.UserService;

@RestController
public class UserController {
    private final static String LOGIN_ERROR1="用户名不存在";
    private final static String LOGIN_ERROR2="密码错误";
    private final static String REGISTER_ERROR="此用户名不可用";

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(UserForm userForm){
        String res = userService.login(userForm);
        if(res.equals("miss")){
            return LOGIN_ERROR1;
        }else if(res.equals("false")){
            return LOGIN_ERROR2;
        }else{
            return res;
        }
    }

    @PostMapping("/register")
    public String register(UserForm userForm){
        String res = userService.register(userForm);
        if(res.equals("false")){
            return REGISTER_ERROR;
        }else{
            return res;
        }
    }
}

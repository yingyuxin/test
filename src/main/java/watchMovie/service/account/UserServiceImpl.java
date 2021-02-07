package watchMovie.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import watchMovie.dao.UserRepo;
import watchMovie.entity.User;
import watchMovie.form.UserForm;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public String login(UserForm userForm){
        User user = userRepo.findByName(userForm.getUserName());
        if(user==null){
            return "miss";      //账户缺失
        }else if(!user.getPassword().equals(userForm.getPassword())){
            return "false";     //账户密码错误
        }else{
            return userForm.getType();    //登录成功，则返回用户类型
        }
    }

    @Override
    public String register(UserForm userForm) {
        if(userRepo.findByName(userForm.getUserName())!=null){
            //已经存在此账号，则注册失败
            return "false";
        }
        User newUser = new User();
        newUser.setName(userForm.getUserName());
        newUser.setPassword(userForm.getPassword());
        newUser.setType(userForm.getType());
        userRepo.save(newUser);
        return "success";
    }

}

package watchMovie.service.account;

import watchMovie.form.UserForm;

public interface UserService {
    String login(UserForm userForm);
    String register(UserForm userForm);
}

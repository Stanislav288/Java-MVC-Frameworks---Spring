package app.contracts;

import app.models.bindingModels.LoginModel;

/**
 * Created by Galin on 17.2.2017 г..
 */
public interface UserService {

    void createUser(LoginModel loginModel);

    LoginModel findByUsernameAndPassword(String username,String password);
}

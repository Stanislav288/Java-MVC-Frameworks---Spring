package softuni.services;

import softuni.models.bindingModels.LoggedUserModel;
import softuni.models.bindingModels.RegisterUserModel;

/**
 * Created by Galin on 3.3.2017 г..
 */
public interface UserService {
    void registerUser(RegisterUserModel registerUserModel);

    RegisterUserModel findByUsername(String username);

    LoggedUserModel findByUsernameAndPassword(String username, String password);
}

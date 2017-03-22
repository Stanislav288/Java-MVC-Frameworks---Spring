package softuni.serviceImpl;

import softuni.entities.User;
import softuni.enums.Role;
import softuni.models.bindingModels.LoggedUserModel;
import softuni.models.bindingModels.RegisterUserModel;
import softuni.repositories.UserRepository;
import softuni.services.UserService;
import softuni.utils.parser.interfaces.ModelParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by Galin on 3.3.2017 г..
 */

//@Local(UserService.class)
@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public void registerUser(RegisterUserModel registerUserModel) {
        User user = this.modelParser.convert(registerUserModel, User.class);
        user.setRole(Role.USER);
        this.userRepository.create(user);
    }

    @Override
    public RegisterUserModel findByUsername(String username) {
        User user = this.userRepository.findByUsername(username);
        RegisterUserModel registerUserModel = null;
        if (user != null) {
            registerUserModel = this.modelParser.convert(user, RegisterUserModel.class);
        }

        return registerUserModel;
    }

    @Transactional
    @Override
    public LoggedUserModel findByUsernameAndPassword(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        LoggedUserModel loggedUserModel = null;
        if (user != null) {
            loggedUserModel = this.modelParser.convert(user, LoggedUserModel.class);
        }

        return loggedUserModel;
    }
}

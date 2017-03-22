package app.services;


import app.contracts.UserRepository;
import app.contracts.UserService;
import app.entities.User;
import app.models.bindingModels.LoginModel;
import app.repository.UserRepositoryImpl;
import org.modelmapper.ModelMapper;


public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    public UserServiceImpl() {
        this.userRepository = UserRepositoryImpl.getInstance();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void createUser(LoginModel loginModel) {
        User user = this.modelMapper.map(loginModel, User.class);

        this.userRepository.createUser(user);
    }

    @Override
    public LoginModel findByUsernameAndPassword(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        LoginModel loginModel = this.modelMapper.map(user, LoginModel.class);

        return loginModel;
    }
}

package app.repository;

import app.contracts.UserRepository;
import app.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Galin on 17.2.2017 г..
 */
public class UserRepositoryImpl implements UserRepository {

    private static long currentId;

    private static UserRepositoryImpl userRepository;

    private List<User> users;

    private UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
            currentId = 1;
        }

        return userRepository;
    }

    @Override
    public void createUser(User user) {
        user.setId(currentId);
        currentId++;
        this.users.add(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = users
                .stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .get();

        return user;
    }
}

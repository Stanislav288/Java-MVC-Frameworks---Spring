package app.contracts;

import app.entities.User;

/**
 * Created by Galin on 16.2.2017 г..
 */
public interface UserRepository {

    void createUser(User user);

    User findByUsernameAndPassword(String username,String password);
}

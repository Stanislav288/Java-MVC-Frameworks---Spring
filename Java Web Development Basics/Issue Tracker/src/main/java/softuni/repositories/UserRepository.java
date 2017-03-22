package softuni.repositories;

import softuni.entities.User;

/**
 * Created by Galin on 1.3.2017 г..
 */
public interface UserRepository {

    void create(User user);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username,String password);
}
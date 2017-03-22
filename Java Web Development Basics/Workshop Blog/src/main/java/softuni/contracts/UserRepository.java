package softuni.contracts;

import softuni.models.User;

/**
 * Created by Galin on 24.2.2017 г..
 */
public interface UserRepository {
    void create(User user);

    User findUserByUsernameAndPassword(String fullName,String password);

    User findById(Long id);
}

package softuni.repository;

import softuni.contracts.UserRepository;
import softuni.models.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Local(UserRepository.class)
@Stateless
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user) {
        this.entityManager.persist(user);
    }

    @Override
    public User findUserByUsernameAndPassword(String fullName, String password) {
        Query query=entityManager.createQuery("SELECT u FROM User AS u " +
                "WHERE u.fullName=:fullName AND u.password=:password");

        query.setParameter("fullName",fullName);
        query.setParameter("password",password);

        User user= (User) query.getSingleResult();

        return user;
    }

    @Override
    public User findById(Long id) {
        User user=this.entityManager.find(User.class,id);
        return user;
    }
}

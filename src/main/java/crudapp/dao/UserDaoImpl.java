package crudapp.dao;

import crudapp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public void addUser(User user) {
        em.persist(user);
    }

    public List<User> getAllUsers() {
        return em.createQuery("from User").getResultList();
    }

    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    public void deleteUserById(int id) {
        em.remove(em.find(User.class, id));
    }

    public void updateUser(User user) {
        em.merge(user);
    }
}

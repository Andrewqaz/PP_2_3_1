package crudapp.dao;

import crudapp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public void addUser(User user){
        em.persist(user);
    }

    public List<User> getAllUsers(){
        return em.createQuery("from User").getResultList();
    }

    public User getUserById(int id){
        return em.find(User.class, id);
    }

    public void deleteUserById(int id){
        em.remove(em.find(User.class, id));
    }

    public void updateUser(int id, User user){
        User resulUser = em.find(User.class, id);
        resulUser.setFirstName(user.getFirstName());
        resulUser.setLastName(user.getLastName());
        resulUser.setAge(user.getAge());
        em.merge(resulUser);
    }
}

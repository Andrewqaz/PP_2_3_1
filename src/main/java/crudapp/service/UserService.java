package crudapp.service;

import crudapp.dao.UserDao;
import crudapp.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserService {
    private UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void addUser(User user){
        dao.addUser(user);
    }

    public List<User> getAllUsers(){
        return dao.getAllUsers();
    }

    @Transactional
    public void deleteUserById(int id){
        dao.deleteUserById(id);
    }

    public User getUserById(int id){
        return dao.getUserById(id);
    }

    @Transactional
    public void updateUser(int id, User user){
        dao.updateUser(id, user);
    }

}

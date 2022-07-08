package crudapp.service;

import crudapp.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    void deleteUserById(int id);

    User getUserById(int id);

    void updateUser(User user);

}

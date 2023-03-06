package com.raex.master.Service;

import com.raex.master.Entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();
    public User getUser(int id);
    public User saveUser(User user);
    public User updateUser(int id, User user);
    public void deleteUser(int id);
}

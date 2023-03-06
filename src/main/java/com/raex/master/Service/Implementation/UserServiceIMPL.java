package com.raex.master.Service.Implementation;

import com.raex.master.Entity.Rol;
import com.raex.master.Entity.User;
import com.raex.master.Repository.UserRepo;
import com.raex.master.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUser() {
        return (List<User>) this.userRepo.findAll();
    }

    @Override
    public User getUser(int id) {
        return this.userRepo.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        user.setCreationDate(saveDate());
        return this.userRepo.save(user);
    }

    @Override
    public User updateUser(int id,User user) {
        User existingUser = userRepo.findById(id).get();
        Rol rol = new Rol();
        existingUser.setIdRol(user.getIdRol());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setPassword(user.getPassword());
        existingUser.setEnable(user.getEnable());
        existingUser.setPhone(user.getPhone());
        existingUser.setUpdateDate(saveDate());

        return userRepo.save(existingUser);

    }

    @Override
    public void deleteUser(int id) {
        this.userRepo.deleteById(id);
    }

    public Date saveDate(){
        java.util.Date currentDate = new java.util.Date();
        java.sql.Date currentDateForSQL = new java.sql.Date(currentDate.getTime());
        return currentDateForSQL;
    }

}



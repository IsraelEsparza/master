package com.raex.master.Controller;

import com.raex.master.Entity.User;
import com.raex.master.Service.Implementation.UserServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceIMPL userServiceIMPL;
    @GetMapping( "/")
    public ResponseEntity<?> getAllUser(){
        List<User> userList = this.userServiceIMPL.getAllUser();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id){
        User user = this.userServiceIMPL.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        User userCreated = this.userServiceIMPL.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user){
        User userUpdate = this.userServiceIMPL.updateUser(id,user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userUpdate);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        this.userServiceIMPL.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}

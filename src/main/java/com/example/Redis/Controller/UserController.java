package com.example.Redis.Controller;

import com.example.Redis.Entity.User;
import com.example.Redis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final Logger logger =  LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        logger.debug(" >> User Controller : /user/{} call :",id);
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        logger.debug(" >> User Controller : /user  :",user.toString());
        return userService.create(user);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        logger.debug(" >> User Controller : /users  :");
        return userService.getAll();
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        logger.debug(" >> User Controller : /update  :",user.toString());
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        logger.debug(" >> User Controller : /delete/{}  :",id);
         userService.deleteUser(id);
    }


}

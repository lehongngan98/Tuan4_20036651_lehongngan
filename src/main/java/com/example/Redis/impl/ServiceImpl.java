package com.example.Redis.impl;

import com.example.Redis.Entity.User;
import com.example.Redis.repository.UserRepository;
import com.example.Redis.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements UserService {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(ServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUser(long id) {
        logger.debug("UserService : enter getUser");
        Optional<User> userOp = userRepository.findById(id);
        if(userOp != null && userOp.isPresent() ){
            logger.debug("UserService : exiting getUser");
            return userOp.get();
        }else {
            logger.debug("UserService : No Such User Exists: exiting getUser");
            return null;
        }
    }

    @Override
    public User create(User user) {
        logger.debug("UserService : Entering create");
        User userToReturn = userRepository.save(user);
        logger.debug("UserService : Exiting create");
        return userToReturn;
    }

    @Override
    public List<User> getAll() {
        logger.debug("UserService : Entering getAll");
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        logger.debug("UserService : Entering updateUser");
        long id = user.getId();
        User userInDB = getUser(id);
        if(userInDB != null){
            logger.debug("UserService : Exiting updateUser");
            return create(user);
        }
        else {
            logger.debug("UserService : No Such User Exists: Exiting updateUser");
            return null;
        }

    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}

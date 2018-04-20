package com.globalaccelerex.tcs.service.impl;

import com.globalaccelerex.tcs.domain.User;
import com.globalaccelerex.tcs.domain.security.UserRole;
import com.globalaccelerex.tcs.repository.RoleRepository;
import com.globalaccelerex.tcs.repository.UserRepository;
import com.globalaccelerex.tcs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean checkUserExists(String username, String email) {
        User user =userRepository.findByUsernameAndEmail(username,email);
        return  user != null;
    }

    @Override
    public Boolean checkEmailExists(String email) {
        return findByEmail(email) != null;
    }

    @Override
    public Boolean checkUsernameExists(String username) {
        return findByUsername(username) != null;
    }

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
       logger.info("Users Email"+user.getPassword());
      String encyptPassword = passwordEncoder.encode(user.getPassword());
        logger.info("encrypt Password"+encyptPassword);
        user.setPassword(encyptPassword);

         for (UserRole ur : userRoles) {

               roleRepository.save(ur.getRole());
           }
        user.getUserRoles().addAll(userRoles);

        return userRepository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Long getTotalUsers() {
        return userRepository.count();
    }
}


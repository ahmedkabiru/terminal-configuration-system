package com.globalaccelerex.tcs.service;

import com.globalaccelerex.tcs.domain.User;
import com.globalaccelerex.tcs.domain.security.UserRole;

import java.util.Set;

public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    Boolean checkUserExists(String username, String email);

    Boolean checkEmailExists(String email);

    Boolean checkUsernameExists(String username);

    User  createUser(User user, Set<UserRole> userRoles);

    Iterable<User> getAllUsers();

    Long getTotalUsers();

}

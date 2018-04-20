package com.globalaccelerex.tcs.repository;

import com.globalaccelerex.tcs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserId (Long userId);

    User findByUsername(String username);

    User findByEmail(String email);

    User findByUsernameAndEmail(String username ,String email);

}

package com.globalaccelerex.tcs.repository;

import com.globalaccelerex.tcs.domain.security.Role;
import com.globalaccelerex.tcs.domain.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(String name);

}

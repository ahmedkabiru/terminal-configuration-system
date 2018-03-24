package com.globalaccelerex.tcs.domain.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    private int roleId;
    private String name;

    public Role(int roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    @OneToMany(mappedBy = "role" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

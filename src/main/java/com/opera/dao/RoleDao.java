package com.opera.dao;

import com.opera.model.Role;

public interface RoleDao {
    void add(Role role);

    Role getRoleByName(String roleName);
}

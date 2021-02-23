package com.tickets.dao;

import com.tickets.model.Role;

public interface RoleDao {
    void add(Role role);

    Role getRoleByName(String roleName);
}

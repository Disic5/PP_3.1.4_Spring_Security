package com.den.spring_security.Dao;

import com.den.spring_security.Model.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface RoleDao {

    public Set<Role> findRoles(List<Long> roles);

    public List<Role> getAllRoles();

    Role getRoleByName(String name);

    HashSet<Role> getRoles(String[] arrayRoles);
}
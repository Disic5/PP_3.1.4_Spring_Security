package com.den.spring_security.Service;

import com.den.spring_security.Dao.RoleDao;
import com.den.spring_security.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Set<Role> findRoles(List<Long> roles) {
        return roleDao.findRoles(roles);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public HashSet<Role> getRoles(String[] arrayRoles) {
        return roleDao.getRoles(arrayRoles);
    }
}
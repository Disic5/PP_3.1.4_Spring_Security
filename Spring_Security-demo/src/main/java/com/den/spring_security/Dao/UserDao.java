package com.den.spring_security.Dao;

import com.den.spring_security.Model.Role;
import com.den.spring_security.Model.User;
import java.util.List;
import java.util.Set;

public interface UserDao {
    void add(User user);
    void delete(long id);
    void change(User user, Set<Role> roles);
    List<User> listUsers();
    User findUserById(long id);
    public User findUserByEmail (String email);
}

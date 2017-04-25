package com.hedgo.dbtests.dao;

import com.hedgo.dbtests.model.User;

import java.util.List;

public interface UserDAO {
    public void save(User p);
    public List<User> list();
}

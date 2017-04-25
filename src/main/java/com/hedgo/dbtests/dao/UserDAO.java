package com.hedgo.dbtests.dao;

import com.hedgo.dbtests.model.User;

import java.util.List;

public interface UserDAO {
    public void save(User user);
    public User read(int id);
    public void update(int id, User user);
    public void delete(int id);
    public List<User> listAll();
    public Long countAll();

    public void initSession();
    public void closeSession();


}
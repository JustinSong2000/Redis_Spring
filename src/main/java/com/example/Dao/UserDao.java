package com.example.Dao;

import com.example.Model.User;

import java.util.List;

public interface UserDao {
    String get(int id);
    void set(User u);

    List<User> showAll();
}

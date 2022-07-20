package com.example.Service;

import com.example.Model.User;

import java.util.List;

public interface UserService {
    String getUserInfo(int id);
    void addUser(User user);
    List<User> showAll();
//    Boolean check_u(User user);
    void sendUser(User user);

}

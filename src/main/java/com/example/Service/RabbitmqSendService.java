package com.example.Service;

import com.example.Model.User;


public interface RabbitmqSendService {
    void sendUser(User u, String type);
}

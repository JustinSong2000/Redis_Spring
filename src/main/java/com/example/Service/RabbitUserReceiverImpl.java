package com.example.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Dao.UserDaoImpl;
import com.example.Model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class RabbitUserReceiverImpl implements RabbitUserReceiver{
    @Autowired
    private UserDaoImpl ud;
    @Override
    public void receiveUser(String user) {
        JSONObject jsonUser =  (JSONObject) JSON.parse(user);;
        ud.set(new User((int)jsonUser.get("id"), (String) jsonUser.get("name")));
    }
}

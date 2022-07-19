package com.example.Service;

import com.example.Dao.UserDao;
import com.example.Model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao ud;
    public String getUserInfo(int id){
        return ud.get(id);
    }
    public void addUser(User user){
        ud.set(user);
    }
    public List<User> showAll(){
        return ud.showAll();
    }
}

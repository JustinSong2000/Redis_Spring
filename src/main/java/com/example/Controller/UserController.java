package com.example.Controller;

import com.example.Model.User;
import com.example.Service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping(value = "/")
public class UserController {
    @Autowired
    private UserService us;
    @GetMapping(value = "/add/{id}/{name}")
    public void setUser(@PathVariable int id, @PathVariable String name){
        us.addUser(new User(id, name));
    }
    @GetMapping(value = "/get/{id}")
    public String getUser(@PathVariable int id){
        return us.getUserInfo(id);
    }
}

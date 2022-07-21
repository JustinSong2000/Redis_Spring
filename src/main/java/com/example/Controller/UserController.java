package com.example.Controller;

import com.example.Listener.UserListener;
import com.example.Model.User;
import com.example.Service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Data
@RequestMapping(value = "/")
public class UserController {
    @Autowired
    private UserService us;
//    private UserListener ul;
    @GetMapping(value = "/add/{id}/{name}")
    public void setUser(@PathVariable int id, @PathVariable String name){
        us.addUser(new User(id, name));
    }
    @GetMapping(value = "/get/{id}")
    public String getUser(@PathVariable int id){
        return us.getUserInfo(id);
    }
    @GetMapping(value = "send/{id}/{name}/{type}")
    public void  sendUser(@PathVariable int id, @PathVariable String name, @PathVariable String type){
        us.sendUser(new User(id, name), type);
//        us.receiveUser();
    }
    @GetMapping(value = "monitor")
    public void create(){
        for(int i = 0; i < 5000; i ++){
            Random r = new Random();
            us.sendUser(new User(r.nextInt(), "name" + r), "b");
        }
    }
}

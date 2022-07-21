package com.example.Dao;

import com.example.Model.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    public String get(int id){
        return (String) redisTemplate.opsForValue().get(id);
    }
    public void set(User u){
        redisTemplate.opsForValue().set(u.getId().toString(), u.getName());
    }

    @Override
    public List<User> showAll() {
        return null;
    }
}

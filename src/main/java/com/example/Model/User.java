package com.example.Model;

import lombok.Data;

@Data
public class User {
    //    @Id
    private int id;
    //    @Column
    private String name;
    public User(){}
    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

}

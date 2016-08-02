package com.upsoft.semantic.domain;

/**
 * Created by admin on 2016/8/2.
 */
public class User {
    private String id;
    private String username;
    private String password;
    private int age;

    public User() {
    }

    public User(String id, String username, String password, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}

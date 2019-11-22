package com.poly.hungnqph07434_duan1.model;

public class User {

    private String name, password,phone,hoten;

    public User() {
    }

    public User(String name, String password, String phone, String hoten) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.hoten = hoten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
}

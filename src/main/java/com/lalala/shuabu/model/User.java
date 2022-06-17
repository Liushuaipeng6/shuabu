//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lalala.shuabu.model;

public class User {
    private String user;
    private String password;
    private int step;

    public User(String user, String password, int step) {
        this.user = user;
        this.password = password;
        this.step = step;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStep() {
        return this.step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String toString() {
        return "User{user='" + this.user + '\'' + ", password='" + this.password + '\'' + ", step=" + this.step + '}';
    }
}

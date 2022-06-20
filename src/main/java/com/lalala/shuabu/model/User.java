//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lalala.shuabu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String user;
    private String password;
    private int step;


    public String toString() {
        return "User{user='" + this.user + '\'' + ", password='" + this.password + '\'' + ", step=" + this.step + '}';
    }
}

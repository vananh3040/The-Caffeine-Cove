/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

/**
 *
 * @author dang
 */
public class AccountModel {

    private String UserName;
    private String Password;
    private Boolean IsLocked;
    private int Type;

    public AccountModel() {
    }

    public AccountModel(String UserName, String Password, Boolean IsLocked, int Type) {
        this.UserName = UserName.trim();
        this.Password = Password;
        this.IsLocked = IsLocked;
        this.Type = Type;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        if (UserName != null) {
            this.UserName = UserName.trim();
        } else {
            this.UserName = null;
        }
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Boolean getIsLocked() {
        return IsLocked;
    }

    public void setIsLocked(Boolean IsLocked) {
        this.IsLocked = IsLocked;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

}

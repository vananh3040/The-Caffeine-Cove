/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import java.sql.Date;

/**
 *
 * @author hoai nam
 */
public class UserModel extends NhanVienModel {

    private String Position;
    private String Password;

    public UserModel(String Position, String Password, int MaNV, int MaCN, String TenNV, int GioiTinh, Date NgayVL, String CCCD) {
        super(MaNV, MaCN, TenNV, GioiTinh, NgayVL, CCCD);
        this.Position = Position.trim();
        this.Password = Password;
    }

    public String getPosition() {
        return Position.trim();
    }
}

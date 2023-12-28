/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

/**
 *
 * @author hoai nam
 */
public class ChiNhanhModel {

    //1. UIT 2. Trung tâm 3. Miền Bắc
    private int MaCN;
    private String TenCN;
    private String DiaChi;

    public ChiNhanhModel() {
    }

    public ChiNhanhModel(int MaCN, String TenCN, String DiaChi) {
        this.MaCN = MaCN;
        this.TenCN = TenCN.trim();
        this.DiaChi = DiaChi.trim();
    }

    public int getMaCN() {
        return MaCN;
    }

    public void setMaCN(int MaCN) {
        this.MaCN = MaCN;
    }

    public String getTenCN() {
        return TenCN;
    }

    public void setTenCN(String TenCN) {
        if (TenCN != null) {
            this.TenCN = TenCN.trim();
        } else {
            this.TenCN = null;
        }
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        if (DiaChi != null) {
            this.DiaChi = DiaChi.trim();
        } else {
            this.DiaChi = null;
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

/**
 *
 * @author vananh
 */
public class KhachHangModel {

    private String SDTKH;
    private String TenKH;
    private int GioiTinh;
    private int TongDiem;

    public KhachHangModel() {
    }

    public KhachHangModel(String SDT, String TenKH, int GioiTinh, int TongDiem) {
        this.SDTKH = SDT.trim();
        this.TenKH = TenKH.trim();
        this.GioiTinh = GioiTinh;
        this.TongDiem = TongDiem;
    }

    public String getSDTKH() {
        return SDTKH;
    }

    public void setSDTKH(String SDT) {
        this.SDTKH = SDT.trim();
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        if (TenKH != null) {
            this.TenKH = TenKH.trim();
        } else {
            this.TenKH = null;
        }
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getTongDiem() {
        return TongDiem;
    }

    public void setTongDiem(int TongDiem) {
        this.TongDiem = TongDiem;
    }

}

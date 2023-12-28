/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import java.sql.Date;

/**
 *
 * @author dang
 */
public class HoaDonKhachHangModel {

    private int MaGiamGia;
    private String SDTKH;
    private int MaNV;
    private Date NgayLap;
    private double TongTien;
    private int MaHD;

    public HoaDonKhachHangModel() {
    }

    public HoaDonKhachHangModel(int MaGiamGia, String SDTKH, int MaNV, Date NgayLap, double TongTien, int MaHD) {
        this.MaGiamGia = MaGiamGia;
        this.SDTKH = SDTKH.trim();
        this.MaNV = MaNV;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
        this.MaHD = MaHD;
    }

    public int getMaGiamGia() {
        return MaGiamGia;
    }

    public void setMaGiamGia(int MaGiamGia) {
        this.MaGiamGia = MaGiamGia;
    }

    public String getSDTKH() {
        return SDTKH;
    }

    public void setSDTKH(String SDTKH) {
        if (SDTKH != null) {
            this.SDTKH = SDTKH.trim();
        } else {
            this.SDTKH = null;
        }
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

}

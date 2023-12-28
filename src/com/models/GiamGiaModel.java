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
public class GiamGiaModel {
    private int MaGiamGia;
    private int GiaTri;
    private Double ToiDa;
    private Date NgayBatDau;
    private Date NgayKetThuc;

    public GiamGiaModel() {
    }

    public GiamGiaModel(int MaGiamGia, int GiaTri, Double ToiDa, Date NgayBatDau, Date NgayKetThuc) {
        this.MaGiamGia = MaGiamGia;
        this.GiaTri = GiaTri;
        this.ToiDa = ToiDa;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
    }

    public int getMaGiamGia() {
        return MaGiamGia;
    }

    public void setMaGiamGia(int MaGiamGia) {
        this.MaGiamGia = MaGiamGia;
    }

    public int getGiaTri() {
        return GiaTri;
    }

    public void setGiaTri(int GiaTri) {
        this.GiaTri = GiaTri;
    }

    public Double getToiDa() {
        return ToiDa;
    }

    public void setToiDa(Double ToiDa) {
        this.ToiDa = ToiDa;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }
    
}

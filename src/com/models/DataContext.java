/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import com.controller.DoUongController;
import java.util.LinkedList;

/**
 *
 * @author vananh
 */
public class DataContext {

    private LinkedList<AccountModel> Accounts;
    private LinkedList<CTHDModel> CTHDs;
    private LinkedList<ChiNhanhModel> ChiNhanhs;
    private LinkedList<DoUongModel> DoUongs;
    private LinkedList<GiamGiaModel> GiamGias;
    private LinkedList<HoaDonKhachHangModel> HoaDonKhachHangs;
    private LinkedList<KhachHangModel> KhachHangs;
    private LinkedList<NhanVienModel> NhanViens;
    private UserModel user;
    private static DataContext _instance;

    private DataContext() {
    }

    public static DataContext getInstance() {
        if (_instance == null) {
            synchronized (DataContext.class) {
                if (_instance == null) {
                    _instance = new DataContext();
                }
            }
        }
        return _instance;
    }

    public LinkedList<AccountModel> getAccounts() {
        return Accounts;
    }

    public void setAccounts(LinkedList<AccountModel> Accounts) {
        this.Accounts = Accounts;
    }

    public LinkedList<CTHDModel> getCTHDs() {
        return CTHDs;
    }

    public void setCTHDs(LinkedList<CTHDModel> CTHDs) {
        this.CTHDs = CTHDs;
    }

    public LinkedList<ChiNhanhModel> getChiNhanhs() {
        return ChiNhanhs;
    }

    public void setChiNhanhs(LinkedList<ChiNhanhModel> ChiNhanhs) {
        this.ChiNhanhs = ChiNhanhs;
    }

    public LinkedList<DoUongModel> getDoUongs() {
        if (DoUongs == null) {
            synchronized (DataContext.class) {
                if (DoUongs == null) {
                    DoUongController.getInstance().LayDuLieu();
                }
            }
        }
        return DoUongs;
    }

    public void setDoUongs(LinkedList<DoUongModel> DoUongs) {
        this.DoUongs = DoUongs;
    }

    public LinkedList<GiamGiaModel> getGiamGias() {
        return GiamGias;
    }

    public void setGiamGias(LinkedList<GiamGiaModel> GiamGias) {
        this.GiamGias = GiamGias;
    }

    public LinkedList<HoaDonKhachHangModel> getHoaDonKhachHangs() {
        return HoaDonKhachHangs;
    }

    public void setHoaDonKhachHangs(LinkedList<HoaDonKhachHangModel> HoaDonKhachHangs) {
        this.HoaDonKhachHangs = HoaDonKhachHangs;
    }

    public LinkedList<KhachHangModel> getKhachHangs() {
        return KhachHangs;
    }

    public void setKhachHangs(LinkedList<KhachHangModel> KhachHangs) {
        this.KhachHangs = KhachHangs;
    }

    public LinkedList<NhanVienModel> getNhanViens() {
        return NhanViens;
    }

    public void setNhanViens(LinkedList<NhanVienModel> NhanViens) {
        this.NhanViens = NhanViens;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

}

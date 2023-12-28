/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.handle.ConnectionHandle;
import com.models.DataContext;
import com.models.KhachHangModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vananh
 */
public class KhachHangController {

    private static KhachHangController _instance;

    public static KhachHangController getInstance() {
        if (_instance == null) {
            synchronized (KhachHangController.class) {
                if (_instance == null) {
                    _instance = new KhachHangController();
                }
            }
        }
        return _instance;
    }

    private KhachHangController() {

    }

    public boolean ThemKhachHang(KhachHangModel k) {
        try {

            // Cau truy van SQL
            String sql = "Insert into KhachHang values(?,?,?,?)";

            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setString(1, k.getSDTKH());
            ps.setString(2, k.getTenKH());
            ps.setInt(3, k.getGioiTinh());
            ps.setInt(4, k.getTongDiem());

            // Kiem tra xem thuc hien co thanh cong hay khong
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean SuaKhachHang(String id, KhachHangModel k) {
        try {

            // Cau truy van SQL
            String sql = "update KhachHang set TenKH=?, GioiTinh=?, TongDiem=? WHERE SDTKH='" + id + " '";
            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setString(1, k.getTenKH());
            ps.setInt(2, k.getGioiTinh());
            ps.setInt(3, k.getTongDiem());

            // Kiem tra xem thuc hien co thanh cong hay khong
            if (ps.executeUpdate() != 1) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaKhachHang(String SDTKH) {
        try {

            // Cau truy van SQL
            String sql = "delete from KhachHang where SDTKH = ?";

            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, SDTKH);

            if (ps.executeUpdate() != 1) {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public void LayDuLieu() {
        try {
            String sql = "Select *  FROM KHACHHANG";

            Statement ps = ConnectionHandle.getInstance().getConnection().createStatement();
            ResultSet rs = ps.executeQuery(sql);
            LinkedList<KhachHangModel> list = new LinkedList<>();
            KhachHangModel kh;
            while (rs.next()) {
                kh = new KhachHangModel();
                kh.setSDTKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setGioiTinh(rs.getInt(3));
                kh.setTongDiem(rs.getInt(4));
                list.add(kh);
            }
            DataContext.getInstance().setKhachHangs(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void TimKhachHang(String id) {
        try {
            String sql = "SELECT * FROM KHACHHANG WHERE SDTKH=?";
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            LinkedList<KhachHangModel> list = new LinkedList<>();
            KhachHangModel nv;
            while (rs.next()) {
                nv = new KhachHangModel();
                nv.setSDTKH(rs.getString(1));
                nv.setTenKH(rs.getString(2));
                nv.setGioiTinh(rs.getInt(3));
                nv.setTongDiem(rs.getInt(4));
                list.add(nv);
            }
            DataContext.getInstance().setKhachHangs(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean congDiem(String id, int value) {
        try {
            String sql = "Update KhachHang set TongDiem=TongDiem+? where SDTKH=?";
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, value);
            ps.setString(2, id);
            return ps.executeUpdate() >= 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

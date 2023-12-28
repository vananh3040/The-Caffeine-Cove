/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.handle.ConnectionHandle;
import com.models.DataContext;
import com.models.NhanVienModel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoai nam
 */
public class NhanVienController {

    private static NhanVienController _instance;

    public static NhanVienController getInstance() {
        if (_instance == null) {
            synchronized (NhanVienController.class) {
                if (_instance == null) {
                    _instance = new NhanVienController();
                }
            }
        }
        return _instance;
    }

    private NhanVienController() {
        LayDuLieu();
    }

    public boolean ThemNhanVien(NhanVienModel nv) {
        try {

            // Cau truy van SQL
            String sql = "Insert into NHANVIEN values(?,?,?,?,?)";

            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setInt(1, nv.getMaCN());
            ps.setString(2, nv.getTenNV());
            ps.setInt(3, nv.getGioiTinh());
            ps.setDate(4, (Date) nv.getNgayVL());
            ps.setString(5, nv.getCCCD());

            // Kiem tra xem thuc hien co thanh cong hay khong
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean SuaNhanVien(int id, NhanVienModel nv) {
        try {

            // Cau truy van SQL
            String sql = "update NHANVIEN set MaCN = ?, TenNV=?, GioiTinh=?,NgayVL=?, CCCD=? where MaNV =" + id;
            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setInt(1, nv.getMaCN());
            ps.setString(2, nv.getTenNV());
            ps.setInt(3, nv.getGioiTinh());
            ps.setDate(4, (Date) nv.getNgayVL());
            ps.setString(5, nv.getCCCD());

            // Kiem tra xem thuc hien co thanh cong hay khong
            if (ps.executeUpdate() != 1) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaNhanVien(int id) {
        try {
            String sql = "DELETE FROM NHANVIEN WHERE MaNV = " + id;

            Statement ps = ConnectionHandle.getInstance().getConnection().createStatement();
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next() == false) {
                return false;
            }
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    public void TimNhanVien(int id) {
        try {
            String sql = "SELECT * FROM NHANVIEN WHERE MANV=?";
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(sql);
            LinkedList<NhanVienModel> list = new LinkedList<>();
            NhanVienModel nv;
            while (rs.next()) {
                nv = new NhanVienModel();
                nv.setMaNV(rs.getInt(1));
                nv.setMaCN(rs.getInt(2));
                nv.setTenNV(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setNgayVL(rs.getDate(5));
                nv.setCCCD(rs.getString(6));
                list.add(nv);
            }
            DataContext.getInstance().setNhanViens(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LayDuLieu() {
        try {
            String sql = "Select *  FROM NHANVIEN";
            Statement ps = ConnectionHandle.getInstance().getConnection().createStatement();
            ResultSet rs = ps.executeQuery(sql);
            LinkedList<NhanVienModel> list = new LinkedList<>();
            NhanVienModel nv;
            while (rs.next()) {
                nv = new NhanVienModel();
                nv.setMaNV(rs.getInt(1));
                nv.setMaCN(rs.getInt(2));
                nv.setTenNV(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setNgayVL(rs.getDate(5));
                nv.setCCCD(rs.getString(6));
                list.add(nv);
            }
            DataContext.getInstance().setNhanViens(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String hienthiTenCN(int maCN) {
        String tenCN = "";
        try {

            String sql = "SELECT TENCN FROM CHINHANH WHERE MACN = ?";
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareCall(sql);
            ps.setInt(1, maCN);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tenCN = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenCN;
    }

    public int layMaNV() {
        int maNV = 0;
        try {
            String sql = "SELECT TOP (1) * FROM NHANVIEN ORDER BY MaNV DESC";
            Statement ps = ConnectionHandle.getInstance().getConnection().createStatement();
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next() == false) {
                maNV = 1;
            } else {
                int maHT = rs.getInt("MANV") + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maNV;
    }

}

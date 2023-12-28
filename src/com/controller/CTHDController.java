/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.handle.ConnectionHandle;
import com.models.CTHDModel;
import com.models.DataContext;
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
public class CTHDController {

    private static CTHDController _instance;

    public static CTHDController getInstance() {
        if (_instance == null) {
            synchronized (CTHDController.class) {
                if (_instance == null) {
                    _instance = new CTHDController();
                }
            }
        }
        return _instance;
    }

    private CTHDController() {

    }

    public boolean ThemCTHD(CTHDModel ct) {
        try {

            // Cau truy van SQL
            String sql = "Insert into CTHD values(?,?,?,?)";

            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setInt(1, ct.getMaHD());
            ps.setInt(2, ct.getMADU());
            ps.setInt(3, ct.getSoLuong());
            ps.setDouble(4, ct.getGia());
            // Kiem tra xem thuc hien co thanh cong hay khong
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CTHDController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean SuaCTHD(int id, CTHDModel k) {
        try {

            // Cau truy van SQL
            String sql = "update CTHD set SoLuong=?, Gia=?";
            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setInt(1, k.getSoLuong());
            ps.setDouble(2, k.getGia());

            // Kiem tra xem thuc hien co thanh cong hay khong
            if (ps.executeUpdate() != 1) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CTHDController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaCTHD(int id) {
        try {

            // Cau truy van SQL
            String sql = "delete from CTHD where MaHD = ?";

            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            ps.setInt(1, id);
            if (ps.executeUpdate() <= 0) {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public void LayDuLieu() {
        try {
            String sql = "Select *  FROM CTHD";

            Statement ps = ConnectionHandle.getInstance().getConnection().createStatement();
            ResultSet rs = ps.executeQuery(sql);
            LinkedList<CTHDModel> list = new LinkedList<>();
            CTHDModel kh;
            while (rs.next()) {
                kh = new CTHDModel();
                kh.setMaHD(rs.getInt(1));
                kh.setMADU(rs.getInt(2));
                kh.setSoLuong(rs.getInt(3));
                kh.setGia(rs.getInt(4));
                list.add(kh);
            }
            DataContext.getInstance().setCTHDs(list);
        } catch (SQLException e) {
        }
    }

    public void TimCTHD(String id) {
        try {
            String sql = "SELECT * FROM CTHD WHERE MaHD=?";
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            LinkedList<CTHDModel> list = new LinkedList<>();
            CTHDModel kh;
            while (rs.next()) {
                kh = new CTHDModel();
                kh.setMaHD(rs.getInt(1));
                kh.setMADU(rs.getInt(2));
                kh.setSoLuong(rs.getInt(3));
                kh.setGia(rs.getInt(4));
                list.add(kh);
            }
            DataContext.getInstance().setCTHDs(list);
        } catch (Exception e) {
        }
    }
}

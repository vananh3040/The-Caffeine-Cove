/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.handle.ConnectionHandle;
import com.handle.ImageHandle;
import com.models.DataContext;
import com.models.DoUongModel;
import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hai dang
 */
public class DoUongController {

    private static DoUongController _instance;

    public static DoUongController getInstance() {
        if (_instance == null) {
            synchronized (DoUongController.class) {
                if (_instance == null) {
                    _instance = new DoUongController();
                }
            }
        }
        return _instance;
    }

    private DoUongController() {
    }

    public boolean ThemDoUong(DoUongModel dr) {
        try {
            // Cau truy van SQL
            String sql = "Insert into DoUong values(?,?,?,?)";

            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setString(1, dr.getTenDU());
            ps.setDouble(2, dr.getGia());
            ps.setString(4, dr.getGhiChu());

            if (dr.getHinhAnh() != null) {
                byte[] b = ImageHandle.getInstance().toByteArray(dr.getHinhAnh(), "jpg");
                ps.setBinaryStream(3, new ByteArrayInputStream(b), b.length);
            } else {
                ps.setBinaryStream(3, null);
            }
            // Kiem tra xem thuc hien co thanh cong hay khong
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DoUongController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean SuaDoUong(int id, DoUongModel dr) {
        try {

            // Cau truy van SQL
            String sql = "update DoUong set TenDU=?, Gia=?, HinhAnh=?, GhiChu=? where MaDU="+id;
            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setString(1, dr.getTenDU());
            ps.setDouble(2, dr.getGia());
            ps.setString(4, dr.getGhiChu());

            if (dr.getHinhAnh() != null) {
                byte[] b = ImageHandle.getInstance().toByteArray(dr.getHinhAnh(), "jpg");
                ps.setBinaryStream(3, new ByteArrayInputStream(b), b.length);
            } else {
                ps.setBinaryStream(3, null);
            }
            // Kiem tra xem thuc hien co thanh cong hay khong

            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DoUongController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaDoUong(int id) {
        try {

            // Cau truy van SQL
            String sql = "delete from DoUong where MaDU = ?";

            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
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
            String sql = "Select *  FROM DoUong";
            Statement ps = ConnectionHandle.getInstance().getConnection().createStatement();
            ResultSet rs = ps.executeQuery(sql);

            LinkedList<DoUongModel> list = new LinkedList<>();
            DoUongModel du;

            while (rs.next()) {
                du = new DoUongModel();
                du.setMaDU(rs.getInt(1));
                du.setTenDU(rs.getString(2));
                du.setGia(rs.getDouble(3));
                du.setHinhAnh(ImageHandle.getInstance().createImageFromBlob(rs.getBlob(4)));
                du.setGhiChu(rs.getString(5));
                list.add(du);
            }

            DataContext.getInstance().setDoUongs(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

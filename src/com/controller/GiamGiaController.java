/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.handle.ConnectionHandle;
import com.models.DataContext;
import com.models.GiamGiaModel;
import java.sql.Date;
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
public class GiamGiaController {

    private static GiamGiaController _instance;

    public static GiamGiaController getInstance() {
        if (_instance == null) {
            synchronized (GiamGiaController.class) {
                if (_instance == null) {
                    _instance = new GiamGiaController();
                }
            }
        }
        return _instance;
    }

    private GiamGiaController() {

    }

    public boolean ThemGiamGia(GiamGiaModel k) {
        try {

            // Cau truy van SQL
            String sql = "Insert into GiamGia values(?,?,?,?)";

            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setInt(1, k.getGiaTri());
            ps.setDouble(2, k.getToiDa());
            ps.setDate(3, (Date) k.getNgayBatDau());
            ps.setDate(4, (Date) k.getNgayKetThuc());

            // Kiem tra xem thuc hien co thanh cong hay khong
            if (ps.executeUpdate() != 1) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GiamGiaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean SuaGiamGia(int id, GiamGiaModel k) {
        try {

            // Cau truy van SQL
            String sql = "update GiamGia set GiaTri=?, ToiDa=?, NgayBatDau=?, NgayKetThuc=? where Magiamgia =" + id;
            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setInt(1, k.getGiaTri());
            ps.setDouble(2, k.getToiDa());
            ps.setDate(3, (Date) k.getNgayBatDau());
            ps.setDate(4, (Date) k.getNgayKetThuc());
            // Kiem tra xem thuc hien co thanh cong hay khong
            if (ps.executeUpdate() != 1) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GiamGiaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaGiamGia(int id) {
        try {
            String sql = "DELETE FROM GIAMGIA WHERE MaGIAMGIA = ?";

            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);

            if (ps.executeUpdate() != 1) {
                return false;
            }
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    public void LayDuLieu() {
        try {
            String sql = "Select *  FROM GiamGia";

            Statement ps = ConnectionHandle.getInstance().getConnection().createStatement();
            ResultSet rs = ps.executeQuery(sql);
            LinkedList<GiamGiaModel> list = new LinkedList<>();
            GiamGiaModel kh;
            while (rs.next()) {
                kh = new GiamGiaModel();
                kh.setMaGiamGia(rs.getInt(1));
                kh.setGiaTri(rs.getInt(2));
                kh.setToiDa(rs.getDouble(3));
                kh.setNgayBatDau(rs.getDate(4));
                kh.setNgayKetThuc(rs.getDate(5));
                list.add(kh);
            }
            DataContext.getInstance().setGiamGias(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public GiamGiaModel layMaGiamGia() {
        LayDuLieu();
        Date d = new Date(System.currentTimeMillis());
        for (GiamGiaModel GiamGia : DataContext.getInstance().getGiamGias()) {
            if (GiamGia.getNgayKetThuc().after(d)
                    && GiamGia.getNgayBatDau().before(d)) {
                System.out.println(GiamGia.getMaGiamGia());
                return GiamGia;
            }
        }
        return null;
    }
}

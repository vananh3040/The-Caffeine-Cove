/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.handle.ConnectionHandle;
import com.models.AccountModel;
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
public class AccountController {

    private static AccountController _instance;

    public static  AccountController getInstance() {
        if (_instance == null) {
            synchronized (AccountController.class) {
                if (_instance == null) {
                    _instance = new AccountController();
                }
            }
        }
        return _instance;
    }

    private AccountController() {

    }

    public boolean ThemAccount(AccountModel k) {
        try {

            // Cau truy van SQL
            String sql = "Insert into Account values(?,?,?)";

            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);

            // Gan bien vao cac dau  ?
            ps.setString(1, k.getPassword());
            ps.setBoolean(2, k.getIsLocked());
            ps.setByte(3, (byte) k.getType());

            // Kiem tra xem thuc hien co thanh cong hay khong
            if (ps.executeUpdate() != 1) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean SuaAccount(String id, AccountModel k) {
        try {

            // Cau truy van SQL
            String sql = "update Account set password=?, islocked=?, type=? where username = '" + id + "'";
            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, id);

            // Gan bien vao cac dau  ?
            ps.setString(1, k.getPassword());
            ps.setBoolean(2, k.getIsLocked());
            ps.setByte(3, (byte) k.getType());

            // Kiem tra xem thuc hien co thanh cong hay khong
            if (ps.executeUpdate() != 1) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaAccount(String Username) {
        try {

            // Cau truy van SQL
            String sql = "delete from Account where username = ?";

            // Lay ket noi
            PreparedStatement ps = ConnectionHandle.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, Username);

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
            String sql = "Select *  FROM Account";

            Statement ps = ConnectionHandle.getInstance().getConnection().createStatement();
            ResultSet rs = ps.executeQuery(sql);
            LinkedList<AccountModel> list = new LinkedList<>();
            AccountModel kh;
            while (rs.next()) {
                kh = new AccountModel();
                kh.setUserName(rs.getString(1));
                kh.setPassword(rs.getString(2));
                kh.setIsLocked(rs.getBoolean(3));
                kh.setType(rs.getByte(4));
                list.add(kh);
            }
            DataContext.getInstance().setAccounts(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

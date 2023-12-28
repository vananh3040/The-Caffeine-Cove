/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.handle;

import com.models.DataContext;
import com.models.UserModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vananh
 */
public class ConnectionHandle {

    private static ConnectionHandle _instance;
    private Connection con;
    private String[] sInfo;
    private String[] user;
    String userName = "sa";
    String password = "password";

    private ConnectionHandle() {
        sInfo = ConfigurationLoader.getInstance().getServerInfo();
    }

    private void Connect() {
        try {
            String connectionUrl
                    = "jdbc:sqlserver://" + sInfo[0] + ":" + sInfo[2] + ";"
                    + "database=" + sInfo[1] + ";"
                    + "user=" + userName + ";"
                    + "password=" + password + ";"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
                    + "loginTimeout=5;";
            con = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ConnectManager() {
        loadManagerUser();
        Connect();
    }

    public boolean Login(String Username, char[] Password) {
        try {
            String sql = "SELECT [dbo].[DangNhap](?,?)";
            ConnectManager();
            CallableStatement cs = getConnection().prepareCall(sql);
            cs.setString(1, Username);
            cs.setString(2, CryptoHandle.EncodeMD5(String.valueOf(Password)));
            ResultSet rs = cs.executeQuery();
            if (rs.next()
                    && rs.getInt(1) != 0) {
                user = ConfigurationLoader.getInstance().getUserInfo(rs.getInt(1));
                loadInforUser(
                        Username,
                        CryptoHandle.EncodeMD5(String.valueOf(Password)),
                        rs.getInt(1)
                );
                return true;
            }
        } catch (Exception ex) {
            return false;
        } finally {
            con = null;
        }
        return false;
    }

    private void loadInforUser(String username, String password, int index) {
        try {
            UserModel userModel = null;
            String sql = "Select * from NhanVien where CCCD=?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            switch (index) {
                case 2:
                    userModel = new UserModel(
                            "Nhân viên",
                            password,
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getDate(5),
                            rs.getString(6)
                    );
                    DataContext.getInstance().setUser(userModel);
                    break;

                case 3:
                    userModel = new UserModel(
                            "Quản lí",
                            password,
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getDate(5),
                            rs.getString(6)
                    );
                    DataContext.getInstance().setUser(userModel);
                    break;
                default:
                    break;
            }
            System.out.println(rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadGuestUser() {
        user = ConfigurationLoader.getInstance().getUserInfo(1);
    }

    public void loadEmployeeUser() {
        user = ConfigurationLoader.getInstance().getUserInfo(2);
    }

    public void loadManagerUser() {
        user = ConfigurationLoader.getInstance().getUserInfo(3);
    }

    public Connection getConnection() {
        if (con == null) {
            Connect();
        }
        return con;
    }

    public static ConnectionHandle getInstance() {
        if (_instance == null) {
            synchronized (ConnectionHandle.class) {
                if (_instance == null) {
                    _instance = new ConnectionHandle();
                }
            }
        }
        return _instance;
    }
}

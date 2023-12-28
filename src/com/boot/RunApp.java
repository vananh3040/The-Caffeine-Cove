/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boot;

import com.handle.NetHandle;
import com.view.frame.LoginFrame;

/**
 *
 * @author vananh
 */
public class RunApp {

    private RunApp() {
        configSystem();
        NetHandle.getInstance();
        new LoginFrame().setVisible(true);
    }

    private void configSystem() {
        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("sun.java2d.uiScale", "1.0");
            System.setProperty("-Dprism.allowhidpi", "false");
            System.out.println("Configure Succefully");
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(RunApp::new);
    }
}

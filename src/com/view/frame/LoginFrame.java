/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view.frame;

import com.handle.ConnectionHandle;
import com.handle.ImageHandle;
import com.handle.LanguageHandle;
import com.utilities.PlaceHolder;
import com.utilities.RoundedButton;
import com.utilities.RoundedJPasswordField;
import com.utilities.RoundedJTextFiled;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author vananh
 */
public class LoginFrame extends JFrame {

    private void loadText() {
        TITLE = LanguageHandle.getInstance().getValue("Login", "TITLE");
        USERNAME = LanguageHandle.getInstance().getValue("Login", "USERNAME");
        ERROR_MESSAGE = LanguageHandle.getInstance().getValue("Login", "ERROR_MESSAGE");
        LOGIN = LanguageHandle.getInstance().getValue("Login", "LOGIN");
        CHANGE_LANGUAGE = LanguageHandle.getInstance().getValue("Login", "CHANGE_LANGUAGE");
    }

    public LoginFrame() {
        loadText();
        loadResource();
        initComponents();
        arangeComponents();
        txtUsername.setText("098765432101");
        txtPassword.setText("12345678");
    }

    private void loadResource() {
        // Nap anh nen
        imageBackground = ImageHandle.getInstance().readImage("/com/resource/background_login.jpg");
        // Nap anh logo
        imageLogo = ImageHandle.getInstance().getIconLogo();
        imageLogo = ImageHandle.getInstance().resize(
                imageLogo,
                200,
                200
        );
        // Icon Ngon ngu
        iconLanguage = ImageHandle.getInstance().readImage("/com/resource/language.png");
        iconLanguage = ImageHandle.getInstance().resize(
                iconLanguage,
                23,
                23
        );
    }

    private void initComponents() {
        setIconImage(imageLogo);
        setTitle(TITLE);
        setSize(LOGIN_WIDTH, LOGIN_HEIGHT);
        setMinimumSize(new Dimension(LOGIN_WIDTH, LOGIN_HEIGHT));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        lbLogo = new JLabel(new ImageIcon(imageLogo));

        txtUsername = new RoundedJTextFiled(USERNAME, 300, 50, 10);
        txtUsername.addFocusListener(new PlaceHolder(USERNAME, txtUsername));

        txtPassword = new RoundedJPasswordField(300, 50, 10);
        txtPassword.addFocusListener(new PlaceHolder("********", txtPassword));
        txtPassword.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Login();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
        lbNotification = new JLabel(" ", JLabel.LEFT);
        lbNotification.setPreferredSize(new Dimension(300, 20));
        lbNotification.setForeground(Color.red);

        btnLogin = new RoundedButton(LOGIN, 300, 50, 10);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Login();
            }
        });

        btnLanguage = new JLabel(new ImageIcon(iconLanguage));
        btnLanguage.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ChangeLanguage();
            }
        });

        leftCon = new Container();
        midCon = new Container();
        midCon.setLayout(new GridBagLayout());
        rightCon = new Container();
        rightCon.setLayout(new GridBagLayout());
    }

    private void arangeComponents() {
        mainJPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawImages(g);
            }

        };
        mainJPanel.setLayout(new GridLayout(1, 3));
        mainJPanel.add(leftCon);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridy = 0;
        midCon.add(lbLogo, gbc);
        gbc.gridy = 1;
        midCon.add(txtUsername, gbc);
        gbc.gridy = 2;
        midCon.add(txtPassword, gbc);
        gbc.gridy = 3;
        midCon.add(lbNotification, gbc);
        gbc.gridy = 4;

        midCon.add(btnLogin, gbc);
        mainJPanel.add(midCon);

        rightCon.add(btnLanguage, gbc);
        mainJPanel.add(rightCon);

        this.add(mainJPanel);
    }

    public void drawImages(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Ve hinh nen
        g2d.drawImage(
                ImageHandle.getInstance().resize(imageBackground, getWidth(), getHeight()),
                0,
                0,
                null
        );

        // Lam mo hinh nen
        g2d.setColor(new Color(0f, 0f, 0f, 0f));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        //De nut doi ngon ngu o goc
        btnLanguage.setLocation(
                rightCon.getWidth() - btnLanguage.getWidth(),
                rightCon.getHeight() - btnLanguage.getHeight()
        );
    }

    private void Login() {
        if ((!ConnectionHandle.getInstance().Login(txtUsername.getText(), txtPassword.getPassword()))
                || ConnectionHandle.getInstance().getConnection() == null) {
            lbNotification.setText(ERROR_MESSAGE);
        } else {
            this.dispose();
            new HomePageFrame().setVisible(true);
        }
    }

    private void ChangeLanguage() {
        LanguageHandle.getInstance().ChangeLanguage();
        lbNotification.setText(CHANGE_LANGUAGE);
        this.dispose();
        new LoginFrame().setVisible(true);
    }

    private static final int LOGIN_HEIGHT = 562;
    private static final int LOGIN_WIDTH = 1000;

    private Image imageBackground;
    private Image imageLogo;
    private Image iconLanguage;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel lbNotification;
    private RoundedButton btnLogin;
    private JLabel lbLogo;
    private JLabel btnLanguage;
    private JPanel mainJPanel;
    private Container leftCon;
    private Container midCon;
    private Container rightCon;

    // Text
    private String USERNAME;
    private String ERROR_MESSAGE;
    private String LOGIN;
    private String CHANGE_LANGUAGE;
    private String TITLE;

}

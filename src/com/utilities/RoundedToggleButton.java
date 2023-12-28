/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;

/**
 *
 * @author dang
 */
public class RoundedToggleButton extends JToggleButton {

    private boolean notification;

    private void initProperties() {
        setOpaque(false);
        setBorder(new NonBorder());
        setPreferredSize(new Dimension(100, 80));

        setBackground(Color.green);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setNotification(false);
            }
        });
        setFont(new CommonFont(20));
    }

    private RoundedToggleButton() {
        this.notification = true;
        initProperties();
    }

    public RoundedToggleButton(String text) {
        this.notification = true;
        setText(text);
        initProperties();
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (!isSelected()) {
            g2d.setColor(Color.green);
        }
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
        super.paintComponent(g);
        if (notification) {
            g2d.setColor(Color.red);
            g2d.fillRoundRect(
                    getWidth() - 20,
                    0,
                    20,
                    20,
                    90,
                    90
            );
        }
    }
}

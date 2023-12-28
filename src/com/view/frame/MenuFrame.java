/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view.frame;

import com.handle.ImageHandle;
import com.handle.LanguageHandle;
import com.handle.NetHandle;
import com.models.DataContext;
import com.models.DoUongModel;
import com.utilities.NonBorder;
import com.utilities.RoundedToggleButton;
import com.view.panel.BillPanel;
import com.view.panel.ChatPanel;
import com.view.panel.DinksPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/**
 *
 * @author dang
 */
public class MenuFrame extends JFrame {
    
    private void initChatArea() {
        leftCon = new Container();
        leftCon.setLayout(new BorderLayout(5, 5));
        leftCon.setPreferredSize(new Dimension(400, 0));
        panel.add(leftCon, BorderLayout.LINE_START);
    }
    
    private void initDrinkArea() {
        midCon = new Container();
        midCon.setLayout(new GridLayout());
        pMain = new Container();
        pMain.setLayout(new GridLayout(0, 3, 30, 30));
        loadDrinks();
        JViewport viewport = new JViewport();
        viewport.setOpaque(false);
        viewport.setView(pMain);
        scMain = new JScrollPane();
        scMain.setViewport(viewport);
        scMain.setOpaque(false);
        scMain.setBorder(new NonBorder());
        scMain.getViewport().setOpaque(false);
        scMain.getVerticalScrollBar().setUnitIncrement(50);
        scMain.setPreferredSize(new Dimension(300, 300));
        midCon.add(scMain);
        panel.add(midCon, BorderLayout.CENTER);
    }
    
    private void initBillArea() {
        rightCon = new Container();
        rightCon.setLayout(new GridLayout());
        rightCon.setPreferredSize(new Dimension(400, 0));
        panel.add(rightCon, BorderLayout.LINE_END);
    }
    
    private void initTableArea() {
        botCon = new Container();
        botCon.setLayout(new BorderLayout(10, 10));
        pTable = new Container();
        pTable.setLayout(new FlowLayout(
                FlowLayout.LEFT,
                10,
                10
        ));
        JViewport viewport = new JViewport();
        viewport.setOpaque(false);
        viewport.setView(pTable);
        scTable = new JScrollPane();
        scTable.setViewport(viewport);
        scTable.setOpaque(false);
        scTable.setBorder(new NonBorder());
        scTable.getViewport().setOpaque(false);
        botCon.add(scTable);
        panel.add(botCon, BorderLayout.PAGE_END);
        
    }
    
    private void initComponents() {
        setIconImage(ImageHandle.getInstance().getIconLogo());
        setTitle(TITLE);
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBackground(g);
            }
        };
        panel.setLayout(new BorderLayout());
        add(panel);
        setMinimumSize(new Dimension(1500, 700));
        initChatArea();
        initDrinkArea();
        initBillArea();
        initTableArea();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public void addTable(String name) {
        if (group == null) {
            group = new ButtonGroup();
        }
        ChatPanel cp = new ChatPanel(name);
        BillPanel bp = new BillPanel(name);
        RoundedToggleButton button = new RoundedToggleButton(TABLE + name);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                changTable(name);
            }
        });
        if (list == null) {
            list = new Hashtable<>();
        }
        list.put(name, new Object[]{cp, bp, button});
        group.add(button);
        pTable.add(button);
        revalidate();
        repaint();
    }
    
    private void changTable(String name) {
        currentTable = name;
        leftCon.removeAll();
        leftCon.add((ChatPanel) list.get(name)[0]);
        
        rightCon.removeAll();
        rightCon.add((BillPanel) list.get(name)[1]);
        revalidate();
        repaint();
    }
    
    public void addDrinks(DoUongModel du) {
        pMain.add(new DinksPanel(
                du.getMaDU(),
                du.getTenDU(),
                du.getHinhAnh()
        ));
    }
    
    private void loadText() {
        TITLE = LanguageHandle.getInstance().getValue("Menu", "TITLE");
        TABLE = LanguageHandle.getInstance().getValue("Menu", "TABLE");
        ORDER = LanguageHandle.getInstance().getValue("Chat", "ORDER");
        CANCEL = LanguageHandle.getInstance().getValue("Chat", "CANCEL");
    }
    
    public void sub(int id) {
        try {
            BillPanel bp = (BillPanel) list.get(currentTable)[1];
            bp.removeDrinks(DataContext.getInstance()
                    .getDoUongs()
                    .stream()
                    .filter(du -> du.getMaDU() == id)
                    .findFirst()
                    .get()
            );
        } catch (java.lang.NullPointerException e) {
            return;
        }
        NetHandle.getInstance().sendData("HuyMon:  " + id, currentTable);
    }
    
    public void plus(int id) {
        try {
            BillPanel bp = (BillPanel) list.get(currentTable)[1];
            bp.addDrinks(DataContext.getInstance()
                    .getDoUongs()
                    .stream()
                    .filter(du -> du.getMaDU() == id)
                    .findFirst()
                    .get()
            );
            
        } catch (java.lang.NullPointerException e) {
            return;
        }
        NetHandle.getInstance().sendData("ThemMon: " + id, currentTable);
    }
    
    private void loadDrinks() {
        for (int i = 0; i < DataContext.getInstance().getDoUongs().size(); i++) {
            addDrinks(DataContext.getInstance().getDoUongs().get(i));
        }
    }
    
    public void receiveMessage(String name, String message) {
        if (message.contains("ThemMon: ")) {
            int maDU = Integer.parseInt(message.substring(9).trim());
            DoUongModel doUongModel = DataContext.getInstance()
                    .getDoUongs()
                    .stream()
                    .filter(x -> x.getMaDU() == maDU)
                    .findFirst()
                    .get();
            message = ORDER + doUongModel.getTenDU() + " ID: " + doUongModel.getMaDU();
        } else if (message.contains("HuyMon:  ")) {
            int maDU = Integer.parseInt(message.substring(9).trim());
            DoUongModel doUongModel = DataContext.getInstance()
                    .getDoUongs()
                    .stream()
                    .filter(x -> x.getMaDU() == maDU)
                    .findFirst()
                    .get();
            message = CANCEL + doUongModel.getTenDU() + " ID: " + doUongModel.getMaDU();
        }
        ((ChatPanel) list.get(name)[0]).receiveMessage(message);
        ((RoundedToggleButton) list.get(name)[2]).setNotification(true);
        validate();
        repaint();
    }
    
    public void drawBackground(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Ve hinh nen
        g2d.drawImage(
                ImageHandle.getInstance().resize(imageBackground, getWidth(), getHeight()),
                0,
                0,
                null
        );
        // Lam mo hinh nen
        g2d.setColor(new Color(0f, 0f, 0f, 0.1f));
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
    
    private MenuFrame() {
        loadText();
        initComponents();
        imageBackground = ImageHandle.getInstance().readImage("/com/resource/back2.jpg");
    }
    
    public static synchronized MenuFrame getInstance() {
        if (_instance == null) {
            _instance = new MenuFrame();
        }
        return _instance;
    }
    
    private static MenuFrame _instance;
    // GUI Components
    private Container leftCon;
    private Container midCon;
    private Container rightCon;
    private Container botCon;
    private JScrollPane scTable;
    private JScrollPane scMain;
    private JScrollPane scChat;
    private JPanel panel;
    private Container pTable;
    private Container pMain;
    private JPanel pBill;
    private JEditorPane txtChat;

    // Variable
    private Hashtable<String, Object[]> list;
    private ButtonGroup group;
    private String currentTable;
    private Image imageBackground;

    //Text 
    private String TITLE;
    private String TABLE;
    private String ORDER;
    private String CANCEL;
}

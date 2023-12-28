/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view.frame;

import com.controller.KhachHangController;
import com.handle.ImageHandle;
import com.handle.LanguageHandle;
import com.models.DataContext;
import com.models.KhachHangModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;


/**
 *
 * @author vananh
 */
public class KhachHangFrame extends javax.swing.JFrame {

    DefaultTableModel modelttKH;

    /**
     * Creates new form KhachHangFrame
     */
    public KhachHangFrame() {
        initComponents(); 
        loadText();
        loadTable();

        configComponents();
    }

    private void loadText() {
        TITLE = LanguageHandle.getInstance().getValue("Customer", "TITLE");
        UPDATE = LanguageHandle.getInstance().getValue("Customer", "UPDATE");
        RESET = LanguageHandle.getInstance().getValue("Customer", "RESET");
        EXIT = LanguageHandle.getInstance().getValue("Customer", "EXIT");
        REFRESH = LanguageHandle.getInstance().getValue("Customer", "REFRESH");
        DELETE = LanguageHandle.getInstance().getValue("Customer", "DELETE");
        LIST_CUSTOMER = LanguageHandle.getInstance().getValue("Customer", "LIST_CUSTOMER");
        SEX = LanguageHandle.getInstance().getValue("Customer", "SEX");
        PHONE_NUMBER = LanguageHandle.getInstance().getValue("Customer", "PHONE_NUMBER");
        INFO_CUSTOMER = LanguageHandle.getInstance().getValue("Customer", "INFO_CUSTOMER");
        NAME_CUSTOMER = LanguageHandle.getInstance().getValue("Customer", "NAME_CUSTOMER");
        SUM_POINTS = LanguageHandle.getInstance().getValue("Customer", "SUM_POINTS");
        ADD = LanguageHandle.getInstance().getValue("Customer", "ADD");
        NOTIFICATION_TITLE = LanguageHandle.getInstance().getValue("Customer", "NOTIFICATION_TITLE");
        NOTI_SUCCESS = LanguageHandle.getInstance().getValue("Customer", "NOTI_SUCCESS");
        NOTI_FAILED = LanguageHandle.getInstance().getValue("Customer", "NOTI_FAILED");
        CHOSSE_DELETE = LanguageHandle.getInstance().getValue("Customer", "CHOSSE_DELETE");
        REQUEST_DELETE = LanguageHandle.getInstance().getValue("Customer", "REQUEST_DELETE");
        ERR_NUMBER_EMPTY = LanguageHandle.getInstance().getValue("Customer", "ERR_NUMBER_EMPTY");
        ERR_NUMBER_WRONG = LanguageHandle.getInstance().getValue("Customer", "ERR_NUMBER_WRONG");
        ERR_NAME_EMPTY = LanguageHandle.getInstance().getValue("Customer", "ERR_NAME_EMPTY");
        ERR_POINT_WRONG = LanguageHandle.getInstance().getValue("Customer", "ERR_POINT_WRONG");
        ERR_POINT_EMPTY = LanguageHandle.getInstance().getValue("Customer", "ERR_POINT_EMPTY");
        MALE = LanguageHandle.getInstance().getValue("Customer", "MALE");
        FEMALE = LanguageHandle.getInstance().getValue("Customer", "FEMALE");
    }

    private void configComponents() {
        setIconImage(ImageHandle.getInstance().getIconLogo());
        setTitle(TITLE);

        cbGioiTinh.removeAllItems();
        cbGioiTinh.addItem(MALE);
        cbGioiTinh.addItem(FEMALE);

        btnCapNhap.setText(UPDATE);
        btnReset.setText(REFRESH);
        btnThem.setText(ADD);
        btnXoa.setText(DELETE);

        lbDSKhachHang.setText(LIST_CUSTOMER);
        lbGioiTinh.setText(SEX);
        lbSDT.setText(PHONE_NUMBER);
        lbTTKhachHang.setText(INFO_CUSTOMER);
        lbTenKH.setText(NAME_CUSTOMER);
        lbTongDiem.setText(SUM_POINTS);

        txtSDT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        txtTongDiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lbSDT = new javax.swing.JLabel();
        lbTenKH = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        lbTongDiem = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        cbGioiTinh = new javax.swing.JComboBox<>();
        txtTongDiem = new javax.swing.JTextField();
        lbTTKhachHang = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbThongTinKH = new javax.swing.JTable();
        lbDSKhachHang = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(228, 207, 203));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSDT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSDT.setForeground(new java.awt.Color(97, 55, 47));
        lbSDT.setText("Số Điện Thoại");
        jPanel3.add(lbSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lbTenKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTenKH.setForeground(new java.awt.Color(97, 55, 47));
        lbTenKH.setText("Tên Khách Hàng");
        jPanel3.add(lbTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        lbGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbGioiTinh.setForeground(new java.awt.Color(97, 55, 47));
        lbGioiTinh.setText("Giới Tính");
        jPanel3.add(lbGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 80, -1));

        lbTongDiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTongDiem.setForeground(new java.awt.Color(97, 55, 47));
        lbTongDiem.setText("Tổng Điểm");
        jPanel3.add(lbTongDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 80, -1));

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        jPanel3.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 156, -1));
        jPanel3.add(txtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 156, -1));

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jPanel3.add(cbGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));
        jPanel3.add(txtTongDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 156, -1));

        lbTTKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTTKhachHang.setForeground(new java.awt.Color(97, 55, 47));
        lbTTKhachHang.setText("THÔNG TIN KHÁCH HÀNG");
        jPanel3.add(lbTTKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/add (1).png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel3.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 30));

        btnCapNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCapNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/edit (2).png"))); // NOI18N
        btnCapNhap.setText("Cập Nhập");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });
        jPanel3.add(btnCapNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, 30));

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/delete (1).png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel3.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, 30));

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/refresh-arrow.png"))); // NOI18N
        btnReset.setText("Refresh");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel3.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 100, 30));

        tbThongTinKH.setBackground(new java.awt.Color(207, 179, 159));
        tbThongTinKH.setForeground(new java.awt.Color(51, 34, 25));
        tbThongTinKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Số Điện Thoại", "Tên Khách Hàng", "Giới Tính", "Tổng Điểm"
            }
        ));
        tbThongTinKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThongTinKHMouseClicked(evt);
            }
        });
        tbThongTinKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbThongTinKHKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbThongTinKH);

        lbDSKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDSKhachHang.setForeground(new java.awt.Color(97, 55, 47));
        lbDSKhachHang.setText("Danh sách Khách Hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDSKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDSKhachHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String checkError() {
        if (txtSDT.getText().equals("")) {
            return ERR_NUMBER_EMPTY;
        } else {
            try {
                Integer.parseInt(txtSDT.getText());
            } catch (Exception e) {
                return ERR_NUMBER_WRONG;
            }
        }
        if (txtSDT.getText().length() != 10) {
            return ERR_NUMBER_WRONG;
        }

        if (txtTenKH.getText().equals("")) {
            return ERR_NAME_EMPTY;
        }
        if (txtTongDiem.getText().equals("")) {
            try {
                int tongdiem = Integer.parseInt(txtTongDiem.getText());
                if (tongdiem < 0) {
                    return ERR_POINT_WRONG;
                }
            } catch (Exception e) {
                return ERR_POINT_WRONG;
            }
            return ERR_POINT_EMPTY;
        }
        return "";
    }

    public void loadTable() {
        modelttKH = (DefaultTableModel) new DefaultTableModel();
        try {
            modelttKH = new DefaultTableModel();
            String tieuDe[] = {PHONE_NUMBER, NAME_CUSTOMER, SEX, SUM_POINTS};
            modelttKH.setColumnIdentifiers(tieuDe);
            Object row[] = new Object[4];
            int i = 0;
            KhachHangController.getInstance().LayDuLieu();
            while (i < DataContext.getInstance().getKhachHangs().size()) {
                row[0] = DataContext.getInstance().getKhachHangs().get(i).getSDTKH();
                row[1] = DataContext.getInstance().getKhachHangs().get(i).getTenKH();
                int gt = DataContext.getInstance().getKhachHangs().get(i).getGioiTinh();
                if (gt == 0) {
                    row[2] = MALE;
                } else {
                    row[2] = FEMALE;
                }
                row[3] = DataContext.getInstance().getKhachHangs().get(i).getTongDiem();
                i++;
                modelttKH.addRow(row);
            }
        } catch (Exception e) {
        }
        tbThongTinKH.setModel(modelttKH);
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String sdt = txtSDT.getText();
        String tenKH = txtTenKH.getText();
        var x = checkError();
        if (!x.equals("")) {
            JOptionPane.showConfirmDialog(null, x, NOTIFICATION_TITLE, JOptionPane.DEFAULT_OPTION);
            return;
        }
        try {
            KhachHangModel kh = new KhachHangModel();
            kh.setSDTKH(sdt);
            kh.setTenKH(tenKH);
            //0: Nam 1: Nữ
            if (cbGioiTinh.getSelectedItem().equals(MALE)) {
                kh.setGioiTinh(0);
            } else {
                kh.setGioiTinh(1);
            }
            kh.setTongDiem(Integer.parseInt(txtTongDiem.getText()));
            if (KhachHangController.getInstance().ThemKhachHang(kh)) {
                JOptionPane.showMessageDialog(null, NOTI_SUCCESS);
            } else {
                JOptionPane.showMessageDialog(null, NOTI_FAILED);
            }
            loadTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, NOTI_FAILED);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        String tenKH = txtTenKH.getText();
        txtSDT.setEditable(true);
        StringBuilder sb = new StringBuilder();
        var x = checkError();
        if (!x.equals("")) {
            JOptionPane.showConfirmDialog(null, x, NOTIFICATION_TITLE, JOptionPane.DEFAULT_OPTION);
            return;
        }
        try {
            KhachHangModel kh = new KhachHangModel();
            kh.setTenKH(tenKH);
            //0: Nam 1: Nữ
            if (cbGioiTinh.getSelectedItem().equals(MALE)) {
                kh.setGioiTinh(0);
            } else {
                kh.setGioiTinh(1);
            }
            kh.setTongDiem(Integer.parseInt(txtTongDiem.getText()));
            if (KhachHangController.getInstance().SuaKhachHang(txtSDT.getText(), kh) == true) {
                JOptionPane.showMessageDialog(null, NOTI_SUCCESS);
            } else {
                JOptionPane.showMessageDialog(null, NOTI_FAILED);
            }
            loadTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, NOTI_FAILED);
        }
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void tbThongTinKHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbThongTinKHKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbThongTinKHKeyPressed

    private void tbThongTinKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThongTinKHMouseClicked
        try {
            int row = this.tbThongTinKH.getSelectedRow();
            if (row >= 0 && row <= tbThongTinKH.getRowCount()) {
                txtSDT.setText(tbThongTinKH.getValueAt(row, 0).toString());
                txtTenKH.setText(tbThongTinKH.getValueAt(row, 1).toString());
                if (tbThongTinKH.getValueAt(row, 2).toString().trim().equals(MALE)) {
                    cbGioiTinh.setSelectedItem(MALE);
                } else {
                    cbGioiTinh.setSelectedItem(FEMALE);
                }
                txtTongDiem.setText(tbThongTinKH.getValueAt(row, 3).toString());
            }
            loadTable();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbThongTinKHMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtSDT.setText("");
        txtTenKH.setText("");
        txtTongDiem.setText("");
        cbGioiTinh.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (this.txtSDT.getText().length() == 0)
            JOptionPane.showMessageDialog(null, REQUEST_DELETE, NOTIFICATION_TITLE, 1);
        else {
            try {
                int result = JOptionPane.showConfirmDialog(this, REQUEST_DELETE, NOTIFICATION_TITLE, JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    if (KhachHangController.getInstance().XoaKhachHang(txtSDT.getText()) == true) {
                        JOptionPane.showMessageDialog(this, NOTI_SUCCESS, NOTIFICATION_TITLE, JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, NOTI_FAILED, NOTIFICATION_TITLE, JOptionPane.WARNING_MESSAGE);
                    }
                }
                loadTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, NOTI_FAILED, NOTIFICATION_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private String TITLE;
    private String UPDATE;
    private String RESET;
    private String EXIT;
    private String REFRESH;
    private String DELETE;
    private String LIST_CUSTOMER;
    private String SEX;
    private String PHONE_NUMBER;
    private String INFO_CUSTOMER;
    private String NAME_CUSTOMER;
    private String SUM_POINTS;
    private String ADD;
    private String NOTIFICATION_TITLE;
    private String NOTI_SUCCESS;
    private String NOTI_FAILED;
    private String CHOSSE_DELETE;
    private String REQUEST_DELETE;
    private String ERR_NUMBER_EMPTY;
    private String ERR_NUMBER_WRONG;
    private String ERR_NAME_EMPTY;
    private String ERR_POINT_WRONG;
    private String ERR_POINT_EMPTY;
    private String MALE;
    private String FEMALE;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDSKhachHang;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbTTKhachHang;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JLabel lbTongDiem;
    private javax.swing.JTable tbThongTinKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTongDiem;
    // End of variables declaration//GEN-END:variables
}

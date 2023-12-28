/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view.frame;

import com.controller.ChiNhanhController;
import com.controller.NhanVienController;
import com.handle.ImageHandle;
import com.handle.LanguageHandle;
import com.models.ChiNhanhModel;
import com.models.DataContext;
import com.models.NhanVienModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dang
 */
public class NhanVienFrame extends javax.swing.JFrame {

    /**
     * Creates new form KhachHangFrame01
     */
    public NhanVienFrame() {
        loadText();
        initComponents();
        LoadTable();
        loadMaCN();
        configComponents();
    }

    private void loadText() {
        TITLE = LanguageHandle.getInstance().getValue("Employee", "TITLE");
        UPDATE = LanguageHandle.getInstance().getValue("Employee", "UPDATE");
        RESET = LanguageHandle.getInstance().getValue("Employee", "RESET");
        EXIT = LanguageHandle.getInstance().getValue("Employee", "EXIT");
        REFRESH = LanguageHandle.getInstance().getValue("Employee", "REFRESH");
        DELETE = LanguageHandle.getInstance().getValue("Employee", "DELETE");
        CCCD = LanguageHandle.getInstance().getValue("Employee", "CCCD");
        LIST_EMPLOYEE = LanguageHandle.getInstance().getValue("Employee", "LIST_EMPLOYEE");
        SEX = LanguageHandle.getInstance().getValue("Employee", "SEX");
        ID_BRANCH = LanguageHandle.getInstance().getValue("Employee", "ID_BRANCH");
        ID_EMPLOYEE = LanguageHandle.getInstance().getValue("Employee", "ID_EMPLOYEE");
        DATE_WORK = LanguageHandle.getInstance().getValue("Employee", "DATE_WORK");
        INFO_EMPLOYEE = LanguageHandle.getInstance().getValue("Employee", "INFO_EMPLOYEE");
        NAME_BRANCH = LanguageHandle.getInstance().getValue("Employee", "NAME_BRANCH");
        NAME_EMPLOYEE = LanguageHandle.getInstance().getValue("Employee", "NAME_EMPLOYEE");
        NOTIFICATION_TITLE = LanguageHandle.getInstance().getValue("Employee", "NOTIFICATION_TITLE");
        NOTI_SUCCESS = LanguageHandle.getInstance().getValue("Employee", "NOTI_SUCCESS");
        NOTI_FAILED = LanguageHandle.getInstance().getValue("Employee", "NOTI_FAILED");
        CHOSSE_DELETE = LanguageHandle.getInstance().getValue("Employee", "CHOSSE_DELETE");
        REQUEST_DELETE = LanguageHandle.getInstance().getValue("Employee", "REQUEST_DELETE");
        MALE = LanguageHandle.getInstance().getValue("Employee", "MALE");
        FEMALE = LanguageHandle.getInstance().getValue("Employee", "FEMALE");
        ERR_NAME_EMPLOYEE_EMPTY = LanguageHandle.getInstance().getValue("Employee", "ERR_NAME_EMPLOYEE_EMPTY");
        ERR_DATE_WRONG = LanguageHandle.getInstance().getValue("Employee", "ERR_DATE_WRONG");
        ERR_CCCD = LanguageHandle.getInstance().getValue("Employee", "ERR_CCCD");
        ADD = LanguageHandle.getInstance().getValue("Employee", "ADD");
    }

    private void configComponents() {
        setIconImage(ImageHandle.getInstance().getIconLogo());
        setTitle(TITLE);

        cbGioiTinh.removeAllItems();
        cbGioiTinh.addItem(MALE);
        cbGioiTinh.addItem(FEMALE);

        btnCapNhap.setText(UPDATE);
        btnRefreshNV.setText(REFRESH);
        btnThem.setText(ADD);
        btnXoa.setText(DELETE);

        lbCCCD.setText(CCCD);
        lbDSNhanVien.setText(LIST_EMPLOYEE);
        lbGioiTinh.setText(SEX);
        lbMaCN.setText(ID_BRANCH);
        lbMaNV.setText(ID_EMPLOYEE);
        lbNgayVL.setText(DATE_WORK);
        lbTTNhanVien.setText(INFO_EMPLOYEE);
        lbTenCN.setText(NAME_BRANCH);
        lbTenNV.setText(NAME_EMPLOYEE);

        txtCCCD.addKeyListener(new KeyAdapter() {
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

        jPanel2 = new javax.swing.JPanel();
        lbMaCN = new javax.swing.JLabel();
        lbMaNV = new javax.swing.JLabel();
        lbTenNV = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        lbNgayVL = new javax.swing.JLabel();
        lbCCCD = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        cbGioiTinh = new javax.swing.JComboBox<>();
        lbTenCN = new javax.swing.JLabel();
        txtTenCN = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnRefreshNV = new javax.swing.JButton();
        lbTTNhanVien = new javax.swing.JLabel();
        cbMaCN = new javax.swing.JComboBox<>();
        NgayVL = new com.toedter.calendar.JDateChooser();
        lbDSNhanVien = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(228, 207, 203));
        jPanel2.setForeground(new java.awt.Color(97, 55, 47));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMaCN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMaCN.setForeground(new java.awt.Color(97, 55, 47));
        lbMaCN.setText("Mã Chi Nhánh");
        jPanel2.add(lbMaCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 130, -1));

        lbMaNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMaNV.setForeground(new java.awt.Color(97, 55, 47));
        lbMaNV.setText("Mã Nhân Viên");
        jPanel2.add(lbMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, -1));

        lbTenNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTenNV.setForeground(new java.awt.Color(97, 55, 47));
        lbTenNV.setText("Tên Nhân Viên");
        jPanel2.add(lbTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 120, -1));

        lbGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbGioiTinh.setForeground(new java.awt.Color(97, 55, 47));
        lbGioiTinh.setText("Giới Tính");
        jPanel2.add(lbGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 110, -1));

        lbNgayVL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNgayVL.setText("Ngày Vào Làm");
        jPanel2.add(lbNgayVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 130, -1));

        lbCCCD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbCCCD.setText("CCCD");
        jPanel2.add(lbCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 130, -1));

        txtMaNV.setEnabled(false);
        jPanel2.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 150, -1));

        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });
        jPanel2.add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 150, -1));

        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDActionPerformed(evt);
            }
        });
        jPanel2.add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 150, -1));

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jPanel2.add(cbGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        lbTenCN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTenCN.setForeground(new java.awt.Color(97, 55, 47));
        lbTenCN.setText("Tên Chi Nhánh");
        jPanel2.add(lbTenCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 130, -1));

        txtTenCN.setText("UIT");
        txtTenCN.setEnabled(false);
        jPanel2.add(txtTenCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 150, -1));

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/add (1).png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 100, 30));

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/delete (1).png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, -1, -1));

        btnCapNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCapNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/edit (2).png"))); // NOI18N
        btnCapNhap.setText("Cập Nhập");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });
        jPanel2.add(btnCapNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 110, 30));

        btnRefreshNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefreshNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/refresh-arrow.png"))); // NOI18N
        btnRefreshNV.setText("Refresh ");
        btnRefreshNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshNVActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefreshNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 110, 30));

        lbTTNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTTNhanVien.setForeground(new java.awt.Color(97, 55, 47));
        lbTTNhanVien.setText("Thông tin Nhân Viên");
        jPanel2.add(lbTTNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 41, -1, -1));

        cbMaCN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cbMaCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaCNActionPerformed(evt);
            }
        });
        jPanel2.add(cbMaCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));
        jPanel2.add(NgayVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 150, -1));

        lbDSNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDSNhanVien.setForeground(new java.awt.Color(97, 55, 47));
        lbDSNhanVien.setText("Danh sách Nhân Viên");

        tbNV.setBackground(new java.awt.Color(207, 179, 159));
        tbNV.setForeground(new java.awt.Color(51, 34, 25));
        tbNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Chi Nhánh", "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Ngày Vào Làm", "CCCD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDSNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDSNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultTableModel listNV;

    public void LoadTable() {
        listNV = new DefaultTableModel();
        String tieuDe[] = {ID_BRANCH, ID_EMPLOYEE, NAME_EMPLOYEE, SEX, DATE_WORK, CCCD};
        listNV.setColumnIdentifiers(tieuDe);
        Object row[] = new Object[6];
        NhanVienController.getInstance().LayDuLieu();
        int i = 0;
        while (i < DataContext.getInstance().getNhanViens().size()) {
            try {
                row[0] = DataContext.getInstance().getNhanViens().get(i).getMaCN();
                row[1] = DataContext.getInstance().getNhanViens().get(i).getMaNV();
                row[2] = DataContext.getInstance().getNhanViens().get(i).getTenNV();
                int gt = DataContext.getInstance().getNhanViens().get(i).getGioiTinh();
                if (gt == 0) {
                    row[3] = MALE;
                } else {
                    row[3] = FEMALE;
                }
                row[4] = DataContext.getInstance().getNhanViens().get(i).getNgayVL();
                row[5] = DataContext.getInstance().getNhanViens().get(i).getCCCD();
                i++;
                listNV.addRow(row);
            } catch (Exception e) {
            }
        }
        tbNV.setModel(listNV);
        setVisible(true);
    }

    public void loadMaCN() {
        cbMaCN.removeAllItems();
        try {
            ChiNhanhController.getInstance().LayDuLieu();
            for (ChiNhanhModel i : DataContext.getInstance().getChiNhanhs()) {
                int maCN = i.getMaCN();
                cbMaCN.addItem(String.valueOf(maCN));
            }
        } catch (Exception e) {
        }
    }

    public String checkError() {
        if (txtTenNV.getText().equals("")) {
            return ERR_NAME_EMPLOYEE_EMPTY;
        }
        if (NgayVL.getDate() == null) {
            if (NgayVL.isValid() == false) {
                return ERR_DATE_WRONG;
            }
        }
        if (!(txtCCCD.getText().length() == 9 || txtCCCD.getText().length() == 12)) {
            return ERR_CCCD;
        }
        return "";
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String tenNV = txtTenNV.getText();
        var x = checkError();
        if (!x.equals("")) {
            JOptionPane.showConfirmDialog(null, x, NOTIFICATION_TITLE, JOptionPane.DEFAULT_OPTION);
            return;
        }
        try {
            NhanVienModel nv = new NhanVienModel();
            nv.setTenNV(tenNV);
            nv.setMaCN(
                    DataContext.getInstance()
                            .getChiNhanhs()
                            .get(cbMaCN.getSelectedIndex())
                            .getMaCN()
            );

            //Nam: 0, Nữ: 1
            if (cbGioiTinh.getSelectedIndex() == 0) {
                nv.setGioiTinh(0);
            } else {
                nv.setGioiTinh(1);
            }
            nv.setNgayVL(new java.sql.Date(NgayVL.getDate().getTime()));
            nv.setCCCD(txtCCCD.getText());
            if (NhanVienController.getInstance().ThemNhanVien(nv)) {
                JOptionPane.showMessageDialog(null, NOTI_SUCCESS);
            } else {
                JOptionPane.showMessageDialog(this, NOTI_FAILED);
                return;
            }
            LoadTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, NOTI_FAILED);
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void cbMaCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaCNActionPerformed
        try {
            txtTenCN.setText(NhanVienController.getInstance().hienthiTenCN((Integer.parseInt(cbMaCN.getSelectedItem().toString()))));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbMaCNActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        String tenNV = txtTenNV.getText();
        String cccd = txtCCCD.getText();
        var x = checkError();
        if (!x.equals("")) {
            JOptionPane.showConfirmDialog(null, x, NOTIFICATION_TITLE, JOptionPane.DEFAULT_OPTION);
            return;
        }
        try {
            NhanVienModel nv = new NhanVienModel();
            String maCN = cbMaCN.getSelectedItem().toString();
            nv.setTenNV(tenNV);
            nv.setMaCN(Integer.parseInt(maCN));
            nv.setCCCD(cccd);
            //Nam: 0, Nữ: 1
            if (cbGioiTinh.getSelectedIndex() == 0) {
                nv.setGioiTinh(0);
            } else {
                nv.setGioiTinh(1);
            }
            nv.setNgayVL(new java.sql.Date(NgayVL.getDate().getTime()));
            int maNV = Integer.parseInt(txtMaNV.getText());
            if (NhanVienController.getInstance().SuaNhanVien(maNV, nv)) {
                JOptionPane.showMessageDialog(null, NOTI_SUCCESS);
            } else {
                JOptionPane.showMessageDialog(null, NOTI_FAILED);
            }
            LoadTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, NOTI_FAILED);
        }
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        if (txtMaNV.getText().equals("")) {
            JOptionPane.showMessageDialog(null, CHOSSE_DELETE, NOTIFICATION_TITLE, 1);
        } else {
            try {
                NhanVienController.getInstance().LayDuLieu();
                int result = JOptionPane.showConfirmDialog(this, REQUEST_DELETE, NOTIFICATION_TITLE, JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    if (NhanVienController.getInstance().XoaNhanVien(Integer.parseInt(txtMaNV.getText())) == true) {
                        JOptionPane.showMessageDialog(this, NOTI_SUCCESS);
                    } else {
                        JOptionPane.showMessageDialog(null, NOTI_FAILED);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, NOTI_FAILED);
            }
        }
        LoadTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnRefreshNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshNVActionPerformed
        cbMaCN.setSelectedIndex(0);
        txtTenNV.setText("");
        txtCCCD.setText("");
        cbGioiTinh.setSelectedIndex(0);
        txtMaNV.setText("");
        NgayVL.setDate(null);
    }//GEN-LAST:event_btnRefreshNVActionPerformed

    private void tbNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNVMouseClicked
        try {
            int row = this.tbNV.getSelectedRow();
            if (row >= 0 && row <= tbNV.getRowCount()) {
                String maCN = tbNV.getValueAt(row, 0).toString();
                cbMaCN.setSelectedItem(maCN);
                String tencn = NhanVienController.getInstance().hienthiTenCN(Integer.parseInt(maCN));
                txtTenCN.setText(tencn);
                txtMaNV.setText(tbNV.getValueAt(row, 1).toString());
                txtTenNV.setText(tbNV.getValueAt(row, 2).toString());
                //0: Nam 1: Nữ
                if (tbNV.getValueAt(row, 3).toString().trim().equals(MALE)) {
                    cbGioiTinh.setSelectedItem(MALE);
                } else {
                    cbGioiTinh.setSelectedItem(FEMALE);
                }
                NgayVL.setDate((Date) tbNV.getModel().getValueAt(row, 4));
                txtCCCD.setText(tbNV.getValueAt(row, 5).toString());
                LoadTable();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbNVMouseClicked

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void txtCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCCDActionPerformed
    private String TITLE;
    private String UPDATE;
    private String RESET;
    private String EXIT;
    private String REFRESH;
    private String DELETE;
    private String ADD;
    private String CCCD;
    private String LIST_EMPLOYEE;
    private String SEX;
    private String ID_BRANCH;
    private String ID_EMPLOYEE;
    private String DATE_WORK;
    private String INFO_EMPLOYEE;
    private String NAME_BRANCH;
    private String NAME_EMPLOYEE;
    private String NOTIFICATION_TITLE;
    private String NOTI_SUCCESS;
    private String NOTI_FAILED;
    private String CHOSSE_DELETE;
    private String REQUEST_DELETE;
    private String MALE;
    private String FEMALE;
    private String ERR_NAME_EMPLOYEE_EMPTY;
    private String ERR_DATE_WRONG;
    private String ERR_CCCD;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser NgayVL;
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnRefreshNV;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JComboBox<String> cbMaCN;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCCCD;
    private javax.swing.JLabel lbDSNhanVien;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbMaCN;
    private javax.swing.JLabel lbMaNV;
    private javax.swing.JLabel lbNgayVL;
    private javax.swing.JLabel lbTTNhanVien;
    private javax.swing.JLabel lbTenCN;
    private javax.swing.JLabel lbTenNV;
    private javax.swing.JTable tbNV;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTenCN;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}

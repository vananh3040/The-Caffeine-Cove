/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view.frame;

import com.controller.CTHDController;
import com.controller.GiamGiaController;
import com.controller.HoaDonKhachHangController;
import com.controller.NhanVienController;
import com.handle.ImageHandle;
import com.handle.LanguageHandle;
import com.models.CTHDModel;
import com.models.DataContext;
import com.models.GiamGiaModel;
import com.models.HoaDonKhachHangModel;
import com.models.NhanVienModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;

/**
 *
 * @author nam
 */
public class HoaDonKhachHangFrame extends javax.swing.JFrame {

    /**
     * Creates new form HoaDonKhachHangFrame
     */
    public HoaDonKhachHangFrame() {
        initComponents();
        loadText();
        configComponents();
        loadTableHD();
        combMaGiamGia();
        combMaNhanVien();
    }

    private void loadText() {
        TITLE = LanguageHandle.getInstance().getValue("BillFrame", "TITLE");
        UPDATE = LanguageHandle.getInstance().getValue("BillFrame", "UPDATE");
        RESET = LanguageHandle.getInstance().getValue("BillFrame", "RESET");
        EXIT = LanguageHandle.getInstance().getValue("BillFrame", "EXIT");
        REFRESH = LanguageHandle.getInstance().getValue("BillFrame", "REFRESH");
        DELETE = LanguageHandle.getInstance().getValue("BillFrame", "DELETE");
        PHONE_NUMBER = LanguageHandle.getInstance().getValue("BillFrame", "PHONE_NUMBER");
        CREATE_DATE = LanguageHandle.getInstance().getValue("BillFrame", "CREATE_DATE");
        LIST_DETAILS = LanguageHandle.getInstance().getValue("BillFrame", "LIST_DETAILS");
        LIST_BILL = LanguageHandle.getInstance().getValue("BillFrame", "LIST_BILL");
        ID_DISCOUNT = LanguageHandle.getInstance().getValue("BillFrame", "ID_DISCOUNT");
        ID_BILL = LanguageHandle.getInstance().getValue("BillFrame", "ID_BILL");
        ID_EMPLOYEE = LanguageHandle.getInstance().getValue("BillFrame", "ID_EMPLOYEE");
        INFO_BILL = LanguageHandle.getInstance().getValue("BillFrame", "INFO_BILL");
        SUM = LanguageHandle.getInstance().getValue("BillFrame", "SUM");
        NOTIFICATION_TITLE = LanguageHandle.getInstance().getValue("BillFrame", "NOTIFICATION_TITLE");
        NOTI_SUCCESS = LanguageHandle.getInstance().getValue("BillFrame", "NOTI_SUCCESS");
        NOTI_FAILED = LanguageHandle.getInstance().getValue("BillFrame", "NOTI_FAILED");
        CHOSSE_DELETE = LanguageHandle.getInstance().getValue("BillFrame", "CHOSSE_DELETE");
        REQUEST_DELETE = LanguageHandle.getInstance().getValue("BillFrame", "REQUEST_DELETE");
        ID_DRINK = LanguageHandle.getInstance().getValue("BillFrame", "ID_DRINK");
        QUANTILE = LanguageHandle.getInstance().getValue("BillFrame", "QUANTILE");
        PRICE = LanguageHandle.getInstance().getValue("BillFrame", "PRICE");
        ERR_NUMBER_EMPTY = LanguageHandle.getInstance().getValue("BillFrame", "ERR_NUMBER_EMPTY");
        ERR_NUMBER_WRONG = LanguageHandle.getInstance().getValue("BillFrame", "ERR_NUMBER_WRONG");
        ERR_SUM_EMPTY = LanguageHandle.getInstance().getValue("BillFrame", "ERR_SUM_EMPTY");
        ERR_SUM_WRONG = LanguageHandle.getInstance().getValue("BillFrame", "ERR_SUM_WRONG");
    }

    private void configComponents() {
        setIconImage(ImageHandle.getInstance().getIconLogo());
        setTitle(TITLE);
        btnCapNhap.setText(UPDATE);
        btnRefresh.setText(REFRESH);
        btnXoa.setText(DELETE);

        lbDSCTHD.setText(LIST_DETAILS);
        lbDSHoaDonKH.setText(LIST_BILL);
        lbMaGiamGia.setText(ID_DISCOUNT);
        lbMaHD.setText(ID_BILL);
        lbMaNV.setText(ID_EMPLOYEE);
        lbNgLap.setText(CREATE_DATE);
        lbSDTKH.setText(PHONE_NUMBER);
        lbThongTinHD.setText(INFO_BILL);
        lbTongTien.setText(SUM);
        
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
        
        txtTongTien.addKeyListener(new KeyAdapter() {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbMaHD = new javax.swing.JLabel();
        lbMaGiamGia = new javax.swing.JLabel();
        lbMaNV = new javax.swing.JLabel();
        lbSDTKH = new javax.swing.JLabel();
        lbNgLap = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        lbThongTinHD = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        NgayLap = new com.toedter.calendar.JDateChooser();
        txtTongTien = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        cbMaGiamGia = new javax.swing.JComboBox<>();
        cbMaNV = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHDKH = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        lbDSHoaDonKH = new javax.swing.JLabel();
        lbDSCTHD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(228, 207, 203));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMaHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMaHD.setForeground(new java.awt.Color(97, 55, 47));
        lbMaHD.setText("Mã HD");
        jPanel2.add(lbMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 74, 61, -1));

        lbMaGiamGia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMaGiamGia.setForeground(new java.awt.Color(97, 55, 47));
        lbMaGiamGia.setText("Mã Giảm Giá");
        jPanel2.add(lbMaGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 122, 93, -1));

        lbMaNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMaNV.setForeground(new java.awt.Color(97, 55, 47));
        lbMaNV.setText("Mã Nhân Viên");
        jPanel2.add(lbMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 219, 93, -1));

        lbSDTKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSDTKH.setForeground(new java.awt.Color(97, 55, 47));
        lbSDTKH.setText("SĐT Khách Hàng");
        jPanel2.add(lbSDTKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 171, -1, -1));

        lbNgLap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNgLap.setForeground(new java.awt.Color(97, 55, 47));
        lbNgLap.setText("Ngày Lập");
        jPanel2.add(lbNgLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 272, 90, -1));

        lbTongTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTongTien.setForeground(new java.awt.Color(97, 55, 47));
        lbTongTien.setText("Tổng Tiền");
        jPanel2.add(lbTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 325, 90, -1));

        lbThongTinHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbThongTinHD.setForeground(new java.awt.Color(97, 55, 47));
        lbThongTinHD.setText("Thông tin Hóa Đơn Khách Hàng");
        jPanel2.add(lbThongTinHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 23, 235, -1));

        txtMaHD.setEnabled(false);
        txtMaHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaHDMouseClicked(evt);
            }
        });
        jPanel2.add(txtMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 71, 140, -1));
        jPanel2.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 168, 140, -1));

        NgayLap.setEnabled(false);
        jPanel2.add(NgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 266, 143, -1));
        jPanel2.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 322, 143, -1));

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/delete (1).png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, -1, -1));

        btnCapNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCapNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/edit (2).png"))); // NOI18N
        btnCapNhap.setText("Cập Nhập");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });
        jPanel2.add(btnCapNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, 30));

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/refresh-arrow.png"))); // NOI18N
        btnRefresh.setText("Refresh ");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, 30));

        cbMaGiamGia.setEnabled(false);
        cbMaGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMaGiamGiaMouseClicked(evt);
            }
        });
        cbMaGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaGiamGiaActionPerformed(evt);
            }
        });
        jPanel2.add(cbMaGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 119, 90, -1));

        cbMaNV.setEnabled(false);
        cbMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaNVActionPerformed(evt);
            }
        });
        jPanel2.add(cbMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 216, 90, -1));

        tbHDKH.setBackground(new java.awt.Color(207, 179, 159));
        tbHDKH.setForeground(new java.awt.Color(51, 34, 25));
        tbHDKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Mã Giảm Giá", "SĐT Khách Hàng", "Mã Nhân Viên", "Ngày Lập", "Tổng Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbHDKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHDKH);

        tbCTHD.setBackground(new java.awt.Color(207, 179, 159));
        tbCTHD.setForeground(new java.awt.Color(51, 34, 25));
        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã DU", "Số Lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCTHD);

        lbDSHoaDonKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDSHoaDonKH.setForeground(new java.awt.Color(97, 55, 47));
        lbDSHoaDonKH.setText("Danh sách Hóa đơn Khách Hàng");

        lbDSCTHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDSCTHD.setForeground(new java.awt.Color(97, 55, 47));
        lbDSCTHD.setText("Danh sách CTHD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDSHoaDonKH)
                            .addComponent(lbDSCTHD))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbDSHoaDonKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDSCTHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loadTableHD() {
        modelHDKH = new DefaultTableModel();
        try {
            HoaDonKhachHangModel kh = new HoaDonKhachHangModel();
            modelHDKH = new DefaultTableModel();
            String tieuDe[] = {ID_BILL, ID_DISCOUNT, PHONE_NUMBER, ID_EMPLOYEE, CREATE_DATE, SUM};
            modelHDKH.setColumnIdentifiers(tieuDe);
            Object row[] = new Object[6];
            int i = 0;
            HoaDonKhachHangController.getInstance().LayDuLieu();
            while (i < DataContext.getInstance().getHoaDonKhachHangs().size()) {
                row[0] = DataContext.getInstance().getHoaDonKhachHangs().get(i).getMaHD();
                row[1] = DataContext.getInstance().getHoaDonKhachHangs().get(i).getMaGiamGia();
                row[2] = DataContext.getInstance().getHoaDonKhachHangs().get(i).getSDTKH();
                row[3] = DataContext.getInstance().getHoaDonKhachHangs().get(i).getMaNV();
                row[4] = DataContext.getInstance().getHoaDonKhachHangs().get(i).getNgayLap();
                row[5] = DataContext.getInstance().getHoaDonKhachHangs().get(i).getTongTien();
                i++;
                modelHDKH.addRow(row);
            }
        } catch (Exception e) {
        }
        tbHDKH.setModel(modelHDKH);
        setVisible(true);
    }

    public String checkError() {
        if (txtSDT.getText().equals("")) {
            return ERR_NUMBER_EMPTY;
        } else if (txtSDT.getText().length() < 9 || txtSDT.getText().length() > 11) {
            return ERR_NUMBER_WRONG;
        } else {
            try {
                Integer.parseInt(txtSDT.getText());
            } catch (Exception e) {
                return ERR_NUMBER_WRONG;
            }
        }

        if (txtTongTien.getText().equals("")) {
            try {
                int tongtiem = Integer.parseInt(txtTongTien.getText());
                if (tongtiem < 0) {
                    return ERR_NUMBER_WRONG;
                }
            } catch (Exception e) {
                return ERR_NUMBER_WRONG;
            }
            return ERR_SUM_EMPTY;
        }
        return "";
    }

    public void loadTableCTHD(int ma) {
        try {
            modelCTHD = new DefaultTableModel();
            String tieuDe[] = {ID_BILL, ID_DRINK, QUANTILE, PRICE};
            modelCTHD.setColumnIdentifiers(tieuDe);
            CTHDController.getInstance().LayDuLieu();
            int mahd = Integer.parseInt(txtMaHD.getText().trim());
            for (CTHDModel cthd : DataContext.getInstance().getCTHDs()) {
                if (mahd == cthd.getMaHD()) {
                    modelCTHD.addRow(new Object[]{
                        cthd.getMaHD(),
                        cthd.getMADU(),
                        cthd.getSoLuong(),
                        cthd.getGia()
                    });
                }
            }
            tbCTHD.setModel(modelHDKH);
        } catch (Exception e) {
        }
        tbCTHD.setModel(modelCTHD);
        setVisible(true);
    }

    public void combMaGiamGia() {
        try {
            GiamGiaController.getInstance().LayDuLieu();
            for (GiamGiaModel i : DataContext.getInstance().getGiamGias()) {
                int maGiamGia = i.getMaGiamGia();
                cbMaGiamGia.addItem(String.valueOf(maGiamGia));
            }
        } catch (Exception e) {
        }
    }

    public void combMaNhanVien() {
        try {
            NhanVienController.getInstance().LayDuLieu();
            for (NhanVienModel i : DataContext.getInstance().getNhanViens()) {
                int maNV = i.getMaNV();
                cbMaNV.addItem(String.valueOf(maNV));
            }
        } catch (Exception e) {
        }
    }

    private void tbHDKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDKHMouseClicked
        int row = this.tbHDKH.getSelectedRow();
        if (!(row >= 0 && row <= tbHDKH.getRowCount())) {
            return;
        }
        try {
            if (row >= 0 && row <= tbHDKH.getRowCount()) {
                txtMaHD.setText(tbHDKH.getValueAt(row, 0).toString());
                cbMaGiamGia.setSelectedItem(tbHDKH.getValueAt(row, 1).toString());
                txtSDT.setText(tbHDKH.getValueAt(row, 2).toString());
                cbMaNV.setSelectedItem(tbHDKH.getValueAt(row, 3).toString());
                NgayLap.setDate((Date) tbHDKH.getModel().getValueAt(row, 4));
                txtTongTien.setText(tbHDKH.getValueAt(row, 5).toString());
            }
            loadTableCTHD(Integer.parseInt(tbHDKH.getValueAt(row, 0).toString()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbHDKHMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        txtMaHD.setText("");
        txtSDT.setText("");
        NgayLap.setDate(null);
        txtTongTien.setText("");
        cbMaGiamGia.setSelectedIndex(0);
        cbMaNV.setSelectedIndex(0);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (txtMaHD.getText().equals("")) {
            JOptionPane.showMessageDialog(this, CHOSSE_DELETE);
            return;
        }
        try {
            int maHD = Integer.parseInt(txtMaHD.getText());
            int result = JOptionPane.showConfirmDialog(this, REQUEST_DELETE, NOTIFICATION_TITLE, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                if (CTHDController.getInstance().XoaCTHD(maHD)
                        && HoaDonKhachHangController.getInstance().XoaHoaDonKhachHang(maHD)) {
                    JOptionPane.showMessageDialog(null, NOTI_SUCCESS);
                } else {
                    JOptionPane.showMessageDialog(null, NOTI_FAILED);
                }
            }
            loadTableHD();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, NOTI_FAILED, NOTIFICATION_TITLE, JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void cbMaGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaGiamGiaActionPerformed

    }//GEN-LAST:event_cbMaGiamGiaActionPerformed

    private void cbMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaNVActionPerformed

    }//GEN-LAST:event_cbMaNVActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        var x = checkError();
        if (!x.equals("")) {
            JOptionPane.showConfirmDialog(null, x, NOTIFICATION_TITLE, JOptionPane.DEFAULT_OPTION);
            return;
        }
        try {
            HoaDonKhachHangModel hd = new HoaDonKhachHangModel();
            hd.setSDTKH(txtSDT.getText());
            hd.setTongTien(Double.parseDouble(txtTongTien.getText()));
            int MaHD = Integer.parseInt(txtMaHD.getText());
            if (HoaDonKhachHangController.getInstance().SuaHoaDonKhachHang(MaHD, hd) == true) {
                JOptionPane.showMessageDialog(null, NOTI_SUCCESS);
            } else {
                JOptionPane.showMessageDialog(null, NOTI_FAILED);
            }
            loadTableHD();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, NOTI_FAILED);
        }
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void tbCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTHDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCTHDMouseClicked

    private void cbMaGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMaGiamGiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMaGiamGiaMouseClicked

    private void txtMaHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaHDMouseClicked

    }//GEN-LAST:event_txtMaHDMouseClicked
    //Text
    private String TITLE;
    private String UPDATE;
    private String RESET;
    private String EXIT;
    private String REFRESH;
    private String DELETE;
    private String PHONE_NUMBER;
    private String CREATE_DATE;
    private String LIST_DETAILS;
    private String LIST_BILL;
    private String ID_DISCOUNT;
    private String ID_BILL;
    private String ID_EMPLOYEE;
    private String INFO_BILL;
    private String SUM;
    private String NOTIFICATION_TITLE;
    private String NOTI_SUCCESS;
    private String NOTI_FAILED;
    private String CHOSSE_DELETE;
    private String REQUEST_DELETE;
    private String ID_DRINK;
    private String QUANTILE;
    private String PRICE;
    private String ERR_NUMBER_EMPTY;
    private String ERR_NUMBER_WRONG;
    private String ERR_SUM_EMPTY;
    private String ERR_SUM_WRONG;

    private DefaultTableModel modelHDKH, modelCTHD;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser NgayLap;
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbMaGiamGia;
    private javax.swing.JComboBox<String> cbMaNV;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbDSCTHD;
    private javax.swing.JLabel lbDSHoaDonKH;
    private javax.swing.JLabel lbMaGiamGia;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbMaNV;
    private javax.swing.JLabel lbNgLap;
    private javax.swing.JLabel lbSDTKH;
    private javax.swing.JLabel lbThongTinHD;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JTable tbHDKH;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}

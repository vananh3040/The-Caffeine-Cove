/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view.frame;

import com.controller.ChiNhanhController;
import com.handle.ImageHandle;
import com.handle.LanguageHandle;
import com.models.ChiNhanhModel;
import com.models.DataContext;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoai nam
 */
public class ChiNhanhFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChiNhanhFrame
     */
    public ChiNhanhFrame() {
        initComponents();
        loadText();
        loadTable();
        configComponents();
    }

    private void loadText() {
        TITLE = LanguageHandle.getInstance().getValue("Branch", "TITLE");
        UPDATE = LanguageHandle.getInstance().getValue("Branch", "UPDATE");
        RESET = LanguageHandle.getInstance().getValue("Branch", "RESET");
        REFRESH = LanguageHandle.getInstance().getValue("Branch", "REFRESH");
        EXIT = LanguageHandle.getInstance().getValue("Branch", "EXIT");
        LIST_BRANCH = LanguageHandle.getInstance().getValue("Branch", "LIST_BRANCH");
        ADDRESS = LanguageHandle.getInstance().getValue("Branch", "ADDRESS");
        ID = LanguageHandle.getInstance().getValue("Branch", "ID");
        INFO = LanguageHandle.getInstance().getValue("Branch", "INFO");
        NAME = LanguageHandle.getInstance().getValue("Branch", "NAME");
        DELETE = LanguageHandle.getInstance().getValue("Branch", "DELETE");
        NOTIFICATION_TITLE = LanguageHandle.getInstance().getValue("Branch", "NOTIFICATION_TITLE");
        NOTI_SUCCESS = LanguageHandle.getInstance().getValue("Branch", "NOTI_SUCCESS");
        NOTI_FAILED = LanguageHandle.getInstance().getValue("Branch", "NOTI_FAILED");
        ERR_NAME_EMPTY = LanguageHandle.getInstance().getValue("Branch", "ERR_NAME_EMPTY");
        ERR_ADDRESS_EMPTY = LanguageHandle.getInstance().getValue("Branch", "ERR_ADDRESS_EMPTY");
        CHOSSE_DELETE = LanguageHandle.getInstance().getValue("Branch", "CHOSSE_DELETE");
        REQUEST_DELETE = LanguageHandle.getInstance().getValue("Branch", "REQUEST_DELETE");
        ADD = LanguageHandle.getInstance().getValue("Branch", "ADD");
    }

    private void configComponents() {
        setIconImage(ImageHandle.getInstance().getIconLogo());
        setTitle(TITLE);
        // Doi ngon ngu
        btnCapNhap.setText(UPDATE);
        btnRefresh.setText(REFRESH);
        btnXoa.setText(DELETE);
        btnThem.setText(ADD);
        
        lbDiaChi.setText(ADDRESS);
        lbMaCN.setText(ID);
        lbTTChiNhanh.setText(INFO);
        lbTenCN.setText(NAME);
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
        lbMaCN = new javax.swing.JLabel();
        lbTenCN = new javax.swing.JLabel();
        lbDiaChi = new javax.swing.JLabel();
        txtMaCN = new javax.swing.JTextField();
        txtTenCN = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        lbTTChiNhanh = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChiNhanh = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(228, 207, 203));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMaCN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMaCN.setForeground(new java.awt.Color(97, 55, 47));
        lbMaCN.setText("Mã Chi Nhánh");
        jPanel2.add(lbMaCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, -1));

        lbTenCN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTenCN.setForeground(new java.awt.Color(97, 55, 47));
        lbTenCN.setText("Tên Chi Nhánh");
        jPanel2.add(lbTenCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, -1));

        lbDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbDiaChi.setForeground(new java.awt.Color(97, 55, 47));
        lbDiaChi.setText("Địa Chỉ");
        jPanel2.add(lbDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 90, -1));

        txtMaCN.setEnabled(false);
        jPanel2.add(txtMaCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 143, -1));
        jPanel2.add(txtTenCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 143, -1));
        jPanel2.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 143, -1));

        lbTTChiNhanh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTTChiNhanh.setForeground(new java.awt.Color(97, 55, 47));
        lbTTChiNhanh.setText("Thông tin Chi Nhánh");
        jPanel2.add(lbTTChiNhanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/add (1).png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 30));

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/delete (1).png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, 30));

        btnCapNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCapNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/edit (2).png"))); // NOI18N
        btnCapNhap.setText("Cập Nhập");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });
        jPanel2.add(btnCapNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, 30));

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resource/refresh-arrow.png"))); // NOI18N
        btnRefresh.setText("Refresh ");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 100, 30));

        tbChiNhanh.setBackground(new java.awt.Color(207, 179, 159));
        tbChiNhanh.setForeground(new java.awt.Color(51, 34, 25));
        tbChiNhanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Chi Nhánh", "Tên Chi Nhánh", "Địa Chỉ"
            }
        ));
        tbChiNhanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChiNhanhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbChiNhanh);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    DefaultTableModel modelChiNhanh;

    public void loadTable() {
        modelChiNhanh = (DefaultTableModel) new DefaultTableModel();
        try {
            String tieuDe[] = {ID, NAME, ADDRESS};
            modelChiNhanh.setColumnIdentifiers(tieuDe);
            Object row[] = new Object[3];
            int i = 0;
            ChiNhanhController.getInstance().LayDuLieu();
            while (i < DataContext.getInstance().getChiNhanhs().size()) {
                row[0] = DataContext.getInstance().getChiNhanhs().get(i).getMaCN();
                row[1] = DataContext.getInstance().getChiNhanhs().get(i).getTenCN();
                row[2] = DataContext.getInstance().getChiNhanhs().get(i).getDiaChi();
                i++;
                modelChiNhanh.addRow(row);
            }
        } catch (Exception e) {
        }
        tbChiNhanh.setModel(modelChiNhanh);
        setVisible(true);
    }

    public String checkError() {
        if (txtTenCN.getText().equals("")) {
            return ERR_NAME_EMPTY;
        }
        if (txtDiaChi.getText().equals("")) {
            return ERR_ADDRESS_EMPTY;
        }
        return "";
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        StringBuilder sb = new StringBuilder();
        var x = checkError();
        if (!x.equals("")) {
            JOptionPane.showConfirmDialog(null, x, NOTIFICATION_TITLE, JOptionPane.DEFAULT_OPTION);
            return;
        }
        try {
            ChiNhanhModel cn = new ChiNhanhModel();
            cn.setTenCN(txtTenCN.getText());
            cn.setDiaChi(txtDiaChi.getText());
            if (ChiNhanhController.getInstance().ThemChiNhanh(cn) == true) {
                JOptionPane.showMessageDialog(null, NOTI_SUCCESS);
            } else {
                JOptionPane.showMessageDialog(null, NOTI_FAILED);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, NOTI_FAILED);            
        }
        loadTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        StringBuilder sb = new StringBuilder();
        var x = checkError();
        if (!x.equals("")) {
            JOptionPane.showConfirmDialog(null, x, NOTIFICATION_TITLE, JOptionPane.DEFAULT_OPTION);
            return;
        }
        try {
            ChiNhanhModel cn = new ChiNhanhModel();
            int maCN = Integer.parseInt(txtMaCN.getText());
            cn.setMaCN(Integer.parseInt(txtMaCN.getText()));
            cn.setTenCN(txtTenCN.getText());
            cn.setDiaChi(txtDiaChi.getText());
            if (ChiNhanhController.getInstance().SuaChiNhanh(maCN, cn) == true) {
                JOptionPane.showMessageDialog(null, NOTI_SUCCESS);
            } else {
                JOptionPane.showMessageDialog(null, NOTI_FAILED);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, NOTI_FAILED);
        }
        loadTable();
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (txtMaCN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, CHOSSE_DELETE, NOTIFICATION_TITLE, 1);
        } else {
            try {
                int result = JOptionPane.showConfirmDialog(this, REQUEST_DELETE, NOTIFICATION_TITLE, JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    if (ChiNhanhController.getInstance().XoaChiNhanh(Integer.parseInt(txtMaCN.getText())) == true) {
                        JOptionPane.showMessageDialog(null, NOTI_SUCCESS);
                    } else {
                        JOptionPane.showMessageDialog(null, NOTI_FAILED);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, NOTI_FAILED);
            }
        }
        loadTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbChiNhanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiNhanhMouseClicked
        try {
            int row = this.tbChiNhanh.getSelectedRow();
            if (row >= 0 && row <= tbChiNhanh.getRowCount()) {
                txtMaCN.setText(tbChiNhanh.getValueAt(row, 0).toString());
                txtTenCN.setText(tbChiNhanh.getValueAt(row, 1).toString());
                txtDiaChi.setText(tbChiNhanh.getValueAt(row, 2).toString());
            }
            loadTable();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbChiNhanhMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        txtMaCN.setText("");
        txtTenCN.setText("");
        txtDiaChi.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    //Text
    private String TITLE;
    private String UPDATE;
    private String RESET;
    private String EXIT;
    private String REFRESH;
    private String LIST_BRANCH;
    private String ADDRESS;
    private String ID;
    private String INFO;
    private String NAME;
    private String DELETE;
    private String NOTIFICATION_TITLE;
    private String NOTI_SUCCESS;
    private String NOTI_FAILED;
    private String ERR_NAME_EMPTY;
    private String ERR_ADDRESS_EMPTY;
    private String CHOSSE_DELETE;
    private String REQUEST_DELETE;
    private String ADD;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbMaCN;
    private javax.swing.JLabel lbTTChiNhanh;
    private javax.swing.JLabel lbTenCN;
    private javax.swing.JTable tbChiNhanh;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaCN;
    private javax.swing.JTextField txtTenCN;
    // End of variables declaration//GEN-END:variables
}

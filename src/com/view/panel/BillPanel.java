/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view.panel;

import com.controller.CTHDController;
import com.controller.GiamGiaController;
import com.controller.HoaDonKhachHangController;
import com.controller.KhachHangController;
import com.handle.ConnectionHandle;
import com.handle.LanguageHandle;
import com.handle.Utilities;
import com.models.CTHDModel;
import com.models.DataContext;
import com.models.DoUongModel;
import com.models.GiamGiaModel;
import com.models.HoaDonKhachHangModel;
import com.utilities.CommonFont;
import com.utilities.NonBorder;
import com.utilities.RoundedButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JLabel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nam
 */
public class BillPanel extends Container {

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 0));

        lbtitle = new JLabel(TITLE + id, JLabel.CENTER);
        lbtitle.setFont(new CommonFont(Font.BOLD, 30));
        lbtitle.setForeground(Color.WHITE);
        add(lbtitle, BorderLayout.NORTH);

        tbBill = new JTable();
        tbBill.setOpaque(false);
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{
            NUMBER_ORDER,
            NAME_DRINK,
            PRICE,
            QUANLITY
        });

        tbBill.setModel(dtm);
        tbBill.getTableHeader().setFont(new CommonFont(20));
        tbBill.setRowHeight(30);
        tbBill.setFont(new CommonFont(20));

        JViewport viewport = new JViewport();
        viewport.setOpaque(false);
        viewport.setView(tbBill);
        scTb = new JScrollPane();
        scTb.setViewport(viewport);
        scTb.setOpaque(false);
        scTb.setBorder(new NonBorder());
        scTb.getViewport().setOpaque(false);
        add(scTb, BorderLayout.CENTER);

        botCon = new Container();
        botCon.setLayout(new GridLayout(1, 2, 10, 10));

        btnPrint = new RoundedButton(PRINT, 100, 50, 10);
        btnPrint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (dtm.getRowCount() == 0) {
                    JOptionPane.showConfirmDialog(
                            null,
                            NOTHING,
                            PRINT_TITLE,
                            JOptionPane.DEFAULT_OPTION
                    );
                    return;
                }
                printBill();
            }
        });
        botCon.add(btnPrint);

        btnPay = new RoundedButton(PAY, 100, 50, 10);
        btnPay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                java.sql.Savepoint savePoint = null;
                try {
                    // Xac nhan co thanh toan khong
                    if (dtm.getRowCount() == 0) {
                        JOptionPane.showConfirmDialog(
                                null,
                                NOTHING,
                                PRINT_TITLE,
                                JOptionPane.DEFAULT_OPTION
                        );
                        return;
                    }
                    // Hoi co in hoa don khong
                    if (JOptionPane.showConfirmDialog(
                            null,
                            PRINT_MESSAGE,
                            PRINT_MESSAGE,
                            JOptionPane.YES_NO_OPTION
                    ) == 0) {
                        printBill();
                    }
                    // Tao diem Savepoint
                    ConnectionHandle.getInstance().getConnection().setAutoCommit(false);
                    savePoint = ConnectionHandle.getInstance().getConnection().setSavepoint();

                    //Thanh toan
                    pay();

                    // Thong bao thanh cong
                    JOptionPane.showConfirmDialog(
                            null,
                            PAY_SUCCESS,
                            PAY_TITLE,
                            JOptionPane.DEFAULT_OPTION
                    );
                    // Commit                    
                    ConnectionHandle.getInstance().getConnection().commit();
                    ConnectionHandle.getInstance().getConnection().setAutoCommit(true);
                } catch (HeadlessException | SQLException ex) {
                    try {
                        ConnectionHandle.getInstance().getConnection().rollback(savePoint);
                        JOptionPane.showConfirmDialog(
                                null,
                                PAY_FAILED,
                                PAY_TITLE,
                                JOptionPane.DEFAULT_OPTION
                        );
                    } catch (SQLException ex1) {
                        Logger.getLogger(BillPanel.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        });
        botCon.add(btnPay);
        add(botCon, BorderLayout.SOUTH);
    }

    private void loadText() {
        TITLE = LanguageHandle.getInstance().getValue("Bill", "TITLE");
        NUMBER_ORDER = LanguageHandle.getInstance().getValue("Bill", "NUMBER_ORDER");
        NAME_DRINK = LanguageHandle.getInstance().getValue("Bill", "NAME_DRINK");
        PRICE = LanguageHandle.getInstance().getValue("Bill", "PRICE");
        QUANLITY = LanguageHandle.getInstance().getValue("Bill", "QUANLITY");
        PRINT = LanguageHandle.getInstance().getValue("Bill", "PRINT");
        PAY = LanguageHandle.getInstance().getValue("Bill", "PAY");
        PRINT_MESSAGE = LanguageHandle.getInstance().getValue("Bill", "PRINT_MESSAGE");
        PRINT_TITLE = LanguageHandle.getInstance().getValue("Bill", "PRINT_TITLE");
        PAY_TITLE = LanguageHandle.getInstance().getValue("Bill", "PAY_TITLE");
        PAY_SUCCESS = LanguageHandle.getInstance().getValue("Bill", "PAY_SUCCESS");
        PAY_FAILED = LanguageHandle.getInstance().getValue("Bill", "PAY_FAILED");
        NOTHING = LanguageHandle.getInstance().getValue("Bill", "NOTHING");

    }

    public void addDrinks(DoUongModel du) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            if (Integer.parseInt(dtm.getValueAt(i, 0).toString())
                    == du.getMaDU()) {
                int value = Integer.parseInt(dtm.getValueAt(i, 3).toString());
                dtm.setValueAt(
                        ++value,
                        i,
                        3
                );
                return;
            }
        }
        dtm.addRow(new Object[]{
            du.getMaDU(),
            du.getTenDU(),
            du.getGia(),
            1
        });
    }

    public void removeDrinks(DoUongModel du) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            if (Integer.parseInt(dtm.getValueAt(i, 0).toString())
                    == du.getMaDU()) {
                int value = Integer.parseInt(dtm.getValueAt(i, 3).toString());
                if (value == 1) {
                    dtm.removeRow(i);
                } else {
                    dtm.setValueAt(
                            --value,
                            i,
                            3
                    );
                }
                return;
            }
        }
    }

    public void pay() throws SQLException {

        // Tinh tong hoa don
        double tongTien = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            double sum = Float.parseFloat(dtm.getValueAt(i, 2).toString())
                    * Integer.parseInt(dtm.getValueAt(i, 3).toString());
            tongTien += sum;
        }

        // Nhap so dien thoai
        String sdt = JOptionPane.showInputDialog("Nhap so sdt").trim();
        if (sdt.trim().equals("")) {
            sdt = null;
        } else {
            if (!KhachHangController.getInstance().congDiem(sdt, (int) (tongTien / 1000))) {
                throw new SQLException("Wrong SDTKH");
            }
        }

        // Kiem tra giam gia
        GiamGiaModel gg = GiamGiaController.getInstance().layMaGiamGia();
        if (gg != null) {
            double soTienGiam = tongTien * (gg.getGiaTri() / 100);
            if (soTienGiam > gg.getToiDa()
                    && gg.getToiDa() != 0) {
                soTienGiam = gg.getToiDa();
            }
            tongTien -= soTienGiam;
        }
        // Them hoa don
        int maHD = HoaDonKhachHangController.getInstance().ThemHoaDonKhachHang(
                new HoaDonKhachHangModel(
                        gg == null ? -1 : gg.getMaGiamGia(),
                        sdt,
                        DataContext.getInstance().getUser().getMaNV(),
                        new Date(System.currentTimeMillis()),
                        tongTien,
                        1
                )
        );

        // Kiem tra them hoa do nco thanh cong hay khong
        if (maHD == -1) {
            throw new SQLException("Can not insert into HoaDonKhachHang");
        }

        // Them CTHD
        for (int i = 0; i < dtm.getRowCount(); i++) {
            CTHDController.getInstance().ThemCTHD(new CTHDModel(
                    Integer.parseInt(dtm.getValueAt(i, 0).toString()),
                    maHD,
                    Integer.parseInt(dtm.getValueAt(i, 3).toString()),
                    Double.parseDouble(dtm.getValueAt(i, 2).toString())
            ));
        }
    }

    private void addHeader() {
        content = """
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td,
            th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
            h1, h2, h3, h4, h6{
              text-align: center;
            }
            div{
              text-align: right;
            }                            
        """;
        // Body
        content += "body{background-image: url(\"" + urlBackground + "\");}</style>";
        content += """                 
        <body>
            <h6>Địa chỉ: KP6, Linh Trung, Thủ Đức, TP. Hồ Chí Minh</h6>
            <h1>The Caffeine Cove</h1>
            <h2>Hóa đơn</h2>
        """;
        content += "<div> Xuất hóa đơn lúc:" + Utilities.getInstance().getTime() + "</div>";
        content += """ 
            <table>
                <tr>
                    <th>STT</th>
                    <th>Tên đồ uống</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                </tr>                                                                   
        """;
    }

    private void addFooter() {
        content += """                               
            <h4>Pass WIFI: The Caffeine Cove<h4>
            <h3>Awaken Your Senses at The Caffeine Cove: Where Every Sip is an Escape</h3>
            <h6>Design: Nguyen Van Anh</h6> 
        </body></html>
        """;
    }

    public void printBill() {
        JEditorPane bill = new JEditorPane();
        bill.setFont(new CommonFont(14));
        bill.setContentType("text/html");
        addHeader();

        // Them danh sach mon da goi
        float tongTien = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            content += "<tr>";
            content += "<td>" + (i + 1) + "</td>";
            content += "<td>" + dtm.getValueAt(i, 1).toString() + "</td>";
            content += "<td>" + dtm.getValueAt(i, 2).toString() + "</td>";
            content += "<td>" + dtm.getValueAt(i, 3).toString() + "</td>";
            float sum = Float.parseFloat(dtm.getValueAt(i, 2).toString())
                    * Integer.parseInt(dtm.getValueAt(i, 3).toString());
            content += "<td>" + sum + "</td>";
            content += "</tr>";
            tongTien += sum;
        }
        content += "</table>";
        
        // Kiem tra giam gia
        GiamGiaModel gg = GiamGiaController.getInstance().layMaGiamGia();
        if (gg != null) {
            double soTienGiam = tongTien * (gg.getGiaTri() / 100.0f);
            if (soTienGiam > gg.getToiDa()
                    && gg.getToiDa() != 0) {
                soTienGiam = gg.getToiDa();
            }
            tongTien -= soTienGiam;
            content += "<div>Giảm giá: " + soTienGiam + " đ</div>";
        }        
        content += "<div>Tổng tiền: " + tongTien + " đ</div>";

        addFooter();
        bill.setText(content);
        try {
            bill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(BillPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BillPanel(String id) {
        this.id = id;
        this.urlBackground = ClassLoader.getSystemResource("com/resource/logo-20.png").toString();
        loadText();
        initComponents();
    }

    // Components
    private final String id;
    private JLabel lbtitle;
    private Container botCon;
    private RoundedButton btnPay;
    private RoundedButton btnPrint;
    private JTable tbBill;
    private JScrollPane scTb;

    // Varible
    private final String urlBackground;
    private DefaultTableModel dtm;
    private String content;

    // Text
    private String TITLE;
    private String NUMBER_ORDER;
    private String NAME_DRINK;
    private String PRICE;
    private String QUANLITY;
    private String PRINT;
    private String PAY;
    private String PRINT_MESSAGE;
    private String PRINT_TITLE;
    private String PAY_TITLE;
    private String PAY_SUCCESS;
    private String PAY_FAILED;
    private String NOTHING;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view.frame;

import com.controller.HoaDonKhachHangController;
import com.handle.ImageHandle;
import com.handle.LanguageHandle;
import com.models.DataContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;

public class ThongKeFrame extends JFrame {

    public ThongKeFrame() {
        loadText();
        initUI();
    }

    private void loadText() {
        TITLE = LanguageHandle.getInstance().getValue("Stat", "TITLE");
        REVENUE = LanguageHandle.getInstance().getValue("Stat", "REVENUE");
        TITLE_CHART = LanguageHandle.getInstance().getValue("Stat", "TITLE_CHART");        
    }

    private void initUI() {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle(TITLE);
        setIconImage(ImageHandle.getInstance().getIconLogo());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private CategoryDataset createDataset() {

        var dataset = new DefaultCategoryDataset();
        if (DataContext.getInstance().getHoaDonKhachHangs() == null) {
            HoaDonKhachHangController.getInstance().LayDuLieu();
        }
        for (var x : DataContext.getInstance().getHoaDonKhachHangs()) {
            try {
                dataset.incrementValue(
                        x.getTongTien(),
                        REVENUE,
                        x.getNgayLap());
            } catch (org.jfree.data.UnknownKeyException e) {
                dataset.setValue(
                        x.getTongTien(),
                        REVENUE,
                        x.getNgayLap());
            }
        }
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                TITLE_CHART,
                "",
                REVENUE,
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        return barChart;
    }
    private String TITLE;
    private String REVENUE;
    private String TITLE_CHART;
}

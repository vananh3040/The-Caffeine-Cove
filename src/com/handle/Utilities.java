/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.handle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hai dang
 */
public class Utilities {

    private static Utilities _instance;

    private Utilities() {
    }

    public static synchronized Utilities getInstance() {
        if (_instance == null) {
            _instance = new Utilities();
        }
        return _instance;
    }

    public String getTime() {
        var x = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return (myFormatObj.format(x));
    }
    public String getTime(String format) {
        var x = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(format);
        return (myFormatObj.format(x));
    }
}

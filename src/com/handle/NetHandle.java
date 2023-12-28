/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.handle;

import com.view.frame.MenuFrame;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Hashtable;

/**
 *
 * @author hoai nam
 */
public class NetHandle extends Thread {

    private static NetHandle _instance;
    private DatagramSocket socket;
    private int port;
    private Hashtable<String, Object[]> listClient;

    private NetHandle() {
        try {
            listClient = new Hashtable<>();
            port = Integer.parseInt(ConfigurationLoader.getInstance().getHostInfo()[1]);
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static NetHandle getInstance() {
        if (_instance == null) {
            synchronized (NetHandle.class) {
                if (_instance == null) {
                    _instance = new NetHandle();
                    _instance.start();
                }
            }
        }
        return _instance;
    }

    @Override
    public void run() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
                Process(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void sendData(byte[] data, InetAddress ipAddress, int port) {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendData(String content, String name) {
        sendData(
                content.getBytes(),
                (InetAddress) listClient.get(name)[0],
                (Integer) listClient.get(name)[1]
        );
    }

    private void Process(DatagramPacket packet) {
        String message = new String(packet.getData());
        System.out.println(message);
        if (message.contains("Login")) {
            listClient.put(
                    message.substring(6),
                    new Object[]{
                        packet.getAddress(),
                        packet.getPort()}
            );
            sendData("OK".getBytes(), packet.getAddress(), packet.getPort());
            MenuFrame.getInstance().addTable(message.substring(6));
        } else {
            for (var x : listClient.keySet()) {
                if (((InetAddress) listClient.get(x)[0]).equals(packet.getAddress())
                        && ((int) listClient.get(x)[1]) == (packet.getPort())) {
                    MenuFrame.getInstance().receiveMessage(
                            (String) x,
                            message
                    );
                    return;
                }
            }
        }
        System.out.println("Danh sach may hien tai:" + listClient.size());
    }
}

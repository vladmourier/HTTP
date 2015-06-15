/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vladimir
 */
public class Communication extends ObjetConnecte implements Runnable {

    public int port_dest;
    public int port_ecoute;
    public InetAddress address_dest;


    private Socket Sclient;
    public Communication( Socket client) throws SocketException {
        super();
        port_dest = client.getPort();
        this.Sclient = client;
        this.address_dest = client.getInetAddress();
        System.out.println("Communication créée avec le Client : " + address_dest + " | " + port_dest);
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        try {
            this.IS = Sclient.getInputStream();
            this.BIS = new BufferedInputStream(this.IS);
            this.BIS.read(buffer);
            
            System.out.println(new String(buffer).substring(0, buffer.length));
            String[] str = new String(buffer).split("\n");
            System.out.println("Première ligne " + str[0]);
            str = str[0].split(" ");
            System.out.println("fichier demandé " + str[1]);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void response() throws SocketException {
    }

    public int getPort_dest() {
        return port_dest;
    }

    public void setPort_dest(int port_dest) {
        this.port_dest = port_dest;
    }

    public InetAddress getAddress_dest() {
        return address_dest;
    }

    public void setAddress_dest(InetAddress address_dest) {
        this.address_dest = address_dest;
    }
}

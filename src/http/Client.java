/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
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
public class Client extends ObjetConnecte {

    private Socket socket;

    public Client(InetAddress ia, int port) throws SocketException, IOException {
        super(ia, port);
        this.socket = new Socket(ia, port);
        this.port_c = this.socket.getLocalPort();
        System.out.println("Socket créé port : " + port_c);
        this.IS = this.socket.getInputStream();
        this.BIS = new BufferedInputStream(this.IS);
        this.OS = this.socket.getOutputStream();
        this.BOS = new BufferedOutputStream(OS);

    }

    public void envoyer(byte[] array) throws IOException {
        this.BOS.write(array);
        BOS.flush();
        System.out.println("J'ai envoyé : " + new String(array));
    }

    public byte[] reception() throws IOException {
        System.out.println("réception");
        byte[] buffer = new byte[1024];
        BIS.read(buffer);
        System.out.println("J'ai reçu : " + new String(buffer));
        return buffer;
    }
}

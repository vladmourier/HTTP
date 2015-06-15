/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Vladimir
 */
public class Client extends ObjetConnecte {

    public Client() throws SocketException {
        super();
    }

    public Client(InetAddress ia, int port) throws SocketException, IOException {
        super(ia, port);
        this.s = new Socket(ia, port);
        
        this.entree = this.s.getInputStream();
        this.bufentree = new BufferedInputStream(this.entree);
        this.sortie = this.s.getOutputStream();
        
    }

    public void envoyer(byte[] array, InetAddress address, int port) throws IOException {
//        this.ia_c = address;
//        this.dp = new DatagramPacket(array, array.length, ia_c, port);
//        s.send(dp);
    }
}

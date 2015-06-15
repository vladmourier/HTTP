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

/**
 *
 * @author Vladimir
 */
public class Client extends ObjetConnecte {

    private Socket socket;

    public Client() throws SocketException {
        super();
    }

    public Client(InetAddress ia, int port) throws SocketException, IOException {
        super(ia, port);
        this.socket = new Socket(ia, port);
        this.port_c = this.socket.getLocalPort();
        this.IS = this.socket.getInputStream();
        this.BIS = new BufferedInputStream(this.IS);
        this.OS = this.socket.getOutputStream();

    }

    public void envoyer(byte[] array) throws IOException {
        this.BOS = new BufferedOutputStream(OS);
        this.BOS.write(array);
    }
}

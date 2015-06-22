/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

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
        byte[] buffer = new byte[1];
        FileWriter fp = new FileWriter(new File("file.txt"), false);

        while (BIS.read(buffer) != -1) {
            fp.write(new String(buffer));
            fp.flush();
            System.out.print(new String(buffer));
        }
        return buffer;
    }
}

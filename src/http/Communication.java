/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
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

    public Communication(Socket client) throws SocketException {
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
            this.OS = Sclient.getOutputStream();
            this.BOS = new BufferedOutputStream(this.OS);
            this.IS = Sclient.getInputStream();
            this.BIS = new BufferedInputStream(this.IS);
            this.BIS.read(buffer);

            

            
            
            RandomAccessFile monFichier = new RandomAccessFile("C:\\Users\\p1407206\\Desktop\\albert.txt", "rw");
            
            Byte a = monFichier.readByte();
            while(a != null) {
                this.BOS.write(a);
                try {
                    a = monFichier.readByte();
                }
                catch(EOFException e) {
                        
                }
            }
           
            
            

            while (true) {
                System.out.println(new String(buffer).substring(0, buffer.length));
                String[] str = new String(buffer).split("\n");
                System.out.println("Première ligne " + str[0]);
                str = str[0].split(" ");
                System.out.println("fichier demandé " + str[1]);

                this.BOS.write("HTTP/1.0 200 OK\r\n".getBytes());
                this.BOS.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n".getBytes());
                this.BOS.write("Server: Apache/0.8.4\r\n".getBytes());
                this.BOS.write("Content-Type: text/html\r\n".getBytes());
                this.BOS.write("Content-Length: 59\r\n".getBytes());
                this.BOS.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n".getBytes());
                this.BOS.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n".getBytes());
                this.BOS.write("\r\n".getBytes());
                this.BOS.write("<TITLE>Exemple</TITLE>".getBytes());
                this.BOS.write("<P>Ceci est une page d'exemple.</P>".getBytes());
                this.BOS.flush();
            }


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

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
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Vladimir
 */
public class Serveur{
    ServerSocket socketServer;

    
   public Serveur(int port_s) throws SocketException, IOException{
    this.socketServer = new ServerSocket(port_s);
   }
   public int Initialisation () throws IOException {
       Socket Sclient = this.socketServer.accept();
       Communication com = new Communication(Sclient);
       Thread T = new Thread(com);
       T.start();
       this.socketServer.close();
       return 0;
   }
}

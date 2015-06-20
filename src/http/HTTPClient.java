/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vladimir
 */
public class HTTPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String s_url = "http://www.google.fr";
            String post = "";
            URL url = new URL(s_url);
            URLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            BufferedOutputStream BOS = new BufferedOutputStream(connection.getOutputStream());
            BOS.write(post.getBytes());
            BOS.flush();
            
            BufferedInputStream BIS = new BufferedInputStream(connection.getInputStream());
            byte[] buffer = new byte[1024];
            BIS.read(buffer);
            System.out.println("reçu : \n" + buffer);
            
            
            
            
            
//            Client c = new Client(InetAddress.getByName("www.google.fr"), 80);
//            //GET /repertoire/page.html HTTP/1.1
//            System.out.println(c.getIa_c().getHostAddress());
//            c.envoyer(new String("GET / HTTP/1.0 \nHost: " + c.getIa_c().getHostAddress() + ":80\n").getBytes());
//            c.reception();
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

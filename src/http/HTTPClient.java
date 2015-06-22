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
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
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
            System.out.println("Saisir l'addresse de la page voulue");
            byte[] address = new byte[1000];
            System.in.read(address);
            String s_url = new String(address);
            FileWriter fp = new FileWriter(new File("E:/file.txt"), false);
//            String s_url = "http://www.koreus.com";
            String post = "";
            StringBuilder document = new StringBuilder();
            URL url = new URL(s_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            
            BufferedOutputStream BOS = new BufferedOutputStream(connection.getOutputStream());
            BufferedInputStream BIS = new BufferedInputStream(connection.getInputStream());
            byte[] buffer = new byte[1];
            
            BOS.write(post.getBytes());
            BOS.flush();
            while(BIS.read(buffer) != -1)
            {
                fp.write(new String(buffer));
                fp.flush();
                document.append(new String(buffer));
            }
            System.out.println(new String(document));
            
            System.out.println("\nrestant à afficher " + BIS.available());
            
            
//            Client c = new Client(InetAddress.getByName("www.koreus.com"), 80);
//            //GET /repertoire/page.html HTTP/1.1
//            System.out.println(c.getIa_c().getHostAddress());
//            c.envoyer(new String("GET / HTTP/1.1\r\nHost:" + c.getIa_c().getHostAddress() + ":80\n").getBytes());
//            c.reception();
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

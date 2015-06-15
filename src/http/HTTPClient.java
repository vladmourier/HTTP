/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.IOException;
import java.net.InetAddress;
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
//            Client c = new Client(InetAddress.getByName("127.0.0.1"), 4000);
            Client c = new Client(InetAddress.getByName("64.15.116.217"), 80);
            c.envoyer(new String("GET / HTTP/1.1\n" +
"Host: 64.15.116.217:80\n" +
"User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0\n" +
"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
"Accept-Language: fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3\n" +
"Accept-Encoding: gzip, deflate\n" +
"DNT: 1\n" +
"Connection: keep-alive").getBytes("ascii"));
            c.reception();
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

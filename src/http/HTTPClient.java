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
            Client c = new Client(InetAddress.getByName("127.0.0.1"), 4000);
            //GET /repertoire/page.html HTTP/1.1\r\n
            System.out.println(c.getIa_c().getHostAddress());
            c.envoyer(new String("GET /Test.html HTTP/1.0\r\nHost:" + c.getIa_c().getHostAddress() + ":4000\n").getBytes());
            c.reception();

            while (true) {
                System.out.println("Saisir l'addresse de la page voulue");
                byte[] address = new byte[1000];
                System.in.read(address);
                String s_url = new String(address);
                c.envoyer(new String("GET " + s_url + "HTTP/1.0\r\nHost:" + c.getIa_c().getHostAddress() + ":4000\n").getBytes());
                c.reception();
            }
//            c.getSocket().close();

        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

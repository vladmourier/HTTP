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
    public static void main(String[] args){
        try {
            Client c = new Client(InetAddress.getByName("127.0.0.1"), 4000);
            c.envoyer(new String ("Je teste l'envoi").getBytes("ascii"));
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
}

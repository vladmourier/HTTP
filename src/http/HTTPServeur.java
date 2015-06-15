/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vladimir
 */
public class HTTPServeur {
        public static void main(String[] args){
            try {
                Serveur s = new Serveur(4000);
                s.Initialisation();
            } catch (IOException ex) {
                Logger.getLogger(HTTPServeur.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
}

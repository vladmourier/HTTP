package vue;

import http.Client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class View {

	private JFrame frame;
	private JTextField txtF_adrS;
	private JTextField txtF_fichier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtF_adrS = new JTextField();
		txtF_adrS.setBounds(216, 12, 86, 20);
		frame.getContentPane().add(txtF_adrS);
		txtF_adrS.setColumns(10);
		
		JLabel lbl_adrS = new JLabel("Adresse du serveur");
		lbl_adrS.setBounds(45, 14, 144, 17);
		frame.getContentPane().add(lbl_adrS);
		
		txtF_fichier = new JTextField();
		txtF_fichier.setBounds(216, 113, 86, 20);
		frame.getContentPane().add(txtF_fichier);
		txtF_fichier.setColumns(10);
		
		JLabel lbl_fichier = new JLabel("Nom du fichier \u00E0 r\u00E9cup\u00E9rer");
		lbl_fichier.setBounds(23, 115, 166, 17);
		frame.getContentPane().add(lbl_fichier);
		
		JButton bt_reception = new JButton("Reception");
		bt_reception.setBounds(165, 201, 102, 23);
		bt_reception.addActionListener(new BoutonReception());
		frame.getContentPane().add(bt_reception);
	}
	
	 class BoutonReception implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String typeFichier = ".html";
			
			if(!(txtF_adrS.getText() == ""|| txtF_fichier.getText() == "")) {
				try {
					Client c = new Client(InetAddress.getByName(txtF_adrS.getText()), 4000);
					System.out.println(c.getIa_c().getHostAddress());
					if(txtF_fichier.getText().equals("paysage")) {
						typeFichier = ".jpg"; 
					}
					c.envoyer(new String("GET /"+ txtF_fichier.getText() + typeFichier +" HTTP/1.1\r\nHost:" + c.getIa_c().getHostAddress() + ":4000\n").getBytes());
					c.reception(typeFichier);
				
				}catch(IOException e) {
					JOptionPane.showMessageDialog(null, "Erreur dans l'adresse du serveur","Erreur",JOptionPane.ERROR_MESSAGE);
				}
			}
			else { JOptionPane.showMessageDialog(null, "Veuillez renseigner l'adresse du serveur et le fichier à récupérer","Erreur",JOptionPane.ERROR_MESSAGE); }
			
		}
	 }
}

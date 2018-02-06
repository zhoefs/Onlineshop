package onlineShop;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenster extends JFrame {

	private static final long serialVersionUID = -8244052221617440206L;

	public void switchJPanel(JPanel panel, String titel) {
		this.setTitle(titel);
		this.setSize(1000, 800);
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.getContentPane().revalidate();
	}

	public static void main(String[] args) {
		Fenster fenster = new Fenster();
		fenster.setSize(350, 120);
		fenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fenster.setLocationRelativeTo(null);
		fenster.setTitle("Anmeldung");
		fenster.setResizable(false);
		fenster.setLayout(new BorderLayout());
		LoginPanel login = new LoginPanel(fenster);
		fenster.add(login, BorderLayout.CENTER);
		fenster.setVisible(true);

	}
}
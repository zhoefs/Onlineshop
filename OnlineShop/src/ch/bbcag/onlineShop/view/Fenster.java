package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenster extends JFrame {

	private static final long serialVersionUID = -8244052221617440206L;

	public void switchJPanel(JPanel panel, String titel, int windowWidth, int windowHeight) {
		this.setTitle(titel);
		this.setSize(windowWidth, windowHeight);
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.getContentPane().revalidate();
	}

	public static void main(String[] args) {
		Fenster fenster = new Fenster();
		fenster.setSize(350, 120);
		fenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fenster.setTitle("Anmeldung");
		fenster.setResizable(false);
		fenster.setLayout(new BorderLayout());
		LoginPanel login = new LoginPanel(fenster);
		fenster.add(login, BorderLayout.CENTER);
		fenster.setVisible(true);
	}
}
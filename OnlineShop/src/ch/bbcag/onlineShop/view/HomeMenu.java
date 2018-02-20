package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.bbcag.onlineShop.helper.IconLoader;

public class HomeMenu extends JFrame {

	private static final long serialVersionUID = 7107604425259214222L;
	private JButton nike1 = new JButton("Nike Air Force 1 Midi Bearbeiten");
	private JButton nike2 = new JButton("Nike Air Hurache Essential Bearbeiten");
	private JButton nike3 = new JButton("Nike Metcon 4 Bearbeiten");
	private JTextArea beschreibung1 = new JTextArea("BLABLABLA");
	private JTextArea beschreibung2 = new JTextArea("Der Nike Air Huarache Essencial ist einer dieser Schuhe, die einen starken Einfluss auf die Erfolgsgeschichte mit dem Swoosh in den frühen 90ern hatten und den Sportswear- und Sneakermarkt noch Heute dominieren. ");
	private JTextField beschreibung3 = new JTextField("BLABLABLA");

	public static void main(String[] args) {
		HomeMenu gui = new HomeMenu();
		gui.pack();
		gui.setVisible(true);
	}

	public HomeMenu() {
		setTitle("Home Menu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel imagePanel = new JPanel(new GridLayout(3,3,3,3));

		imagePanel.add(new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_weiss_klein.PNG")));
		imagePanel.add(new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_weiss_klein.PNG")));
		imagePanel.add(new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_weiss_klein.PNG")));
		
		imagePanel.add(nike1);
		imagePanel.add(nike2);
		imagePanel.add(nike3);

		imagePanel.add(beschreibung1);
		imagePanel.add(beschreibung2);
		imagePanel.add(beschreibung3);
		
		add(imagePanel, BorderLayout.NORTH);
	}
}
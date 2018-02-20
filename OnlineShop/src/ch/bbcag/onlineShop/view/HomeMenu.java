package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.bbcag.onlineShop.helper.IconLoader;

public class HomeMenu extends JFrame {

	private static final long serialVersionUID = 7107604425259214222L;
	private JButton nike1 = new JButton("Nike... Bearbeiten");
	private JButton nike2 = new JButton("Nike... Bearbeiten");
	private JButton nike3 = new JButton("Nike... Bearbeiten");
	private JTextField beschreibung1 = new JTextField("BLABLABLA");
	private JTextField beschreibung2 = new JTextField("BLABLABLA");
	private JTextField beschreibung3 = new JTextField("BLABLABLA");

	public static void main(String[] args) {
		HomeMenu gui = new HomeMenu();
		gui.pack();
		gui.setVisible(true);
	}

	public HomeMenu() {
		setTitle("Home Menu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel imagePanel = new JPanel(new GridLayout(3, 3));

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
package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ch.bbcag.onlineShop.helper.IconLoader;

public class HomeMenu extends JFrame {

	private static final long serialVersionUID = 7107604425259214222L;
	private JButton nike1 = new JButton("Nike Air Force 1 Midi Bearbeiten");
	private JButton nike2 = new JButton("Nike Air Hurache Essential Bearbeiten");
	private JButton nike3 = new JButton("Nike Metcon 4 Bearbeiten");
	private JTextArea beschreibung1 = new JTextArea(5,20);
	private JTextArea beschreibung2 = new JTextArea(5,20);
	private JTextArea beschreibung3 = new JTextArea(5,20);
	
	public static void main(String[] args) {
		HomeMenu gui = new HomeMenu();
		gui.pack();
		gui.setResizable(false);
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

		beschreibung1.setText("Kurtzbeschreibung:			"
				+ "				"
				+ "Der Air Force 1 ist ein Basketballschuh des Sportartikelherstellers "
				+ "Nike. Er wurde 1982 auf den Markt gebracht und "
				+ "bekannt wurde er vor allem als Streetstyle-Schuh in der "
				+ "Hip-Hop-Szene. Insgesamt wurden in den letzten 25 Jahren �ber 1.700 "
				+ "Modelle in unz�hligen verschiedenen Farb- und Materialkombinationen entwickelt.");
		
		beschreibung2.setText("Kurtzbeschreibung:			"
				+ "				"
				+ "Der Nike Air Huarache Essencial ist einer"
				+ "dieser Schuhe, die einen starken Einfluss auf"
				+ "die Erfolgsgeschichte mit dem Swoosh in den"
				+ "fr�hen 90ern hatten und den Sportswear- und Sneaker");
		
		beschreibung3.setText("Kurtzbeschreibung:			"
				+ "				"
				+ "Der Metcon 4 M�nner Cross Training, Gewichtheber-Schuh "
				+ "bietet eine starke, stabile Basis, flexible Unterst�tzung "
				+ "und extreme Haltbarkeit f�r eine breite Palette von "
				+ "Trainingsaktivit�ten, von Sprints und Schlitten dr�cken, Heben und Seilklettern.");
		
		beschreibung1.setLineWrap(true);
		beschreibung1.setWrapStyleWord(true);
		beschreibung2.setLineWrap(true);
		beschreibung2.setWrapStyleWord(true);
		beschreibung3.setLineWrap(true);
		beschreibung3.setWrapStyleWord(true);
		
		
		imagePanel.add(beschreibung1);
		imagePanel.add(beschreibung2);
		imagePanel.add(beschreibung3);
		
		add(imagePanel, BorderLayout.NORTH);
	}
}
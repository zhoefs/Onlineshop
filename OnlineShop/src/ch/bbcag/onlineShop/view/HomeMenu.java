package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ch.bbcag.onlineShop.helper.IconLoader;

public class HomeMenu extends JFrame {

	private static final long serialVersionUID = 7107604425259214222L;
	private JButton ausloggen = new JButton("Ausloggen");
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
		
		JPanel ausloggenPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ausloggenPanel.add(ausloggen);
		
		ausloggen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Fenster fenster = new Fenster();
				fenster.setSize(350, 120);
				fenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
				fenster.setTitle("Anmeldung");
				fenster.setResizable(false);
				fenster.setLayout(new BorderLayout());
				LoginPanel login = new LoginPanel(fenster);
				fenster.add(login, BorderLayout.CENTER);
				fenster.setVisible(true);
				setVisible(false);
			}
		});

		JPanel imagePanel = new JPanel(new GridLayout(3,3,3,3));

		imagePanel.add(new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_weiss_klein.PNG")));
		imagePanel.add(new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_weiss_klein.PNG")));
		imagePanel.add(new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_weiss_klein.PNG")));
		
		JPanel mitteLinks = new JPanel();
		mitteLinks.setLayout(new GridBagLayout());
		mitteLinks.add(nike1);
		
		JPanel mitte = new JPanel();
		mitte.setLayout(new GridBagLayout());
		mitte.add(nike2);
		
		JPanel mitteRechts = new JPanel();
		mitteRechts.setLayout(new GridBagLayout());
		mitteRechts.add(nike3);
		
		imagePanel.add(mitteLinks);
		imagePanel.add(mitte);
		imagePanel.add(mitteRechts);

		beschreibung1.setText("Kurzbeschreibung:			"
				+ "				"
				+ "Der Air Force 1 ist ein Basketballschuh des Sportartikelherstellers "
				+ "Nike. Er wurde 1982 auf den Markt gebracht und "
				+ "bekannt wurde er vor allem als Streetstyle-Schuh in der "
				+ "Hip-Hop-Szene. Insgesamt wurden in den letzten 25 Jahren ueber 1.700 "
				+ "Modelle in unzähligen verschiedenen Farb- und Materialkombinationen entwickelt.");
		
		beschreibung2.setText("Kurzbeschreibung:			"
				+ "				"
				+ "Der Nike Air Huarache Essencial ist einer "
				+ "dieser Schuhe,  die einen starken Einfluss auf"
				+ "die Erfolgsgeschichte mit dem Swoosh in den"
				+ "frühen 90ern hatten und den Sportswear- und Sneaker");
		
		beschreibung3.setText("Kurzbeschreibung:			"
				+ "				"
				+ "Der Metcon 4 Männer Cross Training, Gewichtheber-Schuh "
				+ "bietet eine starke, stabile Basis, flexible Unterstützung "
				+ "und extreme Haltbarkeit für eine breite Palette von "
				+ "Trainingsaktivitaeten, von Sprints und Schlitten druecken, Heben und Seilklettern.");
		
		beschreibung1.setLineWrap(true);
		beschreibung1.setWrapStyleWord(true);
		beschreibung2.setLineWrap(true);
		beschreibung2.setWrapStyleWord(true);
		beschreibung3.setLineWrap(true);
		beschreibung3.setWrapStyleWord(true);
		
		
		imagePanel.add(beschreibung1);
		imagePanel.add(beschreibung2);
		imagePanel.add(beschreibung3);
		
		add(ausloggenPanel, BorderLayout.NORTH);
		add(imagePanel, BorderLayout.CENTER);
	}
}
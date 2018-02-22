package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ch.bbcag.onlineShop.helper.IconLoader;
import ch.bbcag.onlineShop.model.Benutzer;

public class BestellPanel extends JFrame {

	private static final long serialVersionUID = 7107604425259214222L;

	private JButton bestellen = new JButton("Bestellen!");
	private JButton ausloggen = new JButton("Ausloggen");
	private String[] zahlungsartenListe = { "Zahlungsart:", "VISA", "Master Card", "PayPal" };
	private JComboBox<String> zahlungsarten = new JComboBox<String>(zahlungsartenListe);
	private JTextArea beschreibung = new JTextArea(5, 20);
	private JTextArea kundenInformationen = new JTextArea(5, 20);
	static Benutzer benutzer = new Benutzer();
	
	public static void main(String[] args) {
		benutzer.getAdresse().setStrasse("Strasse");
		benutzer.getAdresse().setOrt("ORT");
		benutzer.getAdresse().setPlz("PLZ");
		benutzer.setName("NAME");
		BestellPanel panel = new BestellPanel(benutzer);
		panel.pack();
		panel.setResizable(false);
		panel.setVisible(true);
	}

	public BestellPanel(Benutzer benutzer) {
		setTitle("Bestellung");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 2));

		add(new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_weiss.PNG")));

		JPanel obenRechts = new JPanel(new GridLayout(2, 1));
		JPanel ausloggenPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ausloggenPanel.add(ausloggen);
		obenRechts.add(ausloggenPanel);
		
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

		JPanel zahlungsPanel = new JPanel(new GridLayout(1, 2));

		JPanel zahlungsartPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		zahlungsartPanel.add(zahlungsarten);
		zahlungsPanel.add(zahlungsartPanel);

		JPanel beschreibungsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		beschreibungsPanel.add(beschreibung);
		zahlungsPanel.add(beschreibungsPanel);

		beschreibung.setText("k" + "" + "" + "");
		beschreibung.setLineWrap(true);
		beschreibung.setWrapStyleWord(true);

		beschreibung.setText("Zahlungsart:			" + "Wählen Sie hier Ihre Gewünschte Zahlungsart aus. "
				+ "Ihre Bestellung wird damit Bezahlt.");

		obenRechts.add(zahlungsPanel);
		add(obenRechts);
		
		kundenInformationen.append(benutzer.getName()+"\n"+benutzer.getAdresse().getStrasse()+"\n"+benutzer.getAdresse().getPlz()+" "+benutzer.getAdresse().getOrt());
		add(kundenInformationen);
		
		kundenInformationen.setLineWrap(true);
		kundenInformationen.setWrapStyleWord(true);

		JPanel untenRechts = new JPanel();
		
		JLabel untenRechtsBackgroundLabel = new JLabel(IconLoader.loadIcon("backgroundPictures/rote-pfeile-zugeschnitten.jpg"));
		
		untenRechtsBackgroundLabel.setLayout(null);
		untenRechtsBackgroundLabel.setOpaque(false);
		
		untenRechtsBackgroundLabel.setLayout(new GridBagLayout());
		untenRechtsBackgroundLabel.add(bestellen);
		
		untenRechts.add(untenRechtsBackgroundLabel);

		bestellen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BestellBestaetigungsPanel gui = new BestellBestaetigungsPanel(benutzer);
				gui.setSize(500, 400);
				gui.setResizable(false);
				gui.setVisible(true);
				setVisible(false);
				setVisible(false);
			}
		});

		add(untenRechts);
		
		

	}
}

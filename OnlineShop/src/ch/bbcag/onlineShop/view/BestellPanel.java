package ch.bbcag.onlineShop.view;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ch.bbcag.onlineShop.helper.IconLoader;
import ch.bbcag.onlineShop.model.Benutzer;

public class BestellPanel extends JPanel {

	private static final long serialVersionUID = 7107604425259214222L;

	private JButton bestellen = new JButton("Bestellen!");
	private JButton ausloggen = new JButton("Ausloggen");
	private String[] zahlungsartenListe = { "Zahlungsart:", "VISA", "Master Card", "PayPal" };
	private JComboBox<String> zahlungsarten = new JComboBox<String>(zahlungsartenListe);
	private JTextArea beschreibung = new JTextArea(5, 20);
	private JTextArea kundenInformationen = new JTextArea(5, 20);
	static Benutzer benutzer = new Benutzer();
	
	public BestellPanel(Benutzer benutzer, Fenster fenster) {
		
		add(new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_weiss.PNG")));
		
		JPanel obenRechts = new JPanel(new GridLayout(2, 1));
		JPanel ausloggenPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ausloggenPanel.add(ausloggen);
		obenRechts.add(ausloggenPanel);
		
		ausloggen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenster.switchJPanel(new LoginPanel(fenster), "Login", 350, 120);
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
		
		kundenInformationen.append("Ihre Adresse:"+"\n"+benutzer.getName()+"\n"+benutzer.getAdresse().getStrasse()+"\n"+benutzer.getAdresse().getPlz()+" "+benutzer.getAdresse().getOrt());
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
				fenster.switchJPanel(new BestellBestaetigungsPanel(benutzer, fenster), "Bestätigung", 500, 400);
			}
		});

		add(untenRechts);
		
		

	}
}

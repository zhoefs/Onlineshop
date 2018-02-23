package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
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
	private LayoutManager BorderLayout;
	protected JPanel sevPanel = new JPanel(new BorderLayout());
	static Benutzer benutzer = new Benutzer();

	public BestellPanel(Benutzer benutzer, Fenster fenster, int sevNr) {
		add(sevPanel);
		JLabel picture = null;

		switch (sevNr) {
		case 1:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_weiss.PNG"));
			break;
		case 2:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_grau.PNG"));
			break;
		case 3:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_blau.PNG"));
			break;
		case 4:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_rot.PNG"));
			break;
		case 5:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/weiss_schwarz.PNG"));
			break;
		case 6:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/weiss_grau.PNG"));
			break;
		case 7:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/weiss_blau.PNG"));
			break;
		case 8:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/weiss_rot.PNG"));
			break;
		case 9:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_weiss.PNG"));
			break;
		case 10:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_grau.PNG"));
			break;
		case 11:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_blau.PNG"));
			break;
		case 12:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_rot.PNG"));
			break;
		case 13:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/weiss_schwarz.PNG"));
			break;
		case 14:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/weiss_grau.PNG"));
			break;
		case 15:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/weiss_blau.PNG"));
			break;
		case 16:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/weiss_rot.PNG"));
			break;
		case 17:
			picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_weiss.PNG"));
			break;
		case 18:
			picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_grau.PNG"));
			break;
		case 19:
			picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_blau.PNG"));
			break;
		case 20:
			picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_rot.PNG"));
			break;
		case 21:
			picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/weiss_schwarz.PNG"));
			break;
		case 22:
			picture = new JLabel(IconLoader.loadIcon("Nike_Air_Metcon_4/weiss_grau.PNG"));
			break;
		case 23:
			picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/weiss_blau.PNG"));
			break;
		case 24:
			picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/weiss_rot.PNG"));
			break;

		}
		sevPanel.add(picture, BorderLayout);
		revalidate();
		repaint();

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

		kundenInformationen.append("Ihre Lieferadresse:" + "\n" + "\n" + benutzer.getAdresse().getStrasse() + "\n"
				+ benutzer.getAdresse().getPlz() + " " + benutzer.getAdresse().getOrt() + "\n" + "\n" + "\n"
				+ "Kontakt: " + benutzer.getEmail());
		add(kundenInformationen);

		kundenInformationen.setLineWrap(true);
		kundenInformationen.setWrapStyleWord(true);

		JPanel untenRechts = new JPanel();

		JLabel untenRechtsBackgroundLabel = new JLabel(
				IconLoader.loadIcon("backgroundPictures/rote-pfeile-zugeschnitten.jpg"));

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

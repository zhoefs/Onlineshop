package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
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

public class DesignPanel extends JPanel {

	private static final long serialVersionUID = 7107604425259214222L;

	private JButton weiter = new JButton("Weiter");
	private JButton uebernehmen = new JButton("Übernehmen");
	private JButton ausloggen = new JButton("Ausloggen");
	private String[] farbteil1Liste = { "Erste Farbe wählen", "schwarz", "weiss" };
	private JComboBox<String> farbteil1 = new JComboBox<String>(farbteil1Liste);
	private String[] farbteil2Liste = { "Zweite Farbe wählen", "schwarz", "weiss", "grau", "blau", "rot" };
	private JComboBox<String> farbteil2 = new JComboBox<String>(farbteil2Liste);
	private JTextArea kundenInformationen = new JTextArea(5, 20);
	private int shoeNr;
	private int sevNr;
	private String farbCombi = "schwarz_weiss";
	private JPanel picturePanel = new JPanel(new BorderLayout());

	public DesignPanel(Benutzer benutzer, Fenster fenster, int shoeNr) {
		setShoeNr(shoeNr);
		setLayout(new GridLayout(2, 3));
		add(picturePanel);
		updatePicture();
		kundenInformationen.setLineWrap(true);
		kundenInformationen.setWrapStyleWord(true);

		JPanel obenRechts = new JPanel(new GridLayout(0, 1));
		JPanel ausloggenPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ausloggenPanel.add(ausloggen);
		obenRechts.add(ausloggenPanel);

		JPanel farbteil1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		farbteil1Panel.add(farbteil1);
		obenRechts.add(farbteil1Panel);

		JPanel farbteil2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		farbteil2Panel.add(farbteil2);
		obenRechts.add(farbteil2Panel);

		add(obenRechts);
		JPanel untenRechts = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(untenRechts);

		JPanel untenLinks = new JPanel(new FlowLayout(FlowLayout.LEFT));
		untenRechts.add(uebernehmen);
		untenRechts.setLayout(new GridBagLayout());
		untenRechts.add(weiter);

		weiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenster.switchJPanel(new BestellPanel(benutzer, fenster, getSevNr()), "Bestätigung", 1100, 750);
			}
		});
		ausloggen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenster.switchJPanel(new LoginPanel(fenster), "Log In", 350, 120);
			}
		});

		uebernehmen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((String) farbteil1.getSelectedItem()).equals((String) farbteil2.getSelectedItem())) {
					System.err.println("Es darf nicht 2 Mal die gleiche Farbe ausgewählt sein.");
				} else if (((String) farbteil1.getSelectedItem()) == "Erste Farbe wählen" || ((String) farbteil2.getSelectedItem()) == "Zweite Farbe wählen") {
					System.err.println("Sie müssen bei beiden Auswahlen eine Farbe auswählen!");
					
					
				}else {
					farbCombi = (String) farbteil1.getSelectedItem() + "_" + (String) farbteil2.getSelectedItem();
					updatePicture();
				}
			}
		});
	}

	private void updatePicture() {
		JLabel picture = null;

		switch (getShoeNr()) {
		case 1:
			switch (farbCombi) {
			case "schwarz_weiss":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_weiss.png"));
				sevNr = 1;
				break;
			case "schwarz_grau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_grau.png"));
				sevNr = 2;
				break;
			case "schwarz_blau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_blau.png"));
				sevNr = 3;
				break;
			case "schwarz_rot":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_rot.png"));
				sevNr = 4;
				break;
			case "weiss_schwarz":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/weiss_schwarz.png"));
				sevNr = 5;
				break;
			case "weiss_grau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/weiss_grau.png"));
				sevNr = 6;
				break;
			case "weiss_blau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/weiss_blau.png"));
				sevNr = 7;
				break;
			case "weiss_rot":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/weiss_rot.png"));
				sevNr = 8;
				break;
			}

			kundenInformationen.setText(
					"Die Air Force 1 (oder AF1 oder AF-1) hiess ursprünglich nur die Air Force. Der Name ist ein Verweis auf Air Force One, das Flugzeug,\r\n"
							+ "das den Präsidenten der Vereinigten Staaten trägt. Die Schuhe werden in drei verschiedenen Stilen verkauft, niedrig, mittel und hoch.\r\n"
							+ "Die Mitte kommt mit einem verbundenen Riemen. Die High-Top Air Force 1 sind mit einem Klettverschluss versehen. Der mittlere Obergurt\r\n"
							+ "ist am Schuh befestigt, während der Obergurt bei einigen Versionen beweglich und abnehmbar ist. Obwohl der Schuh in verschiedenen\r\n"
							+ "Farben und Farbschemen erhältlich ist, sind die am häufigsten verkauften Air Force 1-Modelle solides Weiss\r\n"
							+ "(auch als \"Weis auf Weis\" bezeichnet), wobei die zweithäufigste Farbe Schwarz (\"Schwarz auf Schwarz\") ist.");
			break;

		case 2:
			switch (farbCombi) {
			case "schwarz_weiss":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_weiss.png"));
				sevNr = 9;
				break;
			case "schwarz_grau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_grau.png"));
				sevNr = 10;
				break;
			case "schwarz_blau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_blau.png"));
				sevNr = 11;
				break;
			case "schwarz_rot":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_rot.png"));
				sevNr = 12;
				break;
			case "weiss_schwarz":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/weiss_schwarz.png"));
				sevNr = 13;
				break;
			case "weiss_grau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/weiss_grau.png"));
				sevNr = 14;
				break;
			case "weiss_blau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/weiss_blau.png"));
				sevNr = 15;
				break;
			case "weiss_rot":
				picture = new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/weiss_rot.png"));
				sevNr = 16;
				break;
			}

			kundenInformationen.setText(
					"Das Modell, mit dem alles begann. Der Nike Air Huarache war eine Idee der Nike - Design - Legende Tinker Hatfield, die Läufer fragte:\r\n"
							+ "Hast du heute deinen Fuß umarmt? Der leichte Läufer zog das geschäftige Swoosh - Branding des Tages ab\r\n"
							+ "und ließ stattdessen den Technologiegespräch. Diese Technologie beinhaltete eine Mischung aus Lycra- und Neopren-Stoffen, die den\r\n"
							+ "Lauf der Nike-Geschichte für immer verändern würden.");
			break;

		case 3:
			switch (farbCombi) {
			case "schwarz_weiss":
				picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_weiss.png"));
				sevNr = 17;
				break;
			case "schwarz_grau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_grau.png"));
				sevNr = 18;
				break;
			case "schwarz_blau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_blau.png"));
				sevNr = 19;
				break;
			case "schwarz_rot":
				picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_rot.png"));
				sevNr = 20;
				break;
			case "weiss_schwarz":
				picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/weiss_schwarz.png"));
				sevNr = 21;
				break;
			case "weiss_grau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/weiss_grau.png"));
				sevNr = 22;
				break;
			case "weiss_blau":
				picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/weiss_blau.png"));
				sevNr = 23;
				break;
			case "weiss_rot":
				picture = new JLabel(IconLoader.loadIcon("Nike_Metcon_4/weiss_rot.png"));
				sevNr = 24;
				break;
			}

			kundenInformationen.setText(
					"Nike setzte seine neueste haptische Technologie auf dem Schuhoberteil ein. Die Marke sagte, dass Designer Bereiche der Haltbarkeit\r\n"
							+ "dort platzieren können, wo sie gebraucht werden und andere für Atmungsaktivität offen lassen. Der Metcon 4 bietet den Trägern eine\r\n"
							+ "flache und starke Plattform, die für anstrengendes Gewichtheben und hochintensives Training entwickelt wurde.\r\n"
							+ "Die gummierten \"Tri-Star\" -Formstücke an den Sohlen bieten multidirektionalen Halt und Traktion (nützlich für Aktivitäten wie Seilklettern).\r\n"
							+ "Das Modell, so die Marke, ist in der Metcon-Reihe bis heute das robusteste Produkt.");
			break;

		}
		picturePanel.removeAll();
		picturePanel.add(picture, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public int getShoeNr() {
		return shoeNr;
	}

	public void setShoeNr(int shoeNr) {
		this.shoeNr = shoeNr;
	}

	public int getSevNr() {
		return sevNr;
	}
}

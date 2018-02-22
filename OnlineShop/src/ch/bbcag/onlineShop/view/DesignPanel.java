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
import ch.bbcag.onlineShop.view.HomeMenu;
import ch.bbcag.onlineShop.helper.IconLoader;

public class DesignPanel extends JFrame {

	private static final long serialVersionUID = 7107604425259214222L;

	private JButton weiter = new JButton("Weiter");
	private JButton uebernehmen = new JButton("Übernehmen");
	private JButton ausloggen = new JButton("Ausloggen");
	private String[] farbteil1Liste = { "Erste Farbe wählen", "schwarz", "weiss"};
	private JComboBox<String> farbteil1 = new JComboBox<String>(farbteil1Liste);
	private String[] farbteil2Liste = { "Zweite Farbe wählen", "schwarz", "weiss", "grau", "blau", "rot"};
	private JComboBox<String> farbteil2 = new JComboBox<String>(farbteil2Liste);
	private JTextArea kundenInformationen = new JTextArea(5, 20);

	public static void main(String[] args) {
		DesignPanel gui = new DesignPanel();
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
	}

	public DesignPanel() {
		setTitle("Design");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 3));

		add(new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_weiss.PNG")));

		JPanel obenRechts = new JPanel(new GridLayout(0,1));
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
		
		/* if schuhmodelNr == 1{
			kundenInformationen.setText("Die Air Force 1 (oder AF1 oder AF-1) hiess ursprünglich nur die Air Force. Der Name ist ein Verweis auf Air Force One, das Flugzeug,\r\n" + 
				"das den Präsidenten der Vereinigten Staaten trägt. Die Schuhe werden in drei verschiedenen Stilen verkauft, niedrig, mittel und hoch.\r\n" + 
				"Die Mitte kommt mit einem verbundenen Riemen. Die High-Top Air Force 1 sind mit einem Klettverschluss versehen. Der mittlere Obergurt\r\n" + 
				"ist am Schuh befestigt, wäh"
				+ "rend der Obergurt bei einigen Versionen beweglich und abnehmbar ist. Obwohl der Schuh in verschiedenen\r\n" + 
				"Farben und Farbschemen erh�ltlich ist, sind die am h�ufigsten verkauften Air Force 1-Modelle solides Weiss\r\n" + 
				"(auch als \"Weis auf Weis\" bezeichnet), wobei die zweithäufigste Farbe Schwarz (\"Schwarz auf Schwarz\") ist.");
		} */
		
//		switch(getsNr) {
//		case 1: sNr(1); break;
//		case 2: sNr(2); break;
//		case 3: sNr(2); break;
//		}
		
		kundenInformationen.setText("Die Air Force 1 (oder AF1 oder AF-1) hiess ursprünglich nur die Air Force. Der Name ist ein Verweis auf Air Force One, das Flugzeug,\r\n" + 
				"das den Präsidenten der Vereinigten Staaten trägt. Die Schuhe werden in drei verschiedenen Stilen verkauft, niedrig, mittel und hoch.\r\n" + 
				"Die Mitte kommt mit einem verbundenen Riemen. Die High-Top Air Force 1 sind mit einem Klettverschluss versehen. Der mittlere Obergurt\r\n" + 
				"ist am Schuh befestigt, wäh"
				+ "rend der Obergurt bei einigen Versionen beweglich und abnehmbar ist. Obwohl der Schuh in verschiedenen\r\n" + 
				"Farben und Farbschemen erh�ltlich ist, sind die am h�ufigsten verkauften Air Force 1-Modelle solides Weiss\r\n" + 
				"(auch als \"Weis auf Weis\" bezeichnet), wobei die zweithäufigste Farbe Schwarz (\"Schwarz auf Schwarz\") ist.");
		kundenInformationen.setLineWrap(true);
		kundenInformationen.setWrapStyleWord(true);

		JPanel untenRechts = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(kundenInformationen);
		add(untenRechts);
		
		JPanel untenLinks = new JPanel(new FlowLayout(FlowLayout.LEFT));
		untenRechts.add(uebernehmen);
		untenRechts.setLayout(new GridBagLayout());
		
		untenRechts.add(weiter);
				
		weiter.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				BestellPanel gui = new BestellPanel();
				gui.setSize(1155, 739);
				gui.setResizable(false);
				gui.setVisible(true);
				setVisible(false);
		}
		});
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
		
		uebernehmen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (((String)farbteil1.getSelectedItem()).equals((String)farbteil2.getSelectedItem())){
					System.err.println("Es darf nicht 2 Mal die gleiche Farbe ausgewählt sein.");
				} else {
					//TODO: Entsprechendes Bild und Infos laden.
				}
			
			}
		});
	}
}

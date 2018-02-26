package ch.bbcag.onlineShop.view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ch.bbcag.onlineShop.model.Benutzer;

public class BestellBestaetigungsPanel extends JPanel{

	private static final long serialVersionUID = 7107604425259214222L;
	private JButton start = new JButton("Zurück zum Start");
	private JButton weiterEinkaufen = new JButton("Weiter Einkaufen");
	private JTextArea vielenDank = new JTextArea(5, 20);

	public BestellBestaetigungsPanel(Benutzer benutzer, Fenster fenster) {

		JPanel mainPanel = new JPanel(new GridLayout(2, 1));

		JPanel oben = new JPanel(new GridLayout(1, 2));

		JPanel obenLinks = new JPanel();
		obenLinks.setLayout(new GridBagLayout());
		obenLinks.add(start);
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenster.switchJPanel(new LoginPanel(fenster), "Login", 350, 120);
			}
		});


		JPanel obenRechts = new JPanel();
		obenRechts.setLayout(new GridBagLayout());
		obenRechts.add(weiterEinkaufen);
		
		weiterEinkaufen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenster.switchJPanel(new HomeMenu(benutzer, fenster), "Home", 1200, 800);
			}
		});

		oben.add(obenLinks);
		oben.add(obenRechts);

		JPanel unten = new JPanel();
		unten.setLayout(new GridBagLayout());
		unten.add(vielenDank);

		vielenDank.setText("          Vielen Dank für Ihren Einkauf!" + "				"
				+ "  Schauen sie mal bei Nike.com vorbei!");

		vielenDank.setLineWrap(true);
		vielenDank.setWrapStyleWord(true);

		mainPanel.add(oben);
		mainPanel.add(unten);

		add(mainPanel);
	}
}
package ch.bbcag.onlineShop.view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BestellBestaetigungsPanel extends JFrame {

	private static final long serialVersionUID = 7107604425259214222L;
	private JButton start = new JButton("Zurück zum Start");
	private JButton weiterEinkaufen = new JButton("Weiter Einkaufen");
	private JTextArea vielenDank = new JTextArea(5, 20);

	public static void main(String[] args) {
		BestellBestaetigungsPanel gui = new BestellBestaetigungsPanel();
		gui.setSize(500, 400);
		gui.setResizable(false);
		gui.setVisible(true);
	}

	public BestellBestaetigungsPanel() {
		setTitle("Bestellbestätigung");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel(new GridLayout(2, 1));

		JPanel oben = new JPanel(new GridLayout(1, 2));

		JPanel obenLinks = new JPanel();
		obenLinks.setLayout(new GridBagLayout());
		obenLinks.add(start);

		JPanel obenRechts = new JPanel();
		obenRechts.setLayout(new GridBagLayout());
		obenRechts.add(weiterEinkaufen);

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
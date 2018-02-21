package ch.bbcag.onlineShop.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ch.bbcag.onlineShop.helper.IconLoader;

public class BestellPanel extends JFrame {

	private static final long serialVersionUID = 7107604425259214222L;

	private JButton bestellen = new JButton("Bestellen!");
	private JButton ausloggen = new JButton("Ausloggen");
	private String[] zahlungsartenListe = { "VISA", "Master Card", "PayPal" };
	private JComboBox<String> zahlungsarten = new JComboBox<String>(zahlungsartenListe);
	private JTextArea kundenInformationen = new JTextArea(5, 20);

	public static void main(String[] args) {
		BestellPanel gui = new BestellPanel();
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
	}

	public BestellPanel() {
		setTitle("Bestellung");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 2));

		add(new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_weiss.PNG")));

		JPanel obenRechts = new JPanel(new GridLayout(2, 1));
		JPanel ausloggenPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ausloggenPanel.add(ausloggen);
		obenRechts.add(ausloggenPanel);

		JPanel zahlungsartPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		zahlungsartPanel.add(zahlungsarten);
		obenRechts.add(zahlungsartPanel);

		add(obenRechts);

		kundenInformationen.setText("k" + "" + "" + "");
		kundenInformationen.setLineWrap(true);
		kundenInformationen.setWrapStyleWord(true);

		add(kundenInformationen);
		
		JPanel untenRechts = new JPanel();
		untenRechts.setLayout(new BoxLayout(untenRechts, BoxLayout.Y_AXIS));
		untenRechts.setAlignmentY(CENTER_ALIGNMENT);
		bestellen.setAlignmentX(CENTER_ALIGNMENT);
		untenRechts.add(bestellen);
		
		add(untenRechts);

	}
}

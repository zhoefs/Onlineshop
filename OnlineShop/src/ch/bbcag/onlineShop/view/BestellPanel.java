package ch.bbcag.onlineShop.view;

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

public class BestellPanel extends JFrame {

	private static final long serialVersionUID = 7107604425259214222L;

	private JButton bestellen = new JButton("Bestellen!");
	private JButton ausloggen = new JButton("Ausloggen");
	private String[] zahlungsartenListe = { "Zahlungsart:", "VISA", "Master Card", "PayPal" };
	private JComboBox<String> zahlungsarten = new JComboBox<String>(zahlungsartenListe);
	private JTextArea beschreibung = new JTextArea(5, 20);
	private JTextArea kundenInformationen = new JTextArea(5, 20);

	public static void main(String[] args) {
		BestellPanel panel = new BestellPanel();
		panel.pack();
		panel.setResizable(false);
		panel.setVisible(true);
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
				BestellBestaetigungsPanel gui = new BestellBestaetigungsPanel();
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

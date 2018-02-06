package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartScreen extends JPanel {

	private static final long serialVersionUID = -5345921730919202354L;

	public StartScreen() {
		this.setLayout(new BorderLayout());


		JPanel west = new JPanel(new GridLayout(2, 1));
		JPanel east = new JPanel(new GridLayout(2, 1));
		JPanel south = new JPanel(new GridLayout(1, 2));

		west.add(new JLabel("Mail"), BorderLayout.NORTH);
		west.add(new JLabel("Passwort"), BorderLayout.SOUTH);

		
		this.add(west, BorderLayout.WEST);
		this.add(east, BorderLayout.EAST);
		this.add(south, BorderLayout.SOUTH);
	}
}

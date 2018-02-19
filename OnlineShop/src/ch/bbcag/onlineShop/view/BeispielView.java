package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ch.bbcag.onlineShop.controller.UserController;
import ch.bbcag.onlineShop.model.Benutzer;

public class BeispielView extends JFrame {

	private static final long serialVersionUID = -7727022911427098449L;
	
	private final JTextField email = new JTextField("E-Mail", 20);
	private final JButton find = new JButton("Finde");
	private final JLabel name = new JLabel("Wie heisse ich?");

	public static void main(String[] args) {
		BeispielView v = new BeispielView();
		v.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		v.initUI();
		v.pack();
		v.setVisible(true);
	}

	private void initUI() {
		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Benutzer benutzer = UserController.getController().getBenutzerByEmail(email.getText());
				name.setText(benutzer.toString() );
				revalidate();
			}
		});

		add(email, BorderLayout.NORTH);
		add(find, BorderLayout.CENTER);
		add(name, BorderLayout.SOUTH);
	}
}

package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ch.bbcag.onlineShop.controller.Controller;
import ch.bbcag.onlineShop.model.Benutzer;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = -9132440903370725395L;
	JButton loginBtn;
	JButton registerBtn;

	JTextField mail;
	JPasswordField password;

	public LoginPanel(Fenster fenster) {
		this.setLayout(new BorderLayout());

		JPanel west = new JPanel(new GridLayout(2, 1));
		JPanel east = new JPanel(new GridLayout(2, 1));
		JPanel south = new JPanel(new GridLayout(1, 2));

		west.add(new JLabel("Mail"), BorderLayout.NORTH);
		west.add(new JLabel("Passwort"), BorderLayout.SOUTH);

		mail = new JTextField(20);
		password = new JPasswordField(20);

		east.add(mail, BorderLayout.NORTH);
		east.add(password, BorderLayout.SOUTH);

		loginBtn = new JButton("Login");
		registerBtn = new JButton("Registrieren");

		ActionListener loginListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("login : " + mail.getText() + ";" + new String(password.getPassword()));
				fenster.switchJPanel(new StartScreen(), "Start", 1000, 800);
			}

		};
		ActionListener registerListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				//Benutzer password = Controller.getController().getPasswordByEmail(email.getText());
				//name.setText(benutzer.toString() );
				//revalidate();
				
				fenster.switchJPanel(new RegisterPanel(fenster), "Registrierung", 950, 220);
			}
		};
		loginBtn.addActionListener(loginListener);
		registerBtn.addActionListener(registerListener);

		south.add(loginBtn, BorderLayout.WEST);
		south.add(registerBtn, BorderLayout.EAST);

		this.add(west, BorderLayout.WEST);
		this.add(east, BorderLayout.EAST);
		this.add(south, BorderLayout.SOUTH);
	}
}

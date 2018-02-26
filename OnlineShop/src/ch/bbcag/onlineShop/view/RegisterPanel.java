package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ch.bbcag.onlineShop.controller.UserController;
import ch.bbcag.onlineShop.model.Adresse;
import ch.bbcag.onlineShop.model.Benutzer;

public class RegisterPanel extends JPanel {

	private static final long serialVersionUID = -5345921730919202354L;

	JPanel contentPanelLeft;
	JPanel contentPanelRight;
	JPanel leftLabelPanel;
	JPanel leftTextFieldsPanel;

	JPanel rightLabelPanel;
	JPanel rightTextFieldsPanel;

	JButton loginBtn;
	JButton registerBtn;

	JLabel anredeLabel = new JLabel("Anrede");
	JLabel nameLabel = new JLabel("Name");
	JLabel wohnortLabel = new JLabel("Wohnort");
	JLabel strasseLabel = new JLabel("Strasse");
	JLabel mailLabel = new JLabel("Mail");
	JLabel passwordLabel = new JLabel("Password");
	JLabel plzLabel = new JLabel("PLZ");

	String[] anreden = new String[] { "Herr", "Frau" };

	JComboBox<String> anrede = new JComboBox<>(anreden);
	JTextField name;
	JTextField wohnort;
	JTextField strasse;
	JTextField mail;
	JPasswordField password;
	JTextField plz;

	public RegisterPanel(Fenster fenster) {
		this.setLayout(new BorderLayout());

		this.contentPanelLeft = new JPanel();
		this.contentPanelRight = new JPanel();

		this.leftLabelPanel = new JPanel();
		this.leftTextFieldsPanel = new JPanel();
		this.rightLabelPanel = new JPanel();
		this.rightTextFieldsPanel = new JPanel();

		this.leftLabelPanel.setLayout(new GridLayout(0, 1));
		this.leftTextFieldsPanel.setLayout(new GridLayout(0, 1));
		this.rightLabelPanel.setLayout(new GridLayout(0, 1));
		this.rightTextFieldsPanel.setLayout(new GridLayout(0, 1));

		this.contentPanelLeft.setLayout(new GridLayout(1, 2));
		this.contentPanelRight.setLayout(new GridLayout(1, 2));

		name = new JTextField(20);
		wohnort = new JTextField(20);
		strasse = new JTextField(20);
		mail = new JTextField(20);
		password = new JPasswordField(20);
		plz = new JTextField(5);

		this.leftLabelPanel.add(anredeLabel);
		this.leftLabelPanel.add(nameLabel);
		this.leftLabelPanel.add(wohnortLabel);
		this.leftLabelPanel.add(strasseLabel);

		this.leftTextFieldsPanel.add(anrede);
		this.leftTextFieldsPanel.add(name);
		this.leftTextFieldsPanel.add(wohnort);
		this.leftTextFieldsPanel.add(strasse);

		this.rightLabelPanel.add(plzLabel);
		this.rightLabelPanel.add(mailLabel);
		this.rightLabelPanel.add(passwordLabel);

		this.rightTextFieldsPanel.add(plz);
		this.rightTextFieldsPanel.add(mail);
		this.rightTextFieldsPanel.add(password);

		registerBtn = new JButton("Registrieren");

		registerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!(mail.getText().matches("") && name.getText() == "" && password.getText() == ""
						&& wohnort.getText() == "" && strasse.getText() == "")) {
					Benutzer b = new Benutzer();
					b.setEmail(mail.getText());
					b.setName(name.getText());
					b.setPasswort(new String(password.getPassword()));
					Adresse a = new Adresse();
					a.setOrt(wohnort.getText());
					a.setStrasse(strasse.getText());
					a.setPlz(plz.getText());
					b.setAdresse(a);
					UserController.getController().registerBenutzer(b);

					System.out.println("Registrierung abgeschlossen");

					fenster.switchJPanel(new HomeMenu(b, fenster), "Home", 1200, 800);
				} else {
					System.out.println("Registrierung ist entweder unvollständig oder die Email ist nicht Valide");

				}
			}
		});

		this.contentPanelLeft.add(leftLabelPanel);
		this.contentPanelLeft.add(leftTextFieldsPanel);
		this.contentPanelRight.add(rightLabelPanel);
		this.contentPanelRight.add(rightTextFieldsPanel);

		this.add(contentPanelLeft, BorderLayout.WEST);
		this.add(contentPanelRight, BorderLayout.EAST);
		this.add(registerBtn, BorderLayout.SOUTH);

	}
}
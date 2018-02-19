 package ch.bbcag.onlineShop.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.bbcag.onlineShop.helper.IconLoader;

public class HomeMenu extends JFrame {

	private static final long serialVersionUID = 7107604425259214222L;
	private JButton sagHalloButton = new JButton("Sag Hallo");
	private JTextField halloTextField = new JTextField();

	public static void main(String[] args) {
		HomeMenu gui = new HomeMenu();
		gui.pack();
		gui.setVisible(true);
	}

	public HomeMenu() {
		setTitle("Home Menu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		halloTextField.setEditable(false);

		add(sagHalloButton, BorderLayout.NORTH);

		JPanel imagePanel = new JPanel(new GridLayout(0, 3));

		imagePanel.add(new JLabel(IconLoader.loadIcon("Nike_Air_Force_1_MID/schwarz_weiss.PNG")));
		imagePanel.add(new JLabel(IconLoader.loadIcon("Nike_Air_Hurache_Essential/schwarz_weiss.PNG")));
		imagePanel.add(new JLabel(IconLoader.loadIcon("Nike_Metcon_4/schwarz_weiss.PNG")));
		
		add(imagePanel, BorderLayout.CENTER);
	}
}
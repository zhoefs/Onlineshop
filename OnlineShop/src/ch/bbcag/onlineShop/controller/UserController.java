package ch.bbcag.onlineShop.controller;

import ch.bbcag.onlineShop.dao.BenutzerDao;
import ch.bbcag.onlineShop.dao.BenutzerJdbcDao;
import ch.bbcag.onlineShop.model.Benutzer;

public class UserController {

	private static final UserController CONTROLLER = new UserController();
	private BenutzerDao benutzerDao = new BenutzerJdbcDao();

	private UserController() {
	}

	public static UserController getController() {
		return CONTROLLER;
	}

	public Benutzer getBenutzerByEmail(String email) {
		return benutzerDao.findBenutzerByEmail(email);
	}

	public void registerBenutzer(Benutzer benutzer) {
		benutzerDao.insertBenutzer(benutzer);
	}

	public boolean isValidLogin(String username, String password) {
		Benutzer benutzer = getBenutzerByEmail(username);
		if (benutzer != null && username != null && password != null) {
			if (benutzer.getEmail() != null && benutzer.getEmail().equals(username)) {
				if (benutzer.getPasswort() != null && benutzer.getPasswort().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	// Metode VerifyLogin um die View zu teilen

}

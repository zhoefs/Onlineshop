package ch.bbcag.onlineShop.controller;

import ch.bbcag.onlineShop.dao.BenutzerDao;
import ch.bbcag.onlineShop.dao.BenutzerJdbcDao;
import ch.bbcag.onlineShop.model.Benutzer;

public class Controller {

	private static final Controller CONTROLLER = new Controller();
	private BenutzerDao benutzerDao = new BenutzerJdbcDao();

	private Controller() {
	}

	public static Controller getController() {
		return CONTROLLER;
	}

	public Benutzer getBenutzerByEmail(String email) {
		return benutzerDao.findBenutzerByEmail(email);
	}
	
	public void registerBenutzer(Benutzer benutzer) {
		benutzerDao.insertBenutzer(benutzer);
	}
}

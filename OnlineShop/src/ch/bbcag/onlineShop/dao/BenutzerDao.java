package ch.bbcag.onlineShop.dao;

import ch.bbcag.onlineShop.model.Benutzer;

public interface BenutzerDao {
	public abstract void insertBenutzer(Benutzer benutzer);
	public abstract Benutzer findBenutzerByEmail(String email);
}

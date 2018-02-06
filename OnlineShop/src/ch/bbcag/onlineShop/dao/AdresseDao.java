package ch.bbcag.onlineShop.dao;

import ch.bbcag.onlineShop.model.Adresse;

public interface AdresseDao {

	public abstract void insertAdresse(Adresse adresse);

	public abstract Adresse findAdresseById(int id);

}

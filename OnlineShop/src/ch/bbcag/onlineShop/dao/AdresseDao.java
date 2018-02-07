package ch.bbcag.onlineShop.dao;

import ch.bbcag.onlineShop.model.Adresse;

public interface AdresseDao {

	public abstract int insertAdresse(Adresse adresse);

	public abstract Adresse findAdresseById(int id);

}

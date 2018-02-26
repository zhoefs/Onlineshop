package ch.bbcag.onlineShop.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.bbcag.onlineShop.dao.BenutzerDao;
import ch.bbcag.onlineShop.dao.BenutzerJdbcDao;
import ch.bbcag.onlineShop.model.Adresse;
import ch.bbcag.onlineShop.model.Benutzer;

public class BenutzerTest {
	
	private Adresse adresse;
	
	private BenutzerDao benutzerDao;
	private Benutzer benutzer;

	@Before
	public void setUp() throws Exception {
		adresse = new Adresse();
		benutzerDao = new BenutzerJdbcDao();
		benutzer = new Benutzer();
		
		adresse.setOrt("Bern");
		adresse.setPlz("5004");
		adresse.setStrasse("Bahnhofstrasse 56");
	}

	@After
	public void tearDown() throws Exception {
		adresse = null;
		benutzerDao = null;
		benutzer = null;
	}

	@Test
	public void testBenutzerInsert() {
		benutzer.setName("Fritzli");
		benutzer.setEmail("fritzli@bbc-ag.ch");
		benutzer.setPasswort("12345");
		benutzer.setAdresse(adresse);
		benutzerDao.insertBenutzer(benutzer);
		assertEquals(benutzer, benutzerDao.findBenutzerByEmail(benutzer.getEmail()));
	}

}

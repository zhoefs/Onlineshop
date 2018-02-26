package ch.bbcag.onlineShop.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.bbcag.onlineShop.dao.AdresseDao;
import ch.bbcag.onlineShop.dao.AdresseJdbcDao;
import ch.bbcag.onlineShop.model.Adresse;

public class AdressTest {
	
	private AdresseDao adresseDao;
	private Adresse adresse;

	@Before
	public void setUp() throws Exception {
		adresseDao = new AdresseJdbcDao();
		adresse = new Adresse();
	}
	
	@After
	public void tearDown() throws Exception {
		adresseDao = null;
		adresse = null;
	}

	@Test
	public void testAdresseInsert() {
		adresse.setOrt("Zürich");
		adresse.setPlz("8005");
		adresse.setStrasse("Pfingstweidstrasse 100");
		int insertedAddressId = adresseDao.insertAdresse(adresse);
		Adresse addressFromDb = adresseDao.findAdresseById(insertedAddressId);
		assertEquals(adresse, addressFromDb);
	}

}

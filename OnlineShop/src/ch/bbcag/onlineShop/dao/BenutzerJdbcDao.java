package ch.bbcag.onlineShop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch.bbcag.onlineShop.model.Adresse;
import ch.bbcag.onlineShop.model.Benutzer;

public class BenutzerJdbcDao implements BenutzerDao {

	private AdresseDao adresseDao = new AdresseJdbcDao();

	@Override
	public void insertBenutzer(Benutzer benutzer) {
		// insert address
		int adresse_id = adresseDao.insertAdresse(benutzer.getAdresse());
		
		String sql = "insert into onlineshop.benutzer (name, email, passwort, adresse_id) values (?, ?, ?, ?)";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, benutzer.getName());
			ps.setString(2, benutzer.getEmail());
			ps.setString(3, benutzer.getPasswort());
			ps.setInt(4, adresse_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public Benutzer findBenutzerByEmail(String email) {
		String sql = "select * from onlineshop.benutzer where email = ?";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Benutzer benutzer = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				benutzer = new Benutzer();
				benutzer.setId(rs.getInt("id"));
				benutzer.setName(rs.getString("name"));
				benutzer.setEmail(rs.getString("email"));
				benutzer.setPasswort(rs.getString("passwort"));

				Adresse adresse = adresseDao.findAdresseById(rs.getInt("adresse_id"));
                benutzer.setAdresse(adresse);
		        break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (benutzer != null) {
			return benutzer;
		} else {
			return new Benutzer();
		}
	}
}


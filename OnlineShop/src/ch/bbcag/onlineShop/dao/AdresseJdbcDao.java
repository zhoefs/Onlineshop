package ch.bbcag.onlineShop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch.bbcag.onlineShop.model.Adresse;

public class AdresseJdbcDao implements AdresseDao {

	@Override
	public Adresse findAdresseById(int id) {
		String sql = "select * from onlineshop.adresse where id = ?";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Adresse adresse = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				adresse = new Adresse();
				adresse.setId(rs.getInt("id"));
				adresse.setStrasse(rs.getString("strasse"));
				adresse.setOrt(rs.getString("ort"));
				adresse.setPlz(rs.getInt("plz"));
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
		if (adresse != null) {
			return adresse;
		} else {
			return new Adresse();
		}
	}

	@Override
	public void insertAdresse(Adresse adresse) {
		// TODO Auto-generated method stub
		
	}
}

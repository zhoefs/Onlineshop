package ch.bbcag.onlineShop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	public int insertAdresse(Adresse adresse) {
		String sql = "insert into onlineshop.adresse (strasse, ort, plz) values (?,?,?)";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
	    int newPk = 0;
		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, adresse.getStrasse());
			ps.setString(2, adresse.getOrt());
			ps.setInt(3,adresse.getPlz());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				newPk = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newPk;
		
	}
}

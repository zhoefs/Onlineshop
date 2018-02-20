package ch.bbcag.onlineShop.model;

public class Adresse {

	private int id;
	private String strasse = "";
	private String ort = "";
	private String plz = "";

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", strasse=" + strasse + ", ort=" + ort + ", plz=" + plz + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

}
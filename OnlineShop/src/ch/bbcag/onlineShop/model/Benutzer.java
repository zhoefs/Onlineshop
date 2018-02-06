package ch.bbcag.onlineShop.model;

public class Benutzer {
	private int id;
	private String name;
	private String email;
	private String passwort;
	private Adresse adresse;
	
	@Override
	public String toString() {
		return "Benutzer [id=" + id + ", name=" + name + ", email=" + email + ", passwort=" + passwort + ", adresse="
				+ adresse + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}

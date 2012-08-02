package defPack;

public class Universitate {

	private long u_id;
	private String nume_univer;
	private String adresa;
	private String telefon;

	public Universitate() {
		this.u_id = 0;
		this.nume_univer = "";
		this.adresa = "";
		this.telefon = "";
	}

	public Universitate(long u_ID, String u_Denumirea, String u_Adresa,
			String u_Telefon) {
		this.setU_id(u_ID);
		this.setNume_univer(u_Denumirea);
		this.setAdresa(u_Adresa);
		this.setTelefon(u_Telefon);
	}

	public long getU_id() {
		return u_id;
	}

	public void setU_id(long u_id) {
		this.u_id = u_id;
	}

	public String getNume_univer() {
		return nume_univer;
	}

	public void setNume_univer(String nume_univer) {
		this.nume_univer = nume_univer;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}

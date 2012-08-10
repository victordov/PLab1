package md.victordov.lab.vo;

public class Profesor {

	private long p_id;
	private String nume;
	private String prenume;
	private String adresa;

	public Profesor() {
		this.setP_id(0);
		this.setNume("");
		this.setPrenume("");
		this.setAdresa("");
	}

	public Profesor(long P_ProfesorID, String P_Nume, String P_Prenume, String P_Adresa) {
		this.setP_id(P_ProfesorID);
		this.setNume(P_Nume);
		this.setPrenume(P_Prenume);
		this.setAdresa(P_Adresa);

	}

	public long getP_id() {
		return p_id;
	}

	public void setP_id(long p_id) {
		this.p_id = p_id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

}

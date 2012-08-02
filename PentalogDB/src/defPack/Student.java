package defPack;

public class Student {
	long s_id;
	String nume, prenume, grupa, email, telFix;

	public Student() {
		this.setS_id(0);
		this.setNume("");
		this.setPrenume("");
		this.setGrupa("");
		this.setEmail("");
		this.setTelFix("");
	}

	public Student(long s_s_id, String s_nume, String s_prenume, String s_grupa,
			String s_email, String s_telFix) {
		this.setS_id(s_s_id);
		this.setNume(s_nume);
		this.setPrenume(s_prenume);
		this.setGrupa(s_grupa);
		this.setEmail(s_email);
		this.setTelFix(s_telFix);
	}

	public long getS_id() {
		return s_id;
	}

	public void setS_id(long s_id) {
		this.s_id = s_id;
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

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelFix() {
		return telFix;
	}

	public void setTelFix(String telFix) {
		this.telFix = telFix;
	}

}

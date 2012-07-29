package defPack;

public class Curs {
	private long c_id;
	private String nume_curs;
	private long u_id;
	private long p_id;

	Curs() {
		this.setC_id(0);
		this.setNume_curs("");
		this.setU_id(0);
		this.setP_id(0);
	}

	Curs(long ID, String Num_Curs, long U_ID, long P_ID) {
		this.setC_id(ID);
		this.setNume_curs(Num_Curs);
		this.setU_id(U_ID);
		this.setP_id(P_ID);
	}

	public String toString(){
		return this.getC_id()+"\t"+this.getNume_curs()+"\t"+this.getU_id()+"\t"+this.getP_id();
	}

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	public String getNume_curs() {
		return nume_curs;
	}

	public void setNume_curs(String nume_curs) {
		this.nume_curs = nume_curs;
	}

	public long getU_id() {
		return u_id;
	}

	public void setU_id(long u_id) {
		this.u_id = u_id;
	}

	public long getP_id() {
		return p_id;
	}

	public void setP_id(long p_id) {
		this.p_id = p_id;
	}
}

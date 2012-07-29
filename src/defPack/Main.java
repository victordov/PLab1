package defPack;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static Scanner sc = new Scanner(System.in);

	public void Menu() {
		System.out.println("Bine ati Venit");
		System.out.println("Alege Meniul");
		System.out.println("1: Student");
		System.out.println("2: Profesor");
		System.out.println("3: Universitate");
		System.out.println("4: Curs	");
		System.out.println("5: Iesire");
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			Student_Menu();
			break;
		case 2:
			Profesor_Menu();
			break;
		case 3:
			Universitate_Menu();
			break;
		case 4:
			Curs_Menu();
			break;
		case 5:
			System.out.println("La Revedere... ");
			System.exit(0);
		default:
			Menu();
		}
	}

	private void Curs_Menu() {
		System.out.println("1:\tCreate Curs");
		System.out.println("2:\tRead   Curs");
		System.out.println("3:\tUpdate Curs");
		System.out.println("4:\tDelete Curs");
		System.out.println("5:\tPrint Toate Cursurile");
		System.out.println("6:\tMeniul Principal");
		CursDAO cursDAO = new CursDAO();
		Curs curs = new Curs();
		ArrayList<Curs> arrayUniver = new ArrayList<Curs>();
		long id;
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			System.out.println("Introdu ID-ul: ");
			curs.setC_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Denumirea: ");
			curs.setNume_curs(sc.nextLine());

			System.out.println("Introdu Id-ul Universitatii: ");
			curs.setU_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Id-ul Profesorului:");
			curs.setP_id(Long.parseLong(sc.nextLine()));

			System.out
					.println(cursDAO.create(curs) ? "A fost creat Cursul "
							+ curs.getU_id() : "Nu a fost schimbat nimic");
			Universitate_Menu();
			break;
		case 2:
			id = Long.parseLong(sc.nextLine());
			curs = cursDAO.retrieve(id);
			System.out.println("ID\tDenumire Curs\t Universitate ID\tProfesor ID");
			System.out.println(curs.toString());
			Curs_Menu();
			break;
		case 3:
			System.out.println("Introdu ID-ul: ");
			curs.setU_id(Integer.parseInt(sc.nextLine()));

			System.out.println("Introdu Denumirea: ");
			curs.setNume_curs(sc.nextLine());

			System.out.println("Introdu Id-ul Universitatii: ");
			curs.setU_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Id-ul Profesorului:");
			curs.setP_id(Long.parseLong(sc.nextLine()));

			System.out
					.println(cursDAO.update(curs) ? "A fost reinnoit Studetul "
							+ curs.getU_id() : "Nu a fost schimbat nimic");
			Curs_Menu();
			break;
		case 4:

			System.out.println("Introdu ID-ul: ");
			id = Long.parseLong(sc.nextLine());
			cursDAO.delete(id);
			Curs_Menu();
			break;
		case 5:
			Curs_Menu();
			break;
		case 6:
			Menu();
			break;
		default:
			Menu();

		}

	}

	private void Universitate_Menu() {
		System.out.println("1:\tCreate Universitate");
		System.out.println("2:\tRead   Universitate");
		System.out.println("3:\tUpdate Universitate");
		System.out.println("4:\tDelete Universitate");
		System.out.println("5:\tPrint Toate Universitatile");
		System.out.println("6:\tMeniul Principal");
		UnivDAO univDAO = new UnivDAO();
		Universitate univ = new Universitate();
		ArrayList<Universitate> arrayUniver = new ArrayList<Universitate>();
		long id;
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			System.out.println("Introdu ID-ul: ");
			univ.setU_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Denumirea Universitatii: ");
			univ.setNume_univer(sc.nextLine());

			System.out.println("Introdu Adresa: ");
			univ.setAdresa(sc.nextLine());

			System.out.println("Introdu Telefonul:");
			univ.setTelefon(sc.nextLine());

			System.out
					.println(univDAO.create(univ) ? "A fost Creat Universitate "
							+ univ.getU_id()
							: "Nu a fost schimbat nimic");
			Universitate_Menu();
			break;
		case 2:
			System.out.println("Introdu ID-ul universitatii ce urmeaza sa fie afisata");
			id = Long.parseLong(sc.nextLine());
			univ = univDAO.retrieve(id);
			System.out.println("ID\tDenumirea Universitatii\tAdresa\tTelefon");
			System.out.println(univ.toString());
			Universitate_Menu();
			break;
		case 3:
			System.out.println("Introdu ID-ul: ");
			univ.setU_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Denumirea: ");
			univ.setNume_univer(sc.nextLine());

			System.out.println("Introdu Adresa: ");
			univ.setAdresa(sc.nextLine());

			System.out.println("Telefonul:");
			univ.setTelefon(sc.nextLine());

			System.out
					.println(univDAO.update(univ) ? "A fost reinnoita Universitatea "
							+ univ.getU_id()
							: "Nu a fost schimbat nimic");
			Universitate_Menu();
			break;
		case 4:

			System.out.println("Introdu ID-ul: ");
			id = Long.parseLong(sc.nextLine());
			univDAO.delete(id);
			Universitate_Menu();
			break;
		case 5:
			Universitate_Menu();
			break;
		case 6:
			Menu();
			break;
		default:
			Menu();

		}

	}

	private void Profesor_Menu() {
		System.out.println("1:\tCreate Profesor");
		System.out.println("2:\tRead   Profesor");
		System.out.println("3:\tUpdate Profesor");
		System.out.println("4:\tDelete Profesor");
		System.out.println("5:\tPrint All Profesors");
		System.out.println("6:\tMeniul Principal");
		ProfesorDAO prfDAO = new ProfesorDAO();
		Profesor prof = new Profesor();
		ArrayList<Profesor> arrayProf = new ArrayList<Profesor>();
		long id;
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			System.out.println("Introdu ID-ul: ");
			prof.setP_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Numele: ");
			prof.setNume(sc.nextLine());

			System.out.println("Introdu Prenumele: ");
			prof.setPrenume(sc.nextLine());

			System.out.println("Adresa:");
			prof.setAdresa(sc.nextLine());

			System.out.println(prfDAO.create(prof) ? "A fost Creat Profesorul "
					+ prof.getP_id() : "Nu a fost schimbat nimic");
			Profesor_Menu();
			break;
		case 2:
			System.out.println("Introdu ID-ul profesorului ce urmeaza sa fie afisat");
			id = Long.parseLong(sc.nextLine());
			prof = prfDAO.retrieve(id);
			System.out.println("ID\tNume\tPrenue\tAdresa");
			System.out.println(prof.toString());
			Profesor_Menu();
			break;
		case 3:
			System.out.println("Introdu ID-ul: ");
			prof.setP_id(Integer.parseInt(sc.nextLine()));

			System.out.println("Introdu Numele: ");
			prof.setNume(sc.nextLine());

			System.out.println("Introdu Prenumele: ");
			prof.setPrenume(sc.nextLine());

			System.out.println("Adresa:");
			prof.setAdresa(sc.nextLine());

			System.out
					.println(prfDAO.update(prof) ? "A fost reinnoit Profesorul "
							+ prof.getP_id()
							: "Nu a fost schimbat nimic");
			Profesor_Menu();
			break;
		case 4:
			System.out.println("Introdu ID-ul: ");
			id = Long.parseLong(sc.nextLine());
			prfDAO.delete(id);
			Profesor_Menu();
			break;
		case 5:
			Profesor_Menu();
			break;
		case 6:
			Menu();
			break;
		default:
			Menu();

		}

	}

	private void Student_Menu() {
		System.out.println("1:\tCreate Student");
		System.out.println("2:\tRead   Student");
		System.out.println("3:\tUpdate Student");
		System.out.println("4:\tDelete Student");
		System.out.println("5:\tPrint All Students");
		System.out.println("6:\tMeniul Principal");
		StudentDAO stdao = new StudentDAO();
		Student stud = new Student();
		ArrayList<Student> arrayStud = new ArrayList<Student>();
		long id;
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			System.out.println("Introdu ID-ul: ");
			stud.setS_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Numele: ");
			stud.setNume(sc.nextLine());

			System.out.println("Introdu Prenumele: ");
			stud.setPrenume(sc.nextLine());

			System.out.println("Grupa:");
			stud.setGrupa(sc.nextLine());

			System.out.println("Email: ");
			stud.setEmail(sc.nextLine());

			System.out.println("Telefon: ");
			stud.setTelFix(sc.nextLine());

			System.out.println(stdao.create(stud) ? "A fost Creat Studetul "
					+ stud.getS_id() : "Nu a fost schimbat nimic");
			Student_Menu();
			break;
		case 2:
			System.out.println("Introdu ID-ul studentului ce urmeaza sa fie afisat");
			id = Long.parseLong(sc.nextLine());
			stud = stdao.retrieve(id);
			System.out.println("ID\t  Nume\t  Prenue\t  Grupa\t  Email\t  Telefon");
			System.out.println(stud.toString());
			Student_Menu();
			break;
		case 3:
			System.out.println("Introdu ID-ul: ");
			stud.setS_id(Integer.parseInt(sc.nextLine()));

			System.out.println("Introdu Numele: ");
			stud.setNume(sc.nextLine());

			System.out.println("Introdu Prenumele: ");
			stud.setPrenume(sc.nextLine());

			System.out.println("Grupa:");
			stud.setGrupa(sc.nextLine());

			System.out.println("Email: ");
			stud.setEmail(sc.nextLine());

			System.out.println("Telefon: ");
			stud.setTelFix(sc.nextLine());

			// if(stdao.update(stud));
			System.out.println(stdao.update(stud) ? "Informatia studentului a fost reinnoita"
					+ stud.getS_id() : "Nu a fost schimbat nimic");
			Student_Menu();
			break;
		case 4:

			System.out.println("Introdu ID-ul: ");
			id = Long.parseLong(sc.nextLine());
			stdao.delete(id);
			Student_Menu();
			break;
		case 5:
			Student_Menu();
			break;
		case 6:
			Menu();
			break;
		default:
			Menu();

		}

	}

	public static void main(String[] args) {
		Main UniverDB = new Main();
		UniverDB.Menu();
	}

}

package md.victordov.lab.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import md.victordov.lab.dao.CursDAO;
import md.victordov.lab.dao.GenericDAO;
import md.victordov.lab.dao.ProfesorDAO;
import md.victordov.lab.dao.StudentDAO;
import md.victordov.lab.dao.UnivDAO;
import md.victordov.lab.vo.Curs;
import md.victordov.lab.vo.Profesor;
import md.victordov.lab.vo.Student;
import md.victordov.lab.vo.Universitate;

public class Main {

	/**
	 * @param args
	 */
	public static Scanner sc = new Scanner(System.in);
	public static GenericDAO gDAO = null;

	public void Menu() {
		System.out.println(MenuText.outMenuPrincipal);
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

	private void Student_Menu() {

		System.out.println(MenuText.outStudMenu);
		gDAO = new StudentDAO();
		Student stud = new Student();
		ArrayList<Student> arrayStud = new ArrayList<Student>();
		String format = "|%1$-10d|%2$-15s|%3$-15s|%4$-10s|%5$-25s|%6$-12s|\n";
		String format2 = "|%1$-10s|%2$-15s|%3$-15s|%4$-10s|%5$-25s|%6$-12s|\n";
		long id;
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			System.out.println(MenuText.inID);
			stud.setS_id(Long.parseLong(sc.nextLine()));

			System.out.println(MenuText.inNume);
			stud.setNume(sc.nextLine());

			System.out.println(MenuText.inPrenume);
			stud.setPrenume(sc.nextLine());

			System.out.println(MenuText.inGrupa);
			stud.setGrupa(sc.nextLine());

			System.out.println(MenuText.inEmail);
			stud.setEmail(sc.nextLine());

			System.out.println(MenuText.inTelefon);
			stud.setTelFix(sc.nextLine());

			System.out.println(gDAO.create(stud) ? MenuText.outSuccess
					+ stud.getS_id() : MenuText.outEsuare);
			Student_Menu();
			break;
		case 2:
			System.out
					.println("Introdu ID-ul studentului ce urmeaza sa fie afisat");
			id = Long.parseLong(sc.nextLine());
			stud = (Student) gDAO.retrieve(id);
			System.out.format(format2, "ID Stud", "Nume", "Prenume", "Grupa",
					"Email", "TelFix");
			System.out.format(format, stud.getS_id(), stud.getNume(),
					stud.getPrenume(), stud.getGrupa(), stud.getEmail(),
					stud.getTelFix());
			Student_Menu();
			break;
		case 3:
			System.out.println(MenuText.inID);
			stud.setS_id(Integer.parseInt(sc.nextLine()));

			System.out.println(MenuText.inNume);
			stud.setNume(sc.nextLine());

			System.out.println(MenuText.inPrenume);
			stud.setPrenume(sc.nextLine());

			System.out.println(MenuText.inGrupa);
			stud.setGrupa(sc.nextLine());

			System.out.println(MenuText.inEmail);
			stud.setEmail(sc.nextLine());

			System.out.println(MenuText.inTelefon);
			stud.setTelFix(sc.nextLine());

			// if(gDAO.update(stud));
			System.out.println(gDAO.update(stud) ? MenuText.outSuccess
					+ stud.getS_id() : MenuText.outEsuare);
			Student_Menu();
			break;
		case 4:
			System.out.println(MenuText.inID);
			id = Long.parseLong(sc.nextLine());
			gDAO.delete(id);
			Student_Menu();
			break;
		case 5:
			arrayStud.addAll(gDAO.retrieve());
			Iterator<Student> it = arrayStud.iterator();
			System.out.format(format2, "ID Stud", "Nume", "Prenume", "Grupa",
					"Email", "TelFix");
			while (it.hasNext()) {
				Student outputStud = new Student();
				outputStud = it.next();
				System.out.format(format, outputStud.getS_id(),
						outputStud.getNume(), outputStud.getPrenume(),
						outputStud.getGrupa(), outputStud.getEmail(),
						outputStud.getTelFix());

			}
			Student_Menu();
			break;
		case 6:
			Menu();
			break;
		default:
			Menu();
		}
	}

	private void Profesor_Menu() {
		System.out.println(MenuText.outProfMenu);

		gDAO = new ProfesorDAO();
		Profesor prof = new Profesor();
		ArrayList<Profesor> arrayProf = new ArrayList<Profesor>();
		String format = "|%1$-10d|%2$-15s|%3$-15s|%4$-25s|\n";
		String format2 = "|%1$-10s|%2$-15s|%3$-15s|%4$-25s|\n";
		long id;
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			System.out.println(MenuText.inID);
			prof.setP_id(Long.parseLong(sc.nextLine()));

			System.out.println(MenuText.inNume);
			prof.setNume(sc.nextLine());

			System.out.println(MenuText.inPrenume);
			prof.setPrenume(sc.nextLine());

			System.out.println(MenuText.inAdresa);
			prof.setAdresa(sc.nextLine());

			System.out.println(gDAO.create(prof) ? MenuText.outSuccess
					+ prof.getP_id() : MenuText.outEsuare);
			Profesor_Menu();
			break;
		case 2:
			System.out
					.println("Introdu ID-ul profesorului ce urmeaza sa fie afisat");
			id = Long.parseLong(sc.nextLine());
			prof = (Profesor) gDAO.retrieve(id);
			System.out.format(format2, "ID Prof", "Nume", "Prenume", "Adresa");
			System.out.format(format, prof.getP_id(), prof.getNume(),
					prof.getPrenume(), prof.getAdresa());
			Profesor_Menu();
			break;
		case 3:
			System.out.println(MenuText.inID);
			prof.setP_id(Integer.parseInt(sc.nextLine()));

			System.out.println(MenuText.inNume);
			prof.setNume(sc.nextLine());

			System.out.println(MenuText.inPrenume);
			prof.setPrenume(sc.nextLine());

			System.out.println(MenuText.inAdresa);
			prof.setAdresa(sc.nextLine());

			System.out.println(gDAO.update(prof) ? MenuText.outSuccess
					+ prof.getP_id() : MenuText.outEsuare);
			Profesor_Menu();
			break;
		case 4:
			System.out.println(MenuText.inID);
			id = Long.parseLong(sc.nextLine());
			gDAO.delete(id);
			Profesor_Menu();
			break;
		case 5:
			arrayProf.addAll(gDAO.retrieve());
			Iterator<Profesor> it = arrayProf.iterator();
			System.out.format(format2, "ID Prof", "Nume", "Prenume", "Adresa");
			while (it.hasNext()) {
				Profesor outputProf = new Profesor();
				outputProf = it.next();
				System.out.format(format, outputProf.getP_id(),
						outputProf.getNume(), outputProf.getPrenume(),
						outputProf.getAdresa());
			}
			Profesor_Menu();
			break;
		case 6:
			Menu();
			break;
		default:
			Menu();
		}
	}

	private void Universitate_Menu() {
		System.out.println(MenuText.outUnivMenu);
		gDAO = new UnivDAO();
		Universitate univ = new Universitate();
		ArrayList<Universitate> arrayUniver = new ArrayList<Universitate>();
		String format = "|%1$-10d|%2$-19s|%3$-27s|%4$-15s\n";
		String format2 = "|%1$-10s|%2$-19s|%3$-27s|%4$-15s\n";
		long id;
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			System.out.println(MenuText.inID);
			univ.setU_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Denumirea Universitatii: ");
			univ.setNume_univer(sc.nextLine());

			System.out.println(MenuText.inAdresa);
			univ.setAdresa(sc.nextLine());

			System.out.println(MenuText.inTelefon);
			univ.setTelefon(sc.nextLine());

			System.out.println(gDAO.create(univ) ? MenuText.outSuccess
					+ univ.getU_id() : MenuText.outEsuare);
			Universitate_Menu();
			break;
		case 2:
			System.out.println(MenuText.inID);
			id = Long.parseLong(sc.nextLine());
			univ = (Universitate) gDAO.retrieve(id);
			System.out.format(format2, "ID Univer", "Nume Universitate",
					"Adresa", "Telefon");
			System.out.format(format, univ.getU_id(), univ.getNume_univer(),
					univ.getAdresa(), univ.getTelefon());
			Universitate_Menu();
			break;
		case 3:
			System.out.println(MenuText.inID);
			univ.setU_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Denumirea: ");
			univ.setNume_univer(sc.nextLine());

			System.out.println(MenuText.inAdresa);
			univ.setAdresa(sc.nextLine());

			System.out.println(MenuText.inTelefon);
			univ.setTelefon(sc.nextLine());

			System.out.println(gDAO.update(univ) ? MenuText.outSuccess
					+ univ.getU_id() : MenuText.outEsuare);
			Universitate_Menu();
			break;
		case 4:
			System.out.println(MenuText.inID);
			id = Long.parseLong(sc.nextLine());
			gDAO.delete(id);
			Universitate_Menu();
			break;
		case 5:
			arrayUniver.addAll(gDAO.retrieve());
			Iterator<Universitate> it = arrayUniver.iterator();
			System.out.format(format2, "ID Univer", "Nume Universitate",
					"Adresa", "Telefon");
			while (it.hasNext()) {
				Universitate outputUniver = new Universitate();
				outputUniver = it.next();
				System.out.format(format, outputUniver.getU_id(),
						outputUniver.getNume_univer(),
						outputUniver.getAdresa(), outputUniver.getTelefon());
			}
			Universitate_Menu();
			break;
		case 6:
			Menu();
			break;
		default:
			Menu();
		}
	}

	private void Curs_Menu() {
		System.out.println(MenuText.outCursMenu);
		gDAO = new CursDAO();
		Curs curs = new Curs();
		ArrayList<Curs> arrayCurs = new ArrayList<Curs>();
		String format = "|%1$-10d|%2$-20s|%3$-15d|%4$-12d|\n";
		String format2 = "|%1$-10s|%2$-20s|%3$-15s|%4$-12s|\n";
		long id;
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			System.out.println(MenuText.inID);
			curs.setC_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Denumirea: ");
			curs.setNume_curs(sc.nextLine());

			System.out.println("Introdu Id-ul Universitatii: ");
			curs.setU_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Id-ul Profesorului:");
			curs.setP_id(Long.parseLong(sc.nextLine()));

			System.out.println(gDAO.create(curs) ? MenuText.outSuccess
					+ curs.getU_id() : MenuText.outEsuare);
			Curs_Menu();
			break;
		case 2:
			System.out.println("Introdu ID-ul cursului");
			id = Long.parseLong(sc.nextLine());
			curs = (Curs) gDAO.retrieve(id);
			System.out.format(format2, "ID Curs", "Nume Curs",
					"ID Universitate", "ID Profesor");
			System.out.format(format, curs.getC_id(), curs.getNume_curs(),
					curs.getU_id(), curs.getP_id());
			Curs_Menu();
			break;
		case 3:
			System.out.println(MenuText.inID);
			curs.setU_id(Integer.parseInt(sc.nextLine()));

			System.out.println("Introdu Denumirea: ");
			curs.setNume_curs(sc.nextLine());

			System.out.println("Introdu Id-ul Universitatii: ");
			curs.setU_id(Long.parseLong(sc.nextLine()));

			System.out.println("Introdu Id-ul Profesorului:");
			curs.setP_id(Long.parseLong(sc.nextLine()));

			System.out.println(gDAO.update(curs) ? MenuText.outSuccess
					+ curs.getU_id() : MenuText.outEsuare);
			Curs_Menu();
			break;
		case 4:
			System.out.println(MenuText.inID);
			id = Long.parseLong(sc.nextLine());
			gDAO.delete(id);
			Curs_Menu();
			break;
		case 5:
			arrayCurs.addAll(gDAO.retrieve());
			Iterator<Curs> it = arrayCurs.iterator();
			System.out.format(format2, "ID Curs", "Nume Curs",
					"ID Universitate", "ID Profesor");
			while (it.hasNext()) {
				Curs outputCurs = new Curs();
				outputCurs = it.next();
				System.out.format(format, outputCurs.getC_id(),
						outputCurs.getNume_curs(), outputCurs.getU_id(),
						outputCurs.getP_id());
			}
			Curs_Menu();
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

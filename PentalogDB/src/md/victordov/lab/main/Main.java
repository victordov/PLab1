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
	    student_Menu();
	    break;
	case 2:
	    profesor_Menu();
	    break;
	case 3:
	    universitate_Menu();
	    break;
	case 4:
	    curs_Menu();
	    break;
	case 5:
	    System.out.println("La Revedere... ");
	    System.exit(0);
	default:
	    Menu();
	}
    }

    // Inceputul metodelor pentru Sudent Menu
    private Student CreateOrUpdateStudent(Student stud) {
	boolean nextInput = false;
	String tempString = new String();
	do {
	    try {
		System.out.println(MenuText.inID);
		stud.setStudentId(Long.parseLong(sc.nextLine()));
		nextInput = true;
	    } catch (NumberFormatException nfe) {
		System.out.println("Introduceti un numar valid");
	    }

	} while (nextInput != true);

	nextInput = false;

	do {
	    System.out.println(MenuText.inNume);
	    tempString = sc.nextLine();
	    if (!hasNumber(tempString)) {
		stud.setNume(tempString);
		nextInput = true;
	    }
	} while (nextInput != true);

	nextInput = false;

	do {
	    System.out.println(MenuText.inPrenume);
	    tempString = sc.nextLine();
	    if (!hasNumber(tempString)) {
		stud.setPrenume(tempString);
		nextInput = true;
	    }
	} while (nextInput != true);

	System.out.println(MenuText.inGrupa);
	stud.setGrupa(sc.nextLine());

	System.out.println(MenuText.inEmail);
	stud.setEmail(sc.nextLine());

	System.out.println(MenuText.inTelefon);
	stud.setTelFix(sc.nextLine());

	return stud;

    }

    private void printStudentMain() {
	Long id = 0L;
	Student stud = new Student();
	System.out
		.println("Introdu ID-ul studentului ce urmeaza sa fie afisat");
	try {
	    id = Long.parseLong(sc.nextLine());
	    stud = (Student) gDAO.retrieve(id);
	    System.out.printf("|%-10s|%-15s|%-15s|%-10s|%-25s|%-12s|\n",
		    	      "ID Stud", "Nume", "Prenume", "Grupa", "Email", "TelFix");
	    stud.printStudent();
	} catch (NumberFormatException nfe) {
	    System.err.println("Introduceti un numar intreg valid");
	}

    }

    private void printAllStudentMain() {
	ArrayList<Student> arrayStud = new ArrayList<Student>();
	arrayStud.addAll(gDAO.retrieve());
	Iterator<Student> it = arrayStud.iterator();
	System.out.printf("|%-10s|%-15s|%-15s|%-10s|%-25s|%-12s|\n", "ID Stud",
			  "Nume", "Prenume", "Grupa", "Email", "TelFix");
	while (it.hasNext()) {
	    Student outputStud = new Student();
	    outputStud = it.next();
	    outputStud.printStudent();

	}
    }

    // Sfirsitul metodelor pentru Student Menu

    private void student_Menu() {

	System.out.println(MenuText.outStudMenu);
	gDAO = new StudentDAO();
	Student stud = new Student();
	long id;
	int select = 6;
	try {
	    select = Integer.parseInt(sc.nextLine());
	} catch (NumberFormatException nfe) {
	    System.out.println("Nu a fost introdus un numar valid");
	    student_Menu();
	}

	switch (select) {
	case 1:
	    // Create Student
	    stud = CreateOrUpdateStudent(stud);

	    System.out.println(gDAO.create(stud) 
		    ? MenuText.outSuccess
		    : MenuText.outEsuare);
	    student_Menu();
	    break;
	case 2:
	    // Read Student
	    printStudentMain();
	    student_Menu();
	    break;
	case 3:
	    // Update Student
	    stud = CreateOrUpdateStudent(stud);

	    System.out.println(gDAO.update(stud) 
		    ? MenuText.outSuccess
		    : MenuText.outEsuare);

	    student_Menu();
	    break;
	case 4:
	    System.out.println(MenuText.inID);
	    id = Long.parseLong(sc.nextLine());
	    gDAO.delete(id);
	    student_Menu();
	    break;
	case 5:
	    printAllStudentMain();
	    student_Menu();
	    break;
	case 6:
	    Menu();
	    break;
	default:
	    Menu();
	}
    }

    // Inceputul metodelor pentru Profesor Menu
    private Profesor createOrUpdateProfesor(Profesor prof) {
	boolean nextInput = false;
	String tempString = new String();
	do {
	    try {
		System.out.println(MenuText.inID);
		prof.setProfesorId(Long.parseLong(sc.nextLine()));
		nextInput = true;
	    } catch (NumberFormatException nfe) {
		System.out.println("Introduceti un numar valid");
	    }

	} while (nextInput != true);

	nextInput = false;

	do {
	    System.out.println(MenuText.inNume);
	    tempString = sc.nextLine();
	    if (!hasNumber(tempString)) {
		prof.setNume(tempString);
		nextInput = true;
	    }
	} while (nextInput != true);

	nextInput = false;

	do {
	    System.out.println(MenuText.inPrenume);
	    tempString = sc.nextLine();
	    if (!hasNumber(tempString)) {
		prof.setPrenume(tempString);
		nextInput = true;
	    }
	} while (nextInput != true);

	System.out.println(MenuText.inAdresa);
	prof.setAdresa(sc.nextLine());
	return prof;
    }

    private void printProfesor() {
	Long id = 0L;
	Profesor prof = new Profesor();
	try {
	    System.out
		    .println("Introdu ID-ul profesorului ce urmeaza sa fie afisat");
	    id = Long.parseLong(sc.nextLine());
	    prof = (Profesor) gDAO.retrieve(id);
	    System.out.printf("|%-10s|%-15s|%-15s|%-25s|\n", "ID Prof", "Nume",
		    	      "Prenume", "Adresa");
	    prof.printProfesor();
	} catch (NumberFormatException nfe) {
	    System.err.println("Introduceti un numar intreg valid");
	}

    }

    private void printAllProfesorMain() {
	ArrayList<Profesor> arrayProf = new ArrayList<Profesor>();
	arrayProf.addAll(gDAO.retrieve());
	Iterator<Profesor> it = arrayProf.iterator();
	System.out.printf("|%-10s|%-15s|%-15s|%-25s|\n", "ID Prof", "Nume",
			  "Prenume", "Adresa");
	while (it.hasNext()) {
	    Profesor outputProf = new Profesor();
	    outputProf = it.next();
	    outputProf.printProfesor();
	}
    }

    // Sfirsitul metodelor Profesor Menu

    private void profesor_Menu() {
	System.out.println(MenuText.outProfMenu);
	gDAO = new ProfesorDAO();
	Profesor prof = new Profesor();
	long id;
	int select = 6;
	try {
	    select = Integer.parseInt(sc.nextLine());
	} catch (NumberFormatException nfe) {
	    System.out.println("Nu ati introdus un nuar valid");
	    System.out.println("Introduceti un numar intre 1 si 6");
	    profesor_Menu();
	}

	switch (select) {
	case 1:
	    System.out.println(gDAO.create(createOrUpdateProfesor(prof)) 
			    	? MenuText.outSuccess
			    	: MenuText.outEsuare);
	    profesor_Menu();
	    break;
	case 2:
	    printProfesor();
	    profesor_Menu();
	    break;
	case 3:
	    System.out.println(gDAO.update(createOrUpdateProfesor(prof)) 
		    		? MenuText.outSuccess
		    		: MenuText.outEsuare);
	    profesor_Menu();
	    break;
	case 4:
	    System.out.println(MenuText.inID);
	    id = Long.parseLong(sc.nextLine());
	    gDAO.delete(id);
	    profesor_Menu();
	    break;
	case 5:
	    printAllProfesorMain();
	    profesor_Menu();
	    break;
	case 6:
	    Menu();
	    break;
	default:
	    Menu();
	}
    }

    private Universitate createOrUpdateUniversitate(Universitate univ) {

	boolean nextInput = false;
	String tempString = new String();
	do {
	    try {
		System.out.println(MenuText.inID);
		univ.setUniversitateId(Long.parseLong(sc.nextLine()));
		nextInput = true;
	    } catch (NumberFormatException nfe) {
		System.out.println("Introduceti un numar valid");
	    }

	} while (nextInput != true);

	nextInput = false;

	do {
	    System.out.println(MenuText.inNumeUniver);
	    tempString = sc.nextLine();
	    if (!hasNumber(tempString)) {
		univ.setNumeUniversitate(tempString);
		nextInput = true;
	    }
	} while (nextInput != true);

	System.out.println(MenuText.inAdresa);
	univ.setAdresa(sc.nextLine());

	System.out.println(MenuText.inTelefon);
	univ.setTelefon(sc.nextLine());

	return univ;

    }

    private void printUniversitateMain() {
	Long id = 0L;
	Universitate univ = new Universitate();
	try {
	    System.out.println(MenuText.outIdUniver);
	    id = Long.parseLong(sc.nextLine());
	    univ = (Universitate) gDAO.retrieve(id);
	    System.out.printf("|%-10s|%-19s|%-27s|%-15s\n", "ID Univer",
		    	      "Nume Universitate", "Adresa", "Telefon");
	    univ.printUniversitate();
	} catch (NumberFormatException nfe) {
	    System.err.println("Introduceti un numar intreg valid");
	}
    }

    private void printAllUniversitateMain() {
	ArrayList<Universitate> arrayUniver = new ArrayList<Universitate>();

	arrayUniver.addAll(gDAO.retrieve());
	Iterator<Universitate> it = arrayUniver.iterator();
	System.out.printf("|%-10s|%-19s|%-27s|%-15s\n", "ID Univer",
			  "Nume Universitate", "Adresa", "Telefon");
	while (it.hasNext()) {
	    Universitate outputUniver = new Universitate();
	    outputUniver = it.next();
	    outputUniver.printUniversitate();
	}
    }

    private void universitate_Menu() {
	System.out.println(MenuText.outUnivMenu);
	gDAO = new UnivDAO();
	Universitate univ = new Universitate();
	long id;
	int select = 6;
	try {
	    select = Integer.parseInt(sc.nextLine());
	} catch (NumberFormatException nfe) {
	    System.out.println("Nu ati introdus un nuar valid");
	    System.out.println("Introduceti un numar intre 1 si 6");
	    profesor_Menu();
	}
	switch (select) {
	case 1:
	    System.out.println(gDAO.create(createOrUpdateUniversitate(univ)) 
			    	? MenuText.outSuccess
			    	: MenuText.outEsuare);
	    universitate_Menu();
	    break;
	case 2:
	    printUniversitateMain();
	    universitate_Menu();
	    break;
	case 3:
	    System.out.println(gDAO.update(createOrUpdateUniversitate(univ)) 
			    ? MenuText.outSuccess
			    : MenuText.outEsuare);
	    universitate_Menu();
	    break;
	case 4:
	    System.out.println(MenuText.inID);
	    id = Long.parseLong(sc.nextLine());
	    gDAO.delete(id);
	    universitate_Menu();
	    break;
	case 5:
	    printAllUniversitateMain();
	    universitate_Menu();
	    break;
	case 6:
	    Menu();
	    break;
	default:
	    Menu();
	}
    }

    private Curs createOUpdateCurs(Curs curs) {

	boolean nextInput = false;
	String tempString = new String();
	do {
	    try {
		System.out.println(MenuText.inID);
		curs.setCursId(Long.parseLong(sc.nextLine()));
		nextInput = true;
	    } catch (NumberFormatException nfe) {
		System.out.println("Introduceti un numar valid");
	    }

	} while (nextInput != true);

	nextInput = false;

	do {
	    System.out.println(MenuText.inNumeCurs);
	    tempString = sc.nextLine();
	    if (!hasNumber(tempString)) {
		curs.setNumeCurs(tempString);
		nextInput = true;
	    }
	} while (nextInput != true);

	System.out.println(MenuText.inIdUniver);
	curs.setUniversitateId(Long.parseLong(sc.nextLine()));

	System.out.println(MenuText.inIdProfesor);
	curs.setProfesorId(Long.parseLong(sc.nextLine()));

	return curs;

    }

    private void printCursMain() {
	Long id = 0L;
	Curs curs = new Curs();
	try {
	    System.out.println(MenuText.inID);
	    id = Long.parseLong(sc.nextLine());
	    curs = (Curs) gDAO.retrieve(id);
	    System.out.printf("|%-10s|%-20s|%-15s|%-12s|\n", "ID Curs",
		    	      "Nume Curs", "ID Universitate", "ID Profesor");
	    curs.printCurs();
	} catch (NumberFormatException nfe) {
	    System.err.println("Introduceti un numar intreg valid");
	}
    }

    private void printAllCursMain() {
	ArrayList<Curs> arrayCurs = new ArrayList<Curs>();
	arrayCurs.addAll(gDAO.retrieve());
	Iterator<Curs> it = arrayCurs.iterator();
	System.out.printf("|%-10s|%-20s|%-15s|%-12s|\n", "ID Curs",
			  "Nume Curs", "ID Universitate", "ID Profesor");
	while (it.hasNext()) {
	    Curs outputCurs = new Curs();
	    outputCurs = it.next();
	    outputCurs.printCurs();
	}
    }

    private void curs_Menu() {
	System.out.println(MenuText.outCursMenu);
	gDAO = new CursDAO();
	Curs curs = new Curs();

	long id;
	int select = Integer.parseInt(sc.nextLine());
	switch (select) {
	case 1:

	    System.out.println(gDAO.create(createOUpdateCurs(curs)) 
		    		? MenuText.outSuccess
		    		: MenuText.outEsuare);
	    curs_Menu();
	    break;
	case 2:
	    printCursMain();
	    curs_Menu();
	    break;
	case 3:
	    System.out.println(gDAO.update(createOUpdateCurs(curs)) 
			    ? MenuText.outSuccess
			    : MenuText.outEsuare);
	    curs_Menu();
	    break;
	case 4:
	    System.out.println(MenuText.inID);
	    id = Long.parseLong(sc.nextLine());
	    gDAO.delete(id);
	    curs_Menu();
	    break;
	case 5:
	    printAllCursMain();
	    curs_Menu();
	    break;
	case 6:
	    Menu();
	    break;
	default:
	    Menu();

	}

    }

    // Validare String fara numar pentru nume si prenume
    public static boolean hasNumber(String toBeChecked) {
	boolean trueOrFalse = false;
	for (int i = 0; i < toBeChecked.length(); i++) {
	    if (Character.isDigit(toBeChecked.charAt(i))) {
		System.out.println("Cuvintul introdus contine cifre");
		trueOrFalse = true;
		break;
	    }

	}
	return trueOrFalse;
    }

    public static void main(String[] args) {
	Main UniverDB = new Main();
	UniverDB.Menu();
    }

}

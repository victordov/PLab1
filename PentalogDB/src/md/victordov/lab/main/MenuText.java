package md.victordov.lab.main;

public interface MenuText {
	static String inID = "Introdu ID-ul: ";
	static String inNume = "Introdu Numele: ";
	static String inPrenume = "Introdu Prenumele: ";
	static String inGrupa = "Grupa:";
	static String inEmail = "Email: ";
	static String inTelefon = "Telefon: ";
	static String inAdresa = "Adresa: ";
	// Afisare mesajului de succes in cazaul - crearii,reinnoirii sau stergerii
	// unei date din tabel.
	static String outSuccess = "Succes";
	// Afisare mesajului de esuare in cazaul - crearii,reinnoirii sau stergerii
	// unei date din tabel.
	static String outEsuare = "Esuare";
	static String outMenuPrincipal = "Alege Meniul\n1: Student\n2: Profesor\n3: Universitate\n4: Curs\n5: Iesire";
	static String outStudMenu = "1:\tCreate Student\n2:\tRead   Student\n3:\tUpdate Student\n4:\tDelete Student\n5:\tPrint All Students\n6:\tMeniul Principal";
	static String outProfMenu = "1:\tCreate Profesor\n2:\tRead Profesor\n3:\tUpdate Profesor\n4:\tDelete Profesor\n5:\tPrint All Profesors\n6:\tMeniul Principal";
	static String outCursMenu = "1:\tCreate Curs\n2:\tRead Curs\n3:\tUpdate Curs\n4:\tDelete Curs\n5:\tPrint Toate Cursurile\n6:\tMeniul Principal";
	static String outUnivMenu = "1:\tCreate Universitate\n2:\tRead   Universitate\n3:\tUpdate Universitate\n4:\tDelete Universitate\n5:\tPrint Toate Universitatile\n6:\tMeniul Principal";

}

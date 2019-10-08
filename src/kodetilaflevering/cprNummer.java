package kodetilaflevering;
import java.util.Scanner;

public class cprNummer {
	public static void main (String [] args) {
		//Kalder p� et cpr-nummer
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		//Printer test af CPRNummeret
		System.out.print(TestafCPR(s));
	}
	public static String TestafCPR(String s) {
		//Tester hvorvidt det sidste tal er lige eller ulige
		String a;
		if (erbogstav (s) > 1) {
			a =("ikke et cprnummer");			
		} else if (s.length() > 10 || s.length() < 10){
			a =("ikke et cprnummer");
		} else if (passerdato(s) == false) {
			a =("ikke et cprnummer");
		} else {
			String lige = s.substring(9);
			int liget = Integer.parseInt(lige);
			int ulige = liget % 2;
			if (ulige == 0) {
				a =("lige cprnummer");
			} else if (ulige != 0){
				a =("ulige cprnummer");
			} else {
				a =("ikke et cprnummer");
			}
		}
		return a;
	}
	
	public static int erbogstav (String s) {
		int erbogstav = 0;
		for (int i = 0; i < s.length(); i++) {
			char bogstav = s.charAt(i);
			if (Character.isLetter(bogstav)) {
				erbogstav ++;
			}
		}
		return erbogstav;
	}

	public static boolean passerdato(String s) {
		boolean datoer = false;
		int dage;

		//Her laves datoen om til integers
		int cpr0 = Integer.parseInt(s.substring(0,1));
		int cpr1 = Integer.parseInt(s.substring(1,2));
		//Da de f�rste v�rdi er tiere, og den n�ste 1nere, ganges den f�rste med 10
		int dato = cpr0 * 10 + cpr1;

		//Her laves m�nede til integers
		int cpr2 = Integer.parseInt(s.substring(2,3));
		int cpr3 = Integer.parseInt(s.substring(3,4));
		//Da de f�rste v�rdi er tiere, og den n�ste 1nere, ganges den f�rste med 10
		int m�ned = 10 * cpr2 + cpr3;

		//Her laves �rstallet om til integers
		int cpr4 = Integer.parseInt(s.substring(4,5));
		int cpr5 = Integer.parseInt(s.substring(5,6));
		//Da de f�rste v�rdi er tiere, og den n�ste 1nere, ganges den f�rste med 10
		int �r = 10 * cpr4 + cpr5;
		
		//M�neder med 31 dage	
		if (m�ned == 1 || m�ned == 3 || m�ned == 5 || m�ned == 7 || m�ned == 8 || m�ned == 10 || m�ned == 12) {
			dage = 31;
			if (dato <= dage) {
				datoer = true;
			}
		}
		//M�neder med 30 dage
		if (m�ned == 4 || m�ned == 6 || m�ned == 9 || m�ned == 11) {
			dage = 30;
			if (dato <= dage) {
				datoer = true;
			}
		}
		//Februar udenfor skud�r
		if (m�ned == 2 && �r%4 != 0) {
			dage = 28;
			if (dato <= dage) {
				datoer = true;
			}
		}
		//Februar i skud�r
		if (m�ned == 2 && �r%4 == 0) {
			dage = 29;
			if (dato <= dage) {
				datoer = true;
			}
		}
		return datoer;
	}
}
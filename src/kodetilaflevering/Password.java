package kodetilaflevering;

import java.util.Scanner;
public class Password {

	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		/*int sm�Bogstav = 0;
		int storeBogstav = 0;
		int Num = 0;
		int ikkeAlfa = 0; */

		if (s.length() <= 9 && sm�Bogstav >= 1 && storeBogstav >= 1 && Num >= 1 && ikkeAlfa >= 1) {
			System.out.print("strong");
		} else if (s.length() == 8 && sm�Bogstav >= 1 && storeBogstav >= 1 && Num >= 1 && ikkeAlfa >= 1) {
			System.out.print("acceptable");
		} else if (s.length() == 7 && sm�Bogstav >= 1 && storeBogstav >= 1 && Num >= 1 && ikkeAlfa >= 1) {
			System.out.print("acceptable");
		} else if (s.length() <7) {
			System.out.print("unacceptable");
		}	
	}

	public static int sm�Bogstav(String s) {
		int sm�Bogstav = 0;
		for (int i = 0; i < s.length(); i++) {
			char sm� = s.charAt(i);
			if (Character.isLowerCase(sm�)) {
				sm�Bogstav ++;	
			}		
		}
		return sm�Bogstav;
	}

	public static int storeBogstav(String s) {
		int storeBogstav = 0;
		for (int i = 0; i < s.length(); i++) {
			char store = s.charAt(i);
			if (Character.isUpperCase(store)) {
				storeBogstav ++;	
			}		
		}
		return storeBogstav;
	}

	public static int Num(String s) {
		int Num = 0;
		for (int i = 0; i < s.length(); i++) {
			char tal = s.charAt(i);
			if (Character.isDigit(tal)) {
				Num ++;	
			}		
		}
		return Num;
	}

	public static int ikkeAlfaNumerisk (String s) {
		int ikkeAlfa = 0;
		for (int i = 0; i < s.length(); i++) {
			char ikke = s.charAt(i);
			if (Character.isDigit(ikke) || Character.isDigit(ikke)) {

			}
			else {
				ikkeAlfa ++;
			}
		}
		return ikkeAlfa;
	}

	/*public static String tjekStyrke (String s) {
		if (s.length() <= 9 && sm�Bogstav >= 1 && storeBogstav >= 1 && Num >= 1 && ikkeAlfa >= 1) {
			System.out.print("strong");
		} else if (s.length() == 8 && sm�Bogstav >= 1 && storeBogstav >= 1 && Num >= 1 && ikkeAlfa >= 1) {
			System.out.print("acceptable");
		} else if (s.length() == 7 && sm�Bogstav >= 1 && storeBogstav >= 1 && Num >= 1 && ikkeAlfa >= 1) {
			System.out.print("acceptable");
		} else if (s.length() <7) {
			System.out.print("unacceptable");
		}	
		return s;
	} */
}
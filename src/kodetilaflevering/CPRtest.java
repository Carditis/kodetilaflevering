package kodetilaflevering;

import java.util.Scanner;

public class CPRtest {
	public static boolean main (String [] args) {


	}
	public static boolean tjek (String a) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		//CPR-nummer best�r af 10 tal, DDMM��-4tal
		//int mm = n.substring(0,2); 

		String mm = s.substring(0,2);
		System.out.println(mm);
		String dd = s.substring(2,4);
		System.out.println(dd);
		String year = s.substring(4,6);
		System.out.println(year);
		String last = s.substring(6,10);
		System.out.println(last);

		int mmt = Integer.parseInt(mm);
		int ddt = Integer.parseInt(dd);
		int yeart = Integer.parseInt(year);
		int lastt = Integer.parseInt(last);


		if (mmt == 01 & ddt >= 1 & ddt <= 31) {
			System.out.print("Januar");
			return true;
			//M�ned 01 Dato = 1-31) {
		} else if (mmt == 02 & ddt >= 1 & ddt <= 28) {
			System.out.print("Februar");
			return true;
			//M�ned 02 Dato = 1-28 {
		} else if (mmt == 03 & ddt >= 1 & ddt <= 31) {
			System.out.print("Marts");
			return true;
			//M�ned 03 Dato = 1-31) {
		} else if (mmt == 04 & ddt >= 1 & ddt <= 30) {
			System.out.print("April");
			return true;
			//M�ned 04 Dato = 1-30) {
		} else if (mmt == 05 & ddt >= 1 & ddt <= 31) {
			System.out.print("Maj");
			return true;
			//M�ned 05 Dato = 1-31)) {
		} else if (mmt == 06 & ddt >= 1 & ddt <= 30) {
			System.out.print("Juni");
			return true;
			//M�ned 06 Dato = 1-30)) {
		} else if (mmt == 07 & ddt >= 1 & ddt <= 31) {
			System.out.print("Juli");
			return true;
			//M�ned 7 Dato = 1-31)) {
		} else if (mmt == 08 & ddt >= 1 & ddt <= 31) {
			System.out.print("August");
			return true;
			//M�ned 8 Dato = 1-31)) {
		} else if (mmt == 09 & ddt >= 1 & ddt <= 30) {
			System.out.print("September");
			return true;
			//M�ned 9 Dato = 1-30)) {
		} else if (mmt == 10 & ddt >= 1 & ddt <= 31) {
			System.out.print("Oktober");
			return true;
			//M�ned 10 Dato = 1-31)) {
		} else if (mmt == 11 & ddt >= 1 & ddt <= 30) {
			System.out.print("November");
			return true;
			//M�ned 11 Dato = 1-30)) {
		} else if (mmt == 12 & ddt >= 1 & ddt <= 31) {
			System.out.print("December");
			return true;
			//M�ned 12 Dato = 1-31)){
		} else {
			System.out.print("ikke et cprnummer");
		}

		String lige = s.substring(10);
		int liget = Integer.parseInt(lige);
		int ulige = liget % 2;
		if (ulige == 0) {
			System.out.print("lige");
		} else {
			System.out.print("ulige");
		}
	}
}
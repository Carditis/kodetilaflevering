package kodetilaflevering;

import java.util.Scanner;

public class cprNummer {
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		//CPR-nummer best�r af 10 tal, DDMM��-4tal
		//int mm = n.substring(0,2); 


		String cprString = Integer.toString(n);
		System.out.println(cprString);

		String mms = cprString.substring(0,2);
		System.out.println(mms);
		String dds = cprString.substring(2,4);
		System.out.println(dds);
		int mmt = Integer.parseInt(mms);
		System.out.println(mmt);
		int ddt = Integer.parseInt(dds);
		System.out.println(ddt);
		//int firstIndex = s.indexOf();
	}
}


		//if (4tal < 1900 || 4tal >= 2020 ) {
		/*
		if () {
		} else {
			if (mmt == 01 & ddt >= 1 & ddt <= 31)
				//M�ned 01 Dato = 1-31) {
		} else {
			if (mmt == 02 & ddt >= 1 & ddt <= 28)
				//M�ned 02 Dato = 1-28 {
		} else {
			if (mmt == 03 & ddt >= 1 & ddt <= 31)
				//M�ned 03 Dato = 1-31) {
		} else {
			if (mmt == 04 & ddt >= 1 & ddt <= 30)
				//M�ned 04 Dato = 1-30) {
		} else {
			if (mmt == 05 & ddt >= 1 & ddt <= 31)
				//M�ned 05 Dato = 1-31)) {
		} else {
			if (mmt == 06 & ddt >= 1 & ddt <= 30)
				//M�ned 06 Dato = 1-30)) {
		} else {
			if (mmt == 07 & ddt >= 1 & ddt <= 31)
				//M�ned 7 Dato = 1-31)) {
		} else {
			if (mmt == 08 & ddt >= 1 & ddt <= 31)
				//M�ned 8 Dato = 1-31)) {
		} else {
			if (mmt == 09 & ddt >= 1 & ddt <= 30)
				//M�ned 9 Dato = 1-30)) {
		} else {
			if (mmt == 10 & ddt >= 1 & ddt <= 31)
				//M�ned 10 Dato = 1-31)) {
		} else {
			if (mmt == 11 & ddt >= 1 & ddt <= 30)
				//M�ned 11 Dato = 1-30)) {
		} else {
			if (mmt == 12 & ddt >= 1 & ddt <= 31)
				//M�ned 12 Dato = 1-31)){

		}
	}
}
}
}
}
}
}
}
}
}
}
}
		 */
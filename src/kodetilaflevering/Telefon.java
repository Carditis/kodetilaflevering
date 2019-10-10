package kodetilaflevering;
//Vi importerer scanner biblioteket 
import java.util.Scanner;

//lav klassen og main fuktionen
public class Telefon {
	public static void main(String[] args) {
		Scanner consol = new Scanner(System.in);
		String n = consol.nextLine();
		consol.close();
		//kalder funktionen phoneTestet. med en string n.
		System.out.print(phoneTestet(n));
		
	}

	public static String phoneTestet(String n) {
		//vi indfører en variable for længden af n, vi bruger kun den her én gang, så det er lidt overflødigt.
		//Det får det første if-statement til at se lidt pænere ud, men...
		int k = n.length();
		//vi tjekker om længden er mere end eller lig med 8, hvis den er, så fjerner vi alt whitespace, det vil sige mellemrum osv.
		if(k >= 8) {
			n = n.replaceAll("\\s","");
		}else {
			//Hvis den er mindre end 8, kan vi allerede konkludere nu, at det ikke er et dansk-telefonnummer
			return "fejl";
		}
		//vi kigger om stringen nu starter med +45, og så fjerner vi det
		//Her får vi det problem, at hvis 
		if(n.startsWith("+45") ) {
			n = n.replaceAll("\\+45", "");
		}
		//Vi kigger på om det starter med 0
		if(n.startsWith("0")) {
			return "fejl";
		}
		//vi undersøger om stringen indeholder andet end tal nu
		if(n.matches("[0-9]+")) {
		}else {
			return "fejl";
		}
		//nu burde længden kun være 8, så det tjekker vi lige
		if(n.length() == 8) {
		}else {
			return "fejl";
		}
		//Funktionen ville stoppe, så snart den kommer til et "return", så hvis den ikke er stoppet...
		//...ved vi at det må være et dansk telefonnummer. Vi kan nu retunerer det ønskede resultat.

		return "+45 "+n;
	}
}
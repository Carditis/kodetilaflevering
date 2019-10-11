package kodetilaflevering;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NextSquare {
	public static void main(String[] args) {
		//vi laver et input, og tjekker om der er nogle problemer med det input. Det vil sige, om det indeholder andet end heltal
		try {
			System.out.println("Indtast et tal, og se det dobbelte produkt af det næste hele tal:");
			Scanner console = new Scanner(System.in);
			int n = console.nextInt();
			console.close();
			System.out.print(nextSquare(n));
		}
		catch (InputMismatchException exception)
		{
			System.out.println("Dette er ikke et heltal");
		}
	}

	public static int nextSquare(int n) {
		//hvis det er et negativt tal, skal vi bare retunere 0
		if (n < 0) {
			return 0;
		}else {
			//Her laver vi en casting. Det er gjort fordi kvadrartrodden normalt retunere en double
			int h = (int)Math.sqrt(n);
			//læg 1 til, så det bliver den kvadradtrod skarpt højere end
			int g = h+1;
			return g*g;
		}
	}
}

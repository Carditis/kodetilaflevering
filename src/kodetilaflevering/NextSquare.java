package kodetilaflevering;

<<<<<<< HEAD
import java.util.Scanner;

public class NextSquare {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
        System.out.print(nextSquare(n));
    }
    
    public static int nextSquare(int n) {
    	if (n < 0) {
    		int h = (int)Math.sqrt(n*-1);
    		int g = h+1;
    		return(g*g);
    	}
        //Her laver vi en casting. Det er gjort fordi kvadrartrodden normalt retunere en double
        int h = (int)Math.sqrt(n);
        int g = h+1;
        return(g*g);

        
    }
=======
import java.util.InputMismatchException;
import java.util.Scanner;

public class NextSquare {
	public static void main(String[] args) {
		try {
			System.out.println("Indtast et tal, og se det dobbelte produkt af det n�ste hele tal:");
			Scanner console = new Scanner(System.in);
			int n = console.nextInt();
			System.out.print(nextSquare(n));
		}
		catch (InputMismatchException exception)
		{
			System.out.println("Dette er ikke et heltal");
		}
	}

	public static int nextSquare(int n) {
		if (n < 0) {
			int h = (int)Math.sqrt(n*-1);
			int g = h+1;
			return(g*g);
		}
		//Her laver vi en casting. Det er gjort fordi kvadrartrodden normalt retunere en double
		int h = (int)Math.sqrt(n);
		int g = h+1;
		return(g*g);
		//hej

	}




>>>>>>> 9dc323b72cd11b60526f0958fee8bb5154a72024
}

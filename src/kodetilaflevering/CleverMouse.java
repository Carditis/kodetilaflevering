package kodetilaflevering;


public class CleverMouse {
	public static void main(String[] args) {
		//mange af kommentarende vil gå igen, for de tre filer som har med katten og musen at gøre
		//(engelsk fordi initiate lyder dumt på dansk, og fordi det er bedre til kodekommentare) 
		//We create and initiate the variabels that decide the movement, gridsize, and amount of turns
		int n = 1;
		int t = 30;

		//kalder den primære funktion med n, og t.
		runStrategicSimulation(n, t);
	}

	public static void runStrategicSimulation(int n, int t) {
		//Den her forklarer sig selv.
		System.out.println("n=" + n + " t="
				+ t);
		//initiate variables for cat and mouse. They are arrays of length = 2. That corresponds to x and y position.
		int kat[] = new int[2];
		int mus[] = new int[2];
		//mouse starts in the middle
		int p = n / 2;


		kat[0] = 0;
		kat[1] = 0;

		mus[0] = p;
		mus[1] = p;

		//Start med at kigge efter om parametrene passer. Bevægelses programmet skal ikek køre, hvis de ikke passer.
		if (tjekParametre(n, t) == true) {
			//We call the main move function. This uses the arrays and the other variables to move the cat and mouse
			move(n, t, mus, kat);
		} else {
			System.out.print("Illegal Parameters!");
		}
	}

	public static boolean tjekParametre(int n, int t) {
		//test om parametrene er valide i forhold til kravene
		if (n > 0 && t >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void move(int n, int t, int[] m, int[] k) {
		//start med at tjekke det sertilfælde hvor n = 1.
		if (n == 1) {
			System.out.println("[" + m[0] + ";" + m[1] + "] " + "[" + k[0] + ";" + k[1] + "] ");
			System.out.println("Catch!");
		} else {		
			//Den må kun bevæge sig 1 her, så vi sætter dens s til det, så vi kan genbruge så meget af den gamle kode som muligt
			int s = 1;
			int p = n/2;
			//programmet skal køre et antal ture (t)
			for (int i = 0; i <= t; i++) {

				if(m[0] == k[0] && m[0] <= p) {
					m[0] += s;
				}else if(m[0] == k[0] && m[0] > p) {
					m[0] -= s;				
				}else if(m[1] == k[1] && m[1] <= p) {
					m[1] += s;				
				}else if(m[1] == k[1] && m[1] > p) {
					m[1] -= s;				
				}
				// her begynder vi at bevæge katten
				// Vi har tidligere gået efter at katten bevæger sig "tilfældigt", hvor den dog
				// stadig prøver at nå hen til katten.
				// Nu vil nu få den til at bevæge sig så meget den kan i x, og så bevæge sig i
				// y.
				// Det vil sige at den stadig er klog, men ikke så "tilfældig".
				int aKatMusX = Math.abs(m[0] - k[0]);
				int aKatMusY = Math.abs(m[1] - k[1]);
				// vi laver igen nogle overflow variabler, som den bruger til at finde ud af
				// hvor lant den skal bevæge sig
				// i y-retningen, efter at den har bevæget sig i x-retningen.

				int overKatX = 0;

				if (k[0] == m[0]) {
					if (m[1] < k[1]) {
						if (aKatMusY <= s) {
							k[1] = k[1] - aKatMusY;
						} else {
							k[1] = k[1] - s;
						}
					} else if (m[1] > k[1]) {
						if (aKatMusY <= s) {
							k[1] = k[1] + aKatMusY;
						} else {
							k[1] = k[1] + s;
						}
					}
				} else if (k[0] < m[0]) {
					if (aKatMusX < s) {
						k[0] = k[0] + aKatMusX;
						overKatX = s - aKatMusX;
						if (aKatMusY < overKatX) {
							if (k[1] < m[1]) {
								k[1] = k[1] + aKatMusY;
							} else if (k[1] > m[1]) {
								k[1] = k[1] - aKatMusY;
							}
						}
					} else {
						k[0] = k[0] + s;
					}
				} else {
					if (aKatMusX < s) {
						k[0] = k[0] - aKatMusX;
						overKatX = s - aKatMusX;
						if (m[1] < k[1]) {
							if (overKatX < aKatMusY) {
								k[1] = k[1] - overKatX;
							} else {
								k[1] = k[1] - aKatMusY;
							}
						}
					} else {
						k[0] = k[0] - s;
						overKatX = 0;
					}
					//meget af kattens bevægelse sker som i de andre tilfælde.
					//Det er fordi at det virker, også selvom den kun bevæger sig 1 nu
				}
				//For hver tur, printer deres koordinator, og tjekker om musen er blevet fanget.
				System.out.println("[" + m[0] + ";" + m[1] + "] " + "[" + k[0] + ";" + k[1] + "] ");
				if (m[0] == k[0] && m[1] == k[1]) {
					System.out.println("Catch!");
					//Hvis musen bliver fanget, skal løkken stoppe.
					break;
				}
			}
		}
	}
}
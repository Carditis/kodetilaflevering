package kodetilaflevering;

import java.util.Random;

public class CatMouseKitten {
	public static void main(String[] args) {
		//mange af kommentarende vil gå igen, for de tre filer som har med katten og musen at gøre
		//(engelsk fordi initiate lyder dumt på dansk, og fordi det er bedre til kodekommentare) 
		//We create and initiate the variabels that decide the movement, gridsize, and amount of turns
		int n = 30;
		int s = 5;
		int t = 100;

		//kalder den primære funktion med n, s og t.
		runTwoCatsRandom(n, s, t);
	}

	public static void runTwoCatsRandom(int n, int s, int t) {
		//Den her forklarer sig selv.
		System.out.println("n=" + n + " s=" + s + " t=" + t);
		//initiate variables for cat and mouse. They are arrays of length = 2. That corresponds to x and y position.
		int kat[] = new int[2];
		int mus[] = new int[2];
		int kitten[] = new int[2];
		//mouse starts in the middle
		int p = n / 2;
		
		//We describe the position of the animals with arrays. 
		kat[0] = 0;
		kat[1] = 0;
		
		kitten[0] = 0;
		kitten[1]= 0;
		
		mus[0] = p;
		mus[1] = p;
		
		//Start med at kigge efter om parametrene passer. Bevægelses programmet skal ikek køre, hvis de ikke passer.
		if (tjekParametre(n, s, t) == true) {
			//We call the main move function. This uses the arrays and the other variables to move the cat and mouse
			move(n, s, t, mus, kat, kitten);
		} else {
			System.out.print("Illegal Parameters!");
		}
	}

	public static boolean tjekParametre(int n, int s, int t) {
		//test om parametrene er valide i forhold til kravene
		if (n > 0 && 0 <= s && s <= n && t >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void move(int n, int s, int t, int[] m, int[] k, int[] kitten) {
		//programmet skal køre et antal ture (t), eller til katten fanger musen
		for (int i = 0; i != t; i++) {
			Random randMus = new Random();
			int dx = randMus.nextInt(s + 1); // Musen bevæger sig en tilfældig afstand i x.
			int dy = s - dx; // musen bevæger sig altid s, så den afstand som den skal bevæge sig i y, er
			// resten af stykket fra x.
			int OY = 0; // overflow variabel fra y til x.
			int p = n / 2; // vi laver igen en p.

			// vi gør det tilfældigt om musen bevæger sig pos eller neg i y og x
			Random plusMinus = new Random();
			int randMusX = plusMinus.nextInt(4);
			int randMusY = plusMinus.nextInt(4);

			// nu bestemmer vi hvilken retning musen skal bevæge sig, alt efter hvad tilfæddigheden gav
			if (randMusX == 1 || randMusX == 3) {
				if (m[0] <= dx) {
					m[0] = m[0] - m[0];
				} else {
					m[0] = m[0] - dx;
				}
			} else {
				if (m[0] <= n - 1) {
					int e = (n - 1) - m[0];
					if (e < dx) {
						m[0] = m[0] + e;
					} else {
						m[0] = m[0] + dx;
					}
				}
			}
			//musen bevæger sig bare tilfældigt, både i x og y. Den tjekker hver gang inden den bevæger sig, om den har mulighed for det.
			//Det vil sige om den er for tæt på kanten.
			if (randMusY == 1 || randMusY == 3) {
				if (m[1] <= dy) {
					m[1] = m[1] - m[1];
					OY = dy - m[1];
					if (m[0] > p) {
						m[0] = m[0] - OY;
					} else {
						m[0] = m[0] + OY;
					}
				} else {
					m[1] = m[1] - dy;
					OY = 0;
				}
			} else {
				if (m[1] <= n - 1) {
					int w = n - 1 - m[1];
					if (w < dy) {
						m[1] = m[1] + w;
						OY = dy - w;
						if (m[1] > p) {
							m[1] = m[1] - OY;
						} else {
							m[1] = m[1] + OY;
						}
					} else {
						m[1] = m[1] + dy;
						OY = 0;
					}
				}
			}
			// her begynder vi at bevæge katten
			// Vi har tidligere gået efter at katten bevæger sig "tilfældigt", hvor den dog
			// stadig prøver at nå hen til musen.
			// Nu vil nu få den til at bevæge sig så meget den kan i x, og så bevæge sig i y.
			// Det vil sige at den stadig er klog, men ikke så "tilfældig".
			
			//vi finder afstanden mellem dem. Her tager si den numeriskeværdi, da... ja det er jo en afstand.
			//Killingen fungere på helt den samme måde som katten. Den eneste forskel er hvor langt den må bevæge sig.
			//Derfor vil mængden af forklaringer ikke være så hæftige dernede
			int aKatMusX = Math.abs(m[0] - k[0]);
			int aKatMusY = Math.abs(m[1] - k[1]);
			
			int aKittenX = Math.abs(m[0] - kitten[0]);
			int aKittenY = Math.abs(m[1] - kitten[1]);
			
			// vi laver igen overflow variabler, som den bruger til at finde ud af
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
			}
			
			//her starter killingen med at bevæge sig.
			//igen, der sker det sammen som hos katten, vi starter bare med ændre hvor langt den må bevæge sig, og hvad dens variabler hedder.
			int movesKitten = 0;
			if(s % 2 != 0) {
				movesKitten = (s/2) + 1;
			}else {
				movesKitten = s/2;
			}
			//den har også overflow
			int overKittenX = 0;
			
			//samme x, så bevæger den sig kun i y
			//den tjekker hvor langt den må og burde bevæge sig i y, inden den bevæger sig.
			if (kitten[0] == m[0]) {
				if (m[1] < kitten[1]) {
					if (aKittenY <= movesKitten) {
						kitten[1] = kitten[1] - aKittenY;
					} else {
						kitten[1] = kitten[1] - movesKitten;
					}
				} else if (m[1] > kitten[1]) {
					if (aKittenY <= movesKitten) {
						kitten[1] = kitten[1] + aKittenY;
					} else {
						kitten[1] = kitten[1] + movesKitten;
					}
				}
			} else if (kitten[0] < m[0]) {
				if (aKittenX < movesKitten) {
					kitten[0] = kitten[0] + aKittenX;
					overKittenX = movesKitten - aKittenX;
					if (aKittenY < overKittenX) {
						if (kitten[1] < m[1]) {
							kitten[1] = kitten[1] + aKittenY;
						} else if (kitten[1] > m[1]) {
							kitten[1] = kitten[1] - aKittenY;
						}
					}
				} else {
					kitten[0] = kitten[0] + movesKitten;
				}
			} else {
				if (aKittenX < movesKitten) {
					kitten[0] = kitten[0] - aKittenX;
					overKittenX = movesKitten - aKittenX;
					if (m[1] < kitten[1]) {
						if (overKittenX < aKittenY) {
							kitten[1] = kitten[1] - overKittenX;
						} else {
							kitten[1] = kitten[1] - aKittenY;
						}
					}
				} else {
					kitten[0] = kitten[0] - movesKitten;
					overKittenX = 0;
				}
				
			}
			//Vi printer alle dyrenes koordinator, og tjekker om musen er blevet fanget. Hvis det er sket, så printes catch
			System.out.println("[" + m[0] + ";" + m[1] + "] " +"[" + kitten[0] + ";" + kitten[1] + "] " + "[" + k[0] + ";" + k[1] + "] ");
			if (m[0] == k[0] && m[1] == k[1]) {
				System.out.println("Catch!");
				break;
			}else if(m[0] == kitten[0] && m[1] == kitten[1]) {
				System.out.println("Catch!");
			}
		}
	}
}

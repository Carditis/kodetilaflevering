package kodetilaflevering;

import java.util.Random;

public class CatMouse {
	public static void main(String[] args) {
		//(engelsk fordi initiate lyder dumt på dansk, og fordi det er bedre til kodekommentare) 
		//We create and initiate the variabels that decide the movement, gridsize, and amount of turns
		int n = 30;
		int s = 1;
		int t = 100;

		//kalder den primære funktion med n, s og t.
		runRandomSimulation(n, s, t);
	}

	public static void runRandomSimulation(int n, int s, int t) {
		//Den her forklarer sig selv.
		System.out.println("n=" + n + " s=" + s + " t=" + t);
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
		if (tjekParametre(n, s, t) == true) {
			//We call the main move function. This uses the arrays and the other variables to move the cat and mouse
			move(n, s, t, mus, kat);
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

	public static void move(int n, int s, int t, int[] m, int[] k) {
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
			}
			System.out.println("[" + m[0] + ";" + m[1] + "] " + "[" + k[0] + ";" + k[1] + "] ");
			if (m[0] == k[0] && m[1] == k[1]) {
				System.out.println("Catch!");
				break;
			}
		}
	}
}

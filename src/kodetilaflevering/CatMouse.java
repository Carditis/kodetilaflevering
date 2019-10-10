package kodetilaflevering;

import java.util.Random;

public class CatMouse {
	public static void main(String[] args) {
		int n = 30;
		int s = 5;
		int t = 100;

		runRandomSimulation(n, s, t);
	}

	public static void runRandomSimulation(int n, int s, int t) {
		System.out.println("n=" + n + " s=" + s + " t=" + t);

		int kat[] = new int[2];
		int mus[] = new int[2];
		int p = n / 2;

		kat[0] = 0;
		kat[1] = 0;

		mus[0] = p;
		mus[1] = p;

		if (tjekParametre(n, s, t) == true) {
			move(n, s, t, mus, kat);
		} else {
			System.out.print("Illegal Parameters!");
		}
	}

	public static boolean tjekParametre(int n, int s, int t) {
		if (n > 0 && 0 <= s && s <= n && t >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void move(int n, int s, int t, int[] m, int[] k) {
		for (int i = 0; i != 100; i++) {
			// System.out.println("[" + m[0] + ";" + m[1] + "] " + "[" + k[0] + ";" + k[1] +
			// "] ");
			Random randMus = new Random();
			int dx = randMus.nextInt(s + 1); // Musen bev�ger sig en tilf�ldig afstand i x.
			int dy = s - dx; // musen bev�ger sig altid s, s� den afstand som den skal bev�ge sig i y, er
			// resten af stykket fra x.
			int o = 0; // overflow variabel for x til y.
			int OY = 0; // overflow variabel fra y til x.
			int p = n / 2; // vi laver igen en p.

			// vi g�r det tilf�ldigt om musen bev�ger sig pos eller neg i y og x
			Random plusMinus = new Random();
			int randMusX = plusMinus.nextInt(4);
			int randMusY = plusMinus.nextInt(4);

			// nu bestemmer vi hvilken retning musen skal bev�ge sig, alt efeter hvad
			// tilf�digheden gav
			if (randMusX == 1 || randMusX == 3) {
				// vi kan f� tallene 0 og 1, s� hvis den er nul, bev�ger musen sig neg x, vi
				// tjekker f�rst,
				// om den afstand som musen VIL bev�ge sig i x, er st�rre end den afstan som den
				// har hen til
				// kanten, den vil sige dens x-koordinat
				if (m[0] <= dx) {
					// den kan s� kun bev�ge sig sin egen afstand
					m[0] = m[0] - m[0];
					// vi har s� en rest, som er den afstand den nu SKAL bev�ge sig ekstra i y
					// o = dx - m[0];
				} else {
					m[0] = m[0] - dx;
					o = 0;
				}
			} else {
				if (m[0] <= n - 1) {
					int e = (n - 1) - m[0];
					if (e < dx) {
						m[0] = m[0] + e;
						// o = dx - e;
					} else {
						m[0] = m[0] + dx;
						o = 0;
					}
				}
			}
			// vi siger nu at den afstand som musen kan bev�ge sig, m� v�re dy + o
			dy = dy + o;
			// int d = dy + dx;
			// System.out.print();

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
			/*
			 * for (int x : m) { System.out.print(x + " "); }
			 */
			// System.out.println("");
		}

		/*
		 * Random randKat = new Random(); int katDx = randKat.nextInt(s); int katDy = s
		 * - katDx;
		 * 
		 * int xAfstand = m[0] - k[0]; int yAfstand = m[1] - k[1];
		 * 
		 * if(xAfstand == 0) { k[0] = k[0]; if(yAfstand == 0) { break; }else if(yAfstand
		 * < 0 && yAfstand <= s){ k[1] = k[1] - ((-1) * yAfstand); }else if(yAfstand < 0
		 * && yAfstand * (-1) >= s){ k[1] = k[1] - s; }else if(yAfstand > 0 && yAfstand
		 * ) {
		 * 
		 * }
		 * 
		 * }
		 */

	}
}

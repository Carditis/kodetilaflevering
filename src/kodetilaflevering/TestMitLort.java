package kodetilaflevering;

import java.util.Random;


public class TestMitLort {
 public static void main(String[] args) {
	  int n = 30;
	  int s = 5;
	  int t = 100;
	  
	  runSimulation(n, s, t);
 }
 
 
 public static void runSimulation(int n, int s, int t) {
	 tjekParametre(n, s, t);
	 
	 int kat[] = new int[2];
	 int mus[] = new int[2];
	 
	 int p = n/2;
	 
		kat[0]=0;
		kat[1]=0;
		
		mus[0]=p;
		mus[1]=p;
	 
	 moveMus(n, s, t, mus);
	 
	 moveKat();
	 
 }
  
 public static boolean tjekParametre(int n, int s, int t) {
	 if(n > 0 || 0 <= s || s <= n || t>=0) {
		 return true;		 
	 }else {
		 return false;
	 }
 }
 
 public static void moveMus(int n, int s, int t, int[] m) {
	 Random randMus = new Random();
	 int dx = randMus.nextInt(s); //Musen bev�ger sig en tilf�ldig afstand i x.
	 int dy = s-dx; //musen bev�ger sig altid s, s� den afstand som den skal bev�ge sig i y, er resten af stykket fra x
	 int o = 0; //overflow variabel
	 
	 //vi g�r det tilf�ldigt om musen bev�ger sig pos eller neg i y og x
	 Random plusMinus = new Random();
		int randMusX = plusMinus.nextInt(1);
		int randMusY = plusMinus.nextInt(1);
		
		//nu bestemmer vi hvilken retning musen skal bev�ge sig, alt efeter hvad tilf�digheden gav
		if(randMusX == 0) {
			//vi kan f� tallene 0 og 1, s� hvis den er nul, bev�ger musen sig neg x, vi tjekker f�rst,
			//om den afstand som musen VIL bev�ge sig i x, er st�rre end den afstan som den har hen til
			//kanten, den vil sige dens x-koordinat
			if(m[0] < dx) {
				//den kan s� kun bev�ge sig sin ejen afstand
				m[0] = m[0] - m[0];
				//vi har s� en rest, som er den afstand den nu 	SKAL bev�ge sig i y
				o = dx - m[0];
			}else {
				m[0] = m[0] - dx;
			}
		}else {
			if(m[0] < n) {
				int e = n - m[0];
				if(e < dx) {
					m[0] = m[0] + e;
					o = dx - e;
				}else {
					m[0] = m[0] + dx;
				}
			}
		}
		//vi siger nu at den afstand som musen kan bev�ge sig, m� v�re dy + o
		dy = dy + o;
		
		if(randMusY == 0) {
			if(m[1] < dy) {
				m[1] = m[1] - m[1];
			}
		}
	 
	 
	 }
}
 


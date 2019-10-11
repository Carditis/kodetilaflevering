package kodetilaflevering;


public class NextPrime {

	public static void main (String [] args) {
		//Tallet som skal tjekkes om hvorvidt det er et primtal eller ej indtatstes: 
		System.out.println(isPrime(0));
		//Tallet, hvor der skal s�ges for n�ste primtal efter indtastes:
		System.out.println(nextPrime(125676545));
	}
	
	
	//Metoden for at teste om et tal er et primtal
	public static boolean isPrime (int n) {	
		boolean a = false;
		int count = 0;
		//Her bruges der at hvis et tal kan divideres med pr�cis 2 tal,
		//alts� tallet 1 og tallet selv, er dette et primtal
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
			//Hvis tallet kun kan divideres uden rest med 2 tal, 
			if (count == 2) {
				a =  true;
			}
			else {
				a = false;
			}
		}
		return a;
	}
	
	//Metode for at finde det n�ste primtal efter det valgte tal
	public static int nextPrime (int n) {
		int prime = 0;
		//Her bruges der .MAX_VALUE, da det er den h�jeste v�rdi for en Integer
		//og der kan derfor ikke s�ges efter en v�rdi over denne
		int q =Integer.MAX_VALUE;
		//Da det n�ste primtal efter 0 eller et negativt tal, altid vil v�re 2,
		//s�ges der efter dette til at starte med
		if (n == 0 || n < 0) {
			return 2;
		} else {
			for (int j = n+1; j < q; j++) {
				int count = 0;
				for (int i=2; i <= j/2; i++) {
					if (j%i==0 ) {
						count++;
					}
				}	
				if (count == 0) {
					prime = j;
					break;
				}
			}
			return prime;
		}
	}
}
package kodetilaflevering;


public class NextPrime {

	public static void main (String [] args) {
		//Tallet som skal tjekkes om hvorvidt det er et primtal eller ej indtatstes: 
		System.out.println(isPrime(0));
		//Tallet, hvor der skal søges for næste primtal efter indtastes:
		System.out.println(nextPrime(125676545));
	}
	
	
	//Metoden for at teste om et tal er et primtal
	public static boolean isPrime (int n) {	
		boolean a = false;
		int count = 0;
		//Her bruges der at hvis et tal kan divideres med præcis 2 tal,
		//altså tallet 1 og tallet selv, er dette et primtal
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
	
	//Metode for at finde det næste primtal efter det valgte tal
	public static int nextPrime (int n) {
		int prime = 0;
		//Her bruges der .MAX_VALUE, da det er den højeste værdi for en Integer
		//og der kan derfor ikke søges efter en værdi over denne
		int q =Integer.MAX_VALUE;
		//Da det næste primtal efter 0 eller et negativt tal, altid vil være 2,
		//søges der efter dette til at starte med
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
package opgave2;

public class Broek {

	
	private int t;
	private int n;

	public Broek(int t, int n) {
		this.t = t;
		this.n = n;
		plus(Broek.t, Broek.n);
//		minus();
//		gange();
//		divider();
//		reciprok();
	}

	private void reciprok(Broek f) {
		
		
	}

	private void divider(Broek f) {
		// TODO Auto-generated method stub
		
	}

	private void gange(Broek f) {
		// TODO Auto-generated method stub
		
	}

	private void minus(Broek f) {
		// TODO Auto-generated method stub
		
	}

	private void plus(Broek f) {
		int numerator = t;
		int denominator = n;
		
		this.t = t * f.n;
		this.n = n * f.n;
		f.t = f.t * n;
		//f.n = f.n * n;

		numerator = this.t + f.t;
		denominator = this.n;
		
	}
}

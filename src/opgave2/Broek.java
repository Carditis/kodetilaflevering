package opgave2;

public class Broek {

	int numerator;
	int denominator;

	public Broek(int t, int n) {
		this.numerator = t;
		this.denominator = n;

	}	
	//	Gettting Numerator
	public int getNumerator() {
		return numerator;
	}

	//	Getting denominator
	public int getDenominator() {
		return denominator;
	}

	//	Adding two fractions
	public void plus (Broek f) {

		//		Calculating Numerator and finding common denominator
		this.numerator = this.numerator * f.denominator + f.numerator * this.denominator;
		this.denominator = this.denominator * f.denominator;

		reduceFraction();
	}

//		Subtracting two fractions
	public void minus (Broek f) {
		//		Calculating Numerator and finding common denominator
		this.numerator = this.numerator * f.denominator - f.numerator * this.denominator;
		this.denominator = this.denominator * f.denominator;

		reduceFraction();

	}

//		Multiplying two fractions
	public void gange (Broek f) {
//				Calculating Numerator and finding common denominator
		this.numerator = this.numerator * f.denominator * f.numerator * this.denominator;
		this.denominator = this.denominator * f.denominator;

		reduceFraction();

	}

	public void dvision (Broek f) {
//				Calculating Numerator and finding common denominator
		this.numerator = this.numerator * f.denominator;
		this.denominator = f.numerator * this.denominator;

		reduceFraction();
	}

	public void reciprok () {
//			Creating a remporary variable
		int temporary;

//				Switching places
		temporary = this.denominator;
		this.denominator = this.numerator;
		this.numerator = temporary;

	}


	public void reduceFraction () {
//		Reducing fration to lowest denominator
		for (int i = 1; i < this.denominator; i++) {
			if(this.numerator % 2 == 0 && this.denominator % 2 == 0) {
				this.numerator = this.numerator / 2;
				this.denominator = this.denominator / 2;
			} else {
				break;
			}
		}
	}

	public String toString() {
		if (this.numerator < 0 && this.denominator < 0 || this.denominator == 0) {
			throw new IllegalArgumentException("Either negative number, or denominator = 0");
		} else if (this.numerator >= 0 && this.denominator > 0) {
			return this.numerator + "/" + this.denominator;
		} else {
			throw new IllegalArgumentException("");
		}
	}
}

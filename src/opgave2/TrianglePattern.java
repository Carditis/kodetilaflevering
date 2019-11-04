package opgave2;

public class TrianglePattern {
	
	//we decided to use a boolean array, as it makes some of the logic easier
	boolean[][] array;
	
	TrianglePattern(int n, int h, int[] initial) {
		//we teat the gridsize
		if (testGridSize(n, h)) {
			//making the 2 dimentional array
			array = new boolean[h][n];
			
			//we place all the "seeds", with a simpel for loop
			for (int i = 0; i < initial.length; i++) {
				array[0][initial[i]] = true;
			}
			
			for (int r = 1; r < array.length; r++) {
				//we make an above array, that looks at how many trues that are above, and where the are placed
				boolean[] above = array[r - 1];
				for (int j = 1; j < above.length - 1; j++) {
					boolean a = above[j - 1	];
					boolean b = above[j];
					boolean c = above[j + 1];
					int x = 0;
					int y = 0;
					int z = 0;
					if (a) {
						x = 1;
					}
					if (b) {
						y = 1;
					}
					if (c) {
						z = 1;
					}
					
					//if there only is one above, or if a is false and b and c is true, then we set it to true
					boolean one = x + y + z == 1;
					array[r][j] = one || (!a && b && c);
				}
			}
		}
	}

	public boolean testGridSize(int n, int h) {
		//we test the grid size
		if (n >= 5) {
			return true;
		}
		return false;
	}
	
	public int getValueAt(int r, int c) {
		//here we see how cool boolean arrays are. Yes this could be done with other arrays, but this is cool
		//some would ague that this is cool because booleans don't use as much memory, but we haven't learnt that yet
		if(array[r][c]) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int getN() {
		//we can get the lenght of the second dimension, by taking the length of the first row
		return array[0].length;
	}
	
	public int getH() {
		//this is the length of the column
		return array.length;
	}
	
	public int[] getInitial() {
		int q = 0;
		//we again need the lenght for the new array we are making
		for(int i = 0; i < array[0].length; i++) {
			if(array[0][i]) {
				q++;
			}
		}
		//we make an array, and go through the first row, to see if it is true, we then at it to the new array
		int[] initial = new int[q];
		int s = 0;
		for(int i = 0; i < array[0].length; i++) {
			if(array[0][i]) {
				initial[s] = i;
				s+=1;
			}
		}
		return initial;
	}
}

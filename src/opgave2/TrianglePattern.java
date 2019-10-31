package opgave2;

public class TrianglePattern {
	

	boolean[][] array;
	
	TrianglePattern(int n, int h, int[] initial) {
		if (testGridSize(n, h)) {
			array = new boolean[h][n];

			for (int i = 0; i < initial.length; i++) {
				array[0][initial[i]] = true;
			}

			for (int r = 1; r < array.length; r++) {
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

					boolean one = x + y + z == 1;
					array[r][j] = one || (!a && b && c);
				}
			}
		}
	}

	public boolean testGridSize(int n, int h) {
		if (n >= 5) {
			return true;
		}
		return false;
	}
	public int getValueAt(int r, int c) {
		if(array[r][c]) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int getN() {
		return array[0].length;
	}
	
	public int getH() {
		return array.length;
	}
	
	public int[] getInitial() {
		int q = 0;
		for(int i = 0; i < array[0].length; i++) {
			if(array[0][i]) {
				q++;
			}
		}
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

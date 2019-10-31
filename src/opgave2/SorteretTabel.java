package opgave2;

import java.util.Arrays;

public class SorteretTabel {

	int[] array;
	int a;

	public SorteretTabel(SorteretTabel a, SorteretTabel b) {
		int g = a.array.length + b.array.length;
		array = new int[g];
		int ia = 0;
		int ib = 0;

		for (int i = 0; i < g; i++) {
			if (ia == a.array.length || !(ib == b.array.length || a.array[ia] <= b.array[ib])) {
				array[i] = b.array[ib++];
			} else {
				array[i] = a.array[ia++];
			}
		}
	}

	public boolean exists(int holger) {
		int f = array.length;
		for (int i = 0; i <= f-1; i++) {
			if (array[i] == holger) {
				return true;
			} else if (array[i] > holger) {
				return false;
			}
		}
		return false;
	}

	public int find(int holger) {
		if(exists(holger)) {
			return helpFinder(holger, 0, array.length);
		}else {
			return -1;
		}

	}

	private int helpFinder(int holger, int start, int end) {
		while (start < end) {
			int i = (start + end - 1) / 2;
			int elem = array[i];
			if (elem == holger) {
				return i;
			} else if (elem < holger) {
				start = i;
			} else {
				end = i;
			}
			if (end - start == 1) {
				return -1;
			}
		}
		return -1;
	}

	public SorteretTabel(int[] a) {
		array = a;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				System.out.println("Fejl");
				return;
			} else {
			}
		}
	}

	public SorteretTabel(int a) {
		int[] single = { a };
		this.array = single;
	}

	public SorteretTabel() {
		int[] empty = {};
		this.array = empty;
	}

	public String toString() {
		String s = Arrays.toString(array);
		return s;
	}
}
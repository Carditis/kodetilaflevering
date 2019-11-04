package opgave2;

import java.util.Arrays;

public class SorteretTabel {
	
	//vi starter med at lave nogle variabler
	int[] array;
	int a;
	
	//We make differnet constructors debending on what we want to do with the input. Java knows what constructor to use
	//for certain input types
	public SorteretTabel(SorteretTabel a, SorteretTabel b) {
		//arrays in java have a specifik lenght, so we need to make sure that we create the new array in the right way.
		//we have used arraylist in python. Arraylist could also be used here, nut decided not to, as we have never used them in java before
		//We want to add all the numbers from the to difrent tabels, even if they are the same, so we now know the length of the array
		int g = a.array.length + b.array.length;
		array = new int[g];
		int ia = 0;
		int ib = 0;
		
		//we run the size of the new array, and use some logic to determine the what number is the biggest.
		for (int i = 0; i < g; i++) {
			if (ia == a.array.length || !(ib == b.array.length || a.array[ia] <= b.array[ib])) {
				array[i] = b.array[ib++];
			} else {
				array[i] = a.array[ia++];
			}
		}
	}

	public boolean exists(int holger) {
		//hehe, we thought we would use the length a bit more, so it is a variable now
		//We could change it...
		int f = array.length;
		//we check every element of the array, and look for Holger
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
		//we first determine if holger even exist
		if(exists(holger)) {
			//we call the helping function, with a starting and a end determitor
			return helpFinder(holger, 0, array.length);
		}else {
			return -1;
		}

	}

	private int helpFinder(int holger, int start, int end) {
		//we use a while loop, to check if we have reached the end of the array
		while (start < end) {
			//we look at the middle of start and end
			int i = (start + end - 1) / 2;
			int elem = array[i];
			if (elem == holger) {
				return i;
			} else if (elem < holger) {
				//thay are sortet, so if holger is bigger then we have a new start location, if less the na new end location
				start = i;
			} else {
				end = i;
			}
			if (end - start == 1) {
				return -1;
			}
		}
		return -1;
		//we keep doing so, until we find Holger. of till the start is bigger than the end
	}

	public SorteretTabel(int[] a) {
		array = a;
		//we just make sure that what we have, is a sortet tabel
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				System.out.println("Fejl");
				return;
			}
		}
	}

	public SorteretTabel(int a) {
		//making an array with one element
		int[] single = { a };
		this.array = single;
	}

	public SorteretTabel() {
		//empty array
		int[] empty = {};
		this.array = empty;
	}

	public String toString() {
		//this function overrides the normal toString in Java, and lets us print the arrays
		String s = Arrays.toString(array);
		return s;
	}
}
package opg3;


public class FindTenthSmallest {
	long[] array;
 
	public static long findTenthSmallest(long[] ts) {
        int n = 10;
        long[] array = new long[n];

        //We throw a exception, that stops the program. We do not output a element, if the array is too short.
        if (ts.length < 10) {
            throw new RuntimeException("Der er ikke mere end ti elementer, så... du må selv finde det rigtige");
        }
        
        //We start by initialising an array, with the elements in order
        for (int i = 0; i < n; i++) {
            array[i] = ts[i];

            for (int j = i; j > 0; --j) {
                if (array[j] > array[j-1]) {
                    break;
                }
                long temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
            }
        }

        //for every element in the original array, we look to see where it would belong in the new sorted array
        for (int i = 10; i < ts.length; i++) {
            for (int j = 10; j > 0; --j) {
                if (array[j-1] >= ts[i]) {
                    if (j == 10) {
                        array[j-1] = ts[i];
                    } else {
                        long temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;
                    }
                } else {
                    break;
                }
            }
        }
        //now we can return tenth element, as it is the tenth smallest.
        return array[9];
    }
}

//new plan, find den som der har 9 der er mindre end.
 //Det her nede virkede ikke helt, hvilket vi skriver lidt mere om i rapporten
 /*
public class FindTenthSmallest {
	long[] array;
	
	public static long findTenthSmallest(long[] ts) {
		int n = 10;
		if (ts.length < n) {
			throw new RuntimeException("Uha, den var ikke helt god");
		}
		for (int i = 0; i < ts.length; i++) {
			int smaller = 0;
			for (int j = 0; j < ts.length; j++) {
				if (ts[j] < ts[i]) {
					smaller++;
				}
			}
			if (smaller == n - 1) {
				return ts[i];
			}
		}
		return 11111;
	}
}
  */
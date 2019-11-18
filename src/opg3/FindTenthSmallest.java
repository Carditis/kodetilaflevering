package opg3;


public class FindTenthSmallest {
	long[] array;

	public static void main(String[] args) {

	}

	public static long findTenthSmallest(long[] ts) {
        int n = 10;
        long[] array = new long[n];

        if (ts.length < 10) {
            throw new RuntimeException("Nej tak");
        }
        
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

        return array[9];
    }
}

//new plan, find den som der har 9 der er mindre end.
public class SelectionSort {
    public static void selectionSort(int[] intArray){
        int currentValue;
        int minimum;
        for ( currentValue = 0; currentValue < intArray.length; currentValue++) {
            minimum = currentValue;
            for (int i = currentValue+1; i < intArray.length; i++)
            {
                if (intArray[i] < intArray[minimum]) {
                    minimum = i;
                }
            }
            if(minimum != currentValue) {
                swapVar(intArray, minimum, currentValue);
            }
        }
    }


    private static void swapVar(int[] a, int indexOne, int indexTwo) {
        //temp holds value in target index
        int temp;
        temp = a[indexOne];

        //assign targetPosition
        a[indexOne] = a[indexTwo];
        a[indexTwo] = temp;
    } // end swapVar()
}

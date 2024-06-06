public class QuickSort {
    public static void quickSort(int[] intArray, int startPosition, int endPosition) {
        int pivotPosition;

        //base Condition
        if (startPosition < endPosition) {
            //set new pivot Position
            pivotPosition = partition(intArray, startPosition, endPosition);
            //recursive call to the two new partitions
            quickSort(intArray, startPosition, pivotPosition - 1);
            quickSort(intArray, pivotPosition + 1, endPosition);
        }

    }//end quickSort()

    //----------------------------------------------------------------------------------------------------
    private static int partition(int[] intArray, int startPosition, int endPosition) {
        int pivotPosition; //position of pivot
        int pivotValue; //pivot value
        int midPosition = startPosition ; //keeps track of where the correct position of pivot should be

        pivotPosition = (startPosition + endPosition)/2;  //get position of the center of array

        pivotValue = intArray[pivotPosition];

        //move pivot to end
        swapVar(intArray, pivotPosition, endPosition);

        //compare values; when value is smaller than pivot swap values and increment midPosition
        for (int i = startPosition; i < endPosition; i++){
            if (intArray[i] < pivotValue){
                swapVar(intArray, i, midPosition);
                midPosition = midPosition + 1;
            }
        }//end for loop

        //place pivot in correct Place
        swapVar(intArray, endPosition, midPosition);

        return midPosition;
    }//end partition()




    private static void swapVar(int[] a, int indexOne, int indexTwo) {
        //temp holds value in target index
        int temp;
        temp = a[indexOne];

        //assign targetPosition
        a[indexOne] = a[indexTwo];
        a[indexTwo] = temp;
    } // end swapVar()

}

public class InsertSort {

    public static void insertSort(int[] intArray) {


        int value; // hold current value of number in consideration
        int x ; //Index Catalyst Variable.
        for(int i=1; i < intArray.length; i++)
        {
            //store consider array element
            value = intArray[i];
            x = i-1;

            //see if considered element is the higher than the part of array that is already sorted
            while (x >= 0 &&  intArray[x] > value){
                intArray[x + 1] =  intArray[x];
                x--;
            }
            //assign the considered element its new position
            intArray[x + 1] = value;

        }



    }
}

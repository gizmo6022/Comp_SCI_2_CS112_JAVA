public class BubbleSort {
public static void bubbleSort(int[] intArray){
        int i;
        int c;  // catalyst var
        boolean inOrder = false;


        while (!inOrder){
            inOrder = true;
            for (i = 1; i < intArray.length; i++){
                if (intArray[i-1] > intArray[i]){

                    //swap numbers if x-1 is bigger then x
                    c = intArray[i];
                    intArray[i] = intArray[i-1];
                    intArray[i-1] = c;
                    inOrder = false;
                }
            }
        }
    }// end bubbleSort()
}

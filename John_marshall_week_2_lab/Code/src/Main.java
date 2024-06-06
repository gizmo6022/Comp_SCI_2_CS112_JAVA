/* John Marshall Week 2 Lab:  Processing 1000 Random Integers
CSCI112
Last Edited 1/30/2023
*/

public class Main {
    public static void main(String[] args) throws Exception{
        int[] randomNums = new int[1000];
        int i;
        int total;
        double average;

        //Generate Array
        for(i = 0; i < randomNums.length; i++){
            randomNums[i] = 1 + (int)(Math.random()*10);
        }
        // calculate total & average. Narrow cast to double
        total = sum(randomNums);
        average = (double)total / randomNums.length;

        // print Array
        printArray(randomNums);

        //Sort Array
        bubbleSort(randomNums);

        // print Array after sorting
        printArray(randomNums);

        // create File with Name John_Marshall_Lab_week_2.txt
        java.io.File x = new java.io.File("John_Marshall_Lab_week_2.txt");
        java.io.PrintWriter  y = new java.io.PrintWriter(x);
        y.print("John Marshall week 2 Lab  Processing 1000 Random Integers" );
        y.println();
        // print Sum
        y.print("The sum of all 1000 Nunber: " + total);
        y.println();
        // print Average
        y.print("The average is: " + average);
        y.close();

    }// end main


   //Bubble Sort
    private static void bubbleSort(int[] numList){
        int y = 0; //Optimization Variable
        int i;
        int c;  // catalyst var
        boolean inOrder = false;


        while (!inOrder){
            inOrder = true;

            //subtract the optimization var y so it doesn't iterate through already sorted numbers
            for (i = 1; i < numList.length - y; i++){
                if (numList[i-1] > numList[i]){

                    //swap numbers if x-1 is bigger then x
                    c = numList[i];
                    numList[i] = numList[i-1];
                    numList[i-1] = c;
                    inOrder = false;
                }
            }

            //add to optimization variable
            y ++;
        }
    }// end bubbleSort()


    //simple for loop to calculate sum
    private static int sum(int[] numList){
        int sum =1;
        int i;

        for(i = 0; i < numList.length; i++){
            sum = sum + numList[i];
        }

        return sum;
    } // end Sum()


    //simply prints array in rows of 10 numbers
    private static void printArray(int[] numList){
        int i;

        for (i = 1; i < numList.length; i++) {
                System.out.print(numList[i] + " ");
                if(i % 9 == 0 && i > 0){
                    System.out.println();
                }
        }

    }// end print Array()


}

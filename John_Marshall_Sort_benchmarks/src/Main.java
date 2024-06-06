/*John Marshall
Recursive sorting research
CSCI112
Spring 2023*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //randomArrayManager
        RandomArrayManager mainArrayManager = new RandomArrayManager(6,100, 1000000);

//        int[] test = {1,9,3,7,1,2,0,3,6,7,8,5};
//
//        //InsertSort.insertSort(test);
//        //BubbleSort.bubbleSort(test);
//        SelectionSort.selectionSort(test);
//
//        System.out.println(Arrays.toString(test));

        int selection = 0;
        Scanner mainIO = new Scanner(System.in);

        while(selection != 11){
            System.out.println("\t\tRandom Array Benchmark");
            System.out.println("CURRENT ARRAY LENGTH: " + Integer.toString(mainArrayManager.getArrayLength()));
            System.out.println("CURRENT NUMBER OF DIGITS IN INTEGER: " + Integer.toString(mainArrayManager.getDigits()));
            System.out.println("CURRENT NUMBER OF TIMES TO RUN:  " + Integer.toString(mainArrayManager.getTimesRun()));
            System.out.println("CURRENT DATASET SIZES FOR AUTO BENCHMARKING :  " + Arrays.toString(mainArrayManager.getAutoBenchLengths()));
            //list Options
            System.out.println("1 ===>> Edit Array Length");
            System.out.println("2 ===>> Edit Digits In Integer");
            System.out.println("3 ===>> Edit Number of Passes");
            System.out.println("4 ===>> Set AutoBench data set sizes");
            System.out.println("5 ===>> Benchmark Bubble Sort");
            System.out.println("6 ===>> Benchmark Insert Sort");
            System.out.println("7 ===>> Benchmark Selection Sort");
            System.out.println("8 ===>> Benchmark Merge Sort");
            System.out.println("9 ===>> Benchmark Quick Sort");
            System.out.println("10 ===>> Auto Benchmark");
            System.out.println("11 ===>> To Exit System");
            selection = mainIO.nextInt();

            //list options
            if(selection == 1){
                mainArrayManager.setArrayLength();

            }else if(selection == 2){
                mainArrayManager.setDigits();

            }else if(selection == 3) {
                mainArrayManager.setTimesRun();

            }else if(selection == 4){
                    mainArrayManager.setAutoBenchLengths();
                //BUBBLESORT---------------------------------------------------------------------------------------------
            }else if(selection == 5){
                //var to hold Label
                String testLabel;

                //prompt to for label
                System.out.println("Create a Label for test. Will be the title of output CSV file.");
                System.out.println("FILE NAMING FORMAT: 'label'_BUBBLE_TIMESTAMP");
                System.out.println("enter EXIT to Abort");
                testLabel = mainIO.next();

                if(!testLabel.equals("EXIT")) {
                    TestRunManager.bubbleSortBenchmark(mainArrayManager, testLabel);
                }
                //INSERTSORT---------------------------------------------------------------------------------------------
            }else if(selection == 6){
                //var to hold Label
                String testLabel;

                //prompt to for label
                System.out.println("Create a Label for test. Will be the title of output CSV file.");
                System.out.println("FILE NAMING FORMAT: 'label'_INSERT_TIMESTAMP");
                System.out.println("enter EXIT to Abort");
                testLabel = mainIO.next();

                if(!testLabel.equals("EXIT")) {
                    TestRunManager.insertSortBenchmark(mainArrayManager, testLabel);
                }
                //SELECTIONSORT---------------------------------------------------------------------------------------------
            }else if(selection == 7){
                //var to hold Label
                String testLabel;

                //prompt to for label
                System.out.println("Create a Label for test. Will be the title of output CSV file.");
                System.out.println("FILE NAMING FORMAT: 'label'_SELECTION_TIMESTAMP");
                System.out.println("enter EXIT to Abort");
                testLabel = mainIO.next();

                if(!testLabel.equals("EXIT")) {
                    TestRunManager.selectionSortBenchmark(mainArrayManager, testLabel);
                }
                //QUICKSORT---------------------------------------------------------------------------------------------
            }else if(selection == 8){
                //var to hold Label
                String testLabel;

                //prompt to for label
                System.out.println("Create a Label for test. Will be the title of output CSV file.");
                System.out.println("FILE NAMING FORMAT: 'label'_QUICK_TIMESTAMP");
                System.out.println("enter EXIT to Abort");
                testLabel = mainIO.next();

                if(!testLabel.equals("EXIT")) {
                    TestRunManager.quickSortBenchmark(mainArrayManager, testLabel);
                }
                //MERGESORT---------------------------------------------------------------------------------------------
            }else if(selection == 9){
                //var to hold Label
                String testLabel;

                //prompt to for label
                System.out.println("Create a Label for test. Will be the title of output CSV file.");
                System.out.println("FILE NAMING FORMAT: 'label'_MERGE_TIMESTAMP");
                System.out.println("enter EXIT to Abort");
                testLabel = mainIO.next();

                if(!testLabel.equals("EXIT")) {
                    TestRunManager.mergeSortBenchmark(mainArrayManager, testLabel);
                }
            }else if(selection == 10){
                //var to hold Label
                String testLabel;

                //prompt to for label
                System.out.println("Auto bench runs benchmarks at array lengths" + Arrays.toString(mainArrayManager.getAutoBenchLengths()));
                System.out.println("Create a Label for tests. Will be the title of output CSV file.");
                System.out.println("FILE NAMING FORMAT: 'label'ARRAY_LENGTH_SORT_TYPE_TIMESTAMP");
                System.out.println("enter EXIT to Abort");
                testLabel = mainIO.next();

                if(!testLabel.equals("EXIT")) {
                    TestRunManager.autoBenchCompare(mainArrayManager, testLabel);
                }
            }else if(selection == 11){
                System.out.println("Thank you, GoodBye");
            }else{
                System.out.println("Invalid Input");
            }

        }//end while
        mainIO.close();
    }//end main

}//end Main

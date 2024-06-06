public class TestRunManager {


    //these methods generate an array and sort it given an array manager and a label

    public static boolean mergeSortBenchmark(RandomArrayManager x, String benchmarkLabel){

        boolean timeLimitReached = false;

        //array for time scores to be saved as file
        double[] times = new double[x.getTimesRun()];

        for(int i = 0; i < x.getTimesRun();i++) {
            //test array and Temp Array
            int[] testArray = x.generateArray();
            int[] temp = new int[testArray.length];

            // get end start in nanoseconds
            long startTime = System.nanoTime();

            //sort
                MergeSort.mergeSort(testArray, temp, 0, testArray.length - 1);

            // get the end time in nanoseconds
            long endTime = System.nanoTime();



            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            double timeScore =  (double)duration/1000000000;

            //TimeLimit Reached
            if (timeScore > 13){
                times[i] = timeScore;
                timeLimitReached = true;
                break;
            }

            System.out.printf("%12.8f %n", timeScore) ;

            //assign score to array
            times[i] = timeScore;
        }

        FileSave.saveResults(benchmarkLabel, "MERGE",times, x.getArrayLength(), x.getDigits(), x.getTimesRun());
        return timeLimitReached;
    } //end mergeSortBenchmark()

    public static boolean quickSortBenchmark(RandomArrayManager x, String benchmarkLabel){

        boolean timeLimitReached = false;
        //test Array
        double[] times = new double[x.getTimesRun()];

        for(int i = 0; i < x.getTimesRun();i++) {
            int[] testArray = x.generateArray();

            // get end start in nanoseconds
            long startTime = System.nanoTime();

            //sort
            QuickSort.quickSort(testArray, 0, testArray.length - 1);

            // get end time in nanoseconds
            long endTime = System.nanoTime();

            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;
            double timeScore =  (double)duration/1000000000;

            //TimeLimit Reached
            if (timeScore > 13){
                times[i] = timeScore;
                timeLimitReached = true;
                break;
            }

            System.out.printf("%12.8f %n", timeScore) ;

            times[i] = timeScore;
        }

        FileSave.saveResults(benchmarkLabel, "QUICK",times, x.getArrayLength(), x.getDigits(), x.getTimesRun());
        return timeLimitReached;
    } //end quickSortBenchmark()

    //InsertSort--------------------------------------------------------------------------------------------------------

    public static boolean insertSortBenchmark(RandomArrayManager x, String benchmarkLabel){

        boolean timeLimitReached = false;

        //array for time scores to be saved as file
        double[] times = new double[x.getTimesRun()];

        for(int i = 0; i < x.getTimesRun();i++) {
            //test array and Temp Array
            int[] testArray = x.generateArray();
            int[] temp = new int[testArray.length];

            // get end start in nanoseconds
            long startTime = System.nanoTime();

            //sort
            InsertSort.insertSort(testArray);

            // get the end time in nanoseconds
            long endTime = System.nanoTime();



            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            double timeScore =  (double)duration/1000000000;

            //TimeLimit Reached
            if (timeScore > 13){
                times[i] = timeScore;
                timeLimitReached = true;
                break;
            }

            System.out.printf("%12.8f %n", timeScore) ;

            //assign score to array
            times[i] = timeScore;
        }

        FileSave.saveResults(benchmarkLabel, "INSERT",times, x.getArrayLength(), x.getDigits(), x.getTimesRun());
        return timeLimitReached;
    } //end InsertSortBenchmark()

    //SelectionSort--------------------------------------------------------------------------------------------------------

    public static boolean selectionSortBenchmark(RandomArrayManager x, String benchmarkLabel){

        boolean timeLimitReached = false;

        //array for time scores to be saved as file
        double[] times = new double[x.getTimesRun()];

        for(int i = 0; i < x.getTimesRun();i++) {
            //test array and Temp Array
            int[] testArray = x.generateArray();
            int[] temp = new int[testArray.length];

            // get end start in nanoseconds
            long startTime = System.nanoTime();

            //sort
            SelectionSort.selectionSort(testArray);

            // get the end time in nanoseconds
            long endTime = System.nanoTime();



            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            double timeScore =  (double)duration/1000000000;

            //TimeLimit Reached
            if (timeScore > 13){
                times[i] = timeScore;
                timeLimitReached = true;
                break;
            }

            System.out.printf("%12.8f %n", timeScore) ;

            //assign score to array
            times[i] = timeScore;
        }

        FileSave.saveResults(benchmarkLabel, "SELECTION",times, x.getArrayLength(), x.getDigits(), x.getTimesRun());
        return timeLimitReached;
    } //end selectionSortBenchmark()

    //BubbleSort--------------------------------------------------------------------------------------------------------

    public static boolean bubbleSortBenchmark(RandomArrayManager x, String benchmarkLabel){

        boolean timeLimitReached = false;

        //array for time scores to be saved as file
        double[] times = new double[x.getTimesRun()];

        for(int i = 0; i < x.getTimesRun();i++) {
            //test array and Temp Array
            int[] testArray = x.generateArray();
            int[] temp = new int[testArray.length];

            // get end start in nanoseconds
            long startTime = System.nanoTime();

            //sort
            BubbleSort.bubbleSort(testArray);

            // get the end time in nanoseconds
            long endTime = System.nanoTime();



            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            double timeScore =  (double)duration/1000000000;

            //TimeLimit Reached
            if (timeScore > 13){
                times[i] = timeScore;
                timeLimitReached = true;
                break;
            }

            System.out.printf("%12.8f %n", timeScore) ;

            //assign score to array
            times[i] = timeScore;
        }

        FileSave.saveResults(benchmarkLabel, "BUBBLE",times, x.getArrayLength(), x.getDigits(), x.getTimesRun());

        return timeLimitReached;
    } //end bubbleSortBenchmark()

    public static void autoBenchCompare(RandomArrayManager x, String Label){
        int[] autoLengths = x.getAutoBenchLengths();
        //hold old value of ArrayLength of x
        int temp = x.getArrayLength();

        //loop through autoLengths array while running the sorting Algorithms

        //bubbleSort------------------------------------------------------------------------------------------------Auto
        int b = 0;
        boolean bubblePassedTimeLimit = false;
        while( b < autoLengths.length && !bubblePassedTimeLimit){
            //start over all time limit per pass
            long startTime = System.nanoTime();

            x.setArrayLength(autoLengths[b]);
            //label for files
            String labelWithNum = Label + autoLengths[b];
            //run Sorts
            System.out.println("------------------------ Bubble "+ labelWithNum);
            bubblePassedTimeLimit = bubbleSortBenchmark(x, labelWithNum + "BubbleSort");
            System.out.println("------------------------ Bubble "+ labelWithNum);

            long endTime = System.nanoTime();

            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            double timeScore =  (double)duration/1000000000;

            //TimeLimit for overall passes Reached
            if (timeScore > 300){
                break;
            }
            b++;
        }

        //SelectionSort------------------------------------------------------------------------------------------------Auto
        int s = 0;
        boolean selectionPassedTimeLimit = false;
        while( s < autoLengths.length && !selectionPassedTimeLimit){
            //start over all time limit per pass
            long startTime = System.nanoTime();

            x.setArrayLength(autoLengths[s]);
            //label for files
            String labelWithNum = Label + autoLengths[s];
            //run Sorts
            System.out.println("------------------------ Selection "+ labelWithNum);
            selectionPassedTimeLimit = selectionSortBenchmark(x, labelWithNum + "SelectionSort");
            System.out.println("------------------------ Selection "+ labelWithNum);

            long endTime = System.nanoTime();

            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            double timeScore =  (double)duration/1000000000;

            //TimeLimit for overall passes Reached
            if (timeScore > 300){
                break;
            }
            s++;
        }

        //InsertionSort------------------------------------------------------------------------------------------------Auto
        int i = 0;
        boolean insertPassedTimeLimit = false;
        while( i < autoLengths.length && !insertPassedTimeLimit){
            //start over all time limit per pass
            long startTime = System.nanoTime();

            x.setArrayLength(autoLengths[i]);
            //label for files
            String labelWithNum = Label + autoLengths[i];
            //run Sorts
            System.out.println("------------------------ Insert "+ labelWithNum);
            insertPassedTimeLimit = insertSortBenchmark(x, labelWithNum + "InsertSort");
            System.out.println("------------------------ Insert "+ labelWithNum);

            long endTime = System.nanoTime();

            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            double timeScore =  (double)duration/1000000000;

            //TimeLimit for overall passes Reached
            if (timeScore > 300){
                break;
            }
            i++;
        }
        //InsertionSort------------------------------------------------------------------------------------------------Auto
        int q = 0;
        boolean quickPassedTimeLimit = false;
        while( q < autoLengths.length && !quickPassedTimeLimit){
            //start over all time limit per pass
            long startTime = System.nanoTime();

            x.setArrayLength(autoLengths[q]);
            //label for files
            String labelWithNum = Label + autoLengths[q];
            //run Sorts
            System.out.println("------------------------ Quick "+ labelWithNum);
            quickPassedTimeLimit = quickSortBenchmark(x, labelWithNum + "QuickSort");
            System.out.println("------------------------ Quick "+ labelWithNum);

            long endTime = System.nanoTime();

            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            double timeScore =  (double)duration/1000000000;

            //TimeLimit for overall passes Reached
            if (timeScore > 300){
                break;
            }
            q++;
        }

        int m = 0;
        boolean mergePassedTimeLimit = false;
        while( m < autoLengths.length && !mergePassedTimeLimit){
            //start over all time limit per pass
            long startTime = System.nanoTime();

            x.setArrayLength(autoLengths[m]);
            //label for files
            String labelWithNum = Label + autoLengths[m];
            //run Sorts
            System.out.println("------------------------ Merge "+ labelWithNum);
            mergePassedTimeLimit = mergeSortBenchmark(x, labelWithNum + "MergeSort");
            System.out.println("------------------------ Merge "+ labelWithNum);

            long endTime = System.nanoTime();

            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            double timeScore =  (double)duration/1000000000;

            //TimeLimit for overall passes Reached
            if (timeScore > 300){
                break;
            }
            m++;
        }


        //reset to previous single benchmark array Length
        x.setArrayLength(temp);
    }

}

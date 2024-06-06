
/* John Marshall Week 3 Lab:  Exception Handling
CSCI112
Last Edited 2/13/2023
*/


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] randomIntArray = createRandomIntArray(100);

        Scanner userIO = new Scanner(System.in);

        // Write array to file
        try {
            writeArrayToFile(randomIntArray, "ArrayValues");

           //specific Catch for IO exceptions
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error, connection with target location might have failed. Please try again. Check File Location" + e.getMessage());

            // catch any exceptions
        } catch (Exception e) {
            e.printStackTrace();
        }//end catch



        //loop exit condition
        boolean validInput = false;


        //loop through to return from exceptions that might be thrown
        while (!validInput) {
            try {

                //call method that prompts user and prints element Value.
                printArrayIndexValue(randomIntArray);
                validInput = true;


                //Catch for out of bound index with exit Option
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The Index requested is out of bounds, press Enter to try again or Exit to quit.");

                String termRequest = userIO.nextLine();
                if (termRequest.equals("exit") || termRequest.equals("EXIT")) {
                    break;
                }

                //Catch for everything else with exit Option
            } catch (Exception e) {
                System.out.println("Invalid Input, press ENTER to try again, type EXIT to quit");
                String termRequest = userIO.nextLine();
                if (termRequest.equals("exit") || termRequest.equals("EXIT")) {
                    break;
                }
            }


        } // end LOOP
    }//end Main method

    //create random array method, rakes length of the array as argument
    public static int[] createRandomIntArray(int arrayLength) {
        int i;
        int[] randomArray = new int[arrayLength];

        //populate random integer array loop (from 0-10
        for(i=0; i<arrayLength; i ++){
            randomArray[i] = (int) (Math.random()*10);
        }

        return randomArray;
    }// end createRandomInArray


    //write array to file method, takes array and file name as argument. Exceptions handled in Main
    public static void writeArrayToFile(int[] intArray, String fileName) throws Exception{

            //passing Name argument as file name
            java.io.File y =  new java.io.File(fileName + ".txt");

            //start stream
            java.io.PrintWriter x = new java.io.PrintWriter(y);


            // print array in file and close stream
            x.print(Arrays.toString(intArray));
            x.close();
        }// end printArrayIndexValue



 // Print Array index value prompts user and displays array value. Exceptions handled in Main
    public static void printArrayIndexValue(int[] randomArray) throws Exception{

            System.out.println("Enter the index of the value you would like to know? enter an integer between 0 " +
                "and " + (randomArray.length -1));

            Scanner y = new Scanner(System.in);
                int UserInput = Integer.parseInt(y.nextLine());
                System.out.println("The value of index " + UserInput + " is " + randomArray[UserInput]+".");

    } // end createRandomInArray



}//End main Class
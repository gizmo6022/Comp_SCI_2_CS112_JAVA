
import java.util.Scanner;

public class RandomArrayManager {
    //num of digits in an int
    //number of times the sort will run
    //length of array
    private int digits ;

    private int timesRun;

    private int arrayLength;
    private int[] autoBenchLengths = {10000, 20000, 100000, 200000, 1000000, 2000000, 10000000, 20000000};


    //Constructor----------------------------------------------------------
    public RandomArrayManager(int numOfDigits, int numOfPasses, int length){
        this.arrayLength = length;
        this.timesRun = numOfPasses;
        this.digits =numOfDigits;
    }

    //Gets---------------------------------------------------------
    public int getDigits() { return this.digits; }
    public int getArrayLength() { return this.arrayLength;}
    public int getTimesRun() { return this.timesRun;}
    public int[] getAutoBenchLengths(){
        return this.autoBenchLengths;
    };

    //quick sets-------------------------------------------------------

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public void setArrayLength(int arrayLength) {
        this.arrayLength = arrayLength;
    }

    public void setTimesRun(int timesRun) {
        this.timesRun = timesRun;
    }
    //Sets ------------------------------------------------------------

    public void setDigits() {
        //temp int to receive new input
        int newNumOfDigits = -1;

        //io Stream
        Scanner io = new Scanner(System.in);
        //valid input break condition
        while (newNumOfDigits > 9 || newNumOfDigits < 0){
            System.out.println("Number of Digits must be between 1 - 9. Enter EXIT to abort.");
            String input = io.nextLine();

            //abort Condition
            if (input.equalsIgnoreCase( "EXIT")){
                break;
            }
            //value assignment
            try{
                newNumOfDigits = Integer.parseInt(input);
                this.digits = newNumOfDigits;
            } catch(Exception e) {
                System.out.println("Invalid Input");
            }
        }//end while
    } //end setDigits()


    public void setArrayLength() {
        //temp int to receive new input
        int newArrayLength = -1;

        //io Stream
        Scanner io = new Scanner(System.in);
        //valid input break condition
        while (newArrayLength > 2000000000 || newArrayLength <= 0){
            System.out.println("Power of 10 must be between 0 - 2000000000. Enter EXIT to abort.");
            String input = io.nextLine();
            //abort Condition
            if (input.equals( "EXIT")){
                break;
            }
            //value assignment
            try{
                newArrayLength = Integer.parseInt(input);
                this.arrayLength = newArrayLength;

            } catch(Exception e) {
                System.out.println("Invalid Input");
            }
        } //end while
    }//end setArrayLength()


    public void setTimesRun() {
        //temp int to receive new input
        int newNum0fPasses = -1;

        //io Stream
        Scanner io = new Scanner(System.in);
        //valid input break condition
        while (newNum0fPasses < 1){
            System.out.println("Number of Passes Must be above 0.");
            String input = io.nextLine();
            //abort Condition
            if (input.equals("EXIT")){
                break;
            }
            //value assignment
            try{
                newNum0fPasses = Integer.parseInt(input);
                this.timesRun = newNum0fPasses;

            } catch(Exception e) {
                System.out.println("Invalid Input");
            }
        } //end While
    }//end setTimesRun()

    public void setAutoBenchLengths(){

        for (int i = 0; i< this.autoBenchLengths.length; i++){

            int arrayLengths = -1;

            //io Stream
            Scanner io = new Scanner(System.in);
            //valid input break condition
            while (arrayLengths < 1){
                System.out.println("Test "+ (i+1) + " of " + (this.autoBenchLengths.length) +
                        ": Size of data set for this test?");
                String input = io.nextLine();
                //abort Condition
                if (input.equals("EXIT")){
                    break;
                }
                //value assignment
                try{
                    arrayLengths = Integer.parseInt(input);
                    this.autoBenchLengths[i] = arrayLengths;

                } catch(Exception e) {
                    System.out.println("Invalid Input");
                }
            } //end While
        }
    }



    public  int[] generateArray() {

        //calculate number of digits
        int numOfDigits = (int) Math.pow(10, (this.digits));

        //create Array
        int[] returnArray = new int[this.arrayLength];

        for (int i = 0; i< this.arrayLength; i++) {
            returnArray[i] = (int) (Math.random() * (numOfDigits + 1));
        }

        return returnArray;
    }




//Print Array is used for testing purposes only-----------------------------------------------------------------------

    /*public static void printArray(int[] x){
        int lastElement = x.length - 1;
        int middleElement = Math.floorDiv(x.length, 2);

        if (x.length > 10) {
            System.out.print(x[0]);
            System.out.println(x[1]);
            System.out.println(x[2]);
            System.out.println(x[middleElement]);
            System.out.println(x[lastElement -2]);
            System.out.println(x[lastElement -1]);
            System.out.println(x[lastElement]);

        } else {
            for(int i = 0; i < x.length; i++) {
                System.out.println(x[i]);
            }
        }
    } //end printArray*/
}

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class PilotManager {

    protected int length; // stores the current length of elements
    protected int maxSize; // Max Size of length
    protected Pilot [] list; // array holds list of object

    //Begin Constructors-------------------------------------------------------------

    public PilotManager(){
        length = 0;
        maxSize = 10;
        list =  new Pilot[maxSize];
    }//end default constructor

    public PilotManager(int size){
        length = 0; // initiates the current length at zero

        if(size <=0 ){
            System.err.println("The array must be a positive integer. Creating an Array with 100 Elements");
            maxSize = 100;
        } else {
            maxSize = size;
        }

        list =  new Pilot[maxSize];

    }//end constructor

    //End Constructors------------------------------------------------

    //Begin Methods---------------------------------------------------

    public void append(Pilot newPilot){

        //checks if there's space
        if (length == maxSize){
            System.err.println("Can not Append, List is Full");
        }
        else{

            //assigns newPilot to Array at Index of length and then increments length
            list[length] = newPilot;
            length ++;
        }
    }//End Append()


    public void print(){
        //loop that print elements in array
        int count = 0;
            while (count<length){
                System.out.println(list[count].toString());
                count++;
            }

    }//end Print()


    public void loadPilots(String fileName){
        //Record Structure

        // 1st item int idNumber
        // 2nd Item String name
        // 3rd item String hireDate
        // 4th item int licenseNumber
        // 5th item Double rating
        // 6th item Double flightHours
        //idNumber,name,hireDate,licenseNumber,rating,flightHours



        try{
            java.io.File file = new java.io.File(fileName + ".txt");
            Scanner tempData = new Scanner(file);

            while(tempData.hasNext()){
                Pilot temp = new Pilot();

                String record = tempData.nextLine();
                String[] fields = record.split(",");
                temp.setIdNumber(Integer.parseInt(fields[0]));
                temp.setName(fields[1]);
                temp.setHireDate(fields[2]);
                temp.setLicenseNumber(Integer.parseInt(fields[3]));
                temp.setRating(Double.parseDouble(fields[4]));
                temp.setFlightHours(Double.parseDouble(fields[5]));

                append(temp);
            }//end While

           //print(); Test Print
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }//end loadPilots

    public Pilot getAPilot(){
        Scanner kb = new Scanner(System.in);
        int idNumber;            //Pilot ID
        String fullName;            //Pilot Name
        String hireDate;        //pilot Hire Date
        int licenseNumber;      // pilot LicenseNumber
        double rating;          //pilot Rating
        double flightHours;     //pilot Flight Hours
        String informationCorrect; //user confirm

        Pilot newPilot = new Pilot(); //Return Obj


        //collect user Information
        System.out.println("CREATING NEW PILOT");

        System.out.println("Pilots ID Number:");
        idNumber = kb.nextInt();

        System.out.println("Pilots Full Name:");
        fullName = kb.next();

        System.out.println("Pilots Hire Date:");
        hireDate = kb.next();

        System.out.println("Pilots License Number:");
        licenseNumber = kb.nextInt();

        System.out.println("Pilots Rating: FORMAT 0.0");
        rating = kb.nextDouble();

        System.out.println("Pilots Flight Hours: FORMAT 0.0");
        flightHours = kb.nextDouble();


        //confirm Info
        System.out.println("Please Confirm the Following Information\n\n");
        System.out.println("Pilots ID Number: " + idNumber);
        System.out.println("Pilots Full Name: " + fullName);
        System.out.println("Pilots Hire Date: " + hireDate);
        System.out.println("Pilots License Number: " + licenseNumber);
        System.out.println("Pilots Rating: " + rating );
        System.out.println("Pilots Flight Hours: " + flightHours);

        System.out.println("Enter Y to confirm");
        informationCorrect = kb.next();
        informationCorrect = informationCorrect.toUpperCase();


        //set Values
        if(informationCorrect.equals("Y")) {


            newPilot.setIdNumber(idNumber);
            newPilot.setName(fullName);
            newPilot.setHireDate(hireDate);
            newPilot.setLicenseNumber(licenseNumber);
            newPilot.setRating(rating);
            newPilot.setFlightHours(flightHours);

            System.out.println("PILOT CREATED");

        }else {
            System.out.println("CONFIRMATION NOT MET DATA DELETED");
        }
        return newPilot;
    }//end GetAPilot

    public void savePilotList(){

        // 1st item int idNumber
        // 2nd Item String name
        // 3rd item String hireDate
        // 4th item int licenseNumber
        // 5th item Double rating
        // 6th item Double flightHours
        //idNumber,name,hireDate,licenseNumber,rating,flightHours

        try {
            //create File
            java.io.File file = new File("pilotSaveList.txt");
            java.io.PrintWriter pw = new PrintWriter(file);

            int count = 0;

            while (count < length){

                String printLine = "";

                Pilot temp =  list[count];

                //concatenate
                printLine =  printLine + temp.getIdNumber() + "," ;
                printLine =  printLine + temp.getName() + "," ;
                printLine =  printLine + temp.getHireDate() + "," ;
                printLine =  printLine + temp.getLicenseNumber() + "," ;
                printLine =  printLine + temp.getRating() + "," ;
                printLine =  printLine + temp.getFlightHours() + "," ;

                //print to File
                pw.println(printLine);
                System.out.println(printLine);
                count++;
            }
            pw.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }//end catch
    }//End SavePilotList


    public int SeqSearch(Pilot searchItem){
        int loc;
        boolean found = false;
        for(loc = 0; loc < length; loc++)
            if(list[loc].equals(searchItem)){
                found = true;
                break;
            }
        if (found) {
            return loc;
        }else{
         return -1;
        }
    }//end SeqSearch

    public void editPilot(int index){

        // 1st item int idNumber
        // 2nd Item String name
        // 3rd item String hireDate
        // 4th item int licenseNumber
        // 5th item Double rating
        // 6th item Double flightHours

        Scanner kb = new Scanner(System.in);
        int sel=0;

        while(sel != 7){

            System.out.println(list[index].toString());
            System.out.println("");
            System.out.println("Enter the number of the field you would like to edit");
            System.out.println("1 ===>> ID number");
            System.out.println("2 ===>> Name");
            System.out.println("3 ===>> Hire Date");
            System.out.println("4 ===>> License Number");
            System.out.println("5 ===>> Rating");
            System.out.println("6 ===>> Flight Hours");
            System.out.println("7 ===>> Exit selection");

            sel = kb.nextInt();


            //IDNumber Edit
            if(sel == 1){

                String informationCorrect;
                int newIDNumber;
                System.out.println("New ID Number?");
                newIDNumber = kb.nextInt();

                //Echo to user
                System.out.println("Desired ID Number: " + newIDNumber);
                System.out.println("Enter Y to confirm");
                informationCorrect = kb.next();
                informationCorrect = informationCorrect.toUpperCase();

                if(informationCorrect.equals("Y")){
                    list[index].setIdNumber(newIDNumber);
                } else{
                    System.out.println("CONFIRMATION NOT MET, Please try again.");
                }

            //Name Edit
            }if(sel == 2){
                String informationCorrect;
                String newName;
                System.out.println("New Name?");
                newName = kb.next();

                //Echo to user
                System.out.println("Desired Name: " + newName);
                System.out.println("Enter Y to confirm");
                informationCorrect = kb.next();
                informationCorrect = informationCorrect.toUpperCase();

                if(informationCorrect.equals("Y")){
                    list[index].setName(newName);
                } else{
                    System.out.println("CONFIRMATION NOT MET, Please try again.");
                }

            //Hire Date
            }if(sel == 3){

                String informationCorrect;
                String newDate;
                System.out.println("New Hire Date?");
                newDate = kb.next();

                //Echo to user
                System.out.println("Desired Hire Date: " + newDate);
                System.out.println("Enter Y to confirm");
                informationCorrect = kb.next();
                informationCorrect = informationCorrect.toUpperCase();

                if(informationCorrect.equals("Y")){
                    list[index].setHireDate(newDate);
                } else{
                    System.out.println("CONFIRMATION NOT MET, Please try again.");
                }

            //License Number
            }if(sel == 4){

                String informationCorrect;
                int newLicenseNum;
                System.out.println("New ID License Number?");
                newLicenseNum = kb.nextInt();

                //Echo to user
                System.out.println("Desired License Number: " + newLicenseNum);
                System.out.println("Enter Y to confirm");
                informationCorrect = kb.next();
                informationCorrect = informationCorrect.toUpperCase();

                if(informationCorrect.equals("Y")){
                    list[index].setLicenseNumber(newLicenseNum);
                } else{
                    System.out.println("CONFIRMATION NOT MET, Please try again.");
                }

            //Rating
            }if(sel == 5){

                String informationCorrect;
                double newRating;
                System.out.println("New Rating?");
                newRating = kb.nextDouble();

                //Echo to user
                System.out.println("Desired Rating: " + newRating);
                System.out.println("Enter Y to confirm");
                informationCorrect = kb.next();
                informationCorrect = informationCorrect.toUpperCase();

                if(informationCorrect.equals("Y")){
                    list[index].setRating(newRating);
                } else {
                    System.out.println("CONFIRMATION NOT MET, Please try again.");
                }

            //Flight Hours
            }if(sel == 6){
                //USER INPUT FOR NEW LOAD FILE
                String informationCorrect;
                double newFlightHours;
                System.out.println("New Flight Hours?");
                newFlightHours = kb.nextDouble();

                //Echo to user
                System.out.println("Desired Flight Hours: " + newFlightHours);
                System.out.println("Enter Y to confirm");
                informationCorrect = kb.next();
                informationCorrect = informationCorrect.toUpperCase();

                if(informationCorrect.equals("Y")){
                    list[index].setFlightHours(newFlightHours);
                } else {
                    System.out.println("CONFIRMATION NOT MET, Please try again.");
                }

            }if(sel == 7){

            }else{
                System.out.println("Invalid Input");
            }
        }//end While menu

    } //End Edit Pilot

    public void removeAt(int index){
        if (index < 0 || index > length){
            System.err.println("Item index to be removed is out of range");
        } else{
            for(int i = index; i < length -1; i ++){
                list[i]=list[i+1];
                list[length - 1] =  null;
                length --;
            }
        }
    }//End removeAt

}

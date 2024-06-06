/*John Marshall
user Defined Objects
Feb 27 2023
*/

import java.util.Scanner;

public class Main {

    public static PilotManager pilotManagerList = new PilotManager();
    public static void main(String[] args) {

        pilotManagerList.loadPilots("newPilotsList");
        menu();

    }

    public static void menu(){
        int selection = 0;
        Scanner ms = new Scanner(System.in);

        while(selection != 7){
            System.out.println("\t\tPilot Array API");
            System.out.println("1 ===>> To List Pilots");
            System.out.println("2 ===>> To Add a Pilot");
            System.out.println("3 ===>> To Edit a Pilot");
            System.out.println("4 ===>> To Delete a Pilot");
            System.out.println("5 ===>> To Save Pilots");
            System.out.println("6 ===>> To Load Pilots");
            System.out.println("7 ===>> To Exit System");

            selection = ms.nextInt();

            //list pilots
            if(selection == 1){
                pilotManagerList.print();

            //Add pilot
            }else if(selection == 2){
                Pilot newPilot;
                newPilot = pilotManagerList.getAPilot();
                pilotManagerList.append(newPilot);

            //Edit pilot
            }else if(selection == 3){

                //get index then run EditPilot method
                Pilot pilotTobeEdited = getPilotIDObject();
                int i = pilotManagerList.SeqSearch(pilotTobeEdited); //index of search
                pilotManagerList.editPilot(i);

            //Delete pilot
            }else if(selection == 4){
                Pilot pilotTobeEdited = getPilotIDObject();
                int i = pilotManagerList.SeqSearch(pilotTobeEdited); //index of search
                pilotManagerList.removeAt(i);

            //Save list
            }else if(selection == 5){
                    pilotManagerList.savePilotList();

            //Load list
            }else if(selection == 6){
                String informationCorrect;
                String newListLoad;

                //prompt to load
                System.out.println("What is the file Name you would like to load From? *100 Pilot  Limit");
                newListLoad = ms.next();

                //Echo to user
                System.out.println("Desired File Name: " + newListLoad +"txt");
                System.out.println("Enter Y to confirm");
                informationCorrect = ms.next();
                informationCorrect = informationCorrect.toUpperCase();

                //load list
                if(informationCorrect.equals("Y")){
                    pilotManagerList = new PilotManager();
                    pilotManagerList.loadPilots(newListLoad);

                } else {
                    System.out.println("CONFIRMATION NOT MET, Please try again.");
                }


            }else if(selection == 7){
            System.out.println("Thank you, GoodBye");
            }else{
                System.out.println("Invalid Input");
            }

        }//end while
        ms.close();
    }//end Menu

    public static Pilot getPilotIDObject(){
        Pilot temp = new Pilot();
        int pilotID;
        Scanner kb = new Scanner(System.in);
        String informationCorrect;

        //prompt for ID
        System.out.println("Pilot ID to search For \n\n");
        System.out.println("what is the Pilot ID Number of desired Pilot?");
        pilotID = kb.nextInt();


        //Echo ID
        System.out.println("Desired ID Number: " + pilotID);
        System.out.println("Enter Y to confirm");
        informationCorrect = kb.next();
        informationCorrect = informationCorrect.toUpperCase();

        if(informationCorrect.equals("Y")){
            temp.setIdNumber(pilotID);
        } else{
            System.out.println("CONFIRMATION NOT MET, Please try again.");
        }

        return temp;
    }// end getPilotIDObject

}


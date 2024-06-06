/*
John Marshall
Java Database Programming - Course Data Assignment
Spring 2023
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Database connection established.\n");

        int selection = 0;
        Scanner mainIO = new Scanner(System.in);



        while(selection != 3){
            System.out.println("\t\tRandom Array Benchmark");
            //list Options
            System.out.println("1 ===>> Print All Fall2014 to CVS");
            System.out.println("2 ===>> Query 4 credit Classed Held on MWF on Main Campus");
            System.out.println("3 ===>> To Exit System");
            selection = mainIO.nextInt();

            //list options
            if(selection == 1){
                //confirm Connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.75.195/CWHDemo", "CWHDemo",
                        "Cwhdemo%123");
                System.out.println("Database connection established.\n");
                // Create a statement Object for this database connection
                Statement st = conn.createStatement();
                // call a Query Method
                SQLQueries.queryForAll(st);
                // Close connection
                conn.close();

            }else if(selection == 2){
                Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.75.195/CWHDemo", "CWHDemo",
                        "Cwhdemo%123");
                //confirm Connection
                System.out.println("Database connection established.\n");
                // Create Statement Obj
                Statement st = conn.createStatement();
                // call a Query Method
                SQLQueries.customQuery(st);
                // Close  connection
                conn.close();
            }else if(selection == 3){
                System.out.println("Thank you, GoodBye");
            }else{
                System.out.println("Invalid Input");
            }

        }//end while
        mainIO.close();
    }//end main

}//end Main


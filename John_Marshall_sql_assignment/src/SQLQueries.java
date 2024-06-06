import java.io.FileWriter;
import java.sql.*;

/*

The database CWHDemo on the server at IP address 160.153.75.195 has a table named fall2014 with information about
computer courses that were offered at Community College of Philadelphia back in the Fall 2014 semester.
Username: CWHDemo
Password: Cwhdemo%123
Database Name: CWHDemo

crn               char(20)
subject           varchar(5)
course            varchar(5)
section           varchar(5)
credits           integer
time              varchar(20)
days              varchar(8)
term              varchar(5)
campus            varchar(5)
room              varchar(8)
enrollment        integer
 */

public class SQLQueries {

    public static void queryForAll(Statement x)
            throws SQLException, ClassNotFoundException {
        String queryString; // a String to hold an SQL query
        ResultSet allEntities; // the result set from an SQL query as a table
    // Create query that returns all rows and all columns from the database
        queryString = "SELECT * FROM fall2014;";
    // Send a statement executing the query and saving the result set
        allEntities = x.executeQuery(queryString);
    // print headings for the output

        try {
            FileWriter CSVWriter = new FileWriter("CCP_Classes_Summer_2014.csv");

            //Write the CSV file header
            CSVWriter.append("crn,subject,course,section,credits,time,days,term,campus,room,enrollment");

            //Add a new line separator after the header
            CSVWriter.append("\n");

            while (allEntities.next()){
                for(int i = 1; i<12;i++){
                    CSVWriter.append(allEntities.getString(i));
                    CSVWriter.append(",");

                }
                CSVWriter.append("\n");
            }
            CSVWriter.close();
            System.out.println("file was created successfully");

        } catch (Exception e) {
            System.out.println("Error with CsvWriter");
            e.printStackTrace();
        }
    } // end selectAll()


    // Query 4 credit Classed Held on MWF on Main Campus
    public static void customQuery(Statement x)
            throws SQLException, ClassNotFoundException {
        String queryString;
        ResultSet selectInstances;
        // this query returns all rows and applicable columns
        queryString = "SELECT * FROM fall2014 WHERE days  = \"MWF\" AND campus = \"MAI\"; ";
        // executing the query
        selectInstances = x.executeQuery(queryString);
        // print header
        System.out.println(queryString);
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", "crn", "subject",  "course", "section",
                "credits", "time", "days", "term", "campus",
                "room", "enrollment");
        System.out.println("******************************************************************************************");
        // Iterate through the result set and print instances
        while (selectInstances.next())
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", selectInstances.getString(1), selectInstances.getString(2),
                    selectInstances.getString(3), selectInstances.getString(4), selectInstances.getString(5),
                    selectInstances.getString(6), selectInstances.getString(7), selectInstances.getString(8)
                    , selectInstances.getString(9), selectInstances.getString(10), selectInstances.getString(11));
        System.out.println("******************************************************************************************");
    } // end customQuery
}

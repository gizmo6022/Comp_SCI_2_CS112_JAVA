/*
* John Marshall
* CSCI112 Spring 2023
*
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Arrays to carry the career and salaries
        //16 of each
       int[] salaries = new int[16];
       String[] careers = new String[16];

        //try to import arrays from file
        try{
            java.io.File file = new java.io.File( "careers.txt");
            Scanner newData = new Scanner(file);


            //alternate lines for Salaries and arrays
            for(int i = 0; i<16;i++){
                careers[i] = newData.nextLine();
                salaries[i] = Integer.parseInt(newData.nextLine());
            }

            //Catch/ print stack trace
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        //print Unsorted Arrays
        System.out.println(Arrays.toString(salaries));
        System.out.println(Arrays.toString(careers));

        //salaries used as Key properties as arrays will be sorted from highest to lowest
        //tempSalary & tempCareer will hold value of array element being sorted
        int tempSalary;
        String tempCareer;


        int x ;
        for (int i=1; i < salaries.length; i++)
        {
            //store consider array element
            tempSalary = salaries[i];
            tempCareer = careers[i];
            x = i-1;

            //see if considered element is the higher than the part of array that is already sorted
            while (x >= 0 && salaries[x] < tempSalary ){
                salaries[x + 1] = salaries[x];
                careers[x + 1] = careers[x];
                x--;
            }
            //assign the considered element its new position
            salaries[x + 1] = tempSalary;
            careers[x + 1] = tempCareer;

        }

        //print arrays to show they are now inorder
        System.out.println(Arrays.toString(salaries));
        System.out.println(Arrays.toString(careers));
    }
}

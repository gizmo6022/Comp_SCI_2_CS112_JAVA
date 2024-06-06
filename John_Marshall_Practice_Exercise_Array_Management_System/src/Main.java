import java.util.Scanner;

public class Main {

    private static EmployeeManager empList = new EmployeeManager();

    public static void main(String[] args) {

        Employee Debbie = new Employee(1234, "Debbie@debbie.com","215-555-5555");
        Employee Johnny = new Employee(5678, "johnny@johnny.com","215-555-6666");
        Employee Manny = new Employee(9876, "Manny@Manny.com","215-555-7777");
        empList.append(Debbie);
        empList.append(Johnny);
        empList.append(Manny);
        menu();

    }

    public static void menu() {
        int selection = 0;
        Scanner ms = new Scanner(System.in);

        while (selection != 7) {
            System.out.println("\t\tEmployee Array API");
            System.out.println("1 ===>> List Employees");
            System.out.println("2 ===>> Add Employee");
            System.out.println("3 ===>> Search an Employee");
            System.out.println("4 ===>> Delete a Employee");
            System.out.println("5 ===>> Save Employee list ");
            System.out.println("6 ===>> Edit Employee");
            System.out.println("7 ===>> To Exit System");

            selection = ms.nextInt();


            if (selection == 1) {
                empList.print();

            } else if (selection == 2) {


            } else if (selection == 3) {


                //Delete pilot
            } else if (selection == 4) {


                //Save list
            } else if (selection == 5) {

                //Load list
            } else if (selection == 6) {


            } else if (selection == 7) {
                System.out.println("Thank you, GoodBye");
            } else {
                System.out.println("Invalid Input");
            }


        }//end Menu
        ms.close();
    }
}
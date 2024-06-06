public class Employee {
    public int idNumber;
    public String name;
    public String hireDate;
    public String employeeType;


    //Constructors *******************

    //default Constructor
    public void Employee(){

    }



    public void Employee(int idNum, String employeeName, String startDate, String type){
        this.idNumber = idNum;
        this.name = employeeName;
        this.hireDate = startDate;
        this.employeeType= type;

    }



    //Gets and Sets *******************


    //get and set IDNumber
    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    //End IDNumbers



    //get and set Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //end Name


    //get and Set EmployeeType
    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    //End EmployeeType


    //get and Set HireDate
    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    //End hireDate

    //end Gets and SETS******************


    //toString Method
    public String toString(){
        String item = "";
        item = item +"Employee ID Number: " + this.idNumber +"\n";
        item = item + "Employee Name: " + this.name + "\n";
        item = item + "Employee Type: " + this.employeeType + "\n";
        item = item + "Employee Hire Date: " + this.hireDate + "\n";


        return item;
    }

    //end toString



}//End Class

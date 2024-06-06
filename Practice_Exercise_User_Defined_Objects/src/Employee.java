
public class Employee extends Person {
    private int employeeID;
    private String email;
    private String phoneNumber;


    public Employee(){

    }

    public Employee(int ID, String emailAddress, String phone){
        setEmployeeID(ID);
        setEmail(emailAddress);
        setPhoneNumber(phone);
    }

    public void setEmployeeID(int IDNumber) {
        employeeID = IDNumber;
    }
    public int getEmployeeID(){
        return employeeID;
    }

    public void setEmail(String emailAddress){
        email= emailAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneDigits){
        phoneNumber = phoneDigits;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        String item = "";
        item = item + "Employee ID:" +employeeID + "\n";
        item = item + super.toString();
        item = item + "Employee Email:" + email + "\n";
        item = item + "Employee Phone Number:" + phoneNumber + "\n";

        return item;
    }

    //compares 2 employee objects
    //retruns Ranking Order basked on ID num
    public int compare(Employee e){
        if(employeeID > e.employeeID){
            return 1;
        } else if (employeeID < e.employeeID) {
            return -1;
        }else {
            return 0;
        }
    }

    //compares 2 employee obj
    //returns the equality based on ID
    public boolean equals(Employee e){
        return (employeeID == e.employeeID);
    }
}

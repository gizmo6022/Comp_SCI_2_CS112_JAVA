
public class Pilot extends Employee{

    private int licenseNumber;
    private double rating;
    private double flightHours;

    public Pilot(){
        this.employeeType = "Pilot";
    }

    public Pilot(int idNum, String name, String hireDate, int licenseNum){
        this.idNumber = idNum;
        this.name = name;
        this.employeeType = "Pilot";
        this.hireDate = hireDate;
        this.licenseNumber = licenseNum;


    }

//Gets and Sets*************************************
    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    //End constructors

    //Gets and Sets *************************************
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }

    //end Gets and Sets

    //Object Methods *************************************

    public void eject(){
        System.out.println(this.name + " has ejected from their AirCraft!");
    }

    public int compare(Employee e){
        if(idNumber > e.idNumber){
            return 1;
        } else if (idNumber < e.idNumber) {
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String item = "";
        item = item + super.toString();
        item = item + "Pilot License Number:" + licenseNumber + "\n";
        item = item + "Pilot Ratings:" + rating + "\n";
        item = item + "Flight Hours:" + flightHours + "\n";

        return item;
    }



    //object Deep Copy
    public void copy(Pilot source){
        this.idNumber = source.idNumber;
        this.name = source.name;
        this.hireDate = source.hireDate;
        this.employeeType = source.employeeType;
        this.licenseNumber = source.licenseNumber;
        this.rating = source.rating;
        this.flightHours = source.flightHours;
    }

    //equals Method
    public boolean equals(Employee e){
        return (this.idNumber == e.getIdNumber());
    }


}

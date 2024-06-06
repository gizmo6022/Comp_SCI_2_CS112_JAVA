public class EmployeeManager {
    protected int length; // stores the current length of elements
    protected int maxSize; // Max Size of length
    protected Employee [] list; // array holds list of object

    //Begin Constructors-------------------------------------------------------------

    public EmployeeManager(){
        length = 0;
        maxSize = 10;
        list =  new Employee[maxSize];
    }//end default constructor

    public EmployeeManager(int size){
        length = 0; // initiates the current length at zero

        if(size <=0 ){
            System.err.println("The array must be positive");
            maxSize = 100;
        } else {
            maxSize = size;
        }
        list =  new Employee[maxSize];
    }

    public void append(Employee newEmployee){


        if (length == maxSize){
            System.err.println("Can not Append, List  Full");
        }
        else{
            list[length] = newEmployee;
            length ++;
        }
    }


    public void print(){
        int count = 0;
        while (count<length){
            System.out.println(list[count].toString());
            count++;
        }

    }

}

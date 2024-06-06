public class Person {
    private String firstName;
    private String lastName;


    //No argument constructor method
    public Person(){

    }// end no arg constructor

    //constructor
    public Person(String first, String last){
        setFirstName(first);
        setLastName(last);
    }

    public void setLastName(String name) {
        lastName = name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String name) {
        firstName = name;
    }

    public String getFirstName(){
        return firstName;
    }

    public String toString(){
        String item = "";
        item = item + "First Name: " + firstName + "\n ";
        item = item +"Last Name: " + lastName +"\n";

        return item;
    }

    public Boolean equals(Person p){
        return(firstName.equals(p.firstName) && lastName.equals(p.lastName));
    }

    public int compareTo(Person p){
        String itemOne = lastName + firstName;
        String itemTwo = p.firstName + p.lastName;
        return itemOne.compareTo(itemTwo);
    }


}

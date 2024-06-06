import javax.swing.*;
import java.awt.event.ActionListener;


//Class that creates a new Number pad
//includes an init(), add to panel in order func, and add action listener func,
public class NumPad {
   private static JButton[] numPadArray = new JButton[12];

    public NumPad() {

        //loop to create keys 0-9
        for(int i = 0; i < 10; i++ ){
            String numKey = Integer.toString(i);
            numPadArray[i] = new JButton(numKey);
        }

        //pound and Star keys
        numPadArray[10]= new JButton("*");
        numPadArray[11]= new JButton("#");

    }


    //get function
    public static JButton[] getNumPadArray() {
        return numPadArray;
    }

    //this function adds keys to the panel passed in the arguments
    // used to add keys in order in which they should appear on interface
    public static void addNumPadToPanel(JPanel panel){

        //loop to add keys 1 - 9
        for (int i = 1; i < 10; i++) {
            panel.add(numPadArray[i]);
        }

        //add "*,0,#" as found on the button of a key pad
        panel.add(numPadArray[10]);
        panel.add(numPadArray[0]);
        panel.add(numPadArray[11]);
    }


    //Add action listen function
    public void addActionListenerToArray(ActionListener x){

        for(int i = 0; i < numPadArray.length; i++) {
            this.numPadArray[i].addActionListener(x);
        }

    }
}

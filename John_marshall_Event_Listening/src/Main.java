/*
John Marshall
CSCI112 EventListening
3/24/2023
*/

import javax.swing.*;
import java.awt.*;


//Action Listeners to be defined in separate classes
public class Main {

    //main Text field, made public to be used by action listeners classes
    public static JTextField inputField = new JTextField();

    public static void main(String[] args) {

        //first JFrame ----------------------------------------------------------------
        JFrame phoneFrame = new JFrame();
        FlowLayout PhoneLayout = new FlowLayout(FlowLayout.CENTER);
        phoneFrame.setLayout(PhoneLayout);


        //Content Frame-------------------------------------------
        //Second wrapper so contents can always be center within the interface
        JPanel phoneContentsFrame = new JPanel();
        BoxLayout phoneContentsFrameLayout = new BoxLayout(phoneContentsFrame, BoxLayout.Y_AXIS);
        phoneContentsFrame.setLayout(phoneContentsFrameLayout);

        //NumPAD------------------------------------------------------------------------

        //new panel
        JPanel numPadContainer = new JPanel();
        GridLayout numPadLayout = new GridLayout(4,3);
        //numpad Gaps
        numPadLayout.setVgap(4);
        numPadLayout.setHgap(4);
        numPadContainer.setLayout(numPadLayout);

        //init num pad, assign to NumpadContainer panel, add inputEvent listener
        NumPad mainNumPad = new NumPad();
        mainNumPad.addNumPadToPanel(numPadContainer);
        mainNumPad.addActionListenerToArray(new InputEvent());

        //Call and Delete Button------------------------------------------------------------------------
        JPanel callAndDeletePanel = new JPanel();
        BoxLayout callAndDeleteLayout = new BoxLayout(callAndDeletePanel, BoxLayout.X_AXIS);
        //numpad Gaps
        numPadLayout.setVgap(4);
        numPadLayout.setHgap(4);
        callAndDeletePanel.setLayout(callAndDeleteLayout);


        //create keys
        JButton delete = new JButton("←");
        JButton call = new JButton("CALL");

        //Add to panel and add action listener
        call.addActionListener(new CallEvent());
        delete.addActionListener(new DeleteEvent());
        callAndDeletePanel.add(delete);
        callAndDeletePanel.add(call);


        //Content Adding to Main Frame----------------------------------------------------------

        //input field
        phoneContentsFrame.add(inputField);
        //spacer
        phoneContentsFrame.add(Box.createRigidArea(new Dimension(0, 20)));


        //NumberPad
        phoneContentsFrame.add(numPadContainer);
        //spacer
        phoneContentsFrame.add(Box.createRigidArea(new Dimension(0, 20)));
        //delete and call keys
        phoneContentsFrame.add(callAndDeletePanel);



        //Main Jframe adding & settings
        phoneFrame.add(phoneContentsFrame);
        phoneFrame.setTitle("SmartPhone Event Listening");
        phoneFrame.setSize(360, 620);
        phoneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        phoneFrame.setVisible(true);


    }//end main method
}//end main class
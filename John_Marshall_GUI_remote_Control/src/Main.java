/*
John Marshall
CSCI112 Universal Remote Assignment
3/20/2023
*/


import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        //first JFrame ----------------------------------------------------------------
        JFrame remoteFrame = new JFrame();
        FlowLayout remoteLayout = new FlowLayout(FlowLayout.CENTER);
        remoteFrame.setLayout(remoteLayout);


        //Contents Frame-------------------------------------------------------------------
        //Second wrapper so contents can always be center within the remoteFrame
        JPanel remoteContentsFrame = new JPanel();
        BoxLayout remoteContentsFrameLayout = new BoxLayout(remoteContentsFrame, BoxLayout.Y_AXIS);
        remoteContentsFrame.setLayout(remoteContentsFrameLayout);

        //On Button------------------------------------------------------------------------
        JPanel powerButtonContainer = new JPanel();
        FlowLayout powerButtonLayout = new FlowLayout(FlowLayout.RIGHT);
        powerButtonContainer.setLayout(powerButtonLayout);
        //radio button to show System Status
        JRadioButton powerButton = new JRadioButton("Power");
        //adding first panel to second
        powerButtonContainer.add(powerButton);

        //Input------------------------------------------------------------------------
        JPanel inputButtonContainer = new JPanel();
        FlowLayout inputButtonLayout = new FlowLayout(FlowLayout.CENTER);
        inputButtonContainer.setLayout(inputButtonLayout);

        //JCombo to show users input Options
        String[] inputs = new String[] {"HDMI1","HDMI2","HDMI3","TV","Composite"};
        JComboBox inputSelector = new JComboBox(inputs);
        inputButtonContainer.add(inputSelector);


        //Channel Buttons------------------------------------------------------------------------
        //channel Controls Double Wrapped to center buttons
        JPanel channelButtonContainer= new JPanel();
        FlowLayout channelButtonLayout = new FlowLayout(FlowLayout.CENTER);
        channelButtonContainer.setLayout(channelButtonLayout);

        //Second JPanel
        JPanel channelButtonContentsContainer = new JPanel();
        BoxLayout channelButtonContentsLayout = new BoxLayout(channelButtonContentsContainer, BoxLayout.Y_AXIS);
        channelButtonContentsContainer.setLayout(channelButtonContentsLayout);

        //Controller Buttons
        JButton channelUp = new JButton("CHNL ▲");
        JButton channelDown = new JButton("CHNL ▼");

        //adding Buttons
        channelButtonContentsContainer.add(channelUp);
        channelButtonContentsContainer.add(channelDown);
        //adding Double Panel
        channelButtonContainer.add(channelButtonContentsContainer);


        //VolumeSlider ------------------------------------------------------------------------
        //Volume Slider Double wrapped
        JPanel volumeButtonContainer = new JPanel();
        FlowLayout volumeButtonLayout = new FlowLayout(FlowLayout.CENTER);
        volumeButtonContainer.setLayout(volumeButtonLayout);

        //volume Second JPanel
        JPanel volumeButtonContentsContainer = new JPanel();
        BoxLayout  volumeButtonContentsLayout = new BoxLayout(volumeButtonContentsContainer, BoxLayout.Y_AXIS);
        volumeButtonContentsContainer.setLayout(volumeButtonContentsLayout);

        //creating volume Slider and Label
        JLabel  volumeLabel = new JLabel("Volume");
        JSlider volumeSlider = new JSlider();
        //add label&buttons to panel
        volumeButtonContentsContainer.add(volumeLabel);
        volumeButtonContentsContainer.add(volumeSlider);

        //add contents panel to wrapper panel
        volumeButtonContainer.add(volumeButtonContentsContainer);


        //Nav Buttons------------------------------------------------------------------------
        JPanel arrowButtonContainer= new JPanel();
        BorderLayout arrowButtonLayout = new BorderLayout();
        arrowButtonContainer.setLayout(arrowButtonLayout);
        //nav gaps
        arrowButtonLayout.setVgap(4);
        arrowButtonLayout.setHgap(4);

        // Creating Buttons
        JButton upArrow = new JButton("↑");
        JButton downArrow = new JButton("↓");
        JButton rightArrow = new JButton("→");
        JButton LeftArrow = new JButton("←");
        JButton enterButton = new JButton("ENTER");

        //Adding Nav Buttons
        arrowButtonContainer.add(upArrow, BorderLayout.NORTH);
        arrowButtonContainer.add(downArrow, BorderLayout.SOUTH);
        arrowButtonContainer.add(rightArrow, BorderLayout.EAST);
        arrowButtonContainer.add(LeftArrow, BorderLayout.WEST);
        arrowButtonContainer.add(enterButton, BorderLayout.CENTER);



        //NumPAD------------------------------------------------------------------------
        JPanel numPadContainer = new JPanel();
        GridLayout numPadLayout = new GridLayout(4,3);
        //numpad Gaps
        numPadLayout.setVgap(4);
        numPadLayout.setHgap(4);
        numPadContainer.setLayout(numPadLayout);

        //creating and adding numpad buttons 1-9
        for (int i = 1; i <= 9; i++){
            String label = Integer.toString(i);
            JButton numPadButton = new JButton(label);
            numPadContainer.add(numPadButton);
        }
        //creating & Add 0 and spacer for Numpad layout
        JPanel spacer1 = new JPanel();
        JButton numPad0 = new JButton("0");
        numPadContainer.add(spacer1);
        numPadContainer.add(numPad0);

        //Content Adding to Main Frame----------------------------------------------------------

        //elements being added to Contents Frame
        //spacers are "remoteContentsFrame.add(Box.createRigidArea(new Dimension(0, 20)))"

        remoteContentsFrame.add(Box.createRigidArea(new Dimension(0, 20)));
        //Power Button
        remoteContentsFrame.add(powerButtonContainer);
        remoteContentsFrame.add(Box.createRigidArea(new Dimension(0, 20)));
        //Input Selector
        remoteContentsFrame.add(inputButtonContainer);
        remoteContentsFrame.add(Box.createRigidArea(new Dimension(0, 20)));
        //Up and Down Buttons
        remoteContentsFrame.add(channelButtonContainer);
        remoteContentsFrame.add(Box.createRigidArea(new Dimension(0, 20)));
        //volume Control
        remoteContentsFrame.add(volumeButtonContainer);
        remoteContentsFrame.add(Box.createRigidArea(new Dimension(0, 20)));
        //Selectors
        remoteContentsFrame.add(arrowButtonContainer);
        remoteContentsFrame.add(Box.createRigidArea(new Dimension(0, 20)));
        //NumberPad
        remoteContentsFrame.add(numPadContainer);

        //Main Jframe adding & settings
        remoteFrame.add(remoteContentsFrame);
        remoteFrame.setTitle("Universal Remote");
        remoteFrame.setSize(360, 620);
        remoteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        remoteFrame.setVisible(true);


    }//end main func
}//end main class

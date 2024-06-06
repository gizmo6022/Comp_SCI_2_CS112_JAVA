import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this Action listener creates a new JFrame and states what number is being called
//to be used on the call button
public class CallEvent implements ActionListener {
    public void actionPerformed(ActionEvent e){

        if(!Main.inputField.getText().isBlank()) {

            //new Jframe
            JFrame CallFrame = new JFrame();
            FlowLayout remoteLayout = new FlowLayout(FlowLayout.CENTER);
            CallFrame.setLayout(remoteLayout);

            //label that displays what number is being called
            JLabel info = new JLabel("CALLING: " + Main.inputField.getText());
            CallFrame.add(info);

            //jframe attributes
            CallFrame.setTitle("Calling..");
            CallFrame.setSize(360, 620);
            CallFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CallFrame.setVisible(true);
        }


    }
}

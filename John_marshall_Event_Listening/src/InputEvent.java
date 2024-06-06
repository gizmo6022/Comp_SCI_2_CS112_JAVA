import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Action listener that adds characters to the text field\
//to be used on Num pad keys
public class InputEvent implements ActionListener {

    public void actionPerformed(ActionEvent e){
        Main.inputField.setText(Main.inputField.getText() +e.getActionCommand());
    }

}


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//This action deletes the last character in a txt field.
//to be used on the backspace button
public class DeleteEvent implements ActionListener {
    public void actionPerformed(ActionEvent e){

        //delete last character
        if (!Main.inputField.getText().isBlank())
            Main.inputField.setText(Main.inputField.getText().substring(0 ,Main.inputField.getText().length() -1 ));
    }

}

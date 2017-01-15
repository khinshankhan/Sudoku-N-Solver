//FOR INSTRUCTIONS WINDOW
import java.awt.*;
import javax.swing.*;

public class InstructionRenderer extends JPanel{
    private static final long serialVersionUID = 1L;

    //method visible only to the class to which this belongs, and any subclasses
    //will be used for the GUI aspect of Instructions
    protected void paintComponent(Graphics g){
	super.paintComponent(g);
	Instructions.objectname.repaint(g);
    }
}

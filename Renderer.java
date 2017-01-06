//importations
import java.awt.Graphics;
import javax.swing.JPanel;

//class name+ extension
public class Renderer extends JPanel{
    private static final long serialVersionUID = 1L;

    //method visible only to the class to which this belongs, and any subclasses
    //will be used for the GUI aspect of Sudoku
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Sudoku.objectname.repaint(g);
    }
}


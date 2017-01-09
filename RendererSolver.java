//THIS IS FOR THE SOLVER
//import stuffs
import java.awt.Graphics;
import javax.swing.JPanel;

//class name + extension
public class RendererSolver extends JPanel{
    private static final long serialVersionUID = 1L;

    //method visible only to the class to which this belongs, and any subclasses
    //will be used for the GUI aspect of SudokuSolver
    protected void paintComponent(Graphics g){
	super.paintComponent(g);
	SolverGUI.objectname.repaint(g);
    }
}

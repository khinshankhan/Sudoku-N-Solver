import javax.swing.*;

public class SolverBox{

    static String errorMessage = "Please enter a valid puzzle! There was at least one\nnumber repeated in a row, column, and/or box!";

    public static void main(String[] args){
	JOptionPane.showMessageDialog(null, errorMessage, "Solver Error", JOptionPane.ERROR_MESSAGE);
    }
}

    

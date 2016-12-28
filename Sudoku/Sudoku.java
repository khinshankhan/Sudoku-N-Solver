//NOTES & MESSAGES
/*
NEED TO ADD IN USER INPUT FOR SEED
 */

//importations
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

//class name+ implementations, note i like to use graphic
public class Sudoku implements ActionListener, MouseListener{

    //helps with initialization+ renderer
    public static Sudoku objectname;
    //paint component
    public Renderer renderer;
    //seed to help recreate if the user chooses, or else will be random
    static int seed;
    //controls algorithm of changing the puzzle
    private static Random randgen;
    //temp holder for swapping
    String [] temp;
    
    //for switching two rows
    public static void switchRows(String [][] a, int row1, int row2) {
	String [] temp = a[row1];
	a[row1] = a[row2]; 
	a[row2] = temp;
    }

    //for switching two columns
    public static void switchColumns(String [][] a, int column1, int column2) {
	for (int i = 0; i < a.length; i++) {
	    String temp = a[i][column1];
	    a[i][column1] = a[i][column2];
	    a[i][column2] = temp;
	}
    }

    public static void main (String [] a) {
	int x;
	x = (int) (Math.random() * 1000);
	seed = x;
	objectname = new Sudoku(seed);
	//NEED TO ADD IN USER INPUT FOR SEED
    }

//NOTES & MESSAGES
/*
NEED TO ADD IN USER INPUT FOR SEED
***work on puzzle aspect next
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

    String [] temp;
    String numVal = "";
    //Solved puzzzle that will be shuffled (idk why the commit got messed up)
    String [][] solvedPuzzle = {{"6", "1", "3", "5", "4", "2", "8", "9", "7"},
				{"8", "9", "7", "3", "6", "1", "5", "4", "2"},
	                       {"5", "4", "2", "9", "8", "7", "3", "1", "6"}, 
	                       {"4", "6", "1", "7", "3", "9", "2", "8", "5"},
	                       {"7", "5", "8", "4", "2", "6", "1", "3", "9"}, 
	                       {"3", "2", "9", "1", "5", "8", "7", "6", "4"},  
	                       {"2", "3", "6", "8", "7", "4", "9", "5", "1"}, 
	                       {"1", "7", "5", "6", "9", "3", "4", "2", "8"},
	                       {"9", "8", "4", "2", "1", "5", "6", "7", "3"}};
    
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

    //constructor
    public Sudoku(int seed){
	//assign randgen
	randgen = new Random(seed);
	
	JFrame jframe = new JFrame();
	Timer timer = new Timer(20, this);
	renderer = new Renderer();
	jframe.add(renderer);
	jframe.addMouseListener(this);
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.setSize(650, 470);
	jframe.setVisible(true);
	jframe.setResizable(false);
	timer.start();
    }

    //method to use renderer
    public void actionPerformed(ActionEvent e){
	renderer.repaint();
    }

    //method to design the GUI
    public void repaint(Graphics g) {
	//Seed display
	g.setColor(Color.black);
	Font mundane=new Font ("Arial",Font.BOLD,20);
	g.setFont(mundane);
	g.drawString("SEED", 550, 30);
	g.drawString(""+seed, 557, 50);
	//THIS IS THE SUDOKU GRID
	g.setColor(Color.white);
      	g.fillRect(0,  0,  450,  450);
	int i = 50;
	g.setColor(Color.black);
	g.fillRect(450,  0,  70, 450);
	while (i < 450){
	    g.fillRect(i, 0, 1, 450);
	    g.fillRect(0,  i, 450, 1);
	    if (i == 150 || i == 300) {
		g.fillRect(i, 0, 3, 450);
		g.fillRect(0,  i, 450, 3);
	    }
	    i += 50;
	}
	i = 15;
	int num =  1;
	g.setColor(Color.white);
	while (i < 450){
	    g.fillRect(475, i, 20, 20);
	    g.setColor(Color.black);
	    Font font = new Font("Saab", Font.BOLD, 16);
	    g.setFont(font);
	    g.drawString(num + "", 481, i+15);
	    i+=50;
	    num++;
	    g.setColor(Color.white);
	}
	//END OF JUST SUDOKU GRID
    }

    public static void main (String [] a) {
	int x;
	x = (int) (Math.random() * 1000);
	seed = x;
	objectname = new Sudoku(seed);

	//NEED TO ADD IN USER INPUT FOR SEED
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	int xcor = e.getX();
	int ycor = e.getY();
	System.out.println(xcor+","+ycor);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
    

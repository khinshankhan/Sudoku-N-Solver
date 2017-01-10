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
import java.util.Arrays; 

//class name+ implementations
public class SolverGUI implements ActionListener, MouseListener{
    //helps with initialization+ renderer
    public static SolverGUI objectname;
    //paint component
    public RendererSolver renderer;
    //JFrame for closing
    JFrame jf;
    //GUI positioning
    int centerX, centerY, x, y;
    //boolean to solve
    boolean solveNow=false;
    
    //double array for user input
    String [][] orig = new String[9][9];
    String [][] puzzle =  new String[9][9];
    String numVal = "";
  
    //constructor
    public SolverGUI(){
	//blank the vals of the puzzle
	for (int i = 0; i < 9; i++){
	    for (int j = 0; j < 9; j++){
		puzzle[i][j] = "";
	    }
	}
	//GUI
	for (int i = 0; i < 9; i++){
	    for (int j = 0; j < 9; j++){
		orig[i][j] = puzzle[i][j];
	    }
	}

	//Test Methods (terminal rn)
       	JFrame jframe = new JFrame();
	Timer timer = new Timer(20, this);
	jf=jframe;
	renderer = new RendererSolver();
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
	g.setColor(Color.black);
	Font mundane=new Font ("Arial",Font.BOLD,20);
	g.setFont(mundane);
	g.drawString("SOLVE", 550, 30); //BUTTON that checks if solvable
	g.drawString("MAIN", 550, 400);
	g.drawString("MENU", 547, 420);
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
	//User input
	g.setColor(Color.black);
	for (int k = 0; k < puzzle.length; k++) {
	    for (int j = 0; j < puzzle[0].length; j++) {
		if (orig[k][j].equals(""))
		    g.setColor(Color.cyan);
		g.drawString(puzzle[k][j]+"", 50 * j + 25, 50 * k + 25);
	        g.setColor(Color.black);
	    }
	}
	//PROBLEM HERE!!!!!!!!
	if(solveNow){
	    String [][] temp =  new String[9][9];
	    for (int a = 0; a < 9; a++){
		for (int b = 0; b < 9; b++){
		    temp[a][b] = puzzle[a][b];
		}
	    }
	    //check if solution works
	    if(SudokuSolver.canBeSolved(puzzle, 0, 0)){
		for (int a = 0; a < 9; a++){
		    for (int b = 0; b < 9; b++){
			orig[a][b] = puzzle[a][b];
		    }
		}
		//Fill in grid with solution
		g.setColor(Color.black);
		for (int k = 0; k < puzzle.length; k++) {
		    for (int j = 0; j < puzzle[0].length; j++) {
			if (orig[k][j].equals(""))
			    g.setColor(Color.cyan);
			g.drawString(puzzle[k][j]+"", 50 * j + 25, 50 * k + 25);
			g.setColor(Color.black);
		    }
		}
	    }
	    else{
		//if it didnt work (puzzle is not valid)
		for (int a = 0; a < 9; a++){
		    for (int b = 0; b < 9; b++){
			puzzle[a][b] = temp[a][b];
		    }
		}	
	    }
	    solveNow = false;
	}
		
    }
  

    public static void main (String [] a) {
	objectname = new SolverGUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	//makes it easier to use y and x coordinates
	int xcor = e.getX();
	int ycor = e.getY();
System.out.println(xcor+","+ycor);
	//User input from number pad
	if (xcor > 475 && xcor < 495 && ycor > 40 && ycor < 460 &&
	    ((ycor % 100 > 40 && ycor % 100 < 60) || (ycor % 100 < 10 || ycor % 100 > 90))){
	    numVal = (ycor + 15) / 50 + "";
	}
	if (xcor < 475){
	    x = ((xcor + 50) / 50);
	    y = ((ycor + 25) / 50);
	    centerX = 50 * x - 25;
	    centerY = 50 * y - 25;
	    if (orig[y-1][x-1].equals("")){
		puzzle[y-1][x-1] = numVal;
	    }
	}
	if(xcor >=540 && xcor<= 610 && ycor >=405 && ycor<= 445){
	    jf.dispose();
	    String[] myString = {"a"};
	    Menu.main(myString); 
	}
	if(xcor >=545 && xcor<= 620 && ycor >=35 && ycor<= 55){
	    solveNow=true;
	}
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

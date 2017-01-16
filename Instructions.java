import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Instructions implements ActionListener, MouseListener{
    //initialization for InstructionsRenderer
    public static Instructions objectname;
    //paint component
    public InstructionRenderer renderer;
    //JFrame
    JFrame jf;
    //GUI positioning
    int centerX, centerY, x, y;
    


    public Instructions(){
	//creating the window
	JFrame jframe = new JFrame("INSTRUCTIONS");
	jf = jframe;
	renderer = new InstructionRenderer();
	jframe.add(renderer);
	jframe.addMouseListener(this);
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.setSize(800, 800); //what size is best? should be smaller than
	//the menu, right?
	jframe.setVisible(true);
	jframe.setResizable(false);
    }


    //method to use renderer
    public void actionPerformed(ActionEvent e){
	renderer.repaint();
    }

    //method to design GUI
    public void repaint(Graphics g){
	//should be similar in aesthetic to Menu (that's what I'm going for)
	//with a "button" to go back to Menu
	Color background = new Color(0, 0, 0); //black
	g.setColor(background);
	g.fillRect(0, 0, 800, 800); //size reminder here

	g.setColor(Color.WHITE);
	Font titleFont = new Font("Arial", Font.BOLD, 60); //BIG
	Font smallFont = new Font("Arial", Font.BOLD, 18); //SMALL
	Font menuFont = new Font("Arial", Font.BOLD, 40); //MEDIUM
	//writing here
	g.setFont(titleFont); //for the window's header/title!
	g.drawString("INSTRUCTIONS", 170 , 70);

	g.setFont(smallFont); //for the smaller text!

	//note for separating lines:
	//Add 30 to ycor for new rule//info
	//Add 20 for newlines (because \n's apparently don't work with drawString)
	//Add 50 for new sections of text
	//I split it into sections to make it easier to read

	//GENERAL INFO	
	g.drawString("--GENERAL:", 100, 115);
	g.drawString("----Compile and run Menu.java to run the program", 100, 145);
	g.drawString("----For placing numbers, click on the number you want with the number", 100, 175);
	g.drawString("pad on the side of the Sudoku grid, then click on the grid square you", 100, 195);
	g.drawString("want to place the number in (no drag-and-drop)", 100, 215);
	g.drawString("----Directly click on words for actions (like MAIN MENU below)", 100, 245);
	g.drawString("----Note: there is no way to erase inputted values, but you can", 100, 275);
	g.drawString("overwrite them by placing new/different values there", 100, 295);

	//SUDOKU PUZZLE
	g.drawString("--SUDOKU PUZZLE:", 100, 345);
	g.drawString("----Either generate a random puzzle (by clicking directly on SUDOKU", 100, 375);
	g.drawString("PUZZLE), or click on CHOOSE SEED to input a specific integer seed", 100, 395);
	g.drawString("----When the puzzle is completed correctly, a victory message will display", 100, 425);

	//SUDOKU SOLVER
	g.drawString("--SUDOKU SOLVER:", 100, 475);
	g.drawString("----Design your own Sudoku puzzle for the program to solve", 100, 505);
	g.drawString("----A valid Sudoku puzzle is one that has no repeated numbers in each", 100, 535);
	g.drawString("row, column, or box (3x3 grid subset of the larger 9x9 Sudoku grid)", 100, 555);
	g.drawString("----Press SOLVE to see the program's solution. If your inputted puzzle", 100, 585);
	g.drawString("is invalid, the program will display an error message", 100, 605);
	//do we want to say something about uniqueness here?
       	
	//back-to-the-main-menu button
	g.setFont(menuFont);
	g.drawString("MAIN MENU", 275, 665);
    }

    //main method
    public static void main(String[] args){
	objectname = new Instructions();
    }

    @Override
    public void mouseClicked(MouseEvent e){
	//x and y absolute coords, easier to work with 
	int xcor = e.getX();
	int ycor = e.getY();
	System.out.println("" + xcor + ", " + ycor); //for testing
	
	//Need button here, with action for pressing it (should call Menu.main
	//also gonna need to approximate the coords of it
	//corners: (278, 655), (276, 682), (502, 678), (501, 654)
	String[] a = {};
	if(xcor >= 275 && xcor <= 500 && ycor >= 655 && ycor <= 680){
	    jf.dispose();
	    Menu.main(a);
	}
    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }
}
    
	
    

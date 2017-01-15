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
	jframe.setSize(500, 500); //what size is best? should be smaller than
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
	g.fillRect(0, 0, 500, 500); //size reminder here

	g.setColor(Color.WHITE);
	Font titleFont = new Font("Arial", Font.BOLD, 60); //BIG
	Font smallFont = new Font("Arial", Font.BOLD, 30); //SMALL(ER)
	
	//writing here
	g.setFont(titleFont); //for the window's header/title!
	g.drawString("INSTRUCTIONS", 25 , 60); 

	g.setFont(smallFont); //for the smaller text!
	
	
	
	
	 

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

	//Need placement of the button here, with action
	

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
    
	
    

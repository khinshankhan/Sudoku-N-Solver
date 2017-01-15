import java.awt.*;
import javax.swing.*;

public class Instructions implements ActionListener, MouseListener{
    //initialization for InstructionsRenderer
    public static Instructions objectname;
    //paint component
    public InstructionRender renderer;
    //JFrame
    Jframe jf;
    //GUI positioning
    int centerX, centerY, x, y;
    


    public Instructions(){


    }


    //method to use renderer
    public void actionPerformed(ActionEvent e){
	renderer.repaint();
    }

    //method to design GUI
    public void repaint(Graphics g){
	//should be similar in aesthetic to Menu (that's what I'm going for)
	//with a "button" to go back to Menu


    }

    //main method
    public static void main(String[] args){
	objectname = new Instructions();
    }

    @Override
    public void mouseClicked(MouseEvent e){
	//x and y absolute coords
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
    
	
    

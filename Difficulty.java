import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Difficulty implements ActionListener, MouseListener{

    public static Difficulty Difficulty;
    public Ren renderer;
    JFrame x;
    static String[] myString ={"a","","",""};
	
	public Difficulty(){
	//window
	JFrame jframe = new JFrame("DIFFICULTY");
	x=jframe;
        Timer timer = new Timer(20, this);
	renderer = new Ren();
        jframe.add(renderer);
        jframe.addMouseListener(this);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(800, 800);
        jframe.setVisible(true);
        jframe.setResizable(false);
        timer.start();
    }

    public void actionPerformed(ActionEvent e){
	renderer.repaint();
    }

    public void repaint (Graphics g){
	//Parts of Difficulty
	Color background = new Color (0, 0, 0);
	g.setColor(background); 
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.WHITE);
        Font smenu=new Font ("Arial",Font.BOLD,80);
        g.setFont(smenu);
        g.drawString("DIFFICULTY", 180, 150);
        Font mundane=new Font ("Arial",Font.BOLD,40);
        g.setFont(mundane);
	g.drawString("EASY", 375, 300);
        g.drawString("MEDIUM", 350, 400);
        g.drawString("HARD", 375, 500);
    }

    public static void main (String args []){
	Difficulty=new Difficulty();
	try{
	    myString[1]=args[1];
	}catch(Exception e){
	    myString[1]="medium";}
	try{
	    myString[2]=args[2];
	    myString[3]=args[3];
	}catch(Exception e){};
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
	int xcor=e.getX();
        int ycor=e.getY();
	System.out.println(xcor+","+ycor);
        if(xcor >=0 && xcor<= 0 && ycor >=0 && ycor<= 0){
	    myString[1]="easy";
	    x.dispose();
	    Menu.main(myString);
	}
	//solver, need to make GUI
	if(xcor >=0 && xcor<= 0&& ycor >=0 && ycor<= 0){
	    myString[1]="medium";
	    x.dispose();
	    Menu.main(myString);
	}
	//exit
	if(xcor >=0 && xcor<= 0 && ycor >=0 && ycor<= 0){
	    myString[1]="hard";
	    x.dispose();
	    Menu.main(myString);
	}
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
}

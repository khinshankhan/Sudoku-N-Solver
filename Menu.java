import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Menu implements ActionListener, MouseListener{

    public static Menu menu;
    public boolean starter =false;
    public boolean exit =false;
    public Render renderer;
    JFrame x;
    static String[] myString ={"a","","",""};
	
	public Menu(){
	//window
	JFrame jframe = new JFrame("START MENU");
	x=jframe;
        Timer timer = new Timer(20, this);
	renderer = new Render();
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
	//Parts of Menu
	Color background = new Color (0, 0, 0);
	g.setColor(background); 
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.WHITE);
        Font smenu=new Font ("Arial",Font.BOLD,80);
        g.setFont(smenu);
        g.drawString("START MENU", 180, 150);
        Font mundane=new Font ("Arial",Font.BOLD,40);
        g.setFont(mundane);
	g.drawString("SEED", 650, 250);
	g.drawString("SUDOKU PUZZLE", 250, 300);
        g.drawString("SUDOKU SOLVER", 250, 400);
        g.drawString("EXIT", 382, 500);
	//start Sudoku puzzle randomly
	if (starter) {
	    starter= false;
	    x.dispose();
	    Sudoku.main(myString);
	}
    }

    public static void main (String args []){
	menu=new Menu();
	try{
	    myString[1]=args[1];
	}catch(Exception e){};
	try{
	    myString[2]=args[2];
	    myString[3]=args[3];
	}catch(Exception e){};
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
	int xcor=e.getX();
        int ycor=e.getY();
	//System.out.println(xcor+","+ycor);
        if(xcor >=245 && xcor<= 595 && ycor >=290 && ycor<= 330){
	    starter =true;
	}
	//seeded sudoku puzzle
	if(xcor >=645 && xcor<= 765&& ycor >=240 && ycor<= 275){
	    x.dispose();
	    ChooseSeed.main(myString);
	}
	//solver, need to make GUI
	if(xcor >=245 && xcor<= 610&& ycor >=390 && ycor<= 420){
	    x.dispose();
	    SolverGUI.main(myString);
	}
	//exit
	if(xcor >=375 && xcor<= 475 && ycor >=490 && ycor<= 525){
	    System.exit(0); 
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

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
<<<<<<< HEAD
    static String[] myString ={"a","","",""};
	
	public Menu(){
=======
    static String[] myString = {"a","","",""};
    
    public Menu(){
>>>>>>> benExtra
	//window
	JFrame jframe = new JFrame("Start Menu");
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
	Font small=new Font ("Arial",Font.BOLD,20);
        g.setFont(small);
	g.drawString("SEED", 650, 300);
	g.drawString("DIFFICULTY", 620, 340);
	g.drawString("COLOR", 641, 380);
        Font mundane=new Font ("Arial",Font.BOLD,40);
	g.setFont(mundane);
	g.drawString("SUDOKU PUZZLE", 250, 300);
        g.drawString("SUDOKU SOLVER", 250, 400);
        g.drawString("INSTRUCTIONS", 275, 500);
	g.drawString("EXIT", 382, 600);
	//start Sudoku puzzle randomly
<<<<<<< HEAD
=======
	if (starter) {
	    starter= false;
	    x.dispose();
	    Sudoku.main(myString);
	}
>>>>>>> benExtra
    }

    public static void main (String args []){
	menu=new Menu();
<<<<<<< HEAD
	try{
	    myString[1]=args[1];
	}catch(Exception e){
	    myString[1]="medium";}
	try{
	    myString[2]=args[2];
	    myString[3]=args[3];
	}catch(Exception e){};
=======

	try{
	    myString[1] = args[1];
	}catch(Exception e){
	    myString[1] = "medium";
	}
	try{
	    myString[2] = args[2];
	    myString[2] = args[2];
	}catch(Exception e){};
	
	
>>>>>>> benExtra
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
	int xcor=e.getX();
        int ycor=e.getY();
	System.out.println(xcor+","+ycor);
	
        if(xcor >=245 && xcor<= 595 && ycor >=290 && ycor<= 330){
<<<<<<< HEAD
	    x.dispose();
	    Sudoku.main(myString);
=======
	    starter = true;
>>>>>>> benExtra
	}
	//seeded sudoku puzzle
	if(xcor >=650 && xcor<= 710 && ycor >=305 && ycor<= 325){
	    x.dispose();
	    ChooseSeed.main(myString);
	}
	//solver
	if(xcor >=245 && xcor<= 610&& ycor >=390 && ycor<= 420){
<<<<<<< HEAD
	    x.dispose();
	    SolverGUI.main(myString);
	}
	if(xcor >=620 && xcor<= 740 && ycor >=350 && ycor<= 365){
	    x.dispose();
	    Difficulty.main(myString);
	}
	if(xcor >=640 && xcor<= 720 && ycor >=390 && ycor<= 405){
	    x.dispose();
	    Settings.main(myString);
	}
=======
	    x.dispose();	   
	    SolverGUI.main(myString);
	}
	//instructions
	if(xcor >= 275 && xcor<= 570 && ycor >= 490 && ycor<= 517){
	    x.dispose();
	    Instructions.main(myString);
	}

>>>>>>> benExtra
	//exit
	if(xcor >= 375 && xcor <= 475 && ycor >= 590 && ycor <= 625){
	    System.exit(0);
	}
    }
    /*
618,347
737,366
640,388
719,404
    */

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

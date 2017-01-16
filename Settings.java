import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Settings implements ActionListener, MouseListener{
    public static Settings Settings;
    public R renderer;
    JFrame x;
    static String[] myString ={"a","","",""};

    public Settings(){
    //window
    JFrame jframe = new JFrame("Settings");
    x=jframe;
    Timer timer = new Timer(20, this);
    renderer = new R();
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
	//Parts of Settings
	Color background = new Color (0, 0, 0);
	g.setColor(background); 
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.WHITE);
        Font smenu=new Font ("Arial",Font.BOLD,80);
        g.setFont(smenu);
        g.drawString("COLOR SCHEMES", 70, 150);
        Font mundane=new Font ("Arial",Font.BOLD,40);
        g.setFont(mundane);
	//b&w
	g.drawString("DEFAULT", 330, 250);
	//r&g
        g.drawString("ROSES", 350, 300);
	//bl&w
        g.drawString("AQUATIC", 330, 350);
	//bl&o
	g.drawString("NICKS", 350, 400);
	//o&p
	g.drawString("LEMONADE", 310, 450);
	//pu&y
	g.drawString("THINK", 350, 500);
	//r&p
	g.drawString("HUBBA BUBBA", 280, 550);
	//r&p
	g.drawString("PANIC TO FLEE", 280, 600);
	//r&c
	g.drawString("COMPOL", 340, 650);
    }

    public static Color colors(String a){
	return Color.parseColor(a);
    }
    public static void main(String[] args){
	try{
	    myString[1]=args[1];
	}catch(Exception e){
	    myString[1]="medium";}
	try{
	    myString[2]=args[2];
	    myString[3]=args[3];
	}catch(Exception e){};
	Settings=new Settings();
    }

    @Override
    public void mouseClicked(MouseEvent e){
	int xcor=e.getX();
        int ycor=e.getY();
	System.out.println(xcor+","+ycor);
	//default
        if(xcor >=0 && xcor<= 0 && ycor >=0 && ycor<=0){
	    myString[2]="black";
	    myString[3]="white";
	    x.dispose();
	    Menu.main(myString);
	}

	/*
328,242
518,277
349,294
496,323
331,345
512,378
350,392
478,424
309,443
544,475
349,494
478,524
280,543
585,576
280,593
586,625
334,644
522,675

*/
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

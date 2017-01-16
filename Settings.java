import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.lang.reflect.Field;

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
	//y&p
	g.drawString("LEMONADE", 310, 450);
	//c&y
	g.drawString("RELAX", 350, 500);
	//r&y
	g.drawString("FLASH", 350, 550);
	//p&gr
	g.drawString("PINKU TO GURE", 270, 600);
	//r&c
	g.drawString("MARINE", 335, 650);
    }

    public static Color colors(String a){
        Color color;
	try{
	    Field field = Class.forName("java.awt.Color").getField(a);
	    color = (Color)field.get(null);
	}catch (Exception e) {
	    color = null; // Not defined
	}
	return color;
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
	//System.out.println(xcor+","+ycor);
	//default
        if(xcor >=330 && xcor<= 520 && ycor >=240 && ycor<=280){
	    myString[2]="black";
	    myString[3]="white";
	    x.dispose();
	    Menu.main(myString);
	}
	//roses
	if(xcor >=350 && xcor<= 500 && ycor >=295 && ycor<=325){
	    myString[2]="green";
	    myString[3]="red";
	    x.dispose();
	    Menu.main(myString);
	}
	//aquatic
	if(xcor >=330 && xcor<= 510 && ycor >=345 && ycor<=375){
	    myString[2]="white";
	    myString[3]="cyan";
	    x.dispose();
	    Menu.main(myString);
	}
	//nicks
	if(xcor >=350 && xcor<=475 && ycor >=390 && ycor<=425){
	    myString[2]="blue";
	    myString[3]="orange";
	    x.dispose();
	    Menu.main(myString);
	}
	//lemonade
	if(xcor >=300 && xcor<=545 && ycor >=445 && ycor<=475){
	    myString[2]="yellow";
	    myString[3]="pink";
	    x.dispose();
	    Menu.main(myString);
	}
	//relax
	if(xcor >=350 && xcor<=480 && ycor >=495 && ycor<=525){
	    myString[2]="cyan";
	    myString[3]="white";
	    x.dispose();
	    Menu.main(myString);
	}
	//flash
	if(xcor >=350 && xcor<=490 && ycor >=540 && ycor<=580){
	    myString[2]="yellow";
	    myString[3]="red";
	    x.dispose();
	    Menu.main(myString);
	}
	//p&gr
	if(xcor >=265 && xcor<=590 && ycor >=590 && ycor<=630){
	    myString[2]="pink";
	    myString[3]="lightGray";
	    x.dispose();
	    Menu.main(myString);
	}
	if(xcor >=335 && xcor<=505 && ycor >=640 && ycor<=675){
	    myString[2]="green";
	    myString[3]="cyan";
	    x.dispose();
	    Menu.main(myString);
	}

	/*
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

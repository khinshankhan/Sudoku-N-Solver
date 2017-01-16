//importations
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChooseSeed implements ActionListener{

    JFrame x;
    private Container pane;
    private JButton ok;
    private JButton cancel;
    private JLabel seed;
    private JTextField val;
    static int wherefrom;
    static String[] myString ={"a","","",""};

    public ChooseSeed(){
	JFrame jframe = new JFrame("Choose Seed");
	x=jframe;
	pane = jframe.getContentPane();
	pane.setLayout(new FlowLayout());


	jframe.setSize(370,100);
	jframe.setLocation(100,100);
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	seed = new JLabel("Seed:",null,JLabel.CENTER);
	val = new JTextField(15);
	cancel = new JButton("Cancel");
	cancel.addActionListener(this);
	cancel.setActionCommand("2");
	ok = new JButton("OK");
	ok.addActionListener(this);
	ok.setActionCommand("1");

        pane.add(seed);
        pane.add(val);
        pane.add(cancel);
	pane.add(ok);
	jframe.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
	if(e.getActionCommand().equals("1")){
	    x.dispose();
	    myString[0] = val.getText();
	    Sudoku.main(myString);
	   
	}
	if(e.getActionCommand().equals("2")){
	    x.dispose();
	    if(wherefrom>=0){
	    myString[0]=""+wherefrom;
	    Sudoku.main(myString);
	    }
	    else{
		Menu.main(myString);
	    }
	   
	}
    }
    public static void main(String[] args){
	int x;
	try {
	    x = Integer.parseInt(args[0]);
	    x %= 1000;
	}catch (Exception e){
	    x = -1;
	}
	wherefrom = x;
	try{
	    myString[1]=args[1];
	}catch(Exception e){};
	try{
	    myString[2]=args[2];
	    myString[3]=args[3];
	}catch(Exception e){};
	ChooseSeed window = new ChooseSeed();
    }
}

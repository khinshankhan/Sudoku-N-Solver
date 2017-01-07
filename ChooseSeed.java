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
	    String[] myString = {val.getText()};
	    Sudoku.main(myString);
	   
	}
    }
    public static void main(String[] a){
	ChooseSeed window = new ChooseSeed();
    }
}

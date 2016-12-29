//import stuff
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class SudokuSolver{
    private int[][] puzzle = new int[9][9]; //do we want ints or Strings?

    public SudokuSolver(){

    }

    public String toString(){ //for testing in terminal
	String ans = "\n";
	for(int i = 0; i < puzzle.length; i++){
	    if(i == 3 || i == 6){
		ans += "-----------------------\n";
	    }
	    for(int j = 0; j < puzzle[i].length; j++){
		if(j == 3 || j == 6){
		    ans += " | ";
		}
		ans += puzzle[i][j] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[] args){
	SudokuSolver a = new SudokuSolver();
	System.out.println(a);
    }
}

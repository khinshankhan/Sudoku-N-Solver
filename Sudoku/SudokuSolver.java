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
    private String[][] solvedPuzzle = {
	{"6", "1", "3", "5", "4", "2", "8", "9", "7"},
	{"8", "9", "7", "3", "6", "1", "5", "4", "2"},
	{"5", "4", "2", "9", "8", "7", "3", "1", "6"}, 
	{"4", "6", "1", "7", "3", "9", "2", "8", "5"},
	{"7", "5", "8", "4", "2", "6", "1", "3", "9"}, 
	{"3", "2", "9", "1", "5", "8", "7", "6", "4"},  
	{"2", "3", "6", "8", "7", "4", "9", "5", "1"}, 
	{"1", "7", "5", "6", "9", "3", "4", "2", "8"},
	{"9", "8", "4", "2", "1", "5", "6", "7", "3"}}; //decided on Strings

    
    public SudokuSolver(){

    }

    //BOOLEAN BACKTRACKING FUNCTION (ESSENTIAL FOR SOLVING PUZZLES)
    String[] vals = {"1","2","3","4","5","6","7","8","9"}; //for assigning values to the grid

    public static boolean canBeSolved(String[][] puzzle, int r, int c){
	//static or no?
	
	if(r == 8 && c == 8){ //breaks loop -- base case
	    return true;
	}
	
	for(int i = 1; i < vals.length + 1; i++){
	    if(noSameRow(puzzle[r], c, vals[i]) &&
	       noSameCol(puzzle, r, c, vals[i]) &&
	       noSameBox(puzzle, r, c, vals[i])){
		//set that puzzle grid spot to the value 
		puzzle[r][c] = vals[i];

		//recursive call 
		if(r == 8){//end of the row...
		    return canBeSolved(puzzle, 0, c + 1);
		}
		else{//anywhere else in the grid
		    return canBeSolved(puzzle, r + 1, c);
		}
	    }
	}
	return false;
    }

    //helper functions for recursive canBeSolved
    //checks if not any double values in same row
    public static boolean noSameRow(String[] r, int c, String thisVal){
	for(int i = 0; i < r.length; i++){
	    if(i != c && r[i].equals(thisVal)){
		return false;
	    }
	}
	return true;
    }

    //checks if not any double values in same column 
    public static boolean noSameCol(String[][] p, int r, int c, String thisVal){
	for(int i = 0; i < p.length; i++){
	    if(i != r && p[i][c].equals(thisVal)){
		return false;
	    }
	}
	return true;
    }

    //checks if not any double values in same box
    public static boolean noSameBox(String[][] p, int r, int c, String thisVal){
	//have to find the start of each box (each box 'starts' in its upper
	//left corner).
	int boxRowStart = r / 3 * 3; //either 0, 3, or 6
	int boxColStart = c / 3 * 3; //either 0, 3, or 6

	for(int row = boxRowStart; row < boxRowStart + 3; row++){
	    for(int col = boxColStart; col < boxColStart + 3; col++){
		if(!(row == r && col == c) &&
		   p[row][col].equals(thisVal)){
		    return false;
		}
	    }
	}
	return true;
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

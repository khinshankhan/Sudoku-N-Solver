/*
NOTES: 
1/5: finished algorithm (waiting for randomization bit for better tests, though)
     up next: integrate GUI, add ability to build puzzle!
1/6: RendererSolver.java created (beginning of GUI)
     GUI next!!!
     Fix bug with last value in grid
 */ 

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
import java.util.Random; //for puzzle generator

public class SudokuSolver{ //will implement ActionListener, MouseListener

    //for the renderer (RendererSolver.java)
    public static SudokuSolver objectname;
    //paint component
    public RendererSolver renderer;
 
    //decided on Strings for the puzzle
    //will have to be set to a bunch of empty Strings eventually...
    private String[][] puzzle = {
	{"6", "1", "3", "5", "4", "2", "8", "9", "7"},
	{"8", "9", "7", "3", "6", "1", "5", "4", "2"},
	{"5", "4", "2", "9", "8", "7", "3", "1", "6"}, 
	{"4", "6", "1", "7", "3", "9", "2", "8", "5"},
	{"7", "5", "8", "4", "2", "6", "1", "3", "9"}, 
	{"3", "2", "9", "1", "5", "8", "7", "6", "4"},  
	{"2", "3", "6", "8", "7", "4", "9", "5", "1"}, 
	{"1", "7", "5", "6", "9", "3", "4", "2", "8"},
	{"9", "8", "4", "2", "1", "5", "6", "7", "3"}};

    //will be updated with the "build-a-puzzle" alg + graphics!!!
    public SudokuSolver(String[][] p){
	puzzle = p; //for tests
    }

    //BOOLEAN BACKTRACKING FUNCTION (ESSENTIAL FOR SOLVING PUZZLES)

    //for assigning values to the grid
    static String[] vals = {"1","2","3","4","5","6","7","8","9"};

    public static boolean canBeSolved(String[][] puzzle, int r, int c){
	//static or no? Yah
	
	//this is the BUG
	if(r == 8 && c == 8){ //breaks loop -- base case
	    return true;
	}

	//skip over already-filled-in boxes!!!
	if(!(puzzle[r][c].equals(""))){
	    if(r == 8){//if it's the end of the row, go to the next one!
		return canBeSolved(puzzle, 0, c + 1);
	    }
	    else{//anywhere else in the grid
		return canBeSolved(puzzle, r + 1, c);
	    }
	}
	
	//where you set values
	for(int i = 1; i < vals.length + 1; i++){
	    if(noSameRow(puzzle[r], c, vals[i - 1]) &&
	       noSameCol(puzzle, r, c, vals[i - 1]) &&
	       noSameBox(puzzle, r, c, vals[i - 1])){
		//set that puzzle grid spot to the value 
		puzzle[r][c] = vals[i - 1];

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
    private static boolean noSameRow(String[] r, int c, String thisVal){
	for(int i = 0; i < r.length; i++){
	    if(i != c && r[i].equals(thisVal)){
		return false;
	    }
	}
	return true;
    }

    //checks if not any double values in same column 
    private static boolean noSameCol(String[][] p, int r, int c, String thisVal){
	for(int i = 0; i < p.length; i++){
	    if(i != r && p[i][c].equals(thisVal)){
		return false;
	    }
	}
	return true;
    }

    //checks if not any double values in same box
    private static boolean noSameBox(String[][] p, int r, int c, String thisVal){
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
		if(puzzle[i][j].equals("")){
		    ans += "  ";
		}
		else{
		    ans += puzzle[i][j] + " ";
		}
	    }		
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[] args){
	String[][] unsolvedPuzzle = {
	{"6", "1", "3", "5", "4", "2", "8", "9", "7"},
	{"8", "9", "", "3", "6", "1", "5", "4", "2"},
	{"5", "4", "2", "9", "8", "7", "3", "1", "6"}, 
	{"4", "", "1", "7", "3", "9", "2", "8", "5"},
	{"", "5", "8", "", "2", "6", "1", "3", "9"}, 
	{"3", "2", "9", "1", "5", "8", "7", "6", "4"},  
	{"2", "", "6", "", "7", "4", "9", "5", ""}, 
	{"1", "7", "5", "6", "9", "3", "4", "2", ""},
	{"9", "8", "4", "2", "1", "5", "6", "7", "3"}};// deleting a few values for a test run of canBeSolved
	SudokuSolver unsolved = new SudokuSolver(unsolvedPuzzle);
       	System.out.println(unsolved);

	canBeSolved(unsolvedPuzzle, 0, 0);
	SudokuSolver solved = new SudokuSolver(unsolvedPuzzle);
	System.out.println(solved); //should be solved now
	//update: THAT WORKS!!!
    }
}

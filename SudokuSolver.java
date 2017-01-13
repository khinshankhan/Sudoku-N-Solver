/*
NOTES: 
1/5: finished algorithm (waiting for randomization bit for better tests, though)
     up next: integrate GUI, add ability to build puzzle!
1/6: RendererSolver.java created (beginning of GUI)
     GUI next!!!
     Fix bug with last value in grid
1/7: Fixed last value bug 
     Discovered (and fixed) bug Khinshan was having in integrating the solver
     Integrated Khinshan's randomizing constructor
1/8: Keep in mind, will have to analyze inputted puzzle for faults before 
     attempting to solve, or else there will be problems with canBeSolved...
     That will necessitate another function (isValid ? or isSolvable???)
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
    //public RendererSolver renderer;
 
    //decided on Strings for the puzzle
    //will have to be set to a bunch of empty Strings eventually...
    private String[][] solvedPuzzle = {
	{"6", "1", "3", "5", "4", "2", "8", "9", "7"},
	{"8", "9", "7", "3", "6", "1", "5", "4", "2"},
	{"5", "4", "2", "9", "8", "7", "3", "1", "6"}, 
	{"4", "6", "1", "7", "3", "9", "2", "8", "5"},
	{"7", "5", "8", "4", "2", "6", "1", "3", "9"}, 
	{"3", "2", "9", "1", "5", "8", "7", "6", "4"},  
	{"2", "3", "6", "8", "7", "4", "9", "5", "1"}, 
	{"1", "7", "5", "6", "9", "3", "4", "2", "8"},
	{"9", "8", "4", "2", "1", "5", "6", "7", "3"}};

    Random randgen; //for constructor
    
    //will be updated with the "build-a-puzzle" alg + graphics!!!
    public SudokuSolver(String[][] p){
	solvedPuzzle = p; //for tests
    }

    public SudokuSolver(int seed){
    
	//assign randgen
	randgen = new Random(seed);
	int rand, rand2; //instantiation for vars used below
	
	//"BUILD-A-PUZZLE" ALGORITHM FROM KHINSHAN
	for (int i = 0; i < 5; i++){
	    rand = randgen.nextInt(9);
	    if (rand % 3 == 0){
		switchRows(solvedPuzzle, rand, 0);
	        switchRows(solvedPuzzle, rand+1, 1);
	        switchRows(solvedPuzzle, rand+2, 2);
	    }
	    if (rand % 3 == 1){
	        switchRows(solvedPuzzle, rand, 1);
	        switchRows(solvedPuzzle, rand-1, 0);
	        switchRows(solvedPuzzle, rand+1, 2);
	    }
	    if (rand % 3 == 2){
	        switchRows(solvedPuzzle, rand, 2);
	        switchRows(solvedPuzzle, rand-1, 1);
	        switchRows(solvedPuzzle, rand-2, 0);
	    }
	    rand = randgen.nextInt(9);
	    if (rand % 3 == 0){
	        switchColumns(solvedPuzzle, rand, 0);
	        switchColumns(solvedPuzzle, rand+1, 1);
	        switchColumns(solvedPuzzle, rand+2, 2);
	    }
	    if (rand % 3 == 1){
	        switchColumns(solvedPuzzle, rand, 1);
	        switchColumns(solvedPuzzle, rand-1, 0);
	        switchColumns(solvedPuzzle, rand+1, 2);
	    }
	    if (rand % 3 == 2){
		switchColumns(solvedPuzzle, rand, 2);
	        switchColumns(solvedPuzzle, rand-1, 1);
	        switchColumns(solvedPuzzle, rand-2, 0);
	    }
	}

	//blanking out the values
	for(int i = 0; i < 35; i++){ //CRUCIAL -- set number of blank spots here
	    rand = randgen.nextInt(9);
	    rand2 = randgen.nextInt(9);
	    if(solvedPuzzle[rand][rand2].equals("")){
		rand = randgen.nextInt(9);
		rand = randgen.nextInt(9);
	    }
	    solvedPuzzle[rand][rand2] = "";
	}
    }

    //helper functions for constructor randomizer
    //for switching two rows
    public static void switchRows(String [][] a, int row1, int row2) {
	String [] temp = a[row1];
	a[row1] = a[row2]; 
	a[row2] = temp;
    }

    //for switching two columns
    public static void switchColumns(String [][] a, int column1, int column2) {
	for (int i = 0; i < a.length; i++) {
	    String temp = a[i][column1];
	    a[i][column1] = a[i][column2];
	    a[i][column2] = temp;
	}
    }
    
    //BOOLEAN BACKTRACKING FUNCTION (ESSENTIAL FOR SOLVING PUZZLES)

    //for assigning values to the grid
    static String[] vals = {"1","2","3","4","5","6","7","8","9"};

    //DOES NOT ALTER THE 2D ARRAY, only returns boolean
    public static boolean isSolveable(String[][] puzzle){
	String[][] temp = new String[9][9];
	for(int i = 0; i < 9; i++){
	    for(int j = 0; j < 9; j++){
		temp[i][j] = puzzle[i][j];
	    }
	}

	return canBeSolved(temp, 0, 0);
    }

    //ALTERS THE 2D ARRAY
    public static boolean canBeSolved(String[][] puzzle, int r, int c){
	//static or no? Yah

	//isConflictGrid goes here

	
	//a separate section of code for that pesky final grid value
	if(r == 8 && c == 8 && puzzle[r][c].equals("")){ 
	    for(int i = 1; i < vals.length + 1; i++){
		if(noSameRow(puzzle[r], c, vals[i - 1]) &&
		   noSameCol(puzzle, r, c, vals[i - 1]) &&
		   noSameBox(puzzle, r, c, vals[i - 1])){
		    //set that puzzle grid spot to the value 
		    puzzle[r][c] = vals[i - 1];
		}
	    }
	    return (!puzzle[r][c].equals("")); //final case
	    //this should always return true... but not taking any chances
	}
	else if(r == 8 && c == 8){ //breaks loop -- base case
	    return true;
	}

	//skip over already-filled-in boxes!!!
	if(!(puzzle[r][c].equals(""))){
	    if(noSameRow(puzzle[r], c, puzzle[r][c]) &&
	       noSameCol(puzzle, r, c, puzzle[r][c]) &&
	       noSameBox(puzzle, r, c, puzzle[r][c])){
		//that above if statement is another check on the validity of
		//the puzzle, will make our lives easier for FINAL version if
		//not solve the bug we're dealing with right now (infinite loop)
		
		if(r == 8){//if it's the end of the row, go to the next one!
		    return canBeSolved(puzzle, 0, c + 1);
		}
		else{//anywhere else in the grid
		    return canBeSolved(puzzle, r + 1, c);
		}
	    }
	    else{
		return false;
	    }
	}
	
	//where you set values
	for(int i = 1; i < vals.length + 1; i++){
	    if(noSameRow(puzzle[r], c, vals[i - 1]) &&
	       noSameCol(puzzle, r, c, vals[i - 1]) &&
	       noSameBox(puzzle, r, c, vals[i - 1])){
		//set that puzzle grid spot to the value 
		puzzle[r][c] = vals[i - 1];

		//THIS WAS THE STUFF THAT WASN'T WORKING!!!
		//The problem was that it was stopping after one go-through.
		//Needed to add in additional boolean and erase return
		//statements in order to loop through multiple times.
		
		boolean isSolved;
		
		if(r == 8){//end of the row...
		    isSolved = canBeSolved(puzzle, 0, c + 1);
		}
		else{//anywhere else in the grid
		    isSolved = canBeSolved(puzzle, r + 1, c);
		}

		if(isSolved){
		    return true;
		}
		else{
		    puzzle[r][c] = ""; //reset for next iteration through
		}		   	
	    }
	   
	}
	return false;
    }

    //helper functions for recursive canBeSolved


    //combines all three below, eliminates need for unnecessary recursive call
    //in canBeSolved
    //true == there's a prior conflict, grid is not solveable
    //false == puzzle is valid (in that there are no blatant issues with given grid)  
  
    //sorts string arrays
    public static void insertionSort(String[] data){
	String select;
	for(int i = 1; i < data.length; i++){
	    select = data[i];
	    int check= i-1;
	    while(check >=0 && lessThan(select, data[check])){
		data[check+1]=data[check];
		check--;
	    }
	    data[check+1]=select;
	}
    }
    //compares string, less than-- helper for insertion
    public static boolean lessThan(String a, String b ){
	if(a.compareTo( b )<0)
	    return true;
	return false;
    }
    //makes temp 1d array
    public static String[] decoy(String initial[]){
	String[] copy = new String[initial.length];
	System.arraycopy( initial, 0, copy, 0, initial.length );
	return copy;
    }
    //makes temp 2d array
    public static String[][] decoy(String initial[][]){
	String copy[][]= new String[9][9];
	for (int i = 0; i < 9; i++)
	    copy[i]=decoy(initial[i]);
	return copy;
    }
    //checks if sorted has repeated, ignores blanks
    public static boolean repeated(String b []){
	String [] a = decoy(b);
	insertionSort(a);
	for(int j=1; j<a.length ; j++){
	    int i;
	    i=j-1;
	    if(!(a[i].equals("") ||a[j].equals("")) && a[i].equals(a[j]))
		return true;
	}
	return false;
    }
    //BOOLEAN METHOD TO CHECK IF ANY BASIC ERRORS IN SUDOKU GRID
    public static boolean valid(String a[][]){
	String row[][]=convertToRow(a);
	String col [][]=convertToCol(a);
	String box[][]=convertToBox(a);
	for(int i=0; i<9; i++){
	    if(repeated(row[i])||repeated(col[i])||repeated(box[i]))
		return false;
	}
	return true;
    }
    //get rows of original as rows
    public static String[][] convertToRow(String a[][]){
	String converted[][]=decoy(a);
	return converted;
    }
	//get columns of original as rows
    public static String[][] convertToCol(String a[][]){
	String converted[][]=new String[9][9];
	for(int j=0; j<9; j++){
	    int i=0;
	    while(i<9){
		converted[i][j]=a[j][i];
		    i++;
	    }
	}
	return converted;
    }
    public static String[][] convertToBox(String a[][]){
	String converted[][]=new String[9][9];
	//using boxToArray to fill in converted:
	converted[0] = boxToArray(a, 0, 0);
	converted[1] = boxToArray(a, 3, 0);
	converted[2] = boxToArray(a, 6, 0);
	converted[3] = boxToArray(a, 0, 3);
	converted[4] = boxToArray(a, 3, 3);
	converted[5] = boxToArray(a, 6, 3);
	converted[6] = boxToArray(a, 0, 6);
	converted[7] = boxToArray(a, 3, 6);
	converted[8] = boxToArray(a, 6, 6);
	
	return converted;
    }

    //converts one box to a 1D String array
    //startR, startC must be either 0, 3, or 6
    public static String[] boxToArray(String[][] a, int startR, int startC){
	String[] ans = new String[9];
	int counter = 0;
	
	for(int r = startR; r < startR + 3; r++){
	    for(int c = startC; c < startC + 3; c++){
		ans[counter] = a[r][c];
		counter++;
	    }
	}

	return ans;
    }
       
    
    



    

	
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
	for(int i = 0; i < solvedPuzzle.length; i++){
	    if(i == 3 || i == 6){
		ans += "-----------------------\n";
	    }
	    for(int j = 0; j < solvedPuzzle[i].length; j++){
		if(j == 3 || j == 6){
		    ans += " | ";
		}
		if(solvedPuzzle[i][j].equals("")){
		    ans += "  ";
		}
		else{
		    ans += solvedPuzzle[i][j] + " ";
		}
	    }		
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[] args){
	/*String[][] unsolvedPuzzle = {
	{"6", "1", "3", "5", "4", "2", "8", "9", "7"},
	{"8", "9", "", "3", "6", "1", "5", "4", "2"},
	{"5", "4", "2", "9", "8", "7", "3", "1", "6"}, 
	{"4", "", "1", "7", "3", "9", "2", "8", "5"},
	{"", "5", "8", "", "2", "6", "1", "3", "9"}, 
	{"3", "2", "9", "1", "5", "8", "7", "6", "4"},  
	{"2", "", "6", "", "7", "4", "9", "5", ""}, 
	{"1", "7", "5", "6", "9", "3", "4", "2", ""},
	{"9", "8", "4", "2", "1", "5", "6", "7", ""}};// deleting a few values for a test run of canBeSolved
	
	SudokuSolver unsolved = new SudokuSolver(unsolvedPuzzle);//random
       	System.out.println(unsolved);

	canBeSolved(unsolved, 0, 0);
	SudokuSolver solved = new SudokuSolver(unsolvedPuzzle);
	System.out.println(solved); //should be solved now
	//update: THAT WORKS!!!
	//...no longer needed with Khinshan's constructor now incorporated
	*/
	/*
	SudokuSolver withRandomTest = new SudokuSolver(218);//random
       	System.out.println(withRandomTest);

	canBeSolved(withRandomTest.solvedPuzzle, 0, 0);
	
	System.out.println(withRandomTest); //should be solved now
	//update: THAT WORKS!!!
	*/
	/*
	String[][] brokenPuzzle = {
	{"1", "1", "3", "5", "4", "2", "8", "9", "7"},
	{"8", "9", "", "3", "6", "1", "5", "4", "2"},
	{"5", "4", "2", "9", "8", "7", "3", "1", "6"}, 
	{"4", "", "1", "7", "3", "9", "2", "8", "5"},
	{"", "5", "8", "", "2", "6", "1", "3", "9"}, 
	{"3", "2", "9", "1", "5", "8", "7", "6", "4"},  
	{"2", "", "6", "", "7", "4", "9", "5", ""}, 
	{"1", "7", "5", "6", "9", "3", "4", "2", ""},
	{"9", "8", "4", "2", "1", "5", "6", "7", ""}};//broken puzzle, two 1's in first box/column/row.

	SudokuSolver broken = new SudokuSolver(brokenPuzzle);
	System.out.println(broken);

	canBeSolved(brokenPuzzle, 0, 0);
	SudokuSolver stillBroken = new SudokuSolver(brokenPuzzle);
	System.out.println(stillBroken);
	System.out.println(isSolveable(brokenPuzzle));//discovered that it won't return false on blatantly invalid puzzles... this should be a quick fix.
	//IT WORKS!!!
	*/ 

	//testing for boxToArray and convertToBox
	String[][] unsolvedPuzzle = {
	{"6", "1", "3", "5", "4", "2", "8", "9", "7"},
	{"8", "9", "", "3", "6", "1", "5", "4", "2"},
	{"5", "4", "2", "9", "8", "7", "3", "1", "6"}, 
	{"4", "", "1", "7", "3", "9", "2", "8", "5"},
	{"", "5", "8", "", "2", "6", "1", "3", "9"}, 
	{"3", "2", "9", "1", "5", "8", "7", "6", "4"},  
	{"2", "", "6", "", "7", "4", "9", "5", ""}, 
	{"1", "7", "5", "6", "9", "3", "4", "2", ""},
	{"9", "8", "4", "2", "1", "5", "6", "7", ""}};
	
	SudokuSolver normal = new SudokuSolver(unsolvedPuzzle);
	System.out.println(normal);

	SudokuSolver boxed = new SudokuSolver(convertToBox(unsolvedPuzzle));
	System.out.println(boxed);
	//works!!! (boxes are now the rows)
    }
}

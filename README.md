# APCS1_Final_Project
Final Project Repo for K

Team Name:KhanStein-tinovich’s Sudoku

Team Members: Khinshan Khan, Ben Weinstein

Period: 9

Project Title: Sudoku

Project Description: This is a Sudoku puzzle generator and a Sudoku puzzle solver. A Sudoku puzzle is a game in which users insert the numbers one through nine into a 9x9 table of squares, in such a way that every number appears in each row, column, and 3x3 box only once. Our Sudoku puzzle generator creates puzzles for the user to solve (you can choose a seed or have it generate a puzzle randomly). Our solver solves puzzles that the user creates. 

IMPORTANT NOTES:
  1. Use on a Java 8 machine with either Windows or Mac OS (Linux works, but not as well -- the positioning of the GUI gets messed up --, Mac OS and Windows work best). The program will NOT work with Java 7.
  2. Compile Menu.java and run Menu to run our program. 
  3. You DIRECTLY click words for actions. Ex: the start menu (Menu.java) has the words "SUDOKU PUZZLE," "SUDOKU SOLVER," "INSTRUCTIONS," etc. Click on each to access that part of the program. 
  4. In the main menu, click on "INSTRUCTIONS" to see more-specific information for each game mode. 
  4. The larger the screen, the more ideal
  
WORKING FEATURES / THINGS FOR MR. K TO TEST:
  1. The puzzle generator will give the user a random puzzle or one of a specific seed -- press "CHOOSE SEED" to the right of the "SUDOKU SOLVER" button on the main menu to enter a seed. 
  2. Once the puzzle is generated, the user can enter numbers into the grid using the number pad to the right of the puzzle. (NOTE: click on a number on the number pad, THEN on the grid square you want to place it into. NO dragging-and-dropping). When the puzzle is correctly filled in, a victory message will display.
  3. The user can tweak the difficulty of the generated puzzle by clicking on "DIFFICULTY" on the main menu, and selecting either "EASY," "MEDIUM," or "HARD." The difficulty affects the number of grid squares already filled in on a generated puzzle. The default difficulty is medium.
  4. The Sudoku solver gives the user a blank Sudoku grid where the user can fill in the grid with a Sudoku puzzle the program will solve.  When the user presses "SOLVE" after inputting a puzzle, the program will either fill in the rest of the puzzle with the correct answers, or display a message if the given puzzle is not solvable. 
  5. The "INSTRUCTIONS" button on the main menu displays information about the project (similar to this list of features). 
  6. The "COLORS" button on the main menu gives the user the option to choose a fun, lightheartedly-named color theme for the Sudoku grid if the original black-and-white is a little grating on the eyes :) .
  
UNRESOLVED BUGS / UNIMPLEMENTED FEATURES:
  1. If you switch through a lot of different windows (~10) in one session (i.e. without exiting the program and then re-running Menu.java), the program starts to get a little laggy. The program will still be able to run in less than a second, though. It would take going through over 1000 windows in one session before a normal user would start noticing runtime severely slowing down. 
  2. The Sudoku solver does not check for the uniqueness of an inputted puzzle. (Sudoku puzzles are supposed to only be 'valid' if they don't have any conflicts with repeated numbers in rows, columns, and 3x3 boxes, AND have exactly one solution; our program only checks the conflicts, not the uniqueness.) 
  3. When inputting numbers on the Sudoku grid, there is no 'erase' or 'clear' button. However, you can overwrite whatever you placed in the grid by replacing it with another number.
  

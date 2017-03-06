import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private int[][] start;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename)throws FileNotFoundException, Exception{
        //COMPLETE CONSTRUCTOR
	animate = false;
	try{
	    getMaze(filename);
	}catch (FileNotFoundException e){
	    throw new FileNotFoundException(": " + filename);
	}
	if (!isMaze()){
	    throw new Exception("Is not a Maze");
	}
    }

    private void getMaze(String file)throws FileNotFoundException{
	File x = new File(file);
	Scanner lines = new Scanner(x);
	int r = 0;
	while (lines.hasNext()){
	    lines.nextLine().toCharArray();
	    r ++;
	}
	maze = new char[r][];
	Scanner lines2 = new Scanner(x);
	for (int i = 0; i < r; i ++){
	    maze[i] = lines2.nextLine().toCharArray();
	}
    }

    private boolean isMaze(){
	int eCount = 0;
	int sCount = 0;
	start = new int[2][1];
	for (int r = 0; r < maze.length; r ++){
	    for (int c = 0; c < maze[r].length; c ++){
		if (!checkChars(r,c)) return false;
		if (maze[r][c] == 'E') eCount ++;
		if (maze[r][c] == 'S'){sCount ++;
		    start[0][0] = r;
		    start[1][0] = c;
		}
	    }
	}
	return eCount == 1 && sCount == 1;
    }
    
    private boolean checkChars(int r, int c){
	return maze[r][c] == ' ' ||
	       maze[r][c] == '#' ||
	       maze[r][c] == 'E' ||
	       maze[r][c] == 'S';
    }
    
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
        Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;
            //Initialize starting row and startint col with the location of the S.
	    startr = start[0][0];
	    startc = start[1][0];
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int r, int c){
	//if you get anything other than E or a space, you stop
	if(maze[r][c] == '#' ||
	   maze[r][c] == '.' ||
	   maze[r][c] == '@') return false;

	
	if(animate) printMaze();
	//if you get to E, you're done
	if(maze[r][c] == 'E') return true;


	//only thing left is a space
	maze[r][c] = '@';
	//goes through the 4 surrounding squares
	if      (solve(r + 1, c)){
	    return true;
	}else if(solve(r - 1, c)){
	    return true;
	}else if(solve(r    , c + 1)){
	    return true;
	}else if(solve(r    , c - 1)){
	    return true;
	}


	
	//none of the surrounding squares lead to a solution so this is a dead end
	maze[r][c] = '.';
	if(animate) printMaze();
        return false; //so it compiles
    }
    

    public void printMaze(){
	clearTerminal();
	p(toString());
	wait(20);
    }
    public void p(String s){
	System.out.println(s);
    }
    public void p(int i){
	p(i + "");
    }
    
    public String toString(){
	String ans = "";
	for(    int row = 0; row < maze.length; row ++){
	    for(int col = 0; col < maze[row].length; col ++){
		if (maze[row][col] == '@'){
		    ans = ans + "\033[0;40;35m" + maze[row][col] + "\033[0;40;37m";
		}else ans += maze[row][col];
	    }
	    ans += "\n";
	}
    	return ans;
    }
    
}

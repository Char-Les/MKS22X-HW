//does up to 13 relatively fast for count solutions
//does up to 28 relatively fast for solve
public class QueenBoard{
    private boolean[][] board;
    private int count;
    private int[] queens;

    public QueenBoard(int size){
	//initializes all the variables
        count = -1;
	//used to help print the board
	board = new boolean[size][size];
	//used to keep track of queens (only one queen per row so this notation works)
	queens = new int[size];
    }

    //looks for the first solution
    public boolean solve(){
	boolean a = solveH(0);
	//if there is no solution then it clears the board;
	if (!a){
	    clearB();
	}else{
	    //updates the board otherwise as I use queens in my functions
	    update();
	}
	//returns whatever solveH gave
	return a;
    }

    //helper function for solve()
    private boolean solveH(int row){
	//if it was safe to get to this condition then it means that the entire board is safe
	if(row == queens.length)
	    return true;
	//otherwise goes through the possible combinations row by row
	//this for loop checks if any of the positions in this row is safe
        for(;queens[row] < queens.length ; queens[row] = queens[row] + 1){
	    //erases any previous tamperings with the next row
	    clearR(row);
	    //if it is a safe spot it checks the next row
	    if(isSafe(row)){
		//doesn't return because if it's false it would stop the function
		if( solveH(row + 1) )
		    return true;
	    }
	}
	//bad end if it leaves the loop
	//corrects the last ++ from the for loop so it doesn't mess with the other cases
	queens[row] -= 1;
	return false;
    }

    

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */

    private boolean isSafe(int row){
	//checks above, and diagonally for the queens
	//starts one row above to avoid checking itself
	int col  = queens[row]    ;
	int col1 = queens[row] + 1;
	int col2 = queens[row] - 1;
	row --;
	//if it finds a queen in any of the spots, it isn't safe
	for(;row >= 0; row --){
	    if(queens[row] == col || queens[row] == col1 || queens[row] == col2){
		return false;
	    }
	    col1 ++;
	    col2 --;
	}
	//if it passes the checks, then it's safe
	return true;
    }

    //runs through much like the first helper
    private void solveH2(int row){
	//when it reaches a solution it adds one and ends the branch
	if(row == queens.length){
	    count ++;
	    return;
	}
        for(;queens[row] < queens.length ; queens[row] = queens[row] + 1){
	    clearR(row);
	    //if it finds a safe spot it starts a new branch for the next row
	    if(isSafe(row)){
		solveH2(row + 1);		    
	    }
	}
	//fixes any issues with branches that don't produce a solution like solveH
	queens[row] -= 1;
    }

    //just calls the above helper function
    public void countSolutions(){
	clear();
	count = 0;
	solveH2(0);
    }
    
    public int getSolutionCount(){
        return count;
    }

    //clears queens (don't think I used it)
    private void clear(){
	for(int i = 0; i < queens.length; i++){
	    queens[i] = 0;
	}
    }

    //clears the board so that it can update properly
    private void clearB(){
	for(int row = 0; row < board.length; row ++){
	    for(int col = 0; col < board.length; col ++){
		board[row][col] = true;
	    }
	}
    }

    //clears any rows after given row to help avoid previous tamperings
    private void clearR(int row){
	for(row ++; row < queens.length; row ++){
	    queens[row] = 0;
	}
    }

    //pastes Q's based on the queens array
    private void update(){
	//refreshes the board
	clearB();
	for(int i = 0; i < queens.length ; i ++){
	    board[i][queens[i]] = false;
	}
    }
    
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    
    public String toString(){
	//queens is the one constantly changing so this updates the board, which is what we print out
	update();
	//creates a string version of the board
	String ans = "";
	for(    int row = 0; row < board.length; row ++){
	    for(int col = 0; col < board.length; col ++){
		if (board[row][col]){
		    ans += " _";
		}else{
		    ans += " Q";
		}
	    }
	    ans += "\n";
	}
    	return ans;
    }

    //lazy print functions
    public void p(String s){
	System.out.println(s);
    }
    public void p(int i){
	p(i + "");
    }
    //limitied testing i did
    public static void main(String[] args){
	QueenBoard x = new QueenBoard(5);
	if (args.length != 0)
	    x = new QueenBoard(Integer.parseInt(args[0]));
	x.solve();
	x.p(x.toString());
	x.countSolutions();
	x.p(x.getSolutionCount());
    }
}

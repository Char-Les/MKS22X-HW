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
	update();
	return a;
    }

    private boolean solveH(int row){
	if(row == queens.length)
	    return true;
        for(;queens[row] < queens.length ; queens[row] = queens[row] + 1){
	    clearR(row);
	    if(isSafe(row)){
		if( solveH(row + 1) )
		    return true;
	    }
	}
	queens[row] -= 1;
	return false;
    }

    

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */

    private boolean isSafe(int row){
	int col  = queens[row]    ;
	int col1 = queens[row] + 1;
	int col2 = queens[row] - 1;
	row --;
	
	for(;row >= 0; row --){
	    if(queens[row] == col || queens[row] == col1 || queens[row] == col2){
		return false;
	    }
	    col1 ++;
	    col2 --;
	}
	
	return true;
    }

    private void push(){
	if(solve()){
	    count ++;
	}
	queens[queens.length - 1] += 1;
	push();
    }
    
    public int getSolutionCount(){
	clear();
	push();
	if (count == 0)
	    return -1;
	return count;
    }


    private void clear(){
	for(int i = 0; i < queens.length; i++){
	    queens[i] = 0;
	}
    }

    private void clearB(){
	for(int row = 0; row < board.length; row ++){
	    for(int col = 0; col < board.length; col ++){
		board[row][col] = true;
	    }
	}
    }

    private void clearR(int row){
	for(row ++; row < queens.length; row ++){
	    queens[row] = 0;
	}
    }

    private void update(){
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
	update();
	String ans = "";
	for(    int row = 0; row < board.length; row ++){
	    for(int col = 0; col < board.length; col ++){
		if (board[row][col]){
		    ans += " X";
		}else{
		    ans += " Q";
		}
	    }
	    ans += "\n";
	}
    	return ans;
    }

    public void p(String s){
	System.out.println(s);
    }
    public void p(int i){
	p(i + "");
    }
    public static void main(String[] args){
	QueenBoard x = new QueenBoard(5);
	if (args.length != 0)
	    x = new QueenBoard(Integer.parseInt(args[1]));
	x.solve();
	x.p(x.toString());
	//x.getSolutionCount();
    }
}

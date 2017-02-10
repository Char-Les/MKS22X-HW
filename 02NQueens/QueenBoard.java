public class QueenBoard{
    private boolean[][] board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new boolean[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve(){
	for(int i = 0; i < board.length; i ++){
	    if (!solveH(i)){
		return false;
	    }
	}
    }

    private boolean solveH(int row){
	for(int )
	
	return false;
    }

    

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */

    private boolean isSafe(int row, int col){
	int col1 = col;
	int col2 = col;
	try{
	    for(int i = row; i >= 0; i --){
		if(board[row][col]){
		    return false;
		}
	    }
	}catch(IndexOutOfBoundsException e){}

	try{
	    for(int i = row; i >= 0; i --){
		col1--;
		if(board[row][col1]){
		    return false;
		}
	    }
	}catch(IndexOutOfBoundsException e){}

	try{
	    for(int i = row; i >= 0; i --){
		col1++;
		if(board[row][col1]){
		    return false;
		}
	    }
	}catch(IndexOutOfBoundsException e){}
	return true;
    }

    public int getSolutionCount(){
	while (solveH(x)){
	    
	}

    	return -1;
    }


    private void clearRow(int row){
	for(int i = 0; i < board[0].length; ){
	    board[row][i] = false;
	}
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	return "";
    }
}

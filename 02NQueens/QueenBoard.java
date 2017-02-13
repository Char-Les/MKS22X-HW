public class QueenBoard{
    private boolean[][] board;
    private int solutionCount;
    private int[] queens;

    public QueenBoard(int size){
	//false -> queen
	board = new boolean[size][size];
	queens = new int[size];
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
	clear();
	return solveH(0);
    }

    private boolean solveH(int row){
	p(row);
	for(int i = queens[row]; i < queens.length; i ++){
	    clearRow(row);
	    queens[row] = i;
	    board[row][i] = false;
	    if(isSafe(row, i) && row < queens.length - 1){
		p(12312);
		if (solveH(row + 1))
		    return true;
	    }
	}
	
	return false;
    }

    

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */

    private boolean isSafe(int row, int col){
	int col1 = col + 1;
	int col2 = col - 1;
	row --;
	try{
	    for(int i = row; i >= 0; i --){
		if(!board[row][col]){
		    return false;
		}
	    }
	}catch(IndexOutOfBoundsException e){}

	try{
	    for(int i = row; i >= 0; i --){
		col1--;
		if(!board[row][col1]){
		    return false;
		}
	    }
	}catch(IndexOutOfBoundsException e){}

	try{
	    for(int i = row; i >= 0; i --){
		col1++;
		if(!board[row][col1]){
		    return false;
		}
	    }
	}catch(IndexOutOfBoundsException e){}
	return true;
    }

    public int getSolutionCount(){
	while (solveH(3)){
	    
	}

    	return -1;
    }


    public void clear(){
	for(int i = 0; i <board.length; i++){
	    clearRow(i);
	}
    }
    private void clearRow(int row){
	for(int i = 0; i < board[0].length; i ++){
	    board[row][i] = true;
	}
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String ans = "";
	for(    int row = 0; row < board.length; row ++){
	    for(int col = 0; col < board.length; col ++){
		if (board[row][col]){
		    ans += " X";
		}else{
		    ans += " O";
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
	QueenBoard x = new QueenBoard(4);
	x.solve();
	x.p(x.toString());
    }
}

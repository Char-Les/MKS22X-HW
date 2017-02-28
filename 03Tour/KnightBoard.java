import java.util.*;

public class KnightBoard{
    //keeps track of board
    int[][] board;
    //max count should go up to
    int countMax;
    
    public KnightBoard(int r,int c)throws Exception{
	//stops invalid boards
	if (r == 0 || c == 0){
	    throw new Exception("Invalid Dimensions: " + r + " by " + c);
	}
	//initializes board
	board = new int[r][c];
	//finds the max count
	countMax = board.length * board[0].length;
    }

    //main solve method
    public void solve(){
	//runs the helper
	//if not true then there are no solutions starting at the corner (K said we don't need to worry about other starting positions)
	if (!solveH(0,0, 1))
	    p("No Solution");
    }

    //recursive function for solving the tour
    private boolean solveH(int r, int c, int count){
	//if you reach the max count you're done
	if(count == countMax){
	    //still haven't filled out the last square though
	    board[r][c] = count;
	    return true;
	}
	//2D array of the valid spots returns a int[2][] where the first row is the y cor and the second row is x cor
	int[][] places = spots(r,c);
	//if there are no valid spots then this route fails
	if(places[0].length == 0)
	    return false;
	//keeps track of the counting in case this route fails
	int temp = board[r][c];
	board[r][c] = count;
	//loops through possible further moves
	for(int i = 0; i < places[0].length; i ++){
	    //if the spot returns true, you're done; else you keep going
	    if (solveH(places[0][i], places[1][i], count + 1)){
		return true;
	    }
	}
	//none of the routes from this spot are valid -> go back
	board[r][c] = temp;
	return false;
    }

    

    //2 rows; row 1 -> row coord; row 2 -> col coord
    public int[][] spots(int r, int c){
	//checks in the 8 directions whether or not its a valid move
	ArrayList<Integer> row = new ArrayList<Integer>();
	ArrayList<Integer> col = new ArrayList<Integer>();
	if (check(r + 2, c + 1)){
	    row.add(r+2);
	    col.add(c+1);
	}
	
	if (check(r + 2, c - 1)){
	    row.add(r+2);
	    col.add(c-1);
	}
	if (check(r - 2, c + 1)){
	    row.add(r-2);
	    col.add(c+1);
	}
	
	if (check(r - 2, c - 1)){
	    row.add(r-2);
	    col.add(c-1);
	}
	if (check(r + 1, c + 2)){
	    row.add(r+1);
	    col.add(c+2);
	}
	
	if (check(r + 1, c - 2)){
	    row.add(r+1);
	    col.add(c-2);
	}
	if (check(r - 1, c + 2)){
	    row.add(r-1);
	    col.add(c+2);
	}
	
	if (check(r - 1, c - 2)){
	    row.add(r-1);
	    col.add(c-2);
	}
	Object[][] ans = new Object[2][];
	//removes excess spots in the array
	row.trimToSize();
	col.trimToSize();
	ans[0]= row.toArray();
	ans[1]= col.toArray();
	//returns the 2D array
	return intArray(ans);
    }

    //converts the Object Array from ArrayList's toString to a int[][] (shouldn't ever be a casting error)
    private int[][] intArray(Object[][] x){
	int[][] ans = new int[2][x[0].length];
	for (int r = 0; r < x.length; r ++){
	    for (int c = 0; c < x[0].length; c ++){
		Integer temp = (Integer)x[r][c];
		ans[r][c] = temp.intValue();
	    }
	}
	return ans;
    }

    //helper for spots(int,int) for checking possible spots
    private boolean check(int r, int c){
	//within range
	return r >= 0 && r < board.length && 
	       c >= 0 && c < board[0].length && 
	    //valid spot to move to
	       board[r][c] == 0;
    } 
	
    //prints out the board
    //blank if you never called solve or when there is no solution
    public String toString(){
	return stringify(board);
    }

    //retursn the string version of a 2D array
    public String stringify(int[][] x){
	String ans = "";
	for(    int row = 0; row < x.length; row ++){
	    for(int col = 0; col < x[0].length; col ++){
		if (x[row][col] > 9){
		    ans += " " + x[row][col];
		}else{
		    ans += " _" + x[row][col];
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
    
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public static void main(String[] args){
	KnightBoard x;
	try{
	    x = new KnightBoard(5, 4);
	    if (args.length > 1)
		x = new KnightBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	    x.solve();
	    x.p(x.toString());
	}catch (Exception e){
	    System.out.println(e.toString());
	}	

    }
}

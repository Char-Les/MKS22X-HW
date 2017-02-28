import java.util.*;

public class KnightBoard{
    int[][] board;
    int countMax;
    
    public KnightBoard(int r,int c)throws Exception{
	if (r == 0 || c == 0){
	    throw new Exception("Invalid Dimensions: " + r + " by " + c);
	}
	board = new int[r][c];
	countMax = board.length * board[0].length;
    }
    
    public void solve(){
	if (!solveH(0,0, 1))
	    p("No Solution");
    }
    
    private boolean solveH(int r, int c, int count){
	if(count == countMax){
	    board[r][c] = count;
	    return true;
	}
	//wait(20);
	int[][] places = spots(r,c);
	//p(r + "   " + c);
	int temp = board[r][c];
	board[r][c] = count;
	//p(this.toString());
	//p(stringify(places));
	if(places[0].length == 0){
	    board[r][c] = temp;
	    return false;
	}
	for(int i = 0; i < places[0].length; i ++){
	    //p(count + "   " + places[0].length + "   " + i);
	    if (solveH(places[0][i], places[1][i], count + 1)){
		return true;
	    }
	}
	board[r][c] = temp;
	return false;
    }

    

    //2 rows; row 1 -> row coord; row 2 -> col coord
    public int[][] spots(int r, int c){
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
	row.trimToSize();
	col.trimToSize();
	ans[0]= row.toArray();
	ans[1]= col.toArray();
	return intArray(ans);
    }
    
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
    private boolean check(int r, int c){
	//within range
	return r >= 0 && r < board.length && 
	       c >= 0 && c < board[0].length && 
	    //valid spot to move to
	       board[r][c] == 0;
    } 
	
    
    //blank if you never called solve or when there is no solution
    public String toString(){
	return stringify(board);
    }

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
    private void wait(int millis){ //ADDED SORRY!
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

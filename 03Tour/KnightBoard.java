import java.util.*;

public class KnightBoard{
    int[][] board;
    
    public KnightBoard(int r,int c){
	board = new int[r][c];
    }
    
    public void solve(){
	solveloop(0, 0);
    }
    
    private void solveloop(int r, int c){
	//clear;
	if(solveH(r, c, 0)){
	    return;
	}
	if(c == board[0].length - 1)
	    solveloop(r + 1, 0);
	solveloop(r, c +1);
    }
    
    private boolean solveH(int r, int c, int count){
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
	return r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 0
;
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

    public static void main(String[] args){
	KnightBoard x = new KnightBoard(7, 7);
	if (args.length > 2)
	    x = new KnightBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	x.p(x.stringify(x.spots(0,0)));
	
	

    }
}

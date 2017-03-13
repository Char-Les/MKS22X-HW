import java.util.*;
import java.io.*;

public class Travel{
    int[][][] board;
    int[][] cords;
    int moves;
    
    public Travel(String filename) throws FileNotFoundException{
	//access the file
	File text= new File(filename);
	Scanner data= new Scanner(text);

	//first line
	Scanner first = new Scanner(data.nextLine());
	board = new int[2][first.nextInt()][first.nextInt()];
	moves = first.nextInt();
	first.close();
	
	//gets the board
	for(int r = 0; r < board[0].length; r++){
	    String line = data.nextLine();
	    for(int c = 0; c < board[0][r].length; c++){
		if(line.charAt(c) == '.'){
		    board[0][r][c] = 0;
		    board[1][r][c] = 0;
		}else if(line.charAt(c) == '*'){
		    board[0][r][c] = -1;
		    board[1][r][c] = -1;
		}
	    }
	}

	//gets starting and ending cords
	Scanner last = new Scanner(data.nextLine());
	//row 0 is start row 1 is end
	cords = new int[2][2];
	cords[0][0] = last.nextInt() - 1;
	cords[0][1] = last.nextInt() - 1;
	cords[1][0] = last.nextInt() - 1;
	cords[1][1] = last.nextInt() - 1;
	
	last.close();
	data.close();
    }



    public int solve(){
	board[0][cords[0][0]][cords[0][1]] = 1;
	for(int i = 0; i < moves; i ++){
	    advance(i % 2, (i + 1) % 2);
	}
	return board[moves % 2][cords[1][0]][cords[1][1]];
    }

    //advances the board to next state
    private void advance(int old, int neww){
	clear(neww);
	for     (int r = 0; r < board[old].length; r ++){
	    for (int c = 0; c < board[old][r].length; c ++){
		if (board[old][r][c] != -1)
		    Oplus(old, neww, r,c);
	    }
	}


    }
    
    //clears level
    private void clear(int level){
	for     (int r = 0; r < board[level].length; r ++){
	    for (int c = 0; c < board[level][r].length; c ++){
		if (board[level][r][c] != -1) board[level][r][c] = 0;
	    }
	}
    }

    //addes to the four surrounding squares on the new level
    private void Oplus(int old, int neww, int r, int c){
	int x = board[old][r][c];
	if (x == 0 || x == -1) return;
	plus(x, neww, r + 1, c    );
	plus(x, neww, r - 1, c    );
	plus(x, neww, r    , c + 1);
	plus(x, neww, r    , c - 1);
    }
    
    //adds amount to corresponding place
    private void plus(int amount, int neww, int r, int c){
	if (r < 0 || r >= board[neww].length ||
	    c < 0 || c >= board[neww][r].length)
	    return;
	if (board[neww][r][c] == -1)
	    return;
	board[neww][r][c] += amount;
    }




    
	
    //converts a 2d array into a string
    public String stringify(int[][] x){
	String ans = "";
	for     (int r = 0; r < x.length; r ++){
	    for (int c = 0; c < x[r].length; c ++){
		ans += x[r][c] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    

    //prints out land
    public String toString(){
	//prints pasture
	return stringify(board[0]) + "\n\n" + stringify(board[1]);
    }
}

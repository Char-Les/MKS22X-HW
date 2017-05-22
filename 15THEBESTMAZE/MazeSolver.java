import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class MazeSolver{
    Maze board;
    Frontier f;
    boolean star;
    
    public MazeSolver(String filename){
	this(filename,false);
    }

    public MazeSolver(String filename, boolean animate){
	board = new Maze(filename, animate);  	
    }

    public void solve(){
	solve(1);
    }

    public void solve(int style){
	star = true;
	switch(style){
	case 0:
	    f = new FStack();
	    break;
	case 1:
	    f = new FQueue();
	    break;
	case 2:
	    star = false;
	case 3:
	    f = new FPQueue();
	    break;
	default:
	    throw new IllegalArgumentException("invalid style (0-3)");
	}
	f.add(board.start);
	solveH();
    }

    private int startD(int r, int c){
	return distance(r, c, board.start);
    }
    private int endD(int r, int c){
	return distance(r, c, board.end);
    }
    private int distance(int r, int c, Location a){
	int x = Math.abs(a.col - c);
	int y = Math.abs(a.row - r);
	return x + y;
    }
    //adds tile (returns true when it add the end)
    private boolean add(int r, int c, Location check){
	//out of bounds
	if(r < 0 || r > board.maxRows || c < 0|| c > board.maxCols)
	    return false;
	//checks the position
	char x = board.maze[r][c];
	
	switch(x){
	case 'E':
	    board.maze[r][c] = '@';
		return true;
	case 'S':
	case ' ':
	    board.maze[r][c] = '?';
	    f.add(new Location(r, c, check, endD(r, c), check.startD + 1, star));
	    return false;
	case '#':
	case '?':
	case '.':
	default:
	    return false;
	}
    }
    //replaces sqare with @
    private void replace(Location l){
	if(board.animate)
	    System.out.println(board.toString(100));
	if(l != null){
	    board.maze[l.row][l.col] = '@';
	    replace(l.prev);
	}
    }
    private void solveH(){
	//no next element = done
	Location check;
	try{
	    check = f.next();
	}catch(NoSuchElementException e){
	    System.out.println(board.toString(0));
	    return;
	}
	int x = check.row; 
	int y = check.col;
	//try to add 4 adjacent
	if(      add(x - 1, y    , check)){
	    replace(check);
	    return;
	}else if(add(x    , y - 1, check)){
	    replace(check);
	    return;
	}else if(add(x    , y + 1, check)){
	    replace(check);
	    return;
	}else if(add(x + 1, y    , check)){
	    replace(check);
	    return;
	}
	
	board.maze[x][y] = '.';
	if(board.animate)
	    System.out.println(board.toString(500));
	//repeat
	solveH();	
    }


    public static void main(String[] arg){
	int a = 3;
	if(arg.length != 0)
	    a = Integer.parseInt(arg[0]);
	MazeSolver x = new MazeSolver("maze.txt", true);
      	x.solve(a);
	System.out.println(x.board.toString(1000));
	
    }
}

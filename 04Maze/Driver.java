import java.util.*;
import java.io.*;

public class Driver{
    
    public static void p(String s){
	System.out.println(s);
    }
    public static void p(int i){
	p(i + "");
    }
    
    
    public static void main(String[]args){
	try{
	    File x = new File("data1.dat");
	    Scanner file =  new Scanner(x);
	    while (file.hasNext()){
		String next = file.next();
		p(next);
	    }
	}catch (IOException e){
	}
	
        Maze f;
        //f = new Maze("data1.dat");//true animates the maze.
        //
        //f.setAnimate(true);
        //f.solve();

        //System.out.println(f);
    }
}

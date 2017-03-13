import java.util.*;
import java.io.*;

public class Driver{
    
    public static void p(String s){
	System.out.println(s);
    }
    public static void p(int i){
	p(i + "");
    }
    
    
    public static void main(String[]args) throws FileNotFoundException, Exception{
	File x = new File("data1.dat");
	p(args.length);
	if (args.length > 0){
	    x = new File(args[0]);
	}
	Scanner lines = new Scanner(x);
	while (lines.hasNext()){
	    p(lines.nextLine());
	}

	Maze a = new Maze("data1.dat");
	if (args.length > 0){
	    a = new Maze(args[0]);
	}
	a.setAnimate(false);
	p(a.solve() + "");
    }
}

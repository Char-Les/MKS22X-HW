import java.util.*;
import java.io.*;

public class Driver{
    
    public static void p(String s){
	System.out.println(s);
    }
    public static void p(int i){
	p(i + "");
    }
    
    
    public static void main(String[]args) throws FileNotFoundException{
	File x = new File("data1.dat");
	Scanner lines = new Scanner(x);
	while (lines.hasNext()){
	    p(lines.nextLine());
	}

	Maze a = new Maze("data1.dat");
	a.setAnimate(true);
    }
}

import java.io.*;
import java.util.*;


public class USACO{
    USACO(){
    }

    //uses seperate file to handle each problem
    //bronze: Lake.java
    //I worked with Stephanie Zheng for the bronze
    //not sure if this is what I'm supposed to do when the file doesn't exist
    public int bronze(String filename){
	try{
	    Lake x = new Lake(filename);
	    return x.solve();
	}catch(FileNotFoundException e){
	    //System.exit(1);
	}
	return -1;
    }

    //silver: Travel.java
    public int silver(String filename){
	try{
	    Travel x = new Travel(filename);
	    return x.solve();
	}catch(FileNotFoundException e){
	    //System.exit(1);
	}
	return -1;
    }

    public static void main(String[] args){
	USACO x = new USACO();
	try{
	    //brozne test cases
	    for(int i = 1; i < 11; i ++ ){
		int a = x.bronze("makelake." + i + ".in");
		File z = new File("makelake." + i + ".out");
		Scanner y = new Scanner(z);
		int b = y.nextInt();
		System.out.println(i + "   "+ a + "  " + b + "  " + (a == b));
	    }
	
	    
	    // silver
	    System.out.println("\n\n\n");

	    for(int i = 1; i < 11; i ++ ){
		int a = x.silver("ctravel." + i + ".in");
		File z = new File("ctravel." + i + ".out");
		Scanner y = new Scanner(z);
		int b = y.nextInt();
		System.out.println(i + "   "+ a + "  " + b + "  " + (a == b));
	    }


	    x.bronze("I love mr. K");
	    System.out.println(123);
	}catch(FileNotFoundException e){
	}
	
    }
}

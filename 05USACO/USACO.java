import java.io.*;
import java.util.*;


public class USACO{
    USACO(){
    }
    
    public int bronze(String filename){
	try{
	    Lake x = new Lake(filename);
	    return x.solve();
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
	return -1;
    }

    public static void main(String[] args){
	USACO x = new USACO();
	try{
	    //brozne test cases
	    for(int i = 1; i < 10;i ++ ){
		int a = x.bronze("data" + i + ".txt");
		File z = new File("ans" + i + ".txt");
		Scanner y = new Scanner(z);
		int b = y.nextInt();
		System.out.println(i + "   "+ a + "  " + b + "  " + (a == b));
	    }
	
	    
	    // silver
	    System.out.println("\n\n\n");

	    for(int i = 1; i < 10;i ++ ){
		int a = x.bronze("data" + i + ".dat");
		File z = new File("ans" + i + ".dat");
		Scanner y = new Scanner(z);
		int b = y.nextInt();
		System.out.println(i + "   "+ a + "  " + b + "  " + (a == b));
	    }
	}catch(FileNotFoundException e){
	}
	
    }
}

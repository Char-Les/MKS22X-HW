import java.io.*;

public class USACO{
    USACO(){
	
    }
    
    public int bronze(String filename){
	try{
	    Lake x = new Lake(filename);
	    return x.solve();
	}catch (FileNotFoundException e){
	    System.out.println("error");
	}
	return -1;
    }

    public static void main(String[] args){
	USACO x = new USACO();
	if (args.length > 1){
	    System.out.println("error");
	    if (args[0].equals("0")){
		System.out.println(x.bronze(args[1]));
	    }else if (args[0].equals("1")){
		//System.out.println(x.silver(args[1]));
	    }
	    
	}
    }

}

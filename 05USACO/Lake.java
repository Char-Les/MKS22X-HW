import java.util.*;
import java.io.*;
public class Lake{
    private int[][]land;
    private int waterlv;
    private int[][] lake;
    private int[][]instructions;

    public Lake(String filename) throws FileNotFoundException{
	File text= new File(filename);
	Scanner data= new Scanner(text);
	
	//get the first line
	String first=data.nextLine();
	String[] firstList = first.split(" ");
	land=new int[Integer.parseInt(firstList[0])][Integer.parseInt(firstList[1])];
	lake = new int[Integer.parseInt(firstList[0])][Integer.parseInt(firstList[1])];
	waterlv=Integer.parseInt(firstList[2]);
	instructions=new int[Integer.parseInt(firstList[3])][3];
	
	//get the pasture
	for(int r=0; r<land.length; r++){
	    String line=data.nextLine();
	    String[] lineList=line.split(" ");
	    for(int c=0; c<lineList.length; c++){
		land[r][c]=Integer.parseInt(lineList[c]);
	    }
	}
	
	//get the instructions
	for(int r=0;r<instructions.length; r++){
	    String line=data.nextLine();
	    String[] lineList=line.split(" ");
	    for(int c=0; c<3; c++){
		instructions[r][c]=Integer.parseInt(lineList[c]);
	    }
	}
    }

    public int solve(){
	for (int x = 0; x < instructions.length; x ++){
	    stomp(instructions[x][0], instructions[x][1], instructions[x][2]);
	}
	updateLake();
	return 0;
    }
    
    public void stomp (int r, int c, int d){
	//int level = findHigh(r,c) - d;
	
    }
    
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
    
    public void updateLake(){
	for     (int r = 0; r < lake.length; r ++){
	    for (int c = 0; c < lake[r].length; c ++){
		int level = waterlv - land[r][c];
		if (level < 0) level = 0;
		lake[r][c] = level;
	    }
	}
    }
    
    public String toString(){
	//prints pasture and the instructions 
	return stringify(land) + "\n" + stringify(instructions);
    }
    
    public static void main(String[]args)throws FileNotFoundException{
	Lake test=new Lake("data.txt");
	System.out.println(test.toString());
    }
		
	
}

import java.util.*;
import java.io.*;
public class Lake{
    private int[][] land;
    private int waterlv;
    private int[][] lake;
    private int[][] instructions;

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
	    stomp(instructions[x][0] - 1, instructions[x][1] - 1, instructions[x][2]);
	}
	updateLake();
	return sumLake() * 72 * 72;
    }
    
    private void stomp (int r, int c, int d){
	int level = findHigh(r,c) - d;
	for(int i = 0; i < 9; i ++){
	    if ( level < land[r + i/3][c + i%3]) land[r + i/3][c + i%3] = level;
	}
    }
    
    private int findHigh(int r, int c){
	int x = land[r][c];
	for(int i = 1; i < 9; i ++){
	    if (x < land[r + i/3][c + i%3]) x = land[r + i/3][c + i%3];
	}
	return x;
    }

    private void updateLake(){
	for     (int r = 0; r < lake.length; r ++){
	    for (int c = 0; c < lake[r].length; c ++){
		int level = waterlv - land[r][c];
		if (level < 0) level = 0;
		lake[r][c] = level;
	    }
	}
    }
    
    private int sumLake(){
	int ans = 0;
	for     (int r = 0; r < lake.length; r ++){
	    for (int c = 0; c < lake[r].length; c ++){
		ans += lake[r][c];
	    }
	}
	return ans;
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
    











    
    public String toString(){
	//prints pasture and the instructions 
	return stringify(land) + "\n" + stringify(lake);
    }
    
    public static void main(String[]args)throws FileNotFoundException{
	Lake test=new Lake("data.txt");
	System.out.println(test.toString());
	System.out.println(test.solve());
	System.out.println(test.toString());
    }
		
	
}

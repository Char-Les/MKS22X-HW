import java.util.*;
import java.io.*;

public class Lake{
    private int[][] land;
    private int waterlv;
    private int[][] lake;
    private int[][] instructions;

    public Lake(String filename) throws FileNotFoundException{
	//access the file
	File text= new File(filename);
	Scanner data= new Scanner(text);
	
	//interprets first line
	Scanner firstl = new Scanner(data.nextLine());
	land = new int[firstl.nextInt()][firstl.nextInt()];
	lake = new int[land.length][land[0].length];
	waterlv= firstl.nextInt();
	instructions=new int[firstl.nextInt()][3];
	firstl.close();
	
	//get the pasture
	for(int r = 0; r < land.length; r++){
	    Scanner line = new Scanner(data.nextLine());
	    for(int c = 0; c < land[r].length; c++){
		land[r][c] = line.nextInt();
	    }
	}
	
	//get the instructions
	for(int r = 0; r < instructions.length; r++){
	    Scanner line = new Scanner(data.nextLine());
	    for(int c=0; c<3; c++){
		instructions[r][c] = line.nextInt();
	    }
	}
   
	data.close();
    }







    //gets the lakes volume after all instructions
    public int solve(){
	//goes through all the instructions
	for (int x = 0; x < instructions.length; x ++){
	    stomp(instructions[x][0] - 1, instructions[x][1] - 1, instructions[x][2]);
	}

	
	//updates the lake array for sumLake()
	updateLake();
	//answer gets multiplied by 72 * 72
	return sumLake() * 72 * 72;
    }

    //helper for doing instructions
    private void stomp (int r, int c, int d){
	int level = findHigh(r,c) - d;
	for(int i = 0; i < 9; i ++){
	    if ( level < land[r + i/3][c + i%3]) land[r + i/3][c + i%3] = level;
	}
    }

    //parses through a 3 by 3 starting at the given coords to find the highest land value
    private int findHigh(int r, int c){
	int x = land[r][c];
	for(int i = 1; i < 9; i ++){
	    if (x < land[r + i/3][c + i%3]) x = land[r + i/3][c + i%3];
	}
	return x;
    }

    //just inverts land based on waterlv, but negatives become 0
    private void updateLake(){
	for     (int r = 0; r < lake.length; r ++){
	    for (int c = 0; c < lake[r].length; c ++){
		int level = waterlv - land[r][c];
		if (level < 0) level = 0;
		lake[r][c] = level;
	    }
	}
    }

    //sums all the values of the lake array
    private int sumLake(){
	int ans = 0;
	for     (int r = 0; r < lake.length; r ++){
	    for (int c = 0; c < lake[r].length; c ++){
		ans += lake[r][c];
	    }
	}
	return ans;
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
	return stringify(land);
    }
}

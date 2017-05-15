public class Location implements Comparable<Location>{
    int goalD, startD;
    boolean star;
    int row, col;
    Location prev;

    public Loaction(int r, int c, Location p, int goalD, int startD){
	this.goalD = goalD;
	this.startD = startD;
	row = r;
	col = c; 
	prev = p;
	star = false;
    }

    public Loaction(int r, int c, Location p, int goalD, int startD, boolean s){
	this.goalD = goalD;
	this.startD = startD;
	row = r;
	col = c; 
	prev = p;
	star = s;
    }
    
    private int sumD(){
	return goalD + startD;
    }
    
    public int compareTo(Location x){
	if(star){
	    if()
	    return 1;
	}
	
	return -1;
    }
}

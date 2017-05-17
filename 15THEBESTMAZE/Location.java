public class Location implements Comparable<Location>{
    int goalD, startD;
    boolean star;
    int row, col;
    Location prev;

    public Location(int r, int c){
	this(r, c, null, 0, 0, false);
    }
    public Location(int r, int c, Location p, int goalD, int startD){
        this(r, c, p, goalD, startD, false);
    }

    public Location(int r, int c, Location p, int goalD, int startD, boolean s){
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
	    return this.sumD() - x.sumD();
	}
	return this.goalD - x.goalD;
    }
}

import java.util.*;

public class FQueue implements Frontier{
    ArrayDeque<Location> frontier;
    
    public FQueue(){
	frontier = new ArrayDeque<Location>();
    }
    
    public void add(Location x){
	frontier.add(x);
    }

    public Location next(){
	try{
	    return frontier.remove();
	}catch(NoSuchElementException e){
	    throw new NoSuchElementException("empty queue");
	}
    }
}

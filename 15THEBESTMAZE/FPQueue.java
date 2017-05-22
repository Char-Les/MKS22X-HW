import java.util.*;

public class FPQueue implements Frontier{
    MyHeap<Location> frontier;

    public FPQueue(){
	frontier = new MyHeap<Location>(false);
    }

    public void add(Location x){
	frontier.add(x);
    }

    public Location next(){
	try{
	    return frontier.remove();
	}catch(IndexOutOfBoundsException e){
	    throw new NoSuchElementException("empty prioity queue");
	}
    }

    public String toString(){
	return frontier.toString();
    }
}

import java.util.*;

public class FStack implements Frontier{
    Stack<Location> frontier;
    
    public FStack(){
	frontier = new Stack<Location>();
    }
    
    public void add(Location x){
	frontier.push(x);
    }

    public Location next(){
	try{
	    return frontier.pop();
	}catch(EmptyStackException e){
	    throw new NoSuchElementException("empty stack");
	}
    }
}

public class MyDeque{
    String[] deck;
    int start, end;
    
    public MyDeque(){
	deck = new String[16];
    }
    public MyDeque(int num){
	deck = new String[num];
	if(num == 0)
	    MyDeque();
    }
    
    public void addFirst(String x){
	
    }

    public void addLast(String x){
	
    }

    public String removeFirst(){
	String x = getFirst();
	start --;
	if ( start < 0)
	    start = x.length - 1;
	
    }

    public String removeLast(){
	String x = getLast();
	end ++;
	if ( end = x.legnth)
	    end = 0;
    }

    public String getFirst(){
	return deck[start];
    } 
    
    public String getLast(){
	return deck[end];
    } 

}

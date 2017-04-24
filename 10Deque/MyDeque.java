import java.util.*;


public class MyDeque{
    String[] deck;
    int start, end, size;
    
    public MyDeque(){
	deck = new String[16];
    }
    public MyDeque(int num){
	deck = new String[num];
	if(num == 0)
	    deck = new String[16];
    }
    
    public void addFirst(String x){
	if(x == null)
	    throw new NullPointerException("addFirst");
	if(size == 0){
	    size ++;
	    start = 0;
	    end = 0;
	    deck[start] = x;
	    return;
	}
	if ((end + 1) % deck.length == start)
	    resize();
	start = start - 1;
	if(start == -1)
	    start = deck.length - 1;
       	deck[start] = x;
	size ++;
    }

    public void addLast(String x){
	if(x == null)
	    throw new NullPointerException("addFirst");
	if(size == 0){
	    size ++;
	    start = 0;
	    end = 0;
	    deck[start] = x;
	    return;
	}
	if ((end + 1) % deck.length == start)
	    resize();
	end = (end + 1) % deck.length;
	deck[end] = x;
	size ++;
    }

    private void resize(){
	String[] x = new String[deck.length * 2];
	for(int i = 0; i < deck.length; i ++){
	    int place = start + i;
	    if(place >= deck.length)
		place -= deck.length;
	    x[i] = deck[place];
	}
	start = 0;
	end = deck.length - 1;
	deck = x;
    }

    public String removeFirst(){
	if(size == 0)
	    throw new NoSuchElementException("removeFirst");
	String x = getFirst();
	start = (start + 1) % deck.length;
	size --;
	return x;
    }

    public String removeLast(){
	if(size == 0)
	    throw new NoSuchElementException("removeLast");
	String x = getLast();
	end = end - 1;
	if (end == -1)
	    end = deck.length - 1;
	size --;
	return x;
    }

    public String getFirst(){
	if(size == 0)
	    throw new NoSuchElementException("getFirst");
	return deck[start];
    } 
    
    public String getLast(){
	if(size == 0)
	    throw new NoSuchElementException("getLast");
	return deck[end];
    } 


    private static void p(String x){
	System.out.println(x);
    }
    private static void p(int x){
	p(x + "");
    }
    public void p(){
	for(int i = 0; i < deck.length; i++){
	    p(deck[i]);
	}
	p("Size : "+ size);
	p("Start : " + start);
	p("Start : " + end  );
    }
    
    public static void main(String[] args){
	MyDeque x = new MyDeque(3);
	p(-6 % 5);
	x.p();
	x.addFirst("3");
	x.addLast("4");
	x.addFirst("2");
	x.p();
	x.addLast("5");
	x.addFirst("1");
	x.p();
	x.removeFirst();
	x.removeFirst();
	x.removeFirst();
	x.removeLast();
	x.p();
	x.removeLast();
	x.p();
	p(x.getFirst());
	x.removeFirst();
    }
}

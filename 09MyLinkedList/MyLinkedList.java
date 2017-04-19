import java.util.*;


public class MyLinkedList implements Iterable<Integer>{
    private Node start, end;
    private int size;






    
    //sub class node for initializing objects
    private class Node{
	int value;
	Node head, tail;

	//for initializing with set nodes
	public Node(int x, Node pre, Node next){
	    value = x;
	    head = next;
	    tail = pre;
	}

	//default constructor
	public Node(int x){
	    value = x;
	}

	//returns a string in the form (tail value) value (head value)
	public String toString(){
	    String ans = "";
	    ans += helper(tail) + " " + value + helper (head);
	    return ans;
	}

	//helps with toString debugging
	private String helper(Node x){
	    if(x == null){
		return " (null)";
	    }else{
		return " (" + x.value + ")";
	    }
	} 
    }


    public class LLIterator implements Iterator<Integer>{
	private Node x;
	
	public LLIterator(Node start){
	    x = new Node(0, null, start);
	}
	
	public Integer next(){
	    if(hasNext()){
		x = x.head;
		return new Integer(x.value);
	    }else{
		throw new NoSuchElementException();
	    }
	}
	
	public boolean hasNext(){
	    return x.head != null;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
	
    }
    
    public Iterator<Integer> iterator(){
	return new LLIterator(start);
    }





    
    //only constructor we're going to use
    public MyLinkedList(){
	size = 0;
    }









    

    
    //add a value to the end
    public boolean add(int x){
	//empty list case (no end)
	if (size == 0){
	    Node a = new Node(x);
	    start = a;
	    end = a;
	    size ++;
	    return true;
	}

	//general case	
        return add(end, x);
    }

    //adds to the index you give
    public boolean add(int index, int value){
	if(index < 0 || index > size())
	    throw new IndexOutOfBoundsException("add; index: " + index);
	
	//you're adding to start
	if(index == 0){
	    //list is empty
	    if (size == 0){
		Node a = new Node(value);
		start = a;
		end = a;
		size ++;
		return true;
	    }

	    //else procede normally
	    Node a = new Node(value, null, start);
	    start.tail = a;
	    start = a;
	    size ++;
	    return true;
	}
	
	//else get the node before the index and add it
	Node x = getNode(index - 1);
	return add(x, value);
    }

    //general base add function; puts the value after the node you give it
    private boolean add(Node x, int value){
	//less work if it's at the end
	if (x == end){
	    Node a = new Node(value, x, null);
	    x.head = a;
	    end = a;
	    size ++;
	    return true;
	}

	//it's in between something
	Node a = new Node(value, x, x.head);
	a.head.tail = a;
	x.head = a;
	size ++;
	return true;	   
    }











    
    //what does this do??
    public int size(){
	return size;
    }//wow so coooooll











    //gets the value at the index
    public int get(int index){
	return getNode(index).value;
    }
    //gets to a certain node index
    private Node getNode(int index){
	if(index < 0 || index >= size())
	    throw new IndexOutOfBoundsException("add; index: " + index);
	Node ans = start;
	for(;index > 0; index --){
	    ans = ans.head;
	}
	return ans;
    }







    //sets the value at the index to a new one and pops the old one
    public int set(int index, int newValue){
	Node x = getNode(index);
	int temp = x.value;
	x.value = newValue;
	return temp;
    }






    //returns the index of the first occurence of a value; -1 if not found
    public int indexOf(int value){
	Node check = start;
        for(int i = 0; check != null; i ++){
	    if (check.value == value)
		return i;
	    check = check.head;
	}
	//if loop completes -> not found
	return -1;
    }



    

    //removes the node at the index and returns the value
    public int remove(int index){
	if(index < 0 || index >= size())
	    throw new IndexOutOfBoundsException("add; index: " + index);
	
	Node x = getNode(index);
	remove(x);
	size --;
	return x.value;
    }
    
    //removes a certain node given that node 
    private void remove(Node x){
	//x is start and end
	if (x.tail == null && x.head == null){
	    start = null;
	    end = null;
	    return;
	}
	//x is the start
	if (x.tail == null){
	    x.head.tail = null;
	    start = x.head;
	    return;
	}
	//x is the end
	if (x.head == null){
	    x.tail.head = null;
	    end = x.tail;
	    return;
	}
	//x is in the middle
	x.tail.head = x.head;
	x.head.tail = x.tail;
    }
    


    
    

    //







    
    
    
    //prints out the size and each node's values from start to end
    public String toString(){
	String ans = "";
	ans += "size: " + size + "\n";
	//so it doesn't crash
	if(size == 0){
	    return ans + "{}";
	}
	
	//start with the start's value
	Node check = start;
	ans += "{" + check;
	//adds on each subsequent value
	while (check.head != null){
	    check = check.head;
	    ans += ", " + check;
	}
	ans += "}";
	return ans;
    }







    
    //some print methods
    private static void p(String x){
	System.out.println(x);
    }
    private static void p(MyLinkedList x){
	p(x.toString());
    }
    private static void p(int x){
	p(x +"");
    }
    private static void p(Node x){
	p(x.toString());
    }



    
    public static void main(String[] x123){
	MyLinkedList x = new MyLinkedList();
	int[] a = {1,2,3,4,5};

	
	p("\nadd");
	p(x);
	for(int b : a){
	    x.add(b);
	}
	p(x);
	x.add(3,6);
	p(x);

	p("\nget");
	p(x.get(3));
	
	p("\nset");
	p(x.set(3,7));
	p(x);
	
	p("\nindexOf");
	p(x.indexOf(7));
	p(x.indexOf(6));

	p("\nremove");
	x = new MyLinkedList();
	x.add(1);
	p(x.remove(0));
	p(x);

	p("\niterator");
	x.add(123);
	x.add(1231234);
	x.add(43434534);
	x.add(123);
	x.add(1231234);
	x.add(43434534);
	p(x);
	for(int b : x){
	    p(b);
	}
    }
}

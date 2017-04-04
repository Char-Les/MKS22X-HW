public class MyLinkedList{
    Node start, end;
    int size;
    
    private class Node{
	int value;
	Node head, tail;

	public Node(int x, Node next, Node pre){
	    value = x;
	    head = next;
	    tail = pre;
	}

	public Node(int x){
	    value = x;
	    head = null;
	    tail = null;
	}
	
	public String toString(){
	    String ans = "";
	    ans += helper(tail) + helper(this) + helper (head);
	    return ans;
	}

	private String helper(Node x){
	    if(x == null){
		return " (null)";
	    }else{
		return " (" + x.value + ")";
	    }
	} 
    }

    public MyLinkedList(){
	start = null;
	end = null;
	size = 0;
    }
    

    
    //extenstion of the add(Node)
    public boolean add(int x){
	return add(new Node(x));
    }

    //add a node to the end;
    public boolean add(Node x){	
	//empty list case
	if (size == 0){
	    start = x;
	    end = x;
	    size ++;
	    return true;
	}

	//general case	
	end.head = x;
	x.tail = end;
	end = x;
	size ++;
	return true;
    }

    //add after the index you give
    //0 <= index < size
    public boolean add(int index, int value){
	Node x = getNode(index);
	return add(x, value);
    }

    //general base add function
    private boolean add(Node x, int value){
	Node a = new Node(value);
	if (x == end){
	    x.head = a;
	    end = x;
	    return true;
	}

	x.head.tail = a;
	a.head = x.head;
	x.head = a;
	a.tail = x;
	return true;	   
    }
    
    //what does this do??
    public int size(){
	return size;
    }//wow so coooooll

    //gets to a certain node index
    private Node getNode(int index){
	//this is private so the case where index is greater than size is the program's fault
	Node ans = start;
	for(;index > 0; index --){
	    ans = ans.head;
	}
	return ans;
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
    

    
    public String toString(){
	String ans = "";
	Node check = start;
	ans += "size: " + size + "\n";
	ans += "{" + check.value;
	for(int i = 1; i < size; i ++){
	    check = check.head;
	    ans += ", " + check.value;
	}
	ans += "}";
	return ans;
    }
    

    private static void p(String x){
	System.out.println(x);
    }
    private static void p(MyLinkedList x){
	p(x.toString());
    }
    private static void p(int x){
	p(x +"");
    }
    public static void main(String[] x123){
	MyLinkedList x = new MyLinkedList();
	int[] a = {1,2};
	for(int b : a){
	    p(b);
	    x.add(b);
	}

	p(x);
    }
}

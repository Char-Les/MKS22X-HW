public class MyLinkedList{
    LNode start, end;
    int size;
    
    private class LNode{
	int value;
	LNode head, tail;

	public LNode(int x, LNode next, LNode pre){
	    value = x;
	    head = next;
	    tail = pre;
	}

	public LNode(int x){
	    value = x;
	    head = null;
	    tail = null
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
	return true;
    }

    //add after the index you give
    //0 <= index < size
    public boolean add(int index, int value){
	Node x = getNode(x);
	return add(x, value);
    }

    //general base add function
    private boolean add(Node x, int value){
	Node a = new Node(value);
	if (x == end){
	    x.head = a;
	    end = x;
	    return true;;
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
    private node getNode(int index){
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
	
    }
    
}

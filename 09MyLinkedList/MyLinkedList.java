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

    //add a value x to the end;
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

    //what does this do??
    public int size(){
	return size;
    }//wow so coooooll


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

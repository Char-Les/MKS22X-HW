public class MyLinkedList{
    LNode start, end;
    int size;
    
    private class LNode{
	int value;
	LNode next;

	public LNode(int x, LNode thing){
	    value = x;
	    next = thing
	}

	public LNode(int x){
	    value = x;
	    next = null;
	}
    }

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    

    public boolean add(int x){
	end.next = x;
    }

    public int size(){
	return size;
    }



}

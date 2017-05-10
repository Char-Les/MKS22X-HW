import java.util.*;



public class MyHeap{
    ArrayList<String> heap;
    boolean max = true;


    
    public MyHeap(boolean a){
	heap = new ArrayList<String>();
	max = false;
	heap.add("");
    }
    public MyHeap(){
	heap = new ArrayList<String>();
	heap.add("");
    }



    public void add(String x){
	heap.add(x);
	pushUp(heap.size() - 1);
    }
    
    private void pushDown(int 
index){
	//you're at the bottom of the heap; no child
	if (index * 2 >= heap.size())
	    return;

	//try two child catch one child
	try{
	    int max = getMax(index);
	    if (max != index){
		swap(max, index);
		pushDown(max);
	    }
	}catch(IndexOutOfBoundsException e){
	    if (heap.get(index).compareTo(heap.get(index * 2)) < 0){
		swap(index, index * 2);
		pushDown(index * 2);
	    }
	}
    }
    private void pushUp(int index){
	//you're at top; no parent
	if(index == 1)
	    return;

	int parent = index / 2;
        if (heap.get(index).compareTo(heap.get(parent)) > 0){
	    swap(parent, index);
	    pushUp(parent);
	}
    }
    //switch two indexs in the heap
    private void swap(int index, int index2){
	String temp = heap.get(index2);
	heap.set(index2, heap.get(index));
	heap.set(index, temp);
    }
    //finds index of max value given parent
    private int getMax( int index){		
	int c1 = index * 2;
	int c2 = c1 + 1;
	int ans = index;
	if (heap.get(ans).compareTo(heap.get(c1)) < 0)
	    ans = c1;
	if (heap.get(ans).compareTo(heap.get(c2)) < 0)
	    ans = c2;
	return ans;	
    }


    public String remove(){
	//if there is only 1 element then remove will crash
	if(heap.size() == 2) 
	    return heap.remove(1);
	
	//get the last element and the top; organize the array having the top as the last element
	String x = heap.remove(heap.size() - 1);
	String ans = peak(); 
	heap.set(1, x);
	
	//'sort' the heap
	pushDown(1);
	return ans;
    }
    public String peak(){
	return heap.get(1);
    }
    



    public String toString(){
	String ans = "";
	for (int i = 1; i < heap.size(); i++){
	    if(i == 2)
		ans += "\n";
	    if(i == 4)
		ans += "\n";
	    if(i == 8)
		ans += "\n";
	    if(i == 16)
		ans += "\n";
	    ans += i + ": " + heap.get(i) + "   ";
	}
	return ans;
    }

    private static void p(MyHeap x){
	p(x.toString());
    }
    private static void p(int x){
	p(x + "");
    }
    private static void p(String x){
	System.out.println(x);
    }
    
    public static void main(String[] ar){
	MyHeap x = new MyHeap();
	p(x);
	x.add("a");
	x.add("b");
	x.add("c");
	x.add("d");
	x.add("a");
	x.add("b");
	x.add("c");
	x.add("d");
	x.add("d");
	x.add("d");
	x.add("d");
	x.add("a");
	x.add("b");
	x.add("c");
	x.add("d");
	x.add("a");
	x.add("b");
	x.add("c");
	x.add("d");
	x.add("d");
	x.add("d");
	x.add("d");
	p(x);
	for(int i = 0; i < 16; i ++)
	    p(x.remove());
	p(x);
    }
}

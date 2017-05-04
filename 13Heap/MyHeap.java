import java.util;



public class MyHeap{
    ArrayList<String> heap;
    boolean max = true;


    
    public Heap(boolean a){
	heap = new ArrayList<String>();
	max = false;
	heap.add("");
    }
    public Heap(){
	heap = new ArrayList<String>();
	heap.add("");
    }



    public void add(String x){}
    
    private void pushDown(int 
index){
	//you're at the bottom of the heap
	if (index * 2 >= heap.size())
	    return;
	
	int c1 = index * 2;
   int c2 = c1 + 1;

	//try two child catch one
   try{}
    }
    private void pushUp(int index){
	//you're at top
	if(index == 1)
	    return;
	

	int parent = index / 2;
        
	swap(parent, index);
	//see if parent needs to go deeper
	pushDown(index);
    }
    //switch two indexs in the heap
    private void swap(int index, int index2){
	String temp = heap.get(index2);
	heap.set(index2, heap.get(index));
	heap.set(index, temp);
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
	    ans += i + ": " + heap.get(i) + "\n";
	} 
    }
}

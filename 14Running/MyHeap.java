import java.util.*;



public class MyHeap{
    ArrayList<Integer> heap;
    boolean max = true;

    
    public MyHeap(boolean a){
	heap = new ArrayList<Integer>();
	max = false;
	heap.add(0);
    }
    public MyHeap(){
	heap = new ArrayList<Integer>();
	heap.add(0);
    }

    public int size(){
	return heap.size() - 1;
    }
    
    //adds to the end of the list and semi sorts it
    public void add(Integer x){
	heap.add(x);
	pushUp(heap.size() - 1);
    }
    
    private void pushDown(int index){
	if (max)
	    maxpd(index);
	else
	    minpd(index);
    }
    private void maxpd(int index){
	//you're at the bottom of the heap; no child
	if (index * 2 >= heap.size())
	    return;

	//try two child catch one child
	try{
	    int max = getMax(index);
	    if (max != index){
		swap(max, index);
		maxpd(max);
	    }
	}catch(IndexOutOfBoundsException e){
	    if (heap.get(index).compareTo(heap.get(index * 2)) < 0){
		swap(index, index * 2);
		maxpd(index * 2);
	    }
	}
    }
    private void minpd(int index){
	//you're at the bottom of the heap; no child
	if (index * 2 >= heap.size())
	    return;

	//try two child catch one child
	try{
	    int min = getMin(index);
	    if (min != index){
		swap(min, index);
		minpd(min);
	    }
	}catch(IndexOutOfBoundsException e){
	    if (heap.get(index).compareTo(heap.get(index * 2)) > 0){
		swap(index, index * 2);
		minpd(index * 2);
	    }
	}
    }
    private void pushUp(int index){
	if(max)
	    maxpu(index);
	else
	    minpu(index);
    }
    private void maxpu(int index){
	//you're at top; no parent
	if(index == 1)
	    return;

	int parent = index / 2;
        if (heap.get(index).compareTo(heap.get(parent)) > 0){
	    swap(parent, index);
	    maxpu(parent);
	}
    }
    private void minpu(int index){
	//you're at top; no parent
	if(index == 1)
	    return;

	int parent = index / 2;
        if (heap.get(index).compareTo(heap.get(parent)) < 0){
	    swap(parent, index);
	    minpu(parent);
	}
    }
    //switch two indexs in the heap
    private void swap(int index, int index2){
	Integer temp = heap.get(index2);
	heap.set(index2, heap.get(index));
	heap.set(index, temp);
    }
    //finds index of max value given parent
    private int getMax(int index){		
	int c1 = index * 2;
	int c2 = c1 + 1;
	int ans = index;
	if (heap.get(ans).compareTo(heap.get(c1)) < 0)
	    ans = c1;
	if (heap.get(ans).compareTo(heap.get(c2)) < 0)
	    ans = c2;
	return ans;	
    }
    private int getMin(int index){		
	int c1 = index * 2;
	int c2 = c1 + 1;
	int ans = index;
	if (heap.get(ans).compareTo(heap.get(c1)) > 0)
	    ans = c1;
	if (heap.get(ans).compareTo(heap.get(c2)) > 0)
	    ans = c2;
	return ans;	
    }


    public Integer remove(){
	//if there is only 1 element then remove will crash
	if(heap.size() == 2)
	    return heap.remove(1);
	
	//get the last element and the top; organize the array having the top as the last element
	Integer x = heap.remove(heap.size() - 1);
	Integer ans = peak(); 
	heap.set(1, x);
	
	//'sort' the heap
	pushDown(1);
	return ans;
    }
    public Integer peak(){
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
	MyHeap x = new MyHeap(true);
	p(x);	x.add(1);
	x.add(12);
	x.add(1);
	x.add(12);
	x.add(1);
	x.add(12);
	x.add(1);
	x.add(12);
	x.add(1);
	x.add(12);
	p(x);
    }
}

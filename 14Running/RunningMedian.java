
//i modified the myheap in this directory to incorporate size
public class RunningMedian{
    MyHeap less, more;

    
    public RunningMedian(){
	less = new MyHeap();
	more = new MyHeap(false);
    }
    
    public void add(int num){
	//empty heaps
	if (lsize() == 0 && msize() == 0){
	    less.add(num);
	    return;
	}

	double check = getMedian();
	MyHeap smaller = smallPile();
	MyHeap bigger = bigPile();
	MyHeap pile = whichPile(num);

	//correct heap smaller
	if(smaller == pile){
	    smaller.add(num);
	    return;
	}
	//wrong pile
	Integer x = bigger.remove();
	smaller.add(x);
	bigger.add(num);
    }

    public double getMedian(){
	//case none
	if(lsize() == 0 && msize() == 0)
	    throw new NullPointerException("No Median");
	
	//case equal
	if(lsize() == msize()){
	    double x = less.peak();
	    double y = more.peak();
	    return (x + y) / 2;
	}
	//case one larger
	MyHeap pile = bigPile();
	return pile.peak();
    }

    
    //gets the bigger/smaller pile
    //     bigger throws exception when they're equal size;
    private MyHeap smallPile(){
	if(lsize() >= msize())
	    return more;
	return less;
    }
    private MyHeap bigPile(){
	if(lsize() < msize())
	    return more;
	return less;
    }
    private MyHeap whichPile(int num){
	if (num < getMedian())
	    return less;
	return more;
    }

    private int lsize(){
	return less.size();
    }
    private int msize(){
	return more.size();
    }
    
    public String toString(){
	String x = "less: \n";
	x += less.toString()+ "\n";
	
	x += "more: \n";
	x += more;
	return x;
    }
    public static void main(String[] args){
	RunningMedian x = new RunningMedian();
	//x.getMedian();
	x.add(1);
	x.add(2);
	x.add(3);
	x.add(1);
	x.add(2);
	x.add(3);
	x.add(2);
	x.add(3);
	x.add(1);
	x.add(2);
	x.add(3);
	x.add(2);
	x.add(3);
	x.add(1);
	x.add(2);
	x.add(3);
	x.add(2);
	x.add(3);
	System.out.println(x);
	System.out.println(x.getMedian());
    }
}

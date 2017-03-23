import java.io.*;


public class Quick{

    //same function from other file
    private static int part(int[] ary, int start, int end)throws IllegalArgumentException{
	return Part.part(ary, start, end);
    }
    
    //get kth smallest number (0 indexing)
    public static int quickselect(int[] ary, int k) throws IllegalArgumentException{
	//bad case 1
	if (k >= ary.length)
	    throw new IllegalArgumentException("" + k);
	return helper(ary, 0, ary.length - 1, k);
    }

    //helper function for quickselect
    private static int helper(int[] ary, int start, int end, int k){
	//p(start + "    " + end);
	//partitions the array once
	int[] pivot = partC(ary, start, end);
	//if the k is in between the pivot cluster then you're done
	if (k >= pivot[0] && k <= pivot[1]){
	    return ary[k];
	}
	//we have to go deeper
	if (k < pivot[0]){
	    return helper(ary, start, pivot[0] - 1, k);
	}else{   //checked between and less then only greater than left
	    return helper(ary, pivot[1] + 1, end, k);
	}
    }
    

    //same function from other file
    private static int[] partC(int[] ary, int start, int end)throws IllegalArgumentException{
	return Part.partC(ary, start, end);
    }
    
    public static void quicksort(int[] ary) throws IllegalArgumentException{
	quickH(ary, 0, ary.length - 1);
    }

    public static void quickH(int[] ary, int start, int end){
	//p((start == end) + "");
	if (start == end) return;

	//p(start + "   " + end);
	//the array portion isn't small enough so we have to sort it
	int[] pivot = partC(ary, start, end);

	//p(pivot);
	//p("a");
	if (start < pivot[0] - 1){
	    quickH(ary, start, pivot[0] - 1);
	}
	if (pivot[1] + 1 < end){
	    //p("b");
	    quickH(ary, pivot[1] + 1, end);
	}
    }

   


    public static void p(int x){
	Part.p(x);
    }
    public static void p(int[] x){
	Part.p(x);
    }
    public static void p(String x){
	Part.p(x);
    }


    public static void check(int[] ary){
	for (int i = 0; i + 1 < ary.length; i ++){
	    if(ary[i] >= ary[i + 1])
		p(i + " " + ary[i] + " " + ary[i + 1] + " " );
	}
    }
    public static void main(String[] args){
	int[] ary = new int[10000];
	for (int i = 0; i < ary.length; i ++){
	    ary[i] = 10000 - i;
	}
	p(2342343);
	p(quickselect( ary , 0 ));
	p(quickselect( ary , 1 ));

	quicksort(ary);
	check(ary);
    }
}

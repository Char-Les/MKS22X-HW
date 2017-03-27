import java.io.*;

//Part contains the partition function (part(...))and the dutch flag thing (partC(...))
public class Quick extends Part{

    
    //get kth smallest number (0 indexing)
    public static int quickselect(int[] ary, int k) throws IllegalArgumentException{
	//bad case 1
	if (k >= ary.length)
	    throw new IllegalArgumentException(" k is: " + k + ", when array length is: "  + ary.length);
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
    
    
    public static void quicksort(int[] ary) throws IllegalArgumentException{
	//an empty array is sorted and not a bad case
	if (ary.length == 0) return;
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

   



    
      //makes sure all the elements are in order and prints out the ones that aren't
    public static void check(int[] ary){
	for (int i = 0; i + 1 < ary.length; i ++){
	    if(ary[i] > ary[i + 1])
		p(i + " " + ary[i] + " " + ary[i + 1] + " " );
	}
    }
    public static void main(String[] args){
	int[] ary = new int[10000000];
	for (int i = 0; i < ary.length; i ++){
	    ary[i] = 0;
	    ary[i] = (int)(Math.random() * 5);
	    ary[i] = i;
	    ary[i] = ary.length - i;
	    ary[i] = (int)(Math.random() * ary.length);
	    
	}
	p(2342343);
	//p(quickselect( ary , 0 ));
	//p(quickselect( ary , 1 ));

	quicksort(ary);
	check(ary);
    }
}

import java.io.*;


public class Quick{
    
    private static int part(int[] ary, int start, int end)throws IllegalArgumentException{
	return Part.part(ary, start, end);
    }
    

    public static int select(int[] ary, int k) throws IllegalArgumentException{
	if (k >= ary.length)
	    throw new IllegalArgumentException("" + k);
	return helper(ary, 0, ary.length - 1, k);
    }

    private static int helper(int[] ary, int start, int end, int k){
	int pivot = part(ary, start, end);
	if (k == pivot){
	    return ary[k];
	}else if (k < pivot){
	    return helper(ary, start, pivot - 1, k);
	}else{
	    return helper(ary, pivot + 1, end, k);
	}
    }
    
    public static void p(int x){
	System.out.println(x);
    }


    public static void main(String[] args){
	int[]ary = {23, 0};
	p(select( ary , 0 ));
	p(select( ary , 1 ));

    }
}

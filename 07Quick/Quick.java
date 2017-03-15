public class Quick{
    
    private static int part(int[] ary, int start, int end){
	return Part.part(ary, start, end);
    }
    

    public static int select(int[] ary, int k){
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
	int[]ary = { 2, 10, 15, 23, 0,  5};
	p(select( ary , 0 ));
	p(select( ary , 1 ));
	p(select( ary , 2 ));
	p(select( ary , 3 ));
	p(select( ary , 4 ));
	p(select( ary , 5 ));
    }
}

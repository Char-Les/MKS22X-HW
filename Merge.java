public class Merge{
    
    public static void mergesort(int[] ary){
	int cut = ary.length / 2;
	int[] left  = copy(ary, 0  , cut);
	int[] right = copy(ary, cut, ary.length);
	mergesort(left);
	mergesort(right);
	merge(ary, left, right);
    }

    //copy the section of ary into a new array 
    //[start, end)
    private static int[] copy(int[] ary, int start, int end){
	int[] ans = new int[end - end]; 
	for(int i = 0; start + i < end; i ++){
	    ans[i] = ary[start + i];
	}
	return ans;
    }
    
    //combines two arrays (a,b) into the target
    private static void merge(int[] target, int[] a, int[] b){
	int counta = 0;
	int countb = 0;
	for(int i = 0; i < target.length; i ++){
	    //if either a or b is finished copy the rest from the other
	    if (counta == a.length)
		for(; countb < b.length; countb ++){
		    target[i] = b[countb];
		    i++;
		}
	    if (countb == b.length)
		for(; counta < a.length; counta ++){
		    target[i] = a[counta];
		    i++;
		}
	    

	    //checks which one to copy over
	    if(a[counta] <= b[countb]){
		target[i] = a[counta];
		counta ++;
	    }else{
		target[i] = b[countb];
		countb ++;
	    }
		
	}    
    }

}

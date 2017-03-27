public class Merge{
    
    public static void mergesort(int[] ary){
	if(ary.length <= 1) return;
	int cut = ary.length / 2;
	int[] left  = copy(ary, 0  , cut);
	int[] right = copy(ary, cut, ary.length);
	mergesort(left);
	mergesort(right);
	merge(ary, left, right);
	//p(ary);
    }

    //copy the section of ary into a new array 
    //[start, end)
    private static int[] copy(int[] ary, int start, int end){
	int[] ans = new int[end - start]; 
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
	    //checks which one to copy over
	    if(a[counta] <= b[countb]){
		target[i] = a[counta];
		counta ++;
	    }else{
		target[i] = b[countb];
		countb ++;
	    }



	    //if either a or b is finished copy the rest from the other
	    if (counta == a.length){
		i++;
		for(; countb < b.length; countb ++){
		    target[i] = b[countb];
		    i++;
		}
	    }
	    if (countb == b.length){
		i++;
		for(; counta < a.length; counta ++){
		    target[i] = a[counta];
		    i++;
		}
	    }
	}    
    }





    public static void p(int[] x){
	String ans = "";
	for(int i = 0; i < x.length; i ++){
	    ans += x[i] + " ";
	}
	p(ans);
    }

    public static void p(int x){
	p(x + "");
    }
    
    public static void p(String x){
	System.out.println(x);
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
	    //ary[i] = (int)(Math.random() * 3);
	    //ary[i] = i;
	    //ary[i] = ary.length - i;
	    //ary[i] = (int)(Math.random() * ary.length);
	    
	}
	p(2342343);
	//p(ary);
	
	mergesort(ary);
	check(ary);
	//p(ary);
    }
}

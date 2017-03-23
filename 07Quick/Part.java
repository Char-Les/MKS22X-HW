import java.util.*;

public class Part{

    public static int part(int[] data, int start, int end) throws IllegalArgumentException{

	//if length is 0, it's bad data
	if(data.length == 0) throw new IllegalArgumentException("empty array");

	//if end and start are the same, then you're done
	if(end == start) return start;
	
	//chooses random pivot
	Random x = new Random();
	int pivot = x.nextInt(end - start + 1) + start;
	//move pivot out of way
	swap(data, pivot, start);
	pivot = start;

	//beingings of a great wall
	//left of wall -> less than pivot
	//right of wall -> more than or equal to pivot (assumes nothing is less)
	//wall also marks the right most element less than the pivot 
	int wall = start;




	//put the wall in the right place
	int check = data[start];
	for(int i = start + 1; i < end + 1; i ++){
	    //if it's less than the check then it's supposed to be left of the wall
	    //if it's not then its in the right place and you can move on
	    if (data[i] < check){
		wall += 1;
		swap(data, i, wall);
	    }
	}
	

	//everything is in the correct place and we just need to place the pivot
	swap(data, wall, pivot);
	pivot = wall;
	return pivot;
    }

    //swaps data[x] and data[y]
    private static void swap(int[] data, int x, int y){
	int temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }





























    

    //clusters the same values
    public static int[] partC(int[] data, int start, int end) throws IllegalArgumentException{
	//if length is 0, it's bad data
	if(data.length == 0) throw new IllegalArgumentException("empty array");

	//if end and start are the same, then you're done
	int[] aaa = {start, start};
	if(end == start) return aaa;
	
	//chooses random pivot
	Random x = new Random();
	//p(end + "   "  + start);
	int pivot = x.nextInt(end - start + 1) + start;
	//pivot = 3; //debugging specific cases
	//move pivot out of way
	swap(data, pivot, start);
	pivot = start;

	//beingings of a great wall
	//wall marks the last element less than the pivot
	//wallEnd marks the element before the first element greater than the pivot
	//       wallEnd is the last element equal to the pivot at the end
	int wall = start;
	int wallEnd = end;

	//p(data);
	//p("  ");
	//put the wall in the right place
	int check = data[start];
	int i = start + 1;
	while(i <= wallEnd){
	    if (data[i] < check){
		wall ++;
		swap(data, i, wall);
	    }else if(data[i] > check){
		swap(data, i, wallEnd);
		wallEnd --;
		i --;
	    }
	    i ++;
	    //p(i);
	}
	

	//everything in the correct place and we just need to place the pivot
	swap(data, wall, pivot);
	pivot = wall;
	int[] ans = new int[2];
	ans[0] = pivot;
	ans[1] = wallEnd;
	return ans;
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
    public static void main(String[] args){
	int[] x = {5, 2, 1, 4, 3};
	p(x.length);
	p(partC(x, 0, x.length -1));
	p(x);

	p("\n\n\n");
	int[] ary = new int[10000];
	for (int i = 0; i < ary.length; i ++){
	    ary[i] = 10000 - i;
	}
	p(partC(ary, 0, ary.length - 1));
    }
}

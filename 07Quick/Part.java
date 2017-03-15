import java.util.*;

public class Part{

    public static int part(int[] data, int start, int end){
	//if end and start are too close then... well... you're done
	if(end - start <= 1) return start;
	
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

    //swaos data[x] and data[y]
    private static void swap(int[] data, int x, int y){
	int temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }


    public static void p(int[] x){
	for(int i = 0; i < x.length; i ++){
	    p(x[i]);
	}
    }

    public static void p(int x){
	System.out.println(x);
    }
    
    public static void main(String[] args){
	int[] x = {};
	p(x.length);
	p(x[part(x, 0, x.length - 1)]);
	p(x);

    }
}

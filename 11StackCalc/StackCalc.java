import java.util.*;

public class StackCalc{
    public static double eval(String line){
	String[] x = line.split(" ");
	ArrayDeque<Integer> pile = new ArrayDeque<Integer>();
	for(int i = 0; i < x.length; i ++){
	    check(x[i], pile);
	}
	return pile.pop();
    }
    
    private static void check(String x, Deque<Integer> pile){
	System.out.println(x);
	switch (x){
	case "+":
	    int a = pile.removeLast();
	    int b = pile.removeLast();
	    pile.add(b + a);
	    break;

	case "-":
	    int c = pile.removeLast();
	    int d = pile.removeLast();
	    pile.add(d - c);
	    break;

	case "*":
	    int e = pile.removeLast();
	    int f = pile.removeLast();
	    pile.add(f * e);
	    break;
	    
	case "/":
	    int g = pile.removeLast();
	    int h = pile.removeLast();
	    pile.add(h / g);
	    break;

	case "%":
	    int i = pile.removeLast();
	    int j = pile.removeLast();
	    pile.add(j % i);
	    break;
	 
	default:
	    System.out.println(x);
	    pile.add(Integer.getInteger(x));
	}
    }
}

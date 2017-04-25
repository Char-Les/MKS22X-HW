import java.util.*;

public class StackCalc{
    public static double eval(String line){
	String[] x = line.split(" ");
	ArrayDeque<Double> pile = new ArrayDeque<Double>();
	for(int i = 0; i < x.length; i ++){
	    check(x[i], pile);
	    System.out.println(pile.getLast());
	}
	return pile.pop();
    }
    
    private static void check(String x, Deque<Double> pile){
	switch (x){
	case "+":
	    double a = pile.removeLast();
	    double b = pile.removeLast();
	    pile.add(b + a);
	    break;

	case "-":
	    double c = pile.removeLast();
	    double d = pile.removeLast();
	    pile.add(d - c);
	    break;

	case "*":
	    double e = pile.removeLast();
	    double f = pile.removeLast();
	    pile.add(f * e);
	    break;
	    
	case "/":
	    double g = pile.removeLast();
	    double h = pile.removeLast();
	    pile.add(h / g);
	    break;

	case "%":
	    double i = pile.removeLast();
	    double j = pile.removeLast();
	    pile.add(j % i);
	    break;
	 
	default:
	    Double y = new Double(x);
	    pile.add(y);
	}
    }
}

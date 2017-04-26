import java.util.*;

public class StackCalc{
    public static double eval(String line){
	String[] x = line.split(" ");
	ArrayDeque<Double> pile = new ArrayDeque<Double>();
	for(int i = 0; i < x.length; i ++){
	    check(x[i], pile);
	}
	return pile.pop();
    }
    
    private static void check(String x, Deque<Double> pile){
	try{
	    Double y = new Double(x);
	    pile.add(y);
	}catch (NumberFormatException e){
	    double a = pile.removeLast();
	    double b = pile.removeLast();
	    switch (x){
	    case "+":
		pile.add(b + a);
		break;
		
	    case "-":
	        pile.add(b - a);
		break;
		
	    case "*":
		pile.add(b * a);
		break;
		
	    case "/":
		pile.add(b / a);
		break;
		
	    case "%":
		pile.add(b % a);
		break;
	    }	
	}
    }
}

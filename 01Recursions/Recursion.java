public class Recursion{
    //required name function
    public static String name(){
	return "Weng,Charles";
    }

    //starts off the recursion and checks if the number given is valid
    public static double sqrt(double n) throws IllegalArgumentException{
	if(n < 0)
	    throw new IllegalArgumentException("sqrt: " + n);
	return helper(n, 1);
    }

    //this is the function that loops itself until it's good enough
    public static double helper(double n, double guess){
	if (close(n, guess * guess)){
	    return guess;
	}
	return helper(n, ((n / guess) + guess) / 2);	
    }

    //checks if two floats are close (a certain % of each other either way)
    public static boolean close(double a, double b){
	return close2(a,b) || close2(b,a);
    }

    //absolute value function
    public static double abs(double x){
	if (x < 0)
	    return -1 * x;
	return x;
    }

    //checks if b is within a certain % of a
    public static boolean close2(double a, double b){
	double x = abs(a * .00000000000001);
	return a + x > b && a - x < b;
    }

    //2 print funtions for debugging
    public static void p(String n){
	System.out.println(n);
    }
    public static void p(double n){
	p("" +n);
    }
    
    public static void main(String[] args){
	p(name());
	p(sqrt(25));
	p(sqrt(2.2));
	p(sqrt(100.123124513524352));
	p(sqrt(625 + 123819));
	p(sqrt(-25));
	
    }
}

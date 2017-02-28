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
	//if a or b is 0 then close2 can only return false
	if (a == 0.0)             return b < 0.00000000000000000000000000001;
	if (b == 0.0)             return a < 0.00000000000000000000000000001;
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
	p("" + close(0, 0.00000001));
	//p(sqrt(0.0));
	p(sqrt(2.0));
	p(sqrt(100.0));
	p(sqrt(4.0));
	p(sqrt(-25));
	
    }
}

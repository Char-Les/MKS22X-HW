public class Recursion{ 
    public static String name(){
	return "Weng,Charles";
    }

    public static double sqrt throws IllegalArgumentException(double n){
	if(n < 0){
	    throw new IllegalArgumentException("sqrt: " + n);
	}
	double guess = 1;
	while (!close(n,guess)){
	    guess = ((n / guess) + guess) / 2;
	}
	
    }

    public static boolean close(double a, double b){
	return close2(a,b) || close2(b,a);
    }
    
    public static double abs(double x){
	if (x < 0)
	    return -1 * x;
	return x;
    }

    public static boolean close2(double a, double b){
	double x = abs(a * .00000000000001);
	return a + b > b && a -b < b;
    }
    
    public static void main(){
    }
}

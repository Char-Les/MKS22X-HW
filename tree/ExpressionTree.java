public class ExpressionTree{
    /*instance variables, constructors, and some methods not shown*/
  
    /*accessor method for the value, precondition is that isValue() is true.*/
    private double getValue(){    /*implementation not shown*/ }
    /*accessor method for the operation, precondition is that isOp() is true.*/
    private char getOp(){    /*implementation not shown*/  }    
    /* accessor method for left, precondition is that isOp() is true.*/
    private ExpressionTree getLeft(){    /*implementation not shown*/  }
    /* accessor method for right, precondition is that isOp() is true.*/
    private ExpressionTree getRight(){    /*implementation not shown*/  }

    private boolean isOp(){    /*implementation not shown*/  }
    private boolean isValue(){    /*implementation not shown*/  }


    /* you write these four methods, hint: think recursively */

    /*return the expression as an infix notation string with parenthesis*/
    /* The sample tree at the top would be: "( 3 + (2 * 10))"     */
    public String toString(){
	if(isOp())
	    return "(" + getLeft().toString() + " " + getOp() + " " + getRight.toString() + ")";
	return "" + getValue();
    }

    /*return the expression as a postfix notation string without parenthesis*/
    /* The sample tree would be: "3 2 10 * +"     */
    public String toStringPostfix(){
	if(isOp())
	    return getLeft().toString() + " " + getRight.toString() + " " + getOp();
	return "" + getValue();
    }

    /*return the expression as a prefix notation string without parenthesis*/
    /* The sample tree would be: "+ 3 * 2 10"     */
    public String toStringPrefix(){
	if(isOp())
	    return getOp() + " " + getLeft().toString() + " " + getRight.toString();
	return "" + getValue();
    }

    /*return the value of the expression tree*/
    public double evaluate(){
	if(isOp()){
	    double a = getRight().evaluate();
	    double b = getLeft().evaluate();
	    switch (x){
	    case '+':
		return b + a;
		
	    case '-':
	        return b - a;
		
	    case '*':
		return b * a;
       	
	    case '/':
		return b / a;
		
	    case "%":
		return b % a;
	    }
	  
	    return getValue();
	}

    }

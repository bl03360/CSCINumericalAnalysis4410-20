package project3;

public class Bisection {
	 //coefficients of polynomial f(x)=c[n-1]x^(n-1)+...+c[1]x+c[0]
    double[] c;
    // constructor
    public Bisection(double[] coeff) {
        c = coeff;
    }
    
    // evaluate the polynomial using Horner's Rule
    double f(double x) {
    	int n = c.length-1;//3
    	double result = c[n];//1
    	for(int i = n-1;i >= 0;i--) {
    		result = (result * x) + c[i]; 
    	}
    	return result;
    }
    
    //Use bisection to find a solution f(x)=0 in [a, b] with tolerance tol and max iterations n0
    public double bisection(double a, double b, int n0, double tol) {
    	int i = 1;
    	double FA = f(a);//right
    	
    	while(i <= n0) {
    		double p = a+(b-a)/2;
    		double FP = f(p);//right
    		
    		if((b-a)/2 < tol || FP == 0) {
    			return p;
    		}
    		
    		i++;
    		
    		if(FA * FP > 0) {
    			a = p;
    			FA = FP;
    		}
    		else {
    		b = p;
    		}
    	}
    		System.out.println("Bisection Failure after " + n0 + " iterations.");
    		return a;
    		
    }
    
    //Test code
    public static void main(String[] args) {
        double[] c = {1, -2, -3, 1};
        Bisection solver = new Bisection(c);
        double s = solver.bisection(0, 1, 100, 0.0001);
        System.out.println("x1 = " + s);
        s = solver.bisection(-1, 0, 100, 0.0001);
        System.out.println("x2 = " + s);
    }
}


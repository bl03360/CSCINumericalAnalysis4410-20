package project6;

import java.awt.Point;

public class Bezier {
    static double[] a = new double[4];
    static double[] b = new double[4];
    static double[] num;

    public static void set(Point[] p) {
        a[0] = p[0].getX();
        b[0] = p[0].getY();
        a[1] = 3 * (p[1].getX() - a[0]);
        b[1] = 3 * (p[1].getY() - b[0]);
        a[2] = 3 * (a[0] + p[2].getX() - 2 * (p[1].getX()));
        b[2] = 3 * (b[0] + p[2].getY() - 2 * (p[1].getY()));
        a[3] = p[3].getX() - a[0] + 3 * (p[1].getX() - p[2].getX());
        b[3] = p[3].getY() - b[0] + 3 * (p[1].getY() - p[2].getY());
    }

    public static Point[] evaluate(int n) {
    	num = new double[n];
    	Double t = 0.0;
        int count = 0;
        double val1 = a[0];
        double val2 = b[0];
        Point[] pts = new Point[n];
        for (int i= 0;i < n;i++) {
            pts[i] = new Point();
            count = 1;
            while(count < 4) {
            	//System.out.println(count);
                val1 = (val1 * t) + a[count];
                val2 = (val2 * t) + a[count];
                count++;
            }
            pts[i].setLocation(val1,val2);
            num[i] = t;
            t += .1;
        }
        return pts;
    }

    public static void main(String[] args) {    	
    	Point[] pts = new Point[4];
        pts[0] = new Point(124,52);
        pts[1] = new Point(248,61);
        pts[2] = new Point(436,23);
        pts[3] = new Point(725,15);

        set(pts);
        
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " " + b[i]); 
        }
        
        Point[] p = evaluate(20);
        
        for(int i = 0; i < p.length; i++){
            System.out.println("x: " + p[i].getX() + " y: " + p[i].getY() + " with t: " + num[i]);
        }
    }
}

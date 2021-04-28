package com.SLR;

import java.util.Scanner;

public class SLR {
    
    static double [] x = {23,26,30,34,43,48,52,57,58};
    static double [] y = {651,762,856,1063,1190,1298,1421,1440,1518};
    static double sx, sy, sx2, sy2, xy, b1, b0, slr, val;
    
    public static double sigmax(){
        for (int i=0; i<x.length ; i++){
            sx+=x[i];
        }
        return sx;
    }
    public static double sigmay(){
        for (int i=0; i<y.length ; i++){
            sy+=y[i];
        }
        return sy;
    }
    public static double sigmax2(){
        double sqr=0;
        for (int i=0 ; i<x.length ; i++){
            sqr=Math.pow(x[i], 2);
            sx2+=sqr;
        }
        return sx2;
    }
     public static double sigmay2(){
        double sqr=0;
        for (int i=0 ; i<y.length ; i++){
            sqr=Math.pow(y[i], 2);
            sy2+=sqr;
        }
        return sy2;
    }
     public static double smxy(){
         double mxy=0;
         for(int i=0 ; i<x.length ; i++){
             for(int j=0 ; j<y.length ; j++){
                mxy=x[i]*y[i];
             }
             xy+=mxy;
         }
         return xy;
     }
     public static double beta1(double xy,double x,double y,double x2){
         b1=((9*xy)-(x*y))/((9*x2)-(x*x));
         return b1;
     }
     public static double beta0(double y, double x, double x2, double xy, double b){
         b0=(y-(b*x))/9;
         return b0;
     }
     public static double LinearRegression(double x, double m, double b){
         slr=(m*x)+b;
         return slr;
     }
	 public static double read(double val){
		return val;
	 }

    public static void main(String[] args) {
        
        double x=1;
        double a = sigmax();
        double b = sigmay();
        double c = sigmax2();
        double d = sigmay2();
        double e = smxy();
        double b1 = beta1(e,a,b,c);
        double b0 = beta0(b, a, c, e, b1);
        double y = LinearRegression(x,b1,b0);
        System.out.println(y+" = "+b1+"("+x+") + "+b0);
    }
    
}


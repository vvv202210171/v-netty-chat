package org.example.recursion;

public class FactorialDemo {
    public static void main(String[] args) {
    int res= factorial(5);
        System.out.println(res);
    }
    public static  int factorial(int n){
        if(n==1){
            return 1;
        }
        return factorial(n-1)*n;
    }

}

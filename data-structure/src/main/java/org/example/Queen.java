package org.example;

import java.util.Arrays;

public class Queen {
    int max = 8;
    int[] arr=new int[max];
    int count=0;

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
        System.out.println(queen.count);
    }

    public void check(int n) {
        if (max == n) {
            count++;
            show();

            return;
        }
        for (int i=0;i<max;i++){
            arr[n]=i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //判断是否在同一斜线上或者在同一列上
            if(arr[i]==arr[n]||  Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }

        }
        return true;
    }

    public  void test(){
        int n=10;
        int i=1;
        while (i<n){
            i=i*2;
        }

        //n=8 t=3
        //n=16 t=4pos

    }
    public void show() {
        for (int i : arr) {
            System.out.printf("%d\t",i);
        }
        System.out.println();
    }


}

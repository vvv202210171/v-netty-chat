package org.example.arrayqueue;

import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        boolean loop=true;
        while (loop){
            System.out.println("请输入遗下命令");
            System.out.println("1 add");
            System.out.println("2 get");
            System.out.println("3 show");
            Scanner scanner=new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i){
                case 1:  System.out.println("add");
                    scanner=new Scanner(System.in);
                    int i1 = scanner.nextInt();
                    try {
                        arrayQueue.add(i1);
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("加入成功");
                    break;
                case 2:  System.out.println("get");
                    try {
                        int i2 = arrayQueue.get();
                        System.out.println("拿到数据"+i2);

                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:  System.out.println("show");
                    try {
                        arrayQueue.show();
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:  System.out.println("head");
                    try {
                        System.out.println("head");
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}


/**
 * 1.定义队列最大值，初始值，当前值，数组
 * 2.添加判断是否为空
 * 3.添加是否以满
 * 4.添加加入队列方法
 * 5，从队列取出
 * 6，显示队列
 */
class  ArrayQueue{
    private  int maxSize;
    private int[] arr;
    private int start=-1;
    private int end=-1;

    ArrayQueue(int maxSize){

        arr=new int[maxSize];
    }
    public  boolean isEmpty(){
        return  start==end;
    }
    public  boolean isFull(){
        return  start==maxSize-1 &&start!=-1;
    }
    public void  add(int data){
        if(isFull()){
            throw new RuntimeException( "is full");
        }
        start++;
        arr[start]=data;
    }
    public  int  get(){
        if(isEmpty()){
            throw new RuntimeException( "is empty");
        }
        end++;
        return arr[end];
    }

    public int head(){
        if(isEmpty()){
            throw new RuntimeException( "is empty");
        }
        return arr[start+1];
    }

    public  void  show(){
        for (int i = end+1; i < start+1; i++) {
            System.out.printf("%d\t",arr[i]);
        }
    }

}

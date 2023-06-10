package org.example.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        boolean loop=false;
        Scanner scanner=new Scanner(System.in);
        while (true){
            if(loop){
                System.out.println("exit...");
                break;
            }
            System.out.println("show");
            System.out.println("pop");
            System.out.println("push");
            System.out.println("exit");
            String next = scanner.next();
            switch (next){
                case "show":arrayStack.show();
                break;
                case "pop":
                    try {
                    System.out.println(arrayStack.pop());
                    }catch (RuntimeException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "push":
                    int nextInt = scanner.nextInt();
                    arrayStack.push(nextInt);
                    break;
                case "exit":loop=true;


            }
        }
    }
}

class ArrayStack{
    private int maxSize;
    private  int top=-1;
    int []stacks;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stacks=new int[this.maxSize];
    }

    private  boolean isEmpty(){
        return  top==-1;
    }
    private  boolean isFull(){
        return  top==maxSize-1;
    }
    public  void  push(int num){
        if(isFull()){
            System.out.println("已满");
            return;
        }
        top++;
        stacks[top]=num;
    }
    public  int pop(){
        if(isEmpty()){
            throw new RuntimeException("没有数据");
        }
       int num= stacks[top];
        top--;
        return num;
    }
    public void show(){
        for (int i = top; i >=0 ; i--) {
            System.out.println(stacks[i]);
        }
    }
}

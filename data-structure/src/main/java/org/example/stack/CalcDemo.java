package org.example.stack;

public class CalcDemo {
    public static void main(String[] args) {
        String expression = "30*2-6/2-8-11";
        int index = 0;
        CalArrayStack numberStack = new CalArrayStack(10);
        CalArrayStack operStack = new CalArrayStack(10);
        String numStr = "";
        while (true) {
            char c = expression.charAt(index);
            if (operStack.isSymbol(c)) {
                if (operStack.isEmpty()) {
                    operStack.push(c);
                } else if (operStack.priority(c) >= operStack.priority((char) operStack.getTop())) {
                    operStack.push(c);
                } else {
                    int pop = operStack.pop();
                    int num1 = numberStack.pop();
                    int num2 = numberStack.pop();
                    int res = operStack.calc(num1, num2, (char) pop);
                    numberStack.push(res);
                    operStack.push(c);
                }
            } else {
                numStr = numStr.concat(String.valueOf(c - 48));
                if (index == expression.length() - 1) {
                    numberStack.push(Integer.parseInt(numStr));
                    numStr = "";
                } else {
                    char next = expression.charAt(index + 1);
                    if (operStack.isSymbol(next)) {
                        numberStack.push(Integer.parseInt(numStr));
                        numStr = "";
                    }
                }
            }
            index++;
            if (index == expression.length()) {
                break;
            }
        }
        CalArrayStack resStack = new CalArrayStack(20);
        if (!numberStack.isEmpty()) {
            resStack.push(numberStack.pop());
        }
        while (!operStack.isEmpty()) {
            resStack.push(operStack.pop());
            resStack.push(numberStack.pop());
        }
        int res = resStack.pop();
        while (!resStack.isEmpty()) {
            char oper = (char) resStack.pop();
            int num1 = resStack.pop();
            res = resStack.calc(num1, res, oper);
        }

        System.out.printf("expression%s=%d\n", expression, res);

    }
}

class CalArrayStack {
    private int top;
    private int maxSize;
    private int[] stacks;

    public CalArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stacks = new int[maxSize];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == maxSize - 1;
    }

    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        return stacks[top];
    }

    public void push(int num) {
        if (isFull()) {
            System.out.println("已满");
            return;
        }
        top++;
        stacks[top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        int num = stacks[top];
        top--;
        return num;
    }

    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stacks[i]);
        }
    }

    public int priority(char oper) {
        if (oper == '+' || oper == '-') {
            return 0;
        }
        if (oper == '*') {
            return 2;
        }
        if (oper == '/') {
            return 1;
        }
        throw new RuntimeException("运算符不正确");
    }

    public int calc(int num1, int num2, char oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
        }
        throw new RuntimeException("运算符不正确");

    }

    public boolean isSymbol(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;

    }


}

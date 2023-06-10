package org.example.linklist;

public class CircleLinkedListDemo {
    public static void main(String[] args) {

        CircleLinkedList circleLinkedList = new CircleLinkedList();
//        circleLinkedList.add(10);
//        circleLinkedList.show();
            circleLinkedList.Joseph(3,3,10);
    }

}

class CircleLinkedList {
    public CircleNode first;

    public void add(int nums) {
        if (nums < 0) {
            System.out.println("值输入不正确");
            return;
        }
        CircleNode cur = first;
        for (int i = 1; i <= nums; i++) {
            CircleNode circleNode = new CircleNode(i);
            if (i == 1) {
                first = circleNode;
                circleNode.next = first;
            } else {
                circleNode.next = first;
                cur.next = circleNode;
            }
            cur = circleNode;

        }
    }

    public void show() {
        CircleNode help = first;
        while (true) {
            System.out.println(help);
            if (help.next == first) {
                break;
            }
            help=help.next;
        }
    }

    public void Joseph(int startNo,int step,int num){
        if(num<=-1||startNo>num){
            System.out.println("参数不合理");
            return;
        }
        System.out.printf("startNo=%d,step=%d,num=%d\n",startNo,step,num);
        add(num);
    //    show();
        System.out.println("=======");
        CircleNode help = first;
        while (true){
            if (help.next == first) {
                break;
            }
            help=help.next;
        }
            CircleNode start=first;
        for (int i = 1; i <= startNo-1; i++) {
            start=start.next;
            help=help.next;
        }


        while (true){
            if(start.next==start){
                System.out.println("出圈节点"+start);
                break;
            }
            for (int i = 1; i < step; i++) {
                start=start.next;
                help=help.next;
            }
            System.out.println("出圈节点"+start);

            help.next=start.next;
            start=start.next;

        }



    }

}

class CircleNode {
    public int no;
    public CircleNode next;

    public CircleNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "no=" + no +
                '}';
    }
}

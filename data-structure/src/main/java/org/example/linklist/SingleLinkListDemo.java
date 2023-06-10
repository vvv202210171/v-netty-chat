package org.example.linklist;

public class SingleLinkListDemo {
    public static void main(String[] args) {
        HeroNode head = new HeroNode(0, "");
        SingleLinkList singleLinkList = new SingleLinkList(head);
        singleLinkList.add(new HeroNode(1, "z100"));
        singleLinkList.add(new HeroNode(2, "z200"));
        singleLinkList.add(new HeroNode(3, "z300"));
        singleLinkList.add(new HeroNode(4, "z400"));
        singleLinkList.add(new HeroNode(5, "z500"));

        singleLinkList.show();
        System.out.println("size="+singleLinkList.size());
        HeroNode reverse = singleLinkList.reciprocal(2);
        System.out.println("倒数第2的节点是"+reverse);

        singleLinkList.reverse();
        singleLinkList.show();
    }
}

class SingleLinkList {
    public HeroNode head;

    public SingleLinkList(HeroNode head) {
        this.head = head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void show() {
        HeroNode temp = head;
        while (true) {
            temp = temp.next;
            if (temp == null) {
                break;
            }
            System.out.println(temp);
        }
    }

    public int size() {
        HeroNode temp = head;
        if (temp.next == null) {
            return 0;
        }

        int count=0;
        while (temp.next!=null){
            count++;
        temp=temp.next;
        }

        return count;

    }


    public HeroNode reciprocal(int k){
        int size=size();
        if(size<k||k<=0){
            return null;
        }
        HeroNode temp = head.next;
        int len=size-k;
        for (int j = 0; j <len ; j++) {
            temp=temp.next;
        }
        return temp;

    }
     public  void  reverse(){
        if(head.next==null||head.next.next==null){
            return;
        }
        HeroNode reverseHead= new HeroNode(0,"");
         HeroNode curr = head.next;
         HeroNode next=null;
         while (curr!=null){
            next=curr.next;
            curr.next=reverseHead.next;
             reverseHead.next=curr;
             curr=next;
         }
         head.next=reverseHead.next;
     }

}

class HeroNode {
    public int no;
    public String name;
    public HeroNode next;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name=" + name +
                '}';
    }
}

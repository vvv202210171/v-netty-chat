package org.example.linklist;

public class DoubleLinkListDemo {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();
//        doubleLinkList.add(new HeroNodeDouble(100,"name100"));
//        doubleLinkList.add(new HeroNodeDouble(400,"name200"));
//        doubleLinkList.add(new HeroNodeDouble(300,"name300"));
//        doubleLinkList.add(new HeroNodeDouble(20,"name400"));
        doubleLinkList.addSort(new HeroNodeDouble(100,"name100"));
        doubleLinkList.addSort(new HeroNodeDouble(400,"name200"));
        doubleLinkList.addSort(new HeroNodeDouble(300,"name300"));
        doubleLinkList.addSort(new HeroNodeDouble(200,"name400"));
        doubleLinkList.addSort(new HeroNodeDouble(600,"name400"));
        doubleLinkList.addSort(new HeroNodeDouble(700,"name400"));
        doubleLinkList.addSort(new HeroNodeDouble(200,"name400"));
        System.out.println("========show double list===========");
        doubleLinkList.show();;

        System.out.println("=========update ============");
        doubleLinkList.update(300,"name300update");
        doubleLinkList.show();

        System.out.println("=========delete ============");
        doubleLinkList.delete(300);
        doubleLinkList.show();
    }
}

class DoubleLinkList{
    public  HeroNodeDouble head=new HeroNodeDouble(0,null);


    public void add(HeroNodeDouble heroNodeDouble){
        HeroNodeDouble temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=heroNodeDouble;
        heroNodeDouble.pre=temp;
    }
    public void addSort(HeroNodeDouble heroNodeDouble){
        if(head.next==null){
            head.next=heroNodeDouble;
            heroNodeDouble.pre=head;
            return;
        }
        HeroNodeDouble temp=head;
        boolean flag=false;

        while (temp.next!=null){
            if(temp.next.no>heroNodeDouble.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(!flag){
           temp.next=heroNodeDouble;
            heroNodeDouble.pre=temp.next;
            return;
        }
        heroNodeDouble.next=temp.next;
        heroNodeDouble.pre=temp;
        HeroNodeDouble helper= temp.next;
        temp.next=heroNodeDouble;
        helper.pre=heroNodeDouble;




    }
    public  void update(int no,String name){
        HeroNodeDouble temp=head.next;
        boolean flag=false;
        while (temp!=null){
            if(temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(!flag){
            return;
        }
        temp.name=name;
    }
    public  void show(){
        HeroNodeDouble temp=head.next;
        while (temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }

    }

    public  void delete(int no){
        HeroNodeDouble temp=head.next;
        boolean flag=false;
        while (temp!=null){
            if(temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(!flag){
            return;
        }

        temp.pre.next=temp.next;
        if(temp.next!=null){
            temp.next.pre=temp.pre;
        }


    }
}

class HeroNodeDouble {
    public int no;
    public String name;
    public HeroNodeDouble next;
    public HeroNodeDouble pre;

    public HeroNodeDouble(int no, String name) {
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

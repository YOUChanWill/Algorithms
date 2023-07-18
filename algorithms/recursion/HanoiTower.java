package recursion;

import java.util.LinkedList;

public class HanoiTower {

    // 代表三根圆柱
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n){
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    static void move(int n,LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c){
        if (n == 0) return;
        move(n - 1,a,c,b); // n - 1个盘子由a移动至b
        c.addLast(a.removeLast()); // 最后的圆盘由a移动至c
        print();
        move(n - 1,b,a,c);// n - 1个盘子由b移动至c
    }

    private static void print(){
        System.out.println("==============");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void main(String[] args) {
        init(4);
        print();
        move(4,a,b,c);

    }


}

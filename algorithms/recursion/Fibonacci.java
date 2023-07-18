package recursion;

public class Fibonacci {

    public static int f(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        int x = f(n - 1);
        int y = f(n - 2);
        return x + y;
    }
    // 楼梯问题，一次跳一阶或者两阶，有几种方法
    public static int stair(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return stair(n - 1)+stair(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(stair(5));
        System.out.println(f(10));
    }

}

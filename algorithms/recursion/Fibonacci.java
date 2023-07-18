package recursion;

import java.util.Arrays;

public class Fibonacci {

    // 递归的改进，使用Memoization方法,使用数组存结果（使用空间换时间）
    public static int fibonacci(int n){
        int[] cache = new int[n + 1];
        Arrays.fill(cache,-1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n,cache);
    }

    public static int f(int n,int[] cache){
        if (cache[n] != -1) return cache[n];

        int x = f(n - 1,cache);
        int y = f(n - 2,cache);

        cache[n] = x + y;
        return cache[n];
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
        System.out.println(fibonacci(10));
    }

}

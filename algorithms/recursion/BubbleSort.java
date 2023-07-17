package recursion;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] list){
        bubble(list, list.length - 1);
    }
    private static void bubble(int[] list,int j){
        if (j == 0) return; // j表示未排序的右边边界
        int x = 0; // 设置边界的初始值
        for (int i = 0; i < j; i++) {
            if (list[i] > list[i + 1]){
                int temp = list[i];
                list[i] = list[i + 1];
                list[i + 1] = temp;
                x = i; // 边界后移
            }
        }
        bubble(list,x);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2,5,22,6,1,54,98,3,43,23};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }

}

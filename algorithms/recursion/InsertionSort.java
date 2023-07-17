package recursion;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] list){
        insertion01(list,1);
    }
    private static void insertion01(int[] list,int low){
        if (low == list.length) return;

        int cur = list[low];
        int i = low - 1;

        while (i >= 0 && list[i] > cur){
            list[i + 1] = list[i];
            i--;
        }
        list[i + 1] = cur;
        insertion01(list, low + 1);
    }

    // 一种开销更大的算法
    private static void insertion02(int[] list,int low){
        if (low == list.length) return;

        int i = low - 1;

        while (i >= 0 && list[i] > list[i + 1]){
            int temp = list[i];
            list[i] = list[i + 1];
            list[i + 1] = temp;
            i--;
        }

        insertion02(list, low + 1);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2,5,22,6,1,54,98,3,43,23};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}

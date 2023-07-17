package recursion;

public class BinarySearch {

    public static int search(int[] list,int target){
        return f(list,target,0, list.length - 1);
    }

    private static int f(int[] list,int target,int i,int j){
        if (i > j){
            return -1;
        }
        int m = (i + j) >>> 1; // 右移，等于除二
        if (target < list[m]){
            return f(list,target,i,m - 1);// 大于目标值，左移
        } else if (target > list[m]) {
            return f(list,target,m + 1,j);// 小于目标值，右移
        }else return m;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,6};
        System.out.println(search(ints,9));
    }

}

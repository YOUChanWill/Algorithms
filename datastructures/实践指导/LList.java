package 实践指导;

public class LList {
    private int next;

    // 统计并返回表中值为X的元素的个数
    public static int count(LList list,Object X){
        int t = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.value(i + 1).equals(X)){
                t++;
            }
        }
        return t;
    }
    // 线性表中所有元素的最小值
    public static Object minmum(LList list){
        if (list.size() == 0){
            return 0;
        }
        Object min = list.value(1);
        for (int i = 2; i < list.size(); i++) {
            Object x = list.value(i);
            if (x < min){
                min = x;
            }
        }
        return min;
    }
    // 从线性表中删除与X值相同的所有元素
    public static void delete(LList list, Object X){
        while (1){
            int k = list.find(X);
            if (k == -1){
                break;
            }else list.remove(k);
        }
    }

    // 设计判断单链表中元素是否递增的算法
    public int isriseLList(LList head){
        if (head == 0 || head.next == 0){
            return 1;
        }else {
            for (q = head, p = head.next; p != null; q = p, p = p.next) {
                if (q.data.compare to(p.data) > 0){
                    return 0;
                }
            }
            return 1;
        }
    }

    // 线性表的大小
    private int size() {
        return 0;
    }

    // 返回线性表中第pos个元素的值
    private Object value(int pos) {
        return null;
    }

    private int find(Object x) {
        return 0;
    }

    private Object remove(int k) {
        return null;
    }
}

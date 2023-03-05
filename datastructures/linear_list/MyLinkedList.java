package linear_list;

public class MyLinkedList<T> {
    public Node<T> head; // 头指针

    public MyLinkedList() {
        this.head = new Node<T>();
    }

    public MyLinkedList(T[] values) {
        Node<T> rear = head;// 创建空链表，只有头节点
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null){
                rear.next = new Node<>(values[i], null); // 在尾部插入
                rear = rear.next;
            }
        }
    }

    public boolean isEmpty(){
        return head.next == null;
    }

    public T get(int i){
        Node<T> p = head.next;
        for (int j = 0;p != null && j < i; j++) {
            p = p.next;
        }
        return (i >= 0 && p != null) ? p.data : null;
    }

    public void set(int i, T x){
        if (x == null) throw new NullPointerException("x == null");
        Node<T> p = head;
        if (i >= 0 && i < ListLength()){
            for (int j = 0; j <= i; j++) {
                p = p.next;
            }
        }else throw new IndexOutOfBoundsException(i + "");
        p.data = x;
    }

    public int ListLength(){ // 获取链表长度
        int length = 0;
        Node<T> currentNode = head;//当前结点默认为头节点
        while (currentNode != null){
            length++;
            currentNode = currentNode.next;//如果当前结点不为null，则指向下一个结点。
        }
        return length;
    }

    @Override
    public String toString() {
        String str = getClass().getName() + "(";
        for (Node<T> p = head.next; p != null; p = p.next) {
            str += p.data.toString() + (p.next != null ? "," : "");
        }
        return str + ")";
    }

    public Node<T> insert(int i, T x){
        if (x == null) return null;
        Node<T> front = head;
        for (int j = 0;front.next != null && j < i; j++) {
            front = front.next;
        }
        front.next = new Node<T>(x,front.next);
        return front.next;
    }

    public Node<T> insert(T x){
        return insert(Integer.MAX_VALUE, x);
    }

    public T remove(int i){
        Node<T> front = head;
        for (int j = 0; front.next != null && j < i; j++) {
            front = front.next;
        }
        if (i >= 0 && front.next != null){
            T x = front.next.data;
            front.next = front.next.next;
            return x;
        }
        return null;
    }

    public void clear(){
        head.next = null;
    }

    public Node<T> search(T key){
        Node<T> front = head;
        for (int i = 0; i < ListLength(); i++) {
            if (key.equals(front.data)) return front;
            front = front.next;
        }
        return null;
    }

    public T remove(T key){
        Node<T> front = head;
        if (key.equals(front.data)){
            front.next = head;
        }
        for (int j = 1; j < ListLength(); j++) {
            if (key.equals(front.next.data)){
                T x = front.next.data;
                front.next = front.next.next;
                return x;
            }
            front = front.next;
        }
        return null;
    }




}

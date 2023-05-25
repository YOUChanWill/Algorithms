package stack_queue;

class MyQueue {
    private Object[] elements;
    private int front;  // 队列头部索引
    private int rear;  // 队列尾部索引
    private int size;  // 队列中元素的数量
    private int capacity;  // 队列的容量

    public MyQueue(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(Object item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        elements[rear] = item;
        size++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object dequeuedItem = elements[front];
        front = (front + 1) % capacity;
        size--;
        return dequeuedItem;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }
}
public class Queue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println("Queue size: " + queue.size());  // 输出：3

        while (!queue.isEmpty()) {
            System.out.println("Dequeued item: " + queue.dequeue());
        }

        System.out.println("Queue size: " + queue.size());  // 输出：0
    }
}

package stack_queue;

import linear_list.MyArrysList;

public class MySeqStack<T> implements MyStack<T> {
    private MyArrysList<T> list; // 使用线性表

    public MySeqStack(int length) {
        this.list = new MyArrysList<>(length); // 自定义栈的容量
    }
    public MySeqStack(){
        this(64); // 栈的默认容量
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T x) {
        list.insert(x);
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public T pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public String toString() {
        String str = this.getClass().getName() + "(";
        return str + ")";
    }


}

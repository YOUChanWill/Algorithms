package chapter01;

public class MyArrysList<T>{
    protected int n; // 顺序表长度
    protected Object[] element; //存储顺序表的数据
    private static final int MIN_CAPACITY = 10; //数组容量的最小值

    public MyArrysList(int length) { // 创建输入设定参数的空表
        if (length < MIN_CAPACITY) length = MIN_CAPACITY;
        this.n = 0;
        this.element = new Object[length];
    }
    public MyArrysList() { // 创建默认容量的空表
        this(MIN_CAPACITY);
    }

    public MyArrysList(T[] values) {
        this(values.length * 2);
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) this.element[this.n++] = values[i]; // 对象引用赋值
        }
    }

    public boolean isEmpty(){return this.n == 0;} // 判断是否为空

    public int size(){return  this.n;} // 返回元素个数

    public T get(int i){
        if (i >= 0 && i < this.n) return (T) this.element[i]; // 返回数组元素引用的对象
        return null;
    }

    public void set(int i, T x){
        if (x == null) throw new NullPointerException("x == null");
        if (i >= 0 && i < this.n){
            this.element[i] = x;
        }else throw new IndexOutOfBoundsException(i + "");
    }

    @Override
    public String toString() {
        String str = this.getClass().getName() + "(";
        for (int i = 0; i < this.n; i++) {
            if (i != 0) str += ", ";
            str += this.element[i].toString();
        }
        return str + ")";
    }

    public int insert(int i,T x){
        if (x == null) return -1;
        if (i < 0) i = 0;
        if (i > this.n) i = this.n;

        Object[] source = this.element;
        if (this.n == element.length){
            this.element = new Object[source.length * 2];
            for (int j = 0; j < i; j++) {
                this.element[j] = source[j];
            }
        }

        for (int j = this.n - 1; j >= i ;j--) {
            this.element[j + 1] = source[j];
        }
            this.element[i] = x;
            this.n++;
            return i;

    }

    public int insert(T x){
        return insert(n,x);
    }

    public T remove(int i){
        if (i >= 0 && i < n ){
            T x = (T) element[i];
            for (int j = i; j < n - 1; j++) {
                element[j] = element[j + 1];
            }
            element[n - 1] = null;
            n--;
            return x;
        }
        return null;
    }

    public void clear(){
        n = 0; //设置长度为0
    }

    public int search(T key){
        for (int i = 0; i < n; i++) {
            if (key.equals(element[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}

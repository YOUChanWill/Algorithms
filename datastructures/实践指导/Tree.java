package 实践指导;

public class Tree {
    // 在二叉排序树上查找结点X的方法
    BinaryNode bstsearchX(BinaryNode t,int key){
        BinaryNode p = t;
        while (p != 0){
            if (p.key == key){
                return p;
            }else if (p.key > key){
                p = p.lchild;
            }else p = p.rchild;
        }
        return 0;
    }
}

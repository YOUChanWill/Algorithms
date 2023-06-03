package 实践指导;

import tree.BinaryTree;
import tree.MyQueue;
import tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryNode<T> {
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    private T data;

    // 求一棵二叉树中叶子节点总数的递归方法
    public int countleaf(BinaryNode<T> p){
        if (p == null) return 0;
        else if (p.left == null && p.right == null) {
            return 1;
        }
        else return countleaf(p.left) + countleaf(p.right);
    }
    
    // 递归算法，求二叉树p中关键字以x的结点为根的子树的深度
    public int getchilddepth(BinaryNode<T> p, T x){
        BinaryNode<T> q;
        q = searchNode(p,x);
        if (q == null) return 0;
        else return height(q);
    }

    // 返回结点在二叉树上的高度
    private int height(BinaryNode<T> p) {
        if (p == null) return 0;
        int lh = height(p.left);
        int rh = height(p.right);
        return (lh >= rh) ? lh+1 : rh+1;
    }

    private BinaryNode<T> searchNode(BinaryNode<T> p, T key) {
        if (p == null || key == null) return null;
        if (p.data.equals(key)) return p;
        BinaryNode<T> find = searchNode(p.left,key);
        if (find == null){
            find = searchNode(p.right, key);
        }
        return find;
    }

    // 判断是否为完全二叉树
    boolean isCompleteBinaryTree(BinaryNode<T> root) {
        if (root == null) {
            return true;
        }
        Queue<BinaryTree<T>> queue = new LinkedList<BinaryTree<T>>();
        queue.add(root);
        boolean flag = false; // 用于标记是否遇到空节点

        while (!queue.isEmpty()) {
            BinaryTree node = queue.poll();
            // 如果已经遇到空节点，且当前节点不为空，说明不是完全二叉树
            if (flag && node != null) {
                return false;
            }

            if (node == null) {
                flag = true; // 标记遇到空节点
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        return true;
    }

}

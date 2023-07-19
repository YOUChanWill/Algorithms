package tree;

import static tree.RedBlackTree.Color.BLACK;
import static tree.RedBlackTree.Color.RED;

public class RedBlackTree {

    enum Color {RED,BLACK;} // 红黑节点

    private Node root; // 根节点

    private static class Node{
        int key;
        Object value;
        Node left;
        Node right;
        Node parent; // 父节点
        Color color = RED; //新节点默认为红色

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        // 判断是否为左孩子
        boolean isLeftChild(){
            return parent != null && parent.left == this;
        }

        // 叔叔节点
        Node uncle(){
            if (parent == null || parent.parent == null) return null;
            if (parent.isLeftChild()) return parent.parent.right;
            else return parent.parent.left;
        }

        // 兄弟节点
        Node sibling(){
            if (parent == null) return null;
            if (this.isLeftChild()) return parent.right;
            else return parent.left;
        }
    }

    // 判断节点颜色
    boolean isRed(Node node){
        return node != null && node.color == RED;
    }

    boolean isBlack(Node node){
        return node == null || node.color == BLACK;
    }

    // 右旋、左旋
    private void rightRotate(Node node){
        Node parent = node.parent;
        Node yellow = node.left;
        Node green = yellow.right;
        if (green != null) green.parent = node;

        yellow.right = node;
        yellow.parent = parent;
        node.left = green;
        node.parent = yellow;
        if (parent == null) root = yellow;
        else if (parent.left == node) {
            parent.left = yellow;
        }else parent.right = yellow;
    }

    private void leftRotate(Node node){
        Node parent = node.parent;
        Node yellow = node.right;
        Node green = yellow.left;
        if (green != null) green.parent = node;

        yellow.left = node;
        yellow.parent = parent;
        node.right = green;
        node.parent = yellow;
        if (parent == null) root = yellow;
        else if (parent.right == node) {
            parent.right = yellow;
        }else parent.left = yellow;
    }

    // 红黑树更新
    public void put(int key,Object value){
        Node p = root;
        Node parent = null;
        while (p != null){
            if (key < p.key){
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            }else p.value = value;
            return;
        }
        Node inserted = new Node(key,value);
        if (parent == null){
            root = inserted;
        }else if (key < parent.key){
            parent.left = inserted;
            inserted.parent = parent;
        }else {
            parent.right = inserted;
            inserted.parent = parent;
        }
        fixRedRed(inserted);// 改变插入节点的颜色
    }

    void fixRedRed(Node x) {
        // 插入节点是根节点
        if (x == root){
            x.color = BLACK;
            return;
        }
        // 父亲节点是黑色，无需调整
        if (isBlack(x.parent)) return;
        // 叔叔节点为红色
        Node parent = x.parent;
        Node uncle = x.uncle();
        Node grandparent = parent.parent;
        if (isRed(uncle)){
            parent.color = BLACK;
            uncle.color = BLACK;
            grandparent.color = RED;
            fixRedRed(grandparent);
            return;
        }
        // 叔叔节点为黑色
        if (parent.isLeftChild() && x.isLeftChild()){ // 父亲左孩子，插入左孩子，LL不平衡
            parent.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        } else if (parent.isLeftChild() && !x.isLeftChild()) {// 父亲左孩子，插入右孩子，LR不平衡
            leftRotate(parent);
            x.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        } else if (!parent.isLeftChild() && !x.isLeftChild()) {// 父亲右孩子，插入右孩子，RR不平衡
            parent.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        }else { // 父亲右孩子，插入左孩子，RL不平衡
            rightRotate(parent);
            x.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        }
    }

}
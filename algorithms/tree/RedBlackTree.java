package tree;

import static tree.RedBlackTree.Color.BLACK;
import static tree.RedBlackTree.Color.RED;

public class RedBlackTree {

    enum Color {RED,BLACK} // 红黑节点

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

    // 红黑树的删除
    public void remove(int key){
        Node deleted = find(key);
        if (deleted == null) return;
        doRemove(deleted);
    }

    // 处理双黑,少了一个黑色节点
    private void fixDoubleBlack(Node x){
        if (x == root){
            return;
        }
        Node parent = x.parent;
        Node sibling = x.sibling();
        // 兄弟节点为红色，侄子节点为黑
        if (isRed(sibling)){
            if (x.isLeftChild()){
                leftRotate(parent);
            }else {
                rightRotate(parent);
            }
            parent.color = RED;
            sibling.color = BLACK;
            fixDoubleBlack(x);
            return;
        }
        // 兄弟节点为黑色，连个侄子节点为黑
        if (sibling != null) {
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = RED;
                if (isRed(parent)){
                    parent.color = BLACK;
                }else {
                    fixDoubleBlack(parent);
                }
            } else {// 兄弟节点为黑色，至少一个侄子节点为黑
                if (sibling.isLeftChild() && isRed(sibling.left)){ // LL
                    rightRotate(parent);
                    sibling.left.color = BLACK;
                    sibling.color = parent.color;
                }else if (sibling.isLeftChild() && isRed(sibling.right)){ // LR
                    sibling.right.color = parent.color;
                    leftRotate(sibling);
                    rightRotate(parent);
                } else if (!sibling.isLeftChild() && isRed(sibling)) {// RL
                    sibling.left.color = parent.color;
                    rightRotate(sibling);
                    leftRotate(parent);
                }else {// RR
                    leftRotate(parent);
                    sibling.right.color = BLACK;
                    sibling.color = parent.color;
                }
                parent.color = BLACK;
            }
        }else {
            fixDoubleBlack(parent);
        }
    }

    private void doRemove(Node deleted) {
        Node replaced = findReplaced(deleted);
        Node parent = deleted.parent;
        // 没有孩子
        if (replaced == null){
            if (deleted == root){
                root = null;
            }else {
                if (isBlack(deleted)){
                    fixDoubleBlack(deleted);
                }else {
                    // 匹配红色叶子无需处理
                }
                if (deleted.isLeftChild()){
                    parent.left = null;
                }else {
                    parent.right = null;
                }
                deleted.parent = null;
            }
            return;
        }
        // 有一个孩子
        if (deleted.left == null || deleted.right == null){
            // 删除的是根节点
            if (deleted == root){
                root.key = replaced.key;
                root.value = replaced.value;
                root.left = root.right = null;
            }else {
                if (deleted.isLeftChild()){
                    parent.left = replaced;
                }else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.left = deleted.right = deleted.parent = null;
                if (isBlack(deleted) && isBlack(replaced)){
                    fixDoubleBlack(replaced);
                }else {
                    replaced.color = BLACK;
                }
            }
            return;
        }
        // 有两个孩子
        int t = deleted.key;
        deleted.key = replaced.key;
        replaced.key = t;

        Object v = deleted.value;
        deleted.value = replaced.value;
        replaced.value = v;
        doRemove(replaced);
    }

    // 找到要删除的节点
    Node find(int key){
        Node p = root;
        while (p != null){
            if (key < p.key){
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            }else return p;
        }
        return null;
    }

    // 查找剩余节点
    Node findReplaced(Node delete){
        if (delete.left == null && delete.right == null) return null;
        if (delete.left == null) return delete.right;
        if (delete.right == null) return delete.left;
        Node s = delete.right;
        while (s.left != null){
            s = s.left;
        }
        return s;
    }
}

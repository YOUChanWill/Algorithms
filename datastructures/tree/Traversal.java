package tree;

import java.util.ArrayList;
import java.util.List;

public class Traversal {

    /**
     *二叉树的前序、中序、后序遍历，使用递归和栈的方式进行遍历。
     * **/

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    // 前序遍历，先根节点，再左边，再右边
    private void preorder(TreeNode root, List<Integer> list){
        if (root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    // 中序遍历，先左边，再根节点，再右边
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // 后序遍历，先左子树，再右子树，再根节点
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list){
        if (root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

}

class TreeNode { // 二叉树的定义
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(TreeNode left ,int val,  TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

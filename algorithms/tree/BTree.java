package tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BTree {

    static class Node{
        int[] keys; // 关键字
        Node[] children; // 孩子
        int keyNumber;
        boolean leaf = true;
        int t;

        public Node(int t) {
            this.keys = new int[2 * t - 1];
            this.children = new Node[2 * t];
            this.t = t;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys,0,keyNumber));
        }

        Node get(int key){
            int i = 0;
            while (i < keyNumber){
                if (keys[i] == key){
                    return this;
                }
                if (keys[i] > key){
                    break;
                }
                i++;
            }
            if (leaf){
                return null;
            }
            return children[i].get(key);
        }

        void insertKey(int key,int index){
            System.arraycopy(keys,index,keys,index+1,keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }

        void insertChild(Node child,int index){
            System.arraycopy(children,index,children,index + 1,keyNumber - index);
            children[index] = child;
        }


    }

    Node root;
    int MIN_KEY_NUMBER;
    int MAX_KEY_NUMBER;

    int t;

    public BTree(){
        this(2);
    }

    public BTree(int t){
        this.t = t;
        root = new Node(t);
        MAX_KEY_NUMBER = 2 * t - 1;
        MIN_KEY_NUMBER = t - 1;
    }
    // 是否存在
    public boolean contains(int key){
        return root.get(key) != null;
    }

    //新增
    public void put(int key){
        doPut(root,key);
    }

    private void doPut(Node node, int key) {
        int i = 0;
        while (i < node.keyNumber){
            if (node.keys[i] == key){
                return;
            }
            if (node.keys[i] > key){
                break;
            }
            i++;
        }
        if (node.leaf){
            node.insertKey(key,i);
        }else {
            doPut(node.children[i],key);
        }


    }


}

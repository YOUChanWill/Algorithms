package tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BTree {

    private static class Node{
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



}

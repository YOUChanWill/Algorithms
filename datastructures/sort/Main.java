package sort;

class HashTable {
    private static final int TABLE_SIZE = 37;  // 哈希表的大小
    private static final int MAX_COLLISIONS = 2;  // 平均查找长度的上限
    private String[] table;  // 哈希表的存储数组

    HashTable() {
        table = new String[TABLE_SIZE];
    }

    // 哈希函数，使用除留余数法
    private int hash(String key) {
        int hashValue = 0;
        for (char ch : key.toCharArray()) {
            hashValue += ch;  // 将字符的ASCII码相加得到哈希值
        }
        return hashValue % TABLE_SIZE;
    }

    // 插入人名到哈希表
    void insert(String name) {
        int hashValue = hash(name);
        int collisions = 0;

        // 线性探测再散列法处理冲突
        while (table[hashValue] != null && collisions < MAX_COLLISIONS) {
            hashValue = (hashValue + 1) % TABLE_SIZE;
            collisions++;
        }

        // 如果超过最大冲突次数仍然没有找到空槽，则无法插入
        if (collisions == MAX_COLLISIONS) {
            System.out.println("无法插入人名：" + name);
        } else {
            table[hashValue] = name;
        }
    }

    // 在哈希表中查找人名
    boolean search(String name) {
        int hashValue = hash(name);
        int collisions = 0;

        // 线性探测再散列法查找人名
        while (table[hashValue] != null && collisions < MAX_COLLISIONS) {
            if (table[hashValue].equals(name)) {
                return true;  // 找到人名
            }
            hashValue = (hashValue + 1) % TABLE_SIZE;
            collisions++;
        }

        return false;  // 未找到人名
    }
}

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // 插入人名到哈希表
        hashTable.insert("Zhang");
        hashTable.insert("Wang");
        hashTable.insert("Li");
        hashTable.insert("You");
        hashTable.insert("Chan");
        hashTable.insert("Will");
        hashTable.insert("Huang");
        hashTable.insert("Yu");
        hashTable.insert("Han");
        hashTable.insert("Bao");
        hashTable.insert("Gao");
        hashTable.insert("Qi");
        hashTable.insert("Chuan");
        hashTable.insert("Bing");
        hashTable.insert("Xun");
        hashTable.insert("Yi");
        hashTable.insert("Nuo");
        hashTable.insert("Zhao");

        // 在哈希表中查找人名
        System.out.println("查找结果：");
        System.out.println(hashTable.search("You"));  // 应返回true
        System.out.println(hashTable.search("Zi")); // 应返回false
    }
}

package linear_list;

public class Test {
    public static void main(String[] args) {
        AddressBook Book1 = new AddressBook("YOU", 123456);
        AddressBook Book2 = new AddressBook("A", 123456);
        AddressBook Book3 = new AddressBook("B", 123456);
        AddressBook Book4 = new AddressBook("C", 123456);
        AddressBook insert1 = new AddressBook("INSERT", 1);
        AddressBook set1 = new AddressBook("SET", 1);

        MyArrysList<AddressBook> arrysList = new MyArrysList<>();
        arrysList.insert(Book1); // 建立通讯录
        arrysList.insert(Book4);
        arrysList.insert(Book2);
        arrysList.insert(Book3);

        arrysList.set(2,set1); // 替换当前索引位置下的元素
        System.out.println(arrysList);

        arrysList.insert(0,insert1); // 在通讯录中插入数据
        arrysList.remove(0); // 在通讯录中移除数据

        System.out.println(arrysList.search(Book1)); // 在通讯录中找寻数据
        System.out.println(arrysList.search(insert1)); // 在通讯录中找寻数据

        System.out.println(arrysList.get(3)); // 返回数组中指定下标的元素

        System.out.println(arrysList);

        System.out.println("==================================LinkedList=============================================");

        MyLinkedList<AddressBook> linkedList = new MyLinkedList<AddressBook>();
        linkedList.insert(Book1);
        linkedList.insert(Book2);
        linkedList.insert(Book3);
        linkedList.insert(Book4);
        System.out.println(linkedList);
        System.out.println(linkedList.get(2)); // 获取链表中对应下标的元素
        linkedList.set(2,insert1); // 替换链表中的元素
        System.out.println(linkedList);

        linkedList.remove(2); // 删除指定下标的元素
        System.out.println(linkedList);

        System.out.println(linkedList.remove(Book1)); // 删除链表中的首个与key相等的元素
        System.out.println(linkedList);

        System.out.println(linkedList.search(Book2)); // 搜索首个与key相等的元素


    }
}


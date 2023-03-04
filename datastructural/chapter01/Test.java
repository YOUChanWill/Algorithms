package chapter01;

public class Test {
    public static void main(String[] args) {
        AddressBook Book1 = new AddressBook("YOU", 123456);
        AddressBook Book2 = new AddressBook("A", 123456);
        AddressBook Book3 = new AddressBook("B", 123456);
        AddressBook Book4 = new AddressBook("C", 123456);
        AddressBook insert1 = new AddressBook("INSERT", 1);

        MyArrysList<AddressBook> arrysList = new MyArrysList<>();
        arrysList.insert(Book1); // 建立通讯录
        arrysList.insert(Book4);
        arrysList.insert(Book2);
        arrysList.insert(Book3);

        arrysList.insert(0,insert1); // 在通讯录中插入数据
        arrysList.remove(0); // 在通讯录中移除数据

        System.out.println(arrysList.search(Book1)); // 在通讯录中找寻数据
        System.out.println(arrysList.search(insert1)); // 在通讯录中找寻数据

        System.out.println(arrysList.get(3)); // 返回数组中指定下标的元素

        System.out.println(arrysList);


    }
}


package linear_list;

public class AddressBook {
    private String name;
    private Integer numbers;

    public AddressBook(String name, Integer numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "name='" + name + '\'' +
                ", numbers=" + numbers +
                '}';
    }
}

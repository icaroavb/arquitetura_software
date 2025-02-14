
public class ViolationOfEncapsulation {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "John Doe";
        person.age = 30;
        System.out.println(person.name + " is " + person.age + " years old.");
    }
}

class Person {
    public String name;
    public int age;
}

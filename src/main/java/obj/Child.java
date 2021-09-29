package obj;

/**
 * @Title: Child
 * @Package: obj
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/14 16:33
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class Child extends Person{

    String getName() {
        return "Person";
    }

    public static void main(String[] args) {
        int x = 4;
        Child child = new Child();
        Person person = child;
        Person p = new Child();
        System.out.println(person.getName());
        System.out.println("value is : " + (x > 4 ? 9.9 : 9));
    }
}

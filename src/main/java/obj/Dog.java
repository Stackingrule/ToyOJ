package obj;

/**
 * @Title: Dog
 * @Package: obj
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/23 16:35
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class Dog extends Animal{

    public void eat() {
        System.out.println("Dog eat");
    }

    public void run() {
        System.out.println("Dog run");
    }

    public static void main(String[] args) {
        Animal animal = null;
        Dog dog = new Dog();
        animal = dog;
        animal.eat();
        ((Dog) animal).run();
        dog.eat();
        dog.f();

        Integer a = new Integer(10);
        Integer b = new Integer(10);

        Integer c = 10;
        Integer d = 10;

        System.out.println(a == b);
        System.out.println(c == d);

    }
}

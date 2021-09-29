package obj;

/**
 * @Title: ValRef
 * @Package: obj
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/23 12:00
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class ValRef {

    static class User {
        String name = "original";
        int age = 1;
    }

    static void changeInt(int n) {
        n = 100;
    }
    static void changeInteger(Integer n) {
        n = 100;
    }

    static void changeObject(User user) {
        user.age = 20;
        user.name = "changed";
    }
    public static void main(String[] args) {
        Integer a = 10;
        int b = 10;
        User user = new User();
        changeInt(b);
        changeInteger(a);
        changeObject(user);



        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("name = " + user.name);
    }
}

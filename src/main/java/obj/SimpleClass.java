package obj;

/**
 * @Title: SimpleClass
 * @Package: obj
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/22 21:28
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class SimpleClass {
    private static void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        ((SimpleClass)null).test();
    }
}

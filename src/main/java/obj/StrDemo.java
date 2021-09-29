package obj;

/**
 * @Title: StrDemo
 * @Package: obj
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/28 20:48
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class StrDemo {

    String str = new String("good");
    char[] ch = new char[] {'a', 'b', 'c'};

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        StrDemo str = new StrDemo();
        str.change(str.str, str.ch);
        System.out.println(str.str);
        System.out.println(str.ch);
    }
}

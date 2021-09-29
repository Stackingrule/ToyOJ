package obj;

/**
 * @Title: Singleton
 * @Package: obj
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/23 15:09
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

        System.out.println(instance);
    }
}

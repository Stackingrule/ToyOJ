package obj;

/**
 * @Title: VTest
 * @Package: obj
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/22 21:30
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class VTest extends Thread{
    public static void main(String[] args) {
        VTest v = new VTest();
        v.start();
    }

    @Override
    public synchronized void start() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Value of i = " + i);
        }
    }
}

package obj;

/**
 * @Title: PrimeCal
 * @Package: obj
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/26 20:43
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class PrimeCal {

    static boolean isPrime(int n) {

        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 6 != 1 && n % 6 != 5) return false;
        for (int i = 5; i <= Math.floor(Math.sqrt(n)); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int a = 1001;
        for (int i = a; i <= Integer.MAX_VALUE; ++i) {
            if (isPrime(i)) {
                a = i;
                break;
            }
        }
        System.out.println(a);

        System.out.println(isPrime(1001));
    }
}

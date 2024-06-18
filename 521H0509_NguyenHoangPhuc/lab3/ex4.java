import java.util.*;

public class ex4 {

    public static int factorial(int n) {
        if (n < 1)
            return 1;
        return n * factorial(n - 1);
    }
    // cau a

    public static int re1(int n) {
        if (n < 1)
            return 0;
        return (2 * n + 1) + re1(n - 1);
    }
    // cau b

    public static int re2(int n) {
        if (n < 1)
            return 0;
        return factorial(n) + re2(n - 1);
    }
    // cau c

    public static int re3(int n) {
        if (n < 1)
            return 1;
        return factorial(n) * re3(n - 1);
    }
    // cau d

    public static int re4(int n, int k) {
        if (k > n || k <= 0) {
            return 1;
        }
        return (n - k + 1) * re4(n, k - 1);
    }
    // cau e

    public static double re5(int n) {
        if (n == 1) {
            return 3;
        }
        return Math.pow(2, n) + Math.pow(n, 2) + re5(n - 1);
    }

    public static void main(String arg[]) {
        System.out.println(re1(4));
        System.out.println(re2(4));
        System.out.println(re3(4));
        System.out.println(re4(4, 4));
        System.out.println(re5(4));
    }
}
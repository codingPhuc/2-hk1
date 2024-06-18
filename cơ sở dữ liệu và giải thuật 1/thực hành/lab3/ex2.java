import java.util.*;

public class ex2 {
    public static int factorial(int n) {
        if (n < 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static int Compute(int n, int x) {
        if (n == 1)
            return x * 1;
        return x * Compute(n - 1, x);
    }

    public static int Count(int n) {
        if (n < 1)
            return 0;
        return 1 + Count(n / 10);
    }

    public static boolean checkP(int n, int i) {
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;d
        if (i * i > n)
            return true;

        return checkP(n, i + 1);
    }

    public static int Greatest_Common_Divisor(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return Greatest_Common_Divisor(n2, n1 % n2);
    }

    public static void main(String arg[]) {
        System.out.println(factorial(10));
        System.out.println(Count(1000));
        System.out.println(checkP(11, 2));
        System.out.println(Greatest_Common_Divisor(60, 366));
    }
}
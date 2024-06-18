import java.util.*;

public class EX1 {
    public static int factorial(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++)
            sum = sum * i;
        return sum;
    }

    public static int Compute(int n, int x) {
        int pro = 1;
        for (int i = 0; i < n; i++) {
            pro = pro * x;
        }
        return pro;
    }

    public static int Count(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    public static boolean checkP(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int Greatest_Common_Divisor(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void main(String arg[]) {
        System.out.println(factorial(10));
        System.out.println(Compute(2, 2));
        System.out.println(Count(1000));
        System.out.println(checkP(11));
        System.out.println(Greatest_Common_Divisor(60, 366));
    }
}
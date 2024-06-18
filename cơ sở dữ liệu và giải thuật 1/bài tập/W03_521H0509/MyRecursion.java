import java.util.*;

public class MyRecursion {
    public int sum(int A[], int n) {
        if (n <= 0)
            return 0;
        return sum(A, n - 1) + A[n - 1];
    }

    public int countEvenDigit(int a) {
        if (a < 1)
            return 0;
        return countEvenDigit(a / 10) + (a + 1) % 2;
    }

    public String reveString(String str) {

        if (str.isEmpty())
            return str;
        return reveString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String arg[]) {
        MyRecursion s = new MyRecursion();
        int[] A = { 1, 2, 3, 4, 5 };
        System.out.println(s.sum(A, A.length));
        System.out.println(s.countEvenDigit(4482));
        System.out.println(s.reveString("TDTU"));
    }
}
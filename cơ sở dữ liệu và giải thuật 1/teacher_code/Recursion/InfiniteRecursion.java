public class InfiniteRecursion {

    public static int f(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + f(n-2);
        }
    }

    public static void g1(int n) {
        if (n < 0) {
            return;
        }
        g2(n-1);
    }

    public static void g2(int n) {
        if (n < 0) {
            return;
        }
        g1(n-2);
    }

    public static void main(String[] args) {
        System.out.println(f(8));
    }
}
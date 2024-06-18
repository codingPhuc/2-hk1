public class Complexity {
    public static int a() {
        int x = 1;
        int y = 2;
        return x + y;
    }

    public static int b(int n) {
        int sum = 0;            // O(1)

        for(int i = 0; i < n; i++) { // O(n)
            sum += i;
        }
        return sum;
    }

    public static void c() {
        int n = 32;         // O(1)

        while (n > 0) {     // O(logn)
            n /= 2;
        }
    }
}
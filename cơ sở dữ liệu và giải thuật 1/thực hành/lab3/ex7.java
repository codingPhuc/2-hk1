public class ex7 {
    public static int findMin(int a[], int n) {
        if (n == 1)
            return a[0];
        return Math.min(a[n - 1], findMin(a, n - 1));
    }

    public static int findMax(int a[], int n) {
        if (n == 1)
            return a[0];
        return Math.max(a[n - 1], findMax(a, n - 1));
    }

    public static int countEven(int a[], int n) {

        if (n == 1)
            return a[0] % 2;
        return a[n - 1] % 2 + countEven(a, n - 1);
    }

    public static void main(String arg[]) {
        int[] a = { 2, 1, 5, 2, 7, 8 };
        System.out.println(countEven(a, a.length));
        System.out.println(findMax(a, a.length));
        System.out.println(findMin(a, a.length));
    }
}

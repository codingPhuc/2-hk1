public class ex6 {
    public static int findMin(int a[]) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static int findMax(int a[]) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int countEven(int a[]) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String arg[]) {
        int[] a = { 2, 1, 5, 2, 7, 8 };
        System.out.println(findMax(a));
        System.out.println(findMin(a));
        System.out.println(countEven(a));

    }
}

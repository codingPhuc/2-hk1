public class ex5 {
    public static int DecToBinary(int n) {
        if (n == 0)
            return 0;
        return (n % 2 + 10 * DecToBinary(n / 2));
    }

    public static void main(String arg[]) {
        System.out.println(DecToBinary(8));
    }
}

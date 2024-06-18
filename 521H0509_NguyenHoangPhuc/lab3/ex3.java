public class ex3 {
    public static boolean checkP(int n, int i) {
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;

        return checkP(n, i + 1);
    }

    public static void main(String arg[]) {
        System.out.println(checkP(11, 2));
    }

}

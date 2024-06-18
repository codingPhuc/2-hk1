public class CountDigit {
    public static int count(int a) {
        // if (a < 10) {
        //     return 1;
        // }
        // else {
        //     return 1 + count(a/10);
        // }
        return a < 10? 1: 1 + count(a/10);
    }

    public static int sumEven(int a) {
        if (a < 10 && a % 2 == 0) {
            return a;
        }
        if (a < 10 && a % 2 != 0) {
            return 0;
        }
        return sumEven(a % 10) + sumEven(a / 10);
    }

    public static void main(String[] args) {
        System.out.println(sumEven(1234567));
    }
}

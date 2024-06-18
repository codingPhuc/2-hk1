import java.util.Stack;

public class Ex03 {

    public static void main(String[] args) {
        System.out.println(reverseInt(123456));
    }

    private static int reverseInt(int a) {
        Stack<Integer> s = new Stack<>();

        while (a > 0) {
            s.push(a % 10);
            a /= 10;
        }

        int b = 0, d = 1;
        while (!s.empty()) {
            b += s.pop() * d;
            d *= 10;
        }

        return b;
    }
}

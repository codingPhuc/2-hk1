import java.util.*;

public class Test {
    public static int reverseInt(int a) {
        Stack<Integer> stack = new Stack<>();

        while (a > 0) {
            stack.push(a % 10);
            a /= 10;
        }

        a = 0;
        int d = 1;
        while (! stack.empty()) {
            a = a + stack.pop() * d;
            d *= 10;
        }

        return a;
    }

    public static void main(String[] args) {
        // 123 --> 321
        System.out.println(reverseInt(12345));
    }
}

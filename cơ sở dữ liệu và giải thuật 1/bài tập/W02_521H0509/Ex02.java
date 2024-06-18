import java.util.Stack;
import java.util.*;

public class Ex02 {
    public static void main(String agr[]) {
        System.out.println(postfix("2 3 1 * + 9 -"));
    }

    public static int postfix(String str) {
        Stack<Integer> s = new Stack<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                s.push(ch[i] - '0');
                System.out.println(ch[i]);
            } else if (ch[i] != ' ') {
                int value_1 = s.pop();
                int value_2 = s.pop();
                switch (ch[i]) {
                    case '*':
                        s.push(value_2 * value_1);
                        break;
                    case '+':
                        s.push(value_2 + value_1);
                        break;
                    case '/':
                        s.push(value_2 / value_1);
                        break;
                    case '-':
                        s.push(value_2 - value_1);
                        break;

                }
            }
        }
        return s.pop();
    }
}

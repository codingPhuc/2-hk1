
import java.util.Stack;

public class Ex01 {

    public static void main(String[] args) {
        System.out.println(reverseInt("{a,b+(f[4])*3,d+f[5]}"));
    }

    private static boolean reverseInt(String str) {
        Stack<Character> s = new Stack<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '[' || ch[i] == '{' || ch[i] == '(') {
                s.push(ch[i]);
                continue;
            }

            char check;
            switch (ch[i]) {
                case ')':
                    check = s.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = s.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = s.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return s.empty();
    }
}

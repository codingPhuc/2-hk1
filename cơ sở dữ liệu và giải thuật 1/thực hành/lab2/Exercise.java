import javax.management.StringValueExp;

public class Exercise {
    // EX 3
    public double calculate(int n) {
        MysStack<Double> stack = new MysStack<>();
        double sum = 0;
        for (int i = n; i > 0; i--) {
            if (i == 1)
                stack.push(3.0);
            else {
                stack.push(Math.pow(2, i) + Math.pow(i, 2));
            }

        }
        while (!stack.isEmpty()) {
            sum = sum + stack.pop();
        }
        return sum;
    }
    // EX 4

    public String reverse(String S) {
        MysStack<Character> st = new MysStack<>();
        char[] s = S.toCharArray();
        for (int i = 0; i < s.length; i++)
            st.push(s[i]);
        for (int i = 0; i < s.length; i++)
            s[i] = st.pop();
        return String.valueOf(s);
    }

    // EX5
    public boolean balanced(String str) {
        MysStack<Character> s = new MysStack<>();
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
        return s.isEmpty();
    }

    // EX 7
    public boolean palundrome(String str) {
        char[] st = str.toCharArray();
        MysStack<Character> ss = new MysStack<>();
        MyQueue<Character> sq = new MyQueue<>();
        for (int i = 0; i < st.length; i++) {
            ss.push(st[i]);
            sq.enQueue(st[i]);
        }
        for (int i = 0; i < st.length; i++) {
            if (ss.pop() != sq.deQueue()) {
                return false;
            }
        }
        return true;

    }

    public static void main(String arg[]) {
        // EX1
        MysStack<Fraction> stack = new MysStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(new Fraction(i, i + 2));
        }
        stack.print();
        // EX2
        MyQueue<Fraction> queue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(new Fraction(i, i + 2));
        }
        queue.print();
        Exercise ex = new Exercise();
        // ex 7
        System.out.println(ex.palundrome("dad"));
        // ex 4
        System.out.println(ex.reverse("this is"));
        // ex 3
        System.out.println(ex.calculate(4));
        // ex 6
        MyQueue_2Stack_EX6<Integer> stack_EX6 = new MyQueue_2Stack_EX6<>();
        for (int i = 0; i < 10; i++) {
            stack_EX6.enQueue(i + 1);

        }
        stack_EX6.print();
        // ex 5
        System.out.println(ex.balanced("(232+{2+2}+23"));

    }
}

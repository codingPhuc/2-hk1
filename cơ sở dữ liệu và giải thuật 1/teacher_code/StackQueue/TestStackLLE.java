import java.util.Stack;

public class TestStackLLE {
    public static void main(String[] args) {
        StackLLE<Integer> s = new StackLLE<>();
        for (int i = 0; i < 5; i++) {
            s.push(i); // autoboxing
        }

        while (!s.empty()) {
            System.out.print(s.pop() + ", ");
        }
        System.out.println();

        Stack<String> s1 = new Stack<>();
    }
}

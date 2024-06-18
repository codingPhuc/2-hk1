public class TestStackLL {
    public static void main(String[] args) {
        StackLL<Integer> s = new StackLL<>();
        for (int i = 0; i < 5; i++) {
            s.push(i); // autoboxing
        }

        while (!s.empty()) {
            System.out.print(s.pop() + ", ");
        }
        System.out.println();
    }
}

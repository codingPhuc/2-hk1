public class TestStackArr {
    public static void main(String[] args) {
        StackArr<Integer> s = new StackArr<>();
        for (int i = 0; i < 5; i++) {
            s.push(i); // autoboxing
        }

        while (!s.empty()) {
            System.out.print(s.pop() + ", ");
        }
        System.out.println();
    }
}

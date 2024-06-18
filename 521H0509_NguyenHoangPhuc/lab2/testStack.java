public class testStack {
    public static void main(String arg[]) {
        MysStack<Integer> s = new MysStack<>();
        s.push(5);
        s.push(3);
        s.print();
        s.pop();
        s.print();
        MyQueue<Integer> q = new MyQueue<>();
        System.out.println(q.isEmpty());
        q.enQueue(5);
        q.enQueue(3);
        System.out.println(q.isEmpty());
        q.print();
        // q.enQueue(4);
        Exercise EX = new Exercise();
        System.out.println(EX.palundrome("adam"));

    }
}

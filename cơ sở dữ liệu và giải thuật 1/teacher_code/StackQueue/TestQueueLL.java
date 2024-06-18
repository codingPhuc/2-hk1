public class TestQueueLL {
    public static void main(String[] args) {
        QueueLL<Integer> queue = new QueueLL<>();
        for (int i = 0; i < 5; i++) {
            queue.offer(i);
        }

        while (! queue.isEmpty()) {
            System.out.print(queue.poll() + ", ");
        }
        System.out.println();
    }
}

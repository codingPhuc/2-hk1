public class TestQueueArr {
    public static void main(String[] args) {
        QueueArr<Integer> queue = new QueueArr<>();
        for (int i = 0; i < 5; i++) {
            queue.offer(i);
        }

        while (! queue.isEmpty()) {
            System.out.print(queue.poll() + ", ");
        }
        System.out.println();
    }
}

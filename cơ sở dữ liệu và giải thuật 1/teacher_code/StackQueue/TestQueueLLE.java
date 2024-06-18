import java.util.LinkedList;
import java.util.Queue;

public class TestQueueLLE {
    public static void main(String[] args) {
        QueueLLE<Integer> queue = new QueueLLE<>();
        for (int i = 0; i < 5; i++) {
            queue.offer(i);
        }

        while (! queue.isEmpty()) {
            System.out.print(queue.poll() + ", ");
        }
        System.out.println();

        Queue<String> q = new LinkedList<String>();
    }
}

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapAPI {
    public static void main(String[] args) {
        int[] arr = {41, 20, 11, 29, 32, 65, 50, 91};

        PriorityQueue<Integer> heap = new PriorityQueue<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    if (a < b)  return 1;
                    if (a > b) return -1;
                    return 0;
                }
            }
        );
        for(int it: arr) {
            heap.offer(it);
        }
        while (! heap.isEmpty()) {
            System.out.print(heap.poll() + ", ");
        }
    }
}

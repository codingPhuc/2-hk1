import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap{
    int[] heap;
    int heapSize;
    int maxSize;

    public MinHeap(int capacity){
        heapSize = 0;
        this.maxSize = capacity + 1;
        heap = new int[maxSize];
        heap[0] = -1;
    }

    private int parent(int i){
        return i/2;
    }
    
    private int left(int i){
        return 2*i;
    }
    
    private int right(int i){
        return 2*i+1;
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int key) {
        if (heapSize == maxSize){
            throw new NoSuchElementException("Overflow Exception");
        }
        heapSize += 1;
        heap[heapSize] = key;
        shiftUp(heapSize);
    }

    private void shiftUp(int i){
        while(i > 1 && heap[parent(i)] > heap[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public int extractMin(){
        if(heapSize == 0){
            throw new NoSuchElementException("Underflow Exception");
        }
        int min = heap[1];
        heap[1] = heap[heapSize];
        heapSize -= 1;
        shiftDown(1);
        return min;
    }

    private void shiftDown(int i){
        while(i <= heapSize){
            int min = heap[i];
            int min_id = i;

            if(left(i) <= heapSize && min > heap[left(i)]){
                min = heap[left(i)];
                min_id = left(i);
            }

            if(right(i) <= heapSize && min > heap[right(i)]){
                min = heap[right(i)];
                min_id = right(i);
            }

            if(min_id != i){
                swap(min_id,i);
                i = min_id;
            }
            else{
                break;
            }
        }
    }

    public void buildHeapSlow(int[] arr) {
        for(int it: arr) {
            insert(it);
        }
    }

    public void buildHeapFast(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heap[i+1] = arr[i];
        }
        heapSize = arr.length;

        for(int i = parent(heapSize); i >= 1; i--) {
            shiftDown(i);
        }
    }

    public static void heapSort(int[] arr){
        MinHeap heap = new MinHeap(arr.length);
        heap.buildHeapFast(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.extractMin();
        }
    }

    public static void heapSortDesc(int[] arr){
        MaxHeap heap = new MaxHeap(arr.length+1);
        
        for (int x: arr) {
            heap.insert(x);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.extractMax();
        }
    }

    public void print() {
        System.out.print("[");
        for (int i = 1; i <= heapSize; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = {41, 20, 11, 29, 32, 65, 50, 91};
        System.out.println(Arrays.toString(arr));

        MinHeap heap1 = new MinHeap(arr.length);
        heap1.buildHeapSlow(arr);
        System.out.println(Arrays.toString(heap1.heap));

        MinHeap heap2 = new MinHeap(arr.length);
        heap2.buildHeapFast(arr);
        System.out.println(Arrays.toString(heap2.heap));
    }
}
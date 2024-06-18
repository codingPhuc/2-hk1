import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Sorting {
    public static void selectionSort(Student[] a) {
        int minIndex;
        Student tmp; // O(1)
        StudentComparator com = new StudentComparator();
        for (int i = 0; i < a.length - 1; i++) { // O(n)
            // i là vị trí sẽ hoán vị phần tử min về sau
            // mỗi lần lặp
            // tìm min vùng [i, cuối mảng] để hoán vị về vị trí
            minIndex = i; // O(1)
            for (int j = i + 1; j < a.length; j++) { // O(x)
                if (com.compare(a[minIndex], a[j]) > 0) { // inversion O(1)
                    minIndex = j;
                }
            }
            // hoán vị a[i] và a[minIndex]
            tmp = a[i]; // O(1)
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void bubbleSort(Student[] a) {
        // vòng lặp ứng với số pass
        StudentComparator com = new StudentComparator();
        for (int i = 1; i < a.length; i++) { // O(n)
            for (int j = 0; j < a.length - i; j++) { // n-i-1
                if (com.compare(a[j], a[j + 1]) > 0) { //
                    Student tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void insertionSort(Student[] a) {
        StudentComparator com = new StudentComparator();
        for (int i = 1; i < a.length; i++) { // O(n)
            Student next = a[i];
            int j;
            for (j = i - 1; j >= 0 && com.compare(a[j], next) > 0; j--) { // ?
                a[j + 1] = a[j]; // dời a[j] qua vị trí của a[j+1]
            }

            a[j + 1] = next;
        }
    }

    public static void merge(int[] a, int i, int mid, int j) {
        int[] temp = new int[j - i + 1];
        int left = i, right = mid + 1, it = 0;
        StudentComparator com = new StudentComparator();
        while (left <= mid && right <= j) {
            if (a[left] <= a[right]) {
                temp[it++] = a[left++];
            } else {
                temp[it++] = a[right++];
            }
        }

        while (left <= mid)
            temp[it++] = a[left++];
        while (right <= j)
            temp[it++] = a[right++];

        for (int k = 0; k < temp.length; k++) {
            a[i + k] = temp[k];
        }
    }

    public static void mergeSort(int[] a, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            mergeSort(a, i, mid);
            mergeSort(a, mid + 1, j);
            merge(a, i, mid, j); // gộp hai mảng con
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static int partition(int[] a, int i, int j) {
        int p = a[i]; // p is the pivot, the ith item
        int m = i; // Initially S1 and S2 are empty
        for (int k = i + 1; k <= j; k++) { // process unknown region
            if (a[k] < p) { // case 2: put a[k] to S1
                m++;
                swap(a, k, m);
            } else { // case 1: put a[k] to S2. Do nothing!
            } // else part should be removed since it is empty
        }
        swap(a, i, m); // put the pivot at the right place
        return m; // m is the pivot’s final position
    }

    public static void quickSort(int[] a, int i, int j) {
        if (i < j) {
            int pivotIdx = partition(a, i, j);
            quickSort(a, i, pivotIdx - 1); // S1
            quickSort(a, pivotIdx + 1, j); // S2
        }
    }

    public static int getKthDigit(int a, int k) {
        while (a > 0 && k > 0) {
            a /= 10;
            k--;
        }
        return a % 10;
    }

    public static void radixSort(int[] a, int d) {
        Queue<Integer>[] queues = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            queues[i] = new LinkedList<Integer>();
        }

        for (int j = 0; j <= d; j++) {
            for (int i = 0; i < a.length; i++) {
                int k = getKthDigit(a[i], j);
                queues[k].offer(a[i]);
            }

            int it = 0;
            for (int i = 0; i < 10; i++) {
                while (!queues[i].isEmpty()) {
                    a[it++] = (int) queues[i].poll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt() % 100 + 100;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(args[0]);
    }
}
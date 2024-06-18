import java.security.Principal;
import java.time.chrono.MinguoDate;

public class Sorting {
    public static void selectionSort(int[] a) {
        int minIndex;
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j])
                    minIndex = j;
            }
            temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void bubbleSort(int a[]) {
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int next = a[i];
            int j;
            for (j = i - 1; j >= 0 && a[j] > next; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = next;
        }

    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        // index of smaller element
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {

                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // The main function that implements QuickSort algorithm
    // arr[] --> Array to be sorted ,
    // low --> Starting index ,
    // high --> Ending index
    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index , arr[pi] is now at right place
            int pi = partition(arr, low, high);
            // Recursively sort elements before partition and after
            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }

    private static void merge(int arr[], int l, int m, int r) {
        {
            // Find sizes of two sub-arrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;
            // Create temp arrays
            int L[] = new int[n1];
            int R[] = new int[n2];
            // Copy data to temp arrays
            for (int i = 0; i < n1; i++)
                L[i] = arr[l + i];
            for (int j = 0; j < n2; j++)
                R[j] = arr[m + 1 + j];
            /* Merge the temp arrays */
            // Initial indexes of first and second sub-arrays
            int i = 0, j = 0;
            // Initial index of merged sub-array
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
            // Copy remaining elements of L[] if any
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
            // Copy remaining elements of R[] if any
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
    }

    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            // Find the middle point
            int middle = (first + last) / 2;
            // Sort first and second halves
            mergeSort(arr, first, middle);
            mergeSort(arr, middle + 1, last);
            // Merge the sorted halves
            merge(arr, first, middle, last);
        }
    }

    public static void main(String agr[]) {
        int[] a = { 2, 3, 6, 1, 23, 9, 0 };
        selectionSort(a);
        int[] b = { 2, 3, 6, 1, 23, 9, 0 };
        bubbleSort(b);
        int[] c = { 2, 3, 6, 1, 23, 9, 0 };
        insertionSort(c);
        int[] d = { 2, 3, 6, 1, 23, 9, 0 };
        QuickSort(d, 0, d.length - 1);
        int[] e = { 2, 3, 6, 1, 23, 9, 0 };
        mergeSort(e, 0, e.length - 1);
        for (int i = 0; i < a.length - 1; i++)
            System.out.println(a[i]);
        System.out.println("bubble sorting ");
        for (int i = 0; i < b.length; i++)
            System.out.println(b[i]);
        System.out.println("selection sort");
        for (int i = 0; i < c.length; i++)
            System.out.println(c[i]);
        System.out.println("merge sort");
        for (int i = 0; i < e.length; i++)
            System.out.println(e[i]);
        System.out.println("quick  sort");
        for (int i = 0; i < d.length; i++)
            System.out.println(d[i]);
        System.out.println("hello");

    }
}
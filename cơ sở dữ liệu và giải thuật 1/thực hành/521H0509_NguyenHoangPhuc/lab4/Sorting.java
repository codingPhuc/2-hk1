import java.security.Principal;
import java.time.chrono.MinguoDate;

public class Sorting{
    public static void selectionSort(int []a)
    {       
        int minIndex ; 
        int temp ;
        for(int i =0 ;i< a.length-1 ;i++)
        {
            minIndex = i;
            for(int j=i+1 ; j< a.length ; j++)
            {
                if(a[minIndex] > a[j] )
                    minIndex = j; 
            }
            temp = a[i];
            a[i]= a[minIndex];
            a[minIndex]= temp;
        }
    }
    public static void bubbleSort(int a[])
    {   
        int temp ;
        for(int i =0 ; i<a.length ;i++)
        {
            for(int j =0 ; j<a.length-1 ; j++)
            {
                if(a[j]>a[j+1])
                {
                    temp = a[j] ;
                    a[j] = a[j+1];
                    a[j+1]= temp ;
                }
            }
        }
    }
    public static void  insertionSort(int a[])
    {
        for(int i =1 ;i<a.length ;i++)
        {
            int next = a[i];
            int j ;
            for( j = i-1 ; j>= 0 && a[j]>next ; j-- )
            {
                a[j+1]= a[j];
            }
            a[j+1]= next ;
        }

    }
    public static void main(String agr [])
    {   
        int [] a = {2,3,6,1,23,9,0};
        selectionSort(a);
        int [] b = {2,3,6,1,23,9,0};
        bubbleSort(b);
        int [] c = {2,3,6,1,23,9,0};
        insertionSort(c);
        for(int i =0 ; i<a.length ;i++)
            System.out.println(a[i]);
        System.out.println("bubble sorting ");
        for(int i =0 ; i<b.length ;i++)
            System.out.println(b[i]);
        System.out.println("selection sort");
        for(int i =0 ; i<c.length ;i++)
            System.out.println(c[i]);
        System.out.println("hello");

}
}
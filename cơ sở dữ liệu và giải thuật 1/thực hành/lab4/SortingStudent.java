import java.util.*;

public class SortingStudent {
    public static void ascBubbleSort(Student a[]) {
        Student temp;
        StudentComparator st = new StudentComparator();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (st.compare(a[j], a[j + 1]) > 0) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void desBubbleSort(Student[] a) {
        Student temp;
        StudentComparator st = new StudentComparator();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (st.compare(a[j], a[j + 1]) < 0) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void print(Student a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("this is student name " + a[i].getName() + " and gpa " + a[i].getGrade());
        }
    }

    public static void main(String arg[]) {
        Student[] a = new Student[5];
        a[0] = new Student("tom", 5, 7, 5);
        a[1] = new Student("power", 10, 7, 5);
        a[2] = new Student("powr", 1, 7, 5);
        a[3] = new Student("pwer", 4, 7, 5);
        a[4] = new Student("powe", 6, 7, 5);
        System.out.println("decending ");
        desBubbleSort(a);
        print(a);
        System.out.println("acending");
        ascBubbleSort(a);
        print(a);

    }
}

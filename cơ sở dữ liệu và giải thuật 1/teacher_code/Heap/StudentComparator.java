import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        return -(int)(s1.GPA - s2.GPA);
    }
    
}

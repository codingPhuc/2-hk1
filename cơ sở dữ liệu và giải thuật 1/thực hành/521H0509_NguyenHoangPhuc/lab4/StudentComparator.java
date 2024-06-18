import  java.util.* ;
public class StudentComparator implements Comparator
{
    
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        double ratio = s1.getGrade() - s2.getGrade();
        if(ratio>0) return 1 ;
        if(ratio<0) return -1 ;
        return 0;
    }
    
}
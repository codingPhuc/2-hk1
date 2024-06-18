import java.util.PriorityQueue;

public class Student {
    String name;
    float GPA;

    public Student(String name, float GPA) {
        this.name = name;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return String.format("(%s,%.2f)",
            name, GPA);
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student("A", 8),
            new Student("C", 10),
            new Student("E", 7),
            new Student("B", 6)
        };
        PriorityQueue<Student> heap = new PriorityQueue<>(
            new StudentComparator()
        );
        for(Student std: students) {
            heap.offer(std);
        }
        while (! heap.isEmpty()) {
            System.out.print(heap.poll() + ", ");
        }
    }
}

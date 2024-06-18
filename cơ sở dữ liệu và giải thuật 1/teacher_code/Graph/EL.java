import java.util.LinkedList;
import java.util.Scanner;

public class EL {
    int V, E;
    LinkedList<Edge> list = new LinkedList<>();

    public void read() {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        int u, v, w;
        for (int i = 0; i < E; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            list.add(new Edge(u, v, w));
        }
        sc.close();
    }
    
    public void print() {
        for(Edge e: list) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        EL el = new EL();
        el.read();
        el.print();
    } 
}

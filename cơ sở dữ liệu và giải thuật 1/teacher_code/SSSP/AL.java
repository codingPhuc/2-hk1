import java.util.LinkedList;
import java.util.Scanner;

public class AL {
    int V, E;
    LinkedList<Edge>[] al;

    public void read(boolean isUndirected) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        al = new LinkedList[V]; // null
        for(int i = 0; i < V; i++) {
            al[i] = new LinkedList<>();
        }
        int u, v, w;
        for (int i = 0; i < E; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            al[u].add(new Edge(u, v, w));
            if (isUndirected) {
                al[v].add(new Edge(v, u, w));
            }
        }
        sc.close();
    }
    
    public void print() {
        for(LinkedList<Edge> l: al) {
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        AL al = new AL();
        al.read(true);
        al.print();
    }
}
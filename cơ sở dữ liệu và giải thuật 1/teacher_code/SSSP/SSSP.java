import java.util.Arrays;
import java.util.PriorityQueue;

public class SSSP {
    public static void BellmanFord(EL el, int s) {
        // initialization
        int[] D = new int[el.V];
        int[] p = new int[el.V];

        for(int i = 0; i < el.V; i++) {
            D[i] = Integer.MAX_VALUE;
            p[i] = -1;
        }
        D[s] = 0;

        // main loop
        for (int i = 1; i < el.V; i++) {
            for (Edge e: el.el) {
                relax(e, D, p);
            }
        }
        System.out.println(Arrays.toString(D));
        System.out.println(Arrays.toString(p));

        // check negative cycle
        for (Edge e: el.el) {
            if (relax(e, D, p)) {
                System.out.println("Negative cycles");
                break;
            }
        }
    }

    private static boolean relax(Edge e, int[] D, int[] p) {
        if (D[e.v] > D[e.u] + e.w) {
            D[e.v] = D[e.u] + e.w;
            p[e.v] = e.u;
            return true;
        }
        return false;
    }


    public static void Dijkstra(AL al, int source) {
        int dist[] = new int[al.V];
        int prev[] = new int[al.V];
        boolean[] visited = new boolean[al.V];
        PriorityQueue<MyPair> queue = new PriorityQueue<>();

        for (int i = 0; i < al.V; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }
        dist[source] = 0;
        queue.offer(new MyPair(dist[source], source));

        logDistPrev(dist, prev);
        while (!queue.isEmpty()) {
            MyPair p = queue.poll();
            int u = p.snd;
            
            if (! visited[u]){
                visited[u] = true;
                for (Edge e: al.al[u]) {
                    if (relax(e, dist, prev)) {
                        queue.offer(new MyPair(dist[e.v], e.v));
                    }
                }
            }
            logDistPrev(dist, prev);
        }

        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(prev));
    }

    public static void logDistPrev(int[] dist, int[] prev) {
        for (int i = 0; i < dist.length; i++) {
            System.out.print(String.format("%3d,%-3d\t", 
                    prev[i],
                    dist[i] > 1000? 999: dist[i]
                )
            );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // EL el = new EL();
        // el.read();
        // el.print();
        // BellmanFord(el, 0);

        AL al = new AL();
        al.read(false);
        al.print();
        Dijkstra(al, 0);
    }
}

class MyPair implements Comparable<MyPair>{
    int fst, snd;

    public MyPair(int fst, int snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public int compareTo(MyPair p) {
        return this.fst - p.fst;
    }
}

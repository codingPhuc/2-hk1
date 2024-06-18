import java.util.Comparator;

public class Edge {
    int u, v, w;

    public Edge() {}

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)",
                    u, v, w);
    }
}

class EdgeComparator implements Comparator<Edge>{

    @Override
    public int compare(Edge e1, Edge e2) {
        // if (e1.w < e2.w) {
        //     return -1;
        // }
        // if (e1.w > e2.w) {
        //     return 1;
        // }
        // return 0;
        return e1.w - e2.w;
    }
}


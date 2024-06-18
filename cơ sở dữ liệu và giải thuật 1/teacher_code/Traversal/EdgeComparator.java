import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge>{

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

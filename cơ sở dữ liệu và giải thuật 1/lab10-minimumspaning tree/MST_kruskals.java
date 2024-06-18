
import java.io.*;
import java.lang.*;
import java.util.*;

public class MST_kruskals {
    // số vectors trong 1 graph
    private static int V, E;
    private static Vector<IntegerTriple> edge;

    public MST_kruskals(int V, int E, Vector<IntegerTriple> edge) {
        this.V = V;
        this.E = E;
        this.edge = edge;
    }

    public static void selectionSort(Vector<IntegerTriple> a) {
        int minIndex;
        IntegerTriple tmp; // O(1)
        for (int i = 0; i < a.size() - 1; i++) { // O(n)
            minIndex = i; // O(1)
            for (int j = i + 1; j < a.size(); j++) { // O(x)
                if (a.get(minIndex).compareTo(a.get(j)) > 0) { // inversion O(1)
                    minIndex = j;
                }
            }

            tmp = a.get(i); // O(1)
            a.set(i, a.get(minIndex));
            a.set(minIndex, tmp);
        }
    }

    void KruskalMST() {

        Vector<IntegerTriple> result = new Vector<IntegerTriple>();

        int e = 0;

        for (int i = 0; i < V; ++i)
            result.add(new IntegerTriple(0, 0, 0));

        selectionSort(edge);
        UnionFind subsets = new UnionFind(V);

        int i = 0;
        while (e < V - 1) {

            IntegerTriple next_IntegerTriple = edge.get(i++);
            int x = subsets.findSet(next_IntegerTriple.getDest());
            int y = subsets.findSet(next_IntegerTriple.getSource());

            if (x != y) {
                result.set(e++, next_IntegerTriple);
                subsets.unionSet(x, y);
            }

        }

        System.out.println("Following are the IntegerTriples in "
                + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result.get(i).getSource() + " -- "
                    + result.get(i).getDest()
                    + " == " + result.get(i).getWeight());
            minimumCost += result.get(i).getWeight();
        }
        System.out.println("Minimum Cost Spanning Tree "
                + minimumCost);
    }

    public static void main(String[] args) {

        File file = new File("el.txt");
        try {
            Scanner sc = new Scanner(file);
            EdgeList ad = new EdgeList();

            while (sc.hasNextLine()) {
                ad.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            sc.close();
            MST_kruskals graph = new MST_kruskals(ad.countVertices(), ad.countEdges(), ad.getEdges());
            graph.KruskalMST();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

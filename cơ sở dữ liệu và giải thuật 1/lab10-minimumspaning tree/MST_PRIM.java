import java.io.*;
import java.lang.*;
import java.util.*;

class MST_PRIM {

    // số vectors trong 1 graph
    private static int V;

    public MST_PRIM(int V) {
        this.V = V;
    }

    int mincost(int key[], Boolean visited[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (visited[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // hàm dùng để print graph
    void printMST_PRIM(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                    + graph[i][parent[i]]);
    }

    void primMST_PRIM(int graph[][]) {

        int parent[] = new int[V];

        int cost[] = new int[V];

        Boolean visited[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            cost[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        cost[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {

            int min_id = mincost(cost, visited);

            visited[min_id] = true;

            for (int v = 0; v < V; v++)

                if (graph[min_id][v] != 0 && visited[v] == false
                        && graph[min_id][v] < cost[v]) {
                    parent[v] = min_id;
                    cost[v] = graph[min_id][v];
                }
        }

        printMST_PRIM(parent, graph);
    }

    public static void main(String[] args) {
        File file = new File("am.txt");
        try {
            Scanner sc = new Scanner(file);
            AdjacencyMatrix ad = new AdjacencyMatrix(sc.nextInt());
            while (sc.hasNextLine()) {
                for (int i = 0; i < ad.getNUMBER_OF_VERTICES(); i++) {
                    for (int j = 0; j < ad.getNUMBER_OF_VERTICES(); j++) {
                        ad.setEgde(i, j, sc.nextInt());
                    }
                }
            }
            ad.printGraph();
            MST_PRIM t = new MST_PRIM(ad.countVertices());
            t.primMST_PRIM(ad.getAdj());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
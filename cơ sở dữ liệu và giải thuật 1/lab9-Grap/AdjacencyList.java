import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class AdjacencyList {
    private int V;
    private LinkedList<Integer> adj[];// No. of vertices private LinkedList <Integer > adj[]; public AdjacencyList(int


    public AdjacencyList(int v) // v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            System.out.print("head");
            for (Integer v : adj[i]) {
                System.out.print("->" + v);
            }
            System.out.println();
        }
    }

    public int countVertices() {
        return this.V;
    }

    public int countEdges() {
        int sum = 0;
        for (int i = 0; i < V; i++) {
            for (Integer u : adj[i]) {
                sum += 1;
            }
        }
        return sum / 2;
    }

    public void enumerateNeighbors(int u) {
        System.out.println("the Neighbors of " + u + " is: ");
        for (Integer i : adj[u]) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public boolean checkedge(int u, int v) {
        for (Integer i : adj[u]) {
            if (v == i)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        File file = new File("al.txt");
        try {
            Scanner sc = new Scanner(file);
            AdjacencyList ad = new AdjacencyList(sc.nextInt());

            // Scanner sc = new Scanner(file);
            // AdjacencyMatrix ad = new AdjacencyMatrix(sc.nextInt());
            while (sc.hasNextLine()) {
                String a = sc.nextLine();
                System.out.println(a);
                String[] parts = a.split("\\s+");
                for (int i = 1; i < parts.length; i++) {
                    ad.addEdge(Integer.parseInt(parts[0]), Integer.parseInt(parts[i]));
                }

                // myList.add(sc.nextInt());
            }

            sc.close();
            ad.printGraph();

            System.out.println(ad.countVertices());
            System.out.println(ad.countEdges());
            ad.enumerateNeighbors(2);
            System.out.println("the edge between 2 and 1 is:");
            System.out.println(ad.checkedge(2, 1));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

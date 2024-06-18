
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class AdjacencyMatrix {
    private int[][] adj;
    private final int NUMBER_OF_VERTICES;

    public int getNUMBER_OF_VERTICES() {
        return this.NUMBER_OF_VERTICES;
    }

    public int[][] getAdj() {
        return this.adj;
    }

    public AdjacencyMatrix(int vertices) {
        NUMBER_OF_VERTICES = vertices;
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];

    }

    public void setEgde(int vertexSource, int vertexDestination,
            int weight) {

        try {

            adj[vertexSource][vertexDestination] = weight;

            adj[vertexDestination][vertexSource] = weight;

        } catch (ArrayIndexOutOfBoundsException indexBounce) {

            System.out.println("The vertex is invalid");

        }

    }

    public int getEgde(int vertexSource, int vertexDestination) {

        try {

            return adj[vertexSource][vertexDestination];

        } catch (ArrayIndexOutOfBoundsException indexBounce) {

            System.out.println("The vertex is invalid");

        }

        return -1;

    }

    // execise 1
    public void printGraph() {

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {

            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {

                System.out.print(adj[i][j] + " ");

            }

            System.out.println();

        }

    }

    public int countVertices() {
        return this.NUMBER_OF_VERTICES;
    }

    public void enumerateNeighbors(int u) {
        System.out.println("the Neighbors of " + u + " is: ");
        for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
            if (adj[u][j] != 0) {
                System.out.print(j + ", ");
            }
        }
        System.out.println();
    }

    public int countEdges() {
        int sum = 0;

        // traverse all vertex
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {

                if (adj[i][j] != 0) {
                    sum += 1;
                }

            }
        }

        return sum / 2;
    }

    public boolean checkedge(int u, int v) {
        return adj[u][v] != 0;
    }

    // exercise 3
    public void BFS(int s) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];

        Queue<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");

            for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
                if (adj[x][i] != 0 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void DFS_recur(int v, boolean[] visited) {
        visited[v] = true;

        System.out.print(v + " ");

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if (adj[v][i] != 0 && visited[i] == false) {
                DFS_recur(i, visited);
            }
        }
    }

    public void DFS(int s) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        DFS_recur(s, visited);
    }

    public void DFS_iter(int s) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        Stack<Integer> stack = new Stack<>();

        visited[s] = true;
        stack.add(s);
        System.out.print(s + " ");

        while (!stack.isEmpty()) {
            int x = stack.peek();

            boolean check = false;
            for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
                if (adj[x][i] != 0 && visited[i] == false) {
                    stack.add(i);
                    visited[i] = true;
                    check = true;
                    System.out.print(i + " ");
                    break;
                }
            }

            if (check == false) {
                stack.pop();
                // System.out.println("pop: " + stack.pop());
            }
        }
    }

    public boolean check_reach_recur(int v, boolean[] visited, int t) {
        visited[v] = true;

        if (v == t) {
            return true;
        }
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if (adj[v][i] != 0 && visited[i] == false) {

                return check_reach_recur(i, visited, t);
            }
        }
        return false;
    }

    public boolean IsReachable(int s, int v) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        return check_reach_recur(s, visited, v);
    }

    public static void main(String[] args) {

        File file = new File("am.txt");
        try {
            Scanner sc = new Scanner(file);
            AdjacencyMatrix ad = new AdjacencyMatrix(sc.nextInt());
            while (sc.hasNextLine()) {
                for (int i = 0; i < ad.NUMBER_OF_VERTICES; i++) {
                    for (int j = 0; j < ad.NUMBER_OF_VERTICES; j++) {
                        ad.setEgde(i, j, sc.nextInt());
                    }
                }
            }
            sc.close();

            ad.printGraph();

            System.out.println(ad.countVertices());
            System.out.println(ad.countEdges());
            ad.enumerateNeighbors(2);
            System.out.println("the edge between 2 and 1 is:");
            System.out.println(ad.checkedge(2, 1));
            // execise 3
            System.out.println("execise 3");
            ad.DFS(0);
            System.out.println();
            ad.BFS(0);
            System.out.println();
            ad.DFS_iter(4);
            System.out.println();
            System.out.println(ad.IsReachable(0, 4));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}

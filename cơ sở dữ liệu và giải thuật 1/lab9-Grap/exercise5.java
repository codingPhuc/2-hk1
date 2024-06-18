import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class exercise5 {

    
    public static AdjacencyList convert(int[][] a) {
        // no of vertices
        int l = a[0].length;
        AdjacencyList adjListArray = new AdjacencyList(l);


        int i, j;
        for (i = 0; i < a[0].length; i++) {
            for (j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    adjListArray.addEdge(i, j);
                }
            }
        }

        return adjListArray;
    }

    // Function to print the adjacency list
    static void printArrayList(ArrayList<ArrayList<Integer>> adjListArray) {
        // Print the adjacency list
        for (int v = 0; v < adjListArray.size(); v++) {
            System.out.print(v);
            for (Integer u : adjListArray.get(v)) {
                System.out.print(" -> " + u);
            }
            System.out.println();
        }
    }

    // Driver Code
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
            sc.close();

            ad.printGraph();
            System.out.println("convert to AL: ");
            AdjacencyList adjListArray = new AdjacencyList(ad.getNUMBER_OF_VERTICES());
            adjListArray = convert(ad.getAdj());
            adjListArray.printGraph();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
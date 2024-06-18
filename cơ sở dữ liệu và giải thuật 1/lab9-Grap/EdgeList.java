import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class EdgeList {
    private Vector<IntegerTriple> edges;

    public EdgeList() {
        edges = new Vector<IntegerTriple>();
    }

    public void addEdge(int w, int u, int v) {
        edges.add(new IntegerTriple(w, u, v));
    }

    public void printGraph() {
        for (int i = 0; i < edges.size(); i++) {
            System.out.println(edges.get(i));
        }
    }

    public int countEdges() {

        // traverse all vertex
        return edges.size();
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {

        // Create a new LinkedHashSet
        Set<Integer> set = new LinkedHashSet<>();

        // Add the elements to set
        set.addAll(list);

        // Clear the list
        list.clear();

        // add the elements of set
        // with no duplicates to the list
        list.addAll(set);

        // return the list
        return list;
    }

    public int countVertices() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (IntegerTriple el : edges) {
            list.add(el.getSource());
            list.add(el.getDest());

        }
        ArrayList<Integer> newList = removeDuplicates(list);
        return newList.size();
    }

    public void enumerateNeighbors(int u) {
        System.out.println("the Neighbors of " + u + " is: ");
        for (IntegerTriple el : edges) {
            if (el.getSource() == u) {
                System.out.print(el.getDest() + ", ");
            }
            if (el.getDest() == u) {
                System.out.print(el.getSource() + ", ");
            }
        }
        System.out.println();
    }

    public boolean checkedge(int u, int v) {
        for (IntegerTriple el : edges) {
            if ((el.getDest() == v && el.getSource() == u) || (el.getDest() == u && el.getSource() == v))
                return true;
        }
        return false;
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

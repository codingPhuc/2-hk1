import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    public static void main(String[] args) {
        AM am = new AM();
        am.read();
        am.print();
        System.out.println("BFS");
        BFS(am, 0);
        System.out.println("DFS");
        DFS(am, 0);
    }

    public static void BFS(AM am, int s) {
        boolean visited[] = new boolean[am.V]; // F
        int[] parent = new int[am.V]; // 0
        for (int i = 0; i < am.V; i++) {
            parent[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
    
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;
    
        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");

            for (int i = 0; i < am.V; i++) {
                if (am.am[x][i] > 0 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    parent[i] = x;
                }
            }
        }

        System.out.println("visited: " + Arrays.toString(visited));
        System.out.println("parent: " + Arrays.toString(parent));
    }

    public static void DFS_recur(AM am, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
    
        for (int i = 0; i < am.V; i++) {
            if (am.am[v][i] > 0 && visited[i] == false) {
                DFS_recur(am, i, visited);
            }
        }
    }
    
    public static void DFS(AM am, int s) {
        boolean[] visited = new boolean[am.V];
        DFS_recur(am, s, visited);
        System.out.println("visited: " + Arrays.toString(visited));
    }

    public void DFS_iter(AM am, int s) {
        boolean visited[] = new boolean[am.V];
        Stack<Integer> stack = new Stack<>();
    
        visited[s] = true;
        stack.add(s);
        System.out.print(s + " ");
    
        while (!stack.isEmpty()) {
            int x = stack.peek();

            boolean check = false;
            for (int i = 0; i < am.V; i++) {
                if (am.am[x][i] != 0 && visited[i] == false) {
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
}
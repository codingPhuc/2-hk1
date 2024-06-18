import java.util.Scanner;

public class AM {
    int V, E;
    int[][] am;

    public void read() {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        am = new int[V][V]; // 0
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                am[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }
    
    public void print() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.printf("%3d", am[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AM am = new AM();
        am.read();
        am.print();
    }
}
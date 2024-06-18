import java.util.*;

public class StudentManagement {
    private AVL tree;
    private Stack<Node> undoState;
    private Stack<Node> redoState;

    public StudentManagement() {
        this.tree = new AVL();
        this.undoState = new Stack<Node>();
        this.redoState = new Stack<Node>();
    }

    public AVL getTree() {
        return this.tree;
    }

    // Requirement 1
    public boolean addStudent(Student st) {
        // code here
        if (tree.search(st.getId()) != null) {
            return false;
        }
        Node node = new Node();
        node = copyRoot(tree.getRoot());
        undoState.push(node);
        tree.insert(st);
        return true;
    }

    // Requirement 2
    public Student searchStudentById(int id) {
        // code here
        if (tree.search(id) == null)
            return null;
        return tree.search(id).getData();
    }

    // Requirement 3
    public boolean removeStudent(int id) {
        if (tree.search(id) == null) {
            return false;
        }
        undoState.push(tree.getRoot());
        Node node = new Node();
        node = copyRoot(tree.getRoot());
        undoState.push(node);
        tree.delete(tree.search(id).getData());
        return true;
    }

    // Requirement 4
    public void undo() {
        Node node = new Node();
        node = copyRoot(tree.getRoot());
        redoState.push(node);
        tree.setRoot(undoState.pop());
    }

    // Requirement 5
    public void redo() {
        tree.setRoot(redoState.pop());
    }

    // Requirement 6 ScoreAVL
    public ScoreAVL scoreTree(AVL tree) {
        // code here
        ScoreAVL S_avl = new ScoreAVL();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.getRoot());
        Node this_Node;
        while (!queue.isEmpty()) {
            this_Node = queue.poll();

            S_avl.insert(this_Node.getData());

            if (this_Node.getLeft() != null) {
                queue.add(this_Node.getLeft());
            }

            if (this_Node.getRight() != null) {
                queue.add(this_Node.getRight());
            }
        }
        return S_avl;
    }

    public static Node copyRoot(Node root) {
        if (root == null)
            return null;
        Node root_copy = new Node(root.getData());
        root_copy.setHeight(root.getHeight());
        root_copy.setLeft(copyRoot(root.getLeft()));
        root_copy.setRight(copyRoot(root.getRight()));
        return root_copy;
    }
}

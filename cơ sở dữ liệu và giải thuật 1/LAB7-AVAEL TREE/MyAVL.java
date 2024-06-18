public class MyAVL {
    private NodeAVL root;

    public MyAVL() {
    }

    public int height(NodeAVL node) {
        if (node == null)
            return -1;
        return node.height;
    }

    private int getBalance(NodeAVL x) {
        return height(x.left) - height(x.right);
    }

    private NodeAVL rotateLeft(NodeAVL x) {
        NodeAVL y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    // exercise 1
    private NodeAVL rotateRight(NodeAVL x) {
        NodeAVL y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    private NodeAVL balance(NodeAVL x) {
        if (getBalance(x) < -1) { // right
            if (getBalance(x.right) > 0) { // right-left
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        } else if (getBalance(x) > 1) { // left
            if (getBalance(x.left) < 0) { // right
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }
        return x;
    }

    private NodeAVL insert(NodeAVL x, Integer key) {
        if (x == null)
            return new NodeAVL(key);

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = insert(x.left, key);
        else if (cmp > 0)
            x.right = insert(x.right, key);
        else
            x.key = key;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    public void insert(Integer key) {
        this.root = this.insert(this.root, key);
    }

    public void NLR(NodeAVL x) {
        if (x != null) {
            // System.out.print(x.key + " ");
            System.out.print(String.format("(%d, %d), ", x.key, getBalance(x)));
            NLR(x.left);
            NLR(x.right);
        }
    }

    public void LNR(NodeAVL x) {
        if (x != null) {
            LNR(x.left);
            // System.out.print(x.key + " ");
            System.out.print(String.format("(%d, %d), ", x.key, getBalance(x)));
            LNR(x.right);
        }
    }

    public void LRN(NodeAVL x) {
        if (x != null) {
            LRN(x.left);
            LRN(x.right);
            System.out.print(x.key + " ");
            // System.out.print(String.format("(%d, %d), ", x.key, checkBalance(x)));
        }
    }

    public void traverse(String kind) {
        switch (kind) {
            case "NLR":
                NLR(this.root);
                break;
            case "LNR":
                LNR(this.root);
                break;
            case "LRN":
                LRN(this.root);
                break;
            default:
                break;
        }
    }

    private NodeAVL search(NodeAVL x, Integer key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public NodeAVL search(Integer key) {
        return this.search(this.root, key);
    }

    public boolean contains(int key) {
        return search(key) != null;
    }

    private NodeAVL min(NodeAVL x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    private NodeAVL deleteMin(NodeAVL x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);

        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    private NodeAVL delete(NodeAVL x, Integer key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            // node with only one child or no child
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            // node with two children: Get the successor (smallest in the right subtree)
            x.key = min(x.right).key;
            x.right = deleteMin(x.right);
        }

        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    public void delete(Integer key) {
        this.root = this.delete(this.root, key);
    }

    public static void main(String[] args) {
        int keys[] = { 46,98,39,69, 23,77,76,68,6,12 };
        MyAVL tree = new MyAVL();

        for (int x : keys) {
            tree.insert(x);
        }
        tree.traverse("NLR");
        System.out.println();

        // System.out.println(tree.search(64));
        // System.out.println(tree.search(65));

        tree.delete(98);
        tree.traverse("NLR");
        // System.out.println();
        // tree.delete(59);
        // tree.traverse("NLR");
        // System.out.println();
    }
}
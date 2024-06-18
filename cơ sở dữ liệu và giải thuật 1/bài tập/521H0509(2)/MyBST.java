public class MyBST implements BSTInterface {
    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public MyBST() {
    }

    public MyBST(Integer x) {
        this.root = new Node(x);
    }

    public void LNR(Node x) {
        if (x != null) {
            LNR(x.left);
            System.out.print(x.key + " ");
            LNR(x.right);
        }
    }

    public void RNL(Node x) {
        if (x != null) {
            RNL(x.right);
            System.out.print(x.key + " ");
            RNL(x.left);
        }
    }

    public void NLR(Node x) {
        if (x != null) {
            System.out.print(x.key + " ");
            NLR(x.left);
            NLR(x.right);
        }
    }

    private Node insert(Node n, Integer key) {
        if (n == null) {
            return new Node(key);
        }

        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            n.left = insert(n.left, key);
        }
        if (cmp > 0) {
            n.right = insert(n.right, key);
        }
        return n;
    }

    private Node search(Node n, Integer key) {
        if (n == null) {
            return null;
        }

        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            return search(n.left, key);
        }
        if (cmp > 0) {
            return search(n.right, key);
        }
        return n;
    }

    private Node min(Node n) {
        if (n == null) {
            return null;
        }

        if (n.left == null) {
            return n;
        }
        return min(n.left);
    }

    private Node max(Node n) {
        if (n == null) {
            return null;
        }

        if (n.right == null) {
            return n;
        }
        return max(n.right);
    }

    private Node deleteMin(Node n) {
        if (n.left == null) {
            return n.right;
        }
        n.left = deleteMin(n.left);
        return n;
    }

    private Node delete(Node n, Integer k) {
        if (n == null) {
            return null;
        }

        int cmp = k.compareTo(n.key);
        if (cmp < 0) {
            n.left = delete(n.left, k);
        } else {
            if (cmp > 0) {
                n.right = delete(n.right, k);
            } else {
                // k = n.key
                // node with only one child or no child
                if (n.right == null) {
                    return n.left;
                }
                if (n.left == null) {
                    return n.right;
                }

                // node with two children: Get the successor (smallest in the right subtree)
                Node t = n;

                n = min(t.right);

                // Delete the successor
                n.right = deleteMin(t.right);

                // re-link left subtree to the node which was replaced
                n.left = t.left;
            }
        }
        return n;
    }

    @Override
    public Node insert(Integer x) {
        return root = insert(root, x);
    }

    @Override
    public Node search(Integer x) {
        return search(root, x);
    }

    @Override
    public Node delete(Integer x) {
        return root = delete(root, x);
    }

    @Override
    public void traverse() {
        RNL(root);
    }

    static int left_height(Node node) {
        int ht = 0;
        while (node != null) {
            ht++;
            node = node.left;
        }

        return ht;
    }

    static int right_height(Node node) {
        int ht = 0;
        while (node != null) {
            ht++;
            node = node.right;
        }

        return ht;
    }

    // cau 1
    public int count(Node n) {

        if (root == null)
            return 0;

        int lh = left_height(root);
        int rh = right_height(root);

        if (lh == rh)
            return (1 << lh) - 1;

        return 1 + count(root.left)
                + count(root.right);
    }

    // cau 2
    public Node minOdd(Node n) {
        if (n == null) {
            return null;
        }

        if (n.left == null || n.left.key % 2 != 0) {
            return n;
        }
        return min(n.left);
    }
}

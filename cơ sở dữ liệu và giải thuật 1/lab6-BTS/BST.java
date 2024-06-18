public class BST {
	private Node root;

	public BST() {
		this.root = null;
	}

	private Node insert(Node x, Integer key) {
		if (x == null) {
			return new Node(key);
		}

		int cmp = key.compareTo(x.getKey());

		if (cmp < 0) {
			x.setLeft(insert(x.getLeft(), key));
		} else if (cmp > 0) {
			x.setRight(insert(x.getRight(), key));
		} else {
			x.setKey(key);
		}

		return x;
	}

	public boolean insert(Integer key) {
		if (insert(this.root, key) == null) {
			return false;
		}
		this.root = insert(this.root, key);
		return true;
	}

	public void NLR(Node x) {
		if (x != null) {
			System.out.print(x.getKey() + " ");
			NLR(x.getLeft());
			NLR(x.getRight());
		}
	}

	public void LNR(Node x) {
		if (x != null) {
			LNR(x.getLeft());
			System.out.print(x.getKey() + " ");
			LNR(x.getRight());
		}
	}

	public void LRN(Node x) {
		if (x != null) {
			LRN(x.getLeft());
			LRN(x.getRight());
			System.out.print(x.getKey() + " ");
		}
	}

	public void RNL(Node x) {
		if (x != null) {
			RNL(x.getRight());
			System.out.print(x.getKey() + " ");
			RNL(x.getLeft());
		}
	}

	private Node search(Node x, Integer key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.getKey());

		if (cmp < 0) {
			return search(x.getLeft(), key);
		} else if (cmp > 0) {
			return search(x.getRight(), key);
		} else {
			return x;
		}
	}

	public boolean search(Integer key) {
		if (search(this.root, key) == null) {
			return false;
		}
		this.root = search(this.root, key);
		return true;
	}

	public Node createTree(String strKey) {
		String[] tmp = strKey.split(" ");

		if (tmp.length == 0) {
			return null;
		}

		for (String ele : tmp) {
			this.root = insert(this.root, Integer.parseInt(ele));
		}

		return this.root;
	}

	public boolean printAscending() {
		if (this.root.getKey() == null) {
			return false;
		}

		LNR(this.root);
		return true;
	}

	public boolean printDescending() {
		if (this.root.getKey() == null) {
			return false;
		}

		RNL(this.root);
		return true;
	}

	public boolean contains(Integer key) {
		if (this.root == null) {
			return false;
		}
		return contains(this.root, key);
	}

	private boolean contains(Node x, Integer key) {
		// Node tmp = this.root;

		// if (tmp == null) {
		// return false;
		// }

		// boolean isPersent = false;

		// while (tmp != null) {
		// if (key < tmp.getKey()) {
		// tmp = tmp.getLeft();
		// }
		// else if (key > tmp.getKey()) {
		// tmp = tmp.getRight();
		// }
		// else {
		// isPersent = true;
		// break;
		// }
		// }

		// return isPersent;
		if (x == null) {
			return false;
		}
		if (key < x.getKey()) {
			return contains(x.getLeft(), key);
		}
		if (key > x.getKey()) {
			return contains(x.getRight(), key);
		}
		return true;
	}

	private Node deleteMin(Node x) {
		if (x.getLeft() == null) {
			return x.getRight();
		}
		x.setLeft(deleteMin(x.getLeft()));
		return x;
	}

	public boolean deleteMin() {
		if (this.root == null) {
			return false;
		}
		this.root = deleteMin(this.root);
		return true;
	}

	private Node deleteMax(Node x) {
		if (x.getRight() == null) {
			return x.getLeft();
		}
		x.setRight(deleteMax(x.getRight()));
		return x;
	}

	public boolean deleteMax() {
		if (this.root == null) {
			return false;
		}
		this.root = deleteMax(this.root);
		return true;
	}

	private Node min(Node x) {
		if (x.getLeft() == null) {
			return x;
		}
		return min(x.getLeft());
	}

	private Node delete(Node x, Integer key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.getKey());

		if (cmp < 0) {
			x.setLeft(delete(x.getLeft(), key));
		} else if (cmp > 0) {
			x.setRight(delete(x.getRight(), key));
		} else {
			if (x.getRight() == null) {
				return x.getLeft();
			}
			if (x.getLeft() == null) {
				return x.getRight();
			}

			Node t = x;
			x = min(t.getRight());
			x.setRight(deleteMin(t.getRight()));
			x.setLeft(t.getLeft());

			// x.setKey(min(t.getRight()).getKey());
			// x.setRight(deleteMin(x.getRight()));
		}
		return x;
	}

	public boolean delete(Integer key) {
		if (this.root == null) {
			return false;
		}

		this.root = delete(this.root, key);
		return true;
	}

	private Node max(Node x) {
		if (x.getRight() == null) {
			return x;
		}
		return max(x.getRight());
	}

	private Node delete_pre(Node x, Integer key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.getKey());

		if (cmp < 0) {
			x.setLeft(delete(x.getLeft(), key));
		} else if (cmp > 0) {
			x.setRight(delete(x.getRight(), key));
		} else {
			if (x.getRight() == null) {
				return x.getLeft();
			}
			if (x.getLeft() == null) {
				return x.getRight();
			}

			Node t = x;
			x = max(t.getLeft());
			x.setLeft(deleteMax(t.getLeft()));
			x.setRight(t.getRight());

			// x.setKey(max(t.getLeft()).getKey());
			// x.setLeft(deleteMax(x.getLeft()));
		}
		return x;
	}

	public boolean delete_pre(Integer key) {
		if (this.root == null) {
			return false;
		}
		this.root = delete_pre(this.root, key);
		return true;
	}

	private int height(Node x) {
		if (x == null) {
			return -1;
		}
		return 1 + Math.max(height(x.getLeft()), height(x.getRight()));
	}

	public int height() {
		return height(this.root);
	}

	public Integer sum(Node x) {
		if (x == null) {
			return 0;
		}
		return x.getKey() + sum(x.getLeft()) + sum(x.getRight());
	}

	public Integer sum() {
		return sum(this.root);
	}
}
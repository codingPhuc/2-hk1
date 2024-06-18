public class Node {
	private Integer key;
	private Node left, right;

	public Node(Integer key) {
		this.key = key;
		this.left = this.right = null;
	}

	public Integer getKey() {
		return this.key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node Left) {
		this.left = Left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setRight(Node Right) {
		this.right = Right;
	}
}
public class main {
	public static void main(String[] args) {
		BST testBST = new BST();

		String tmpStr = "25 40 78 10 32 3 17 38 30 93 50";
		testBST.createTree(tmpStr);
		testBST.printAscending();
		System.out.println();
		testBST.printDescending();
		System.out.println();
		System.out.println(testBST.contains(32) + " " + testBST.contains(14));
		testBST.deleteMax();
		testBST.printAscending();
		System.out.println();
		testBST.deleteMin();
		testBST.printAscending();
		System.out.println();
		testBST.delete(78);
		testBST.printAscending();
		System.out.println();
		testBST.delete_pre(17);
		testBST.printAscending();
		System.out.println();
		System.out.println(testBST.height());
		System.out.println(testBST.sum());
	}
}
public class NodeAVL {
    Integer key;
    NodeAVL left, right;
    int height;

    public NodeAVL(Integer key){
        this.key = key;
        this.height = 0;
        this.left = this.right = null;
    }
}
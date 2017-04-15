import java.util.Iterator;

public class TreeIterable<T> implements Iterable<T> {
    private final BinaryTree tree;
    private final boolean isDF;

    public TreeIterable(BinaryTree tree, boolean isDF) {
      this.tree = tree;
      this.isDF = isDF;
    }

    public Iterator<T> iterator() {
        return new TreeIterator<T>(this.tree, this.isDF);
    }
}

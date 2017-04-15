import java.util.Iterator;
import java.lang.Comparable;
import java.util.ArrayList;

public class TreeIterator<T> implements Iterator<T> {
    // Need something to do with the T's, so we'll just make an array:
    private BinaryTree<T> tree;
    private ArrayList<T> myList = new ArrayList<T>();
    private int index = 0;

    public TreeIterator(BinaryTree<T> tree, boolean isDF) {
        this.tree = tree;
        if(isDF)
          DFIterate();
        else
          BFIterate();
    }

    private void BFIterate(){
      bfs();
      return;
    }

    public void bfs(){
      LinkedList queue = new LinkedList();
      queue.add(root);
      while(hasHowMany((Node<T>)queue.element()) == 2){
        queue.add((Node<T>) queue.element().getLeft());
        queue.add((Node<T>) queue.element().getRight());
        myList.add(queue.remove().getContent());
      }
      return;
	  }

    private void DFIterate(){
      dfs(tree.getRoot());
      return;
    }

    public void dfs(Node root){
      if(root.getLeft() != null){
        dfs(root.getleft());
      }
      myList.add(root.getContent());
      if(root.getRight() != null){
        dfs(root.getRight());
      }
    }

    public boolean hasNext() {
      return index < myList.length();
    }

    public T next(){
      return myList.get(index++);
    }

    public static void main(String[] args) {
      BinaryTree<Integer> myTree = new BinaryTree<Integer>();

        // for (Integer i: new TreeIterable<Integer>())
        //     System.out.println(i);
        //
        // for (String word: new TreeIterable<String>(new String[]{"Cat", "Dog", "Platypus"}))
        //     System.out.println(word);
    }
}

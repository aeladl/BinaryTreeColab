 public class BinarySearchTree<T> extends BinaryTree{
  public BinarySearchTree(){
  }
  public boolean add(T item) {
    if(item == null)
    throw new NullPointerException();

    return addItem(item, root);
  }
  private boolean addItem(T item, Node<T> thisRoot){
    if(thisRoot == null)
    {
      thisRoot = new Node<T>(item);
      return true;
    }

    if(item.compareTo(thisRoot.getContent()) =< 0)
    return addItem(item, thisRoot.left);

    else
    return addItem(item, thisRoot.right);
  }
}

 public class BinarySearchTree<T> extends BinaryTree{
  public BinarySearchTree(){
  }
  public boolean empty(){
    return root == null;
  }
  public void clear(){
    root = null;
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
  //TODO
  public void remove(T item) throws NullPointerException{

  }
  public boolean contains(T item){
    return this.conatins(item, root);
  }
}

public class Set<T> extends BinarySetTree{
  public Set(){
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

    if(item.compareTo(thisRoot.getContent()) < 0)
    return addItem(item, thisRoot.left);

    else if(item.compareTo(thisRoot.getContent()) > 0)
    return addItem(item, thisRoot.right);

    return false;

  }
  public boolean contains(T item){
    return this.conatins(item, root);
  }
  //TEST
  //Change name of iterator
  public Set union(Set other){
    for (Node<T> j: new MyIterable<T>(other)){
            for (Node<T> i: new MyIterable<T>(this)){
            if (j.getContent().compareTo(i.getContent()) != 0)
              other.add(i);
          }
        }
        return other;
  }
  //TEST
  //Change name of iterator
  public Set intersection(Set other){
    Set<T> n = new Set<T>();
    for (Node<T> i: new MyIterable<T>(this)){
            for (Node<T> j: new MyIterable<T>(other)){
            if (j.getContent().compareTo(i.getContent()) == 0)
              n.add(i);
          }
        }
        return n;
  }
}

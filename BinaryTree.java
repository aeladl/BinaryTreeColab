import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
  protected Node<T> root;

  public BinaryTree(T item){
    root = new Node<T>(item);
  }

  public boolean empty(){
    return root == null;
  }

  public void clear(){
    root = null;
  }

  public boolean add(T item){
    LinkedList queue = new LinkedList();
    queue.add(root);
    while(queue.element().hasHowMany() == 2){
      queue.add((Node)queue.element().left);
      queue.add((Node)queue.element().right);
      queue.removeFirst();
    }

    if (queue.element().left == null) {
      queue.element().left = new Node(item);
    }
    else {
      queue.element().right = new Node(item);
    }
  }

  //TODO
  public void remove(T item) throws NullPointerException{
    if(!contains(item)) throw new NullPointerException("You Fool!!! Why???");



  }

  public boolean contains(T item){
    return contains(item, root);
  }

  public boolean contains(T item, Node<T> n){
    if (n.getContent() == item){
      return true;
    }
    else if (n == null){
      return false;
    }
    else{
      return contains(item, n.left) || contains(item, n.right);
    }
    return false;
  }

  //TODO
  public Node<T> get(T item) throws NullPointerException{
    if (!contains(item)) throw new NullPointerException();

    while (root.compareTo(item) )
    while(queue.peek().hasHowMany() == 2){
      queue.add(queue.peek().left);
      queue.add(queue.peek().right);
      if(queue.peek().equals(item))
      {
        return queue.peek()
      }
      queue.remove();
    }

    if (queue.peek().left.equals(item)) {
      return queue.peek()
    }
    else if(queue.peek().right.equals(item)) {
      return queue.peek()
    }
  }

  //TODO
  public Node<T> get(T item, Node<T> n){
    if (n.getContent() = item){
      return n;
    }

    else{

    }
  }

  //TODO
  public java.util.Iterator<T> breadthFirst(){

  }

  //TODO
  public java.util.Iterator<T> depthFirst(){

  }

  public class Node<T>{
    private T contents;
    public Node<T> left;
    public Node<T> right;

      public Node(T data){
        contents = data;
      }

      public boolean addLeft(Node<T> n, T item){
        n.left = new Node<T>(item);
        return true;
      }

      public boolean addRight(Node<T> n, T item){
        n.right = new Node<T>(item);
        return true;
      }

      // returns true if both left and right are occupied
      public int children(){
        if (left != null && right != null)
      		return 2;
        if (left == null && right == null)
          return 0;
        return 1;
      }

      public boolean hasLeftChild(){
        if (left != null)
        	return true;
        return false;
      }

        public boolean hasRightChild(){
        	if (right != null)
        		return true;
        	return false;
        }
    }
  }

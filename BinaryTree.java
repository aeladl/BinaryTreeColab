import java.util.LinkedList;
import java.util.ArrayList;

public class BinaryTree<T> {
  protected Node<T> root;

  public class Node<T>{
    private T content;
    public Node<T> left;
    public Node<T> right;

    public Node(){}

      public Node(T content){
        this.content = content;
      }
      public void setContent(T item){
        this.content = item;
      }

      public T getContent(){
        return this.content;
      }

      public Node<T> getLeft(){
        return this.left;
      }

      public Node<T> getRight(){
        return this.right;
      }

      public boolean addLeft(Node<T> n, T item){
        n.left = new Node<T>(item);
        return true;
      }

      public boolean addRight(Node<T> n, T item){
        n.right = new Node<T>(item);
        return true;
      }
    }

    public BinaryTree(){
    }

    public Node<T> getRoot(){
      return root;
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
      while(hasHowMany((Node<T>)queue.element()) == 2){
        queue.add((Node<T>) queue.element().left);
        queue.add((Node<T>) queue.element().right);
        queue.remove();
      }
      if (queue.element().left == null){
        queue.element().left = new Node(item);
      }
      else {
        queue.element().right = new Node(item);
      }
    }
    private int hasHowMany(Node<T> n){
      if(n.left == null && n.right == null) return 0;
      else if(n.left == null ^ n.right == null) return 1;
      else if(n.left != null && n.right != null) return 2;
      return -1;
    }
    //TODO
    public void remove(T item) throws NullPointerException{
      if(!this.contains(item)) throw new NullPointerException("You Fool!!! Why???");

    }
    public boolean contains(T item){
      return this.contains(item, root);
    }
    public boolean contains(T item, Node<T> n){
      if (n.getContent() == item){
        return true;
      }
      else if (n == null){
        return false;
      }
      else{
        return this.contains(item, n.left) || this.contains(item, n.right);
      }
      return false;
    }
    //TODO
    public Node<T> get(T item) throws NullPointerException{
      if (!this.contains(item)){
        throw new NullPointerException();
      }
      else {

      }
    }
    // //TODO
    // public Node<T> get(T item, Node<T> n){
    //   if (n.getContent() = item){
    //     return n;
    //   }
    //   if ()
    //   else{
    //
    //   }
    // }
    //
    // public java.util.Iterator<T> breadthFirst(){
    //   return new TreeIterable(this, false);

    // //TODO
    // public java.util.Iterator<T> breadthFirst(){
    //
    // }

    // //TODO
    // public java.util.Iterator<T> depthFirst(){
    //
    // }

  }

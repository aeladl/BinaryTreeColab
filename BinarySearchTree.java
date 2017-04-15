 public class BinarySearchTree<T> extends BinaryTree<T>{
  protected Node<T> switch;

  public BinarySearchTree(){
  }

  public boolean add(T item) {
    if(item == null)
      throw new NullPointerException();
    return addItem(item, root);
  }

  private boolean addItem(T item, Node<T> thisRoot) {
    if(thisRoot == null)
    {
      thisRoot = new Node<T>(item);
      return true;
    }

    if(item.compareTo(thisRoot.contents) =< 0)
      return addItem(item, thisRoot.left);
    return addItem(item, thisRoot.right);
  }

  public boolean remove(T item) {
    if (root == null)
      return false;
    else {
    if (root.contents.equals(item)) {
      Node<T> aux = new Node<T>(0);
                       aux.setLeftChild(root);
                       boolean result = root.remove(value, aux);
                       root = aux.left;
                       return result;
                 } else {
                       return root.remove(value, null);
                 }
           }
     }

  // public void remove(T item) throws NullPointerException {
  //   if (!contains(item)) throw new NullPointerException();
  //
  //   while (true)
  //   {
  //     if (root.contents.equals(item))
  //       break;
  //
  //     if(item.compareTo(root.contents) <= 0)
  //       root = root.left;
  //     root = root.right;
  //   }
  //   //at item to be removed
  //   if (root.children().equals("B"))
  //   {
  //     switch = root.left;
  //
  //     while (switch.children().equals("R"))
  //     {
  //       switch = switch.right;
  //     }
  //     root.contents = switch.contents;
  //     if (switch.children().equals)
  //   }
  //   else if (root.children().equals("L"))
  //   {
  //     switch =
  //   }
  //   else
  //   {
  //     root = null;
  //   }
  // }

  public Node<T> get(T item) throws new NullPointerException {

  }


  public class Node<T>
  {
    private T contents;
    public Node<T> left;
    public Node<T> right;

    public Node(T data)
    {
      contents = data;
    }

    public boolean remove(T item, Node<T> parent) {
        if (item.compareTo(contents) < 0) {
              if (left != null)
                    return left.remove(value, this);
              else
                    return false;
        } else if (item.compareTo(contents) > 0) {
              if (right != null)
                    return right.remove(value, this);
              else
                    return false;
        } else {
              if (left != null && right != null) {
                    contents = right.minValue();
                    right.remove(contents, this);
              } else if (parent.left == this) {
                    parent.left = (left != null) ? left : right;
              } else if (parent.right == this) {
                    parent.right = (left != null) ? left : right;
              }
              return true;
        }
    }

    public int minValue() {
        if (left == null)
              return contents;
        else
              return left.minValue();
    }
  }

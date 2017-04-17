import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T>
{
  protected Node<T> root;

  public BinaryTree()
  {

  }

  public boolean empty()
  {
    return root == null;
  }

  public void clear()
  {
    root = null;
  }

  public boolean add(T item)
  {
	Queue<Node<T>> queue = new LinkedList<Node<T>>();

    queue.add(root);
	if (empty())
	{
		root = new Node<T>(item);
		return true;
	}

	while (queue.peek().hasChildren())
	{
		queue.add(queue.peek().left);
		queue.add(queue.peek().right);
		queue.remove();
	}

	if (queue.peek().hasLeftChild())
	{
		queue.peek().addRight(item);
	}
	else
	{
		queue.peek().addLeft(item);
	}
	return true;
  }

//  public void remove(T item) throws NullPointerException
//  {
//	  if(!this.contains(item))
//		  throw new NullPointerException("You Fool!!! Why???");
//
//	  Node<T> n = get(item);
//	  Node<T> parent;
//	  if (!n.hasChildren())
//		  n = null;
//	  else if (n.hasLeftChild())
//		  parent = n.left;
//	  else
//		  parent = n.right;
//	  Node<T> child = n.left;
//	  while(parent.right.right != null)
//	  {
//		  parent = parent.right;
//	  }
//	  child = parent.right;
//	  n.content = child.content;
//	  parent.right = child.left;
//  }


//  public Node<T> getParent(Node<T> c)
//  {
//	  Queue<Node<T>> queue = new LinkedList<Node<T>>();
//	  T item = c.content;
//
//	  if (!contains(item))
//		  throw new NullPointerException("Item Does Not Exist");
//
//	  queue.add(root);
//
//	  while (!queue.peek().left.equals(item) || !queue.peek().right.equals(item))
//	  {
//		  if (queue.peek().hasChildren())
//		  {
//			  queue.add(queue.peek().left);
//			  queue.add(queue.peek().right);
//		  }
//		  else if (queue.peek().hasLeftChild())
//		  {
//			  queue.add(queue.peek().left);
//		  }
//		  else if (queue.peek().hasRightChild())
//		  {
//			  queue.add(queue.peek().left);
//		  }
//		  queue.remove();
//	  }
//	  return queue.peek();
//  }
//
  public boolean contains(T item)
  {
    return contains(item, root);
  }

  public boolean contains(T item, Node<T> n)
  {
	if (n == null)
	{
		return false;
	}
	else if (n.content.equals(item))
    {
    	return true;
    }
    else
    {
    	return contains(item, n.left) || contains(item, n.right);
    }
  }

  public Node<T> get(T item) throws NullPointerException
  {
	  if (!contains(item))
          throw new NullPointerException("Item Does Not Exist");

      Queue<Node<T>> queue = new LinkedList<Node<T>>();
      queue.add(root);

      while (!queue.peek().content.equals(item))
      {
          if (queue.peek().hasChildren())
          {
              queue.add(queue.peek().left);
              queue.add(queue.peek().right);
          }
          else if (queue.peek().hasLeftChild())
          {
              queue.add(queue.peek().left);
          }
          else if (queue.peek().hasRightChild())
          {
              queue.add(queue.peek().left);
          }
          queue.remove();
      }
      return queue.peek();
  }


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

  public class Node<T>
  {
	  protected T content;
	  protected Node<T> left;
	  protected Node<T> right;

      public Node(T item)
      {
        content = item;
      }

      public String toString()
      {
    	  return "" + content;
      }

      public boolean addLeft(T item)
      {
        left = new Node<T>(item);
        return true;
      }

      public boolean addRight(T item)
      {
        right = new Node<T>(item);
        return true;
      }

      public boolean hasChildren()
      {
        if(left != null && right != null)
        	return true;
        return false;
      }

      public boolean hasLeftChild()
      {
    	if(left != null && right == null)
    		return true;
    	return false;
      }

      public boolean hasRightChild()
      {
    	if(left == null && right != null)
    		return true;
        return false;
      }
    }
  }

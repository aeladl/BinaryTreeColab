
import java.util.LinkedList;
import java.util.Queue;

import Test.BinaryTree.Node;

public class BinarySearchTree<T> extends BinaryTree<T>
{
	protected BSTNode<T> root;

	public BinarySearchTree()
	{
		super();
	}

	public boolean add(T item)
	{
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();

	    queue.add(root);
		if (empty())
		{
			root = new BSTNode<T>(item);
			return true;
		}
		while (true)
		{
			if (item.toString().compareTo(queue.peek().content.toString()) <= 0)
			{
				if (queue.peek().hasLeftChild())
				{
					queue.add(queue.peek().left);
					queue.remove();
				}
				queue.peek().addLeft(item);
				return true;
			}
			else
			{
				if (queue.peek().hasRightChild())
				{
					queue.add(queue.peek().right);
					queue.remove();
				}
				queue.peek().addRight(item);
				return true;
			}
		}
	}

	public boolean contains(T item)
	{
		return contains(item, root);
	}

	public boolean contains(T item, BSTNode<T> s)
	{
		if (s == null)
		{
			return false;
		}
		else if (s.content.equals(item))
	    {
	    	return true;
	    }
	    else if (item.toString().compareTo(s.content.toString()) <= 0)
	    {
	    	return contains(item, s.left);
	    }
	    else
	    {
	    	return contains(item, s.right);
	    }
	}

	public class BSTNode<T> extends Node<T>
	{
	    protected T content;
	    protected BSTNode<T> left;
	    protected BSTNode<T> right;

	    public BSTNode(T item)
	    {
	        super(item);
	    }

	      public boolean addLeft(T item)
	      {
	        left = new BSTNode<T>(item);
	        return true;
	      }

	      public boolean addRight(T item)
	      {
	        right = new BSTNode<T>(item);
	        return true;
	      }
	}
}

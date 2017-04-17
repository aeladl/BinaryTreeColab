# Binary Trees
## Phillips Academy CSC630: Data Structures and Algorithms, Spring 2017
##### Created April 5, 2017
##### Author: Nicholas Zufelt

In this project, we'll be working with binary trees and all the multitude of data structures that are related to or associated with them. This project will have multiple tasks, much of which should be completable in parallel. Unlike the previous project, parts of which might have been difficult to Test Drive (as in, perform test-driven development), this project should allow you to slow down and make sure you're carefully following TDD practices.

### Classes you'll create
1. `BinaryTree`
2. `BinarySearchTree` and `Set`
3. `Heap` and `PriorityQueue`

## `BinaryTree` class
An object of type `BinaryTree` should constitute an entire binary tree.  A node of this binary tree will use a _nested_ class `Node`.  Each class you create after this should use a `BinaryTree` or one of its derivatives.  A binary tree is a data structure where every node has two _child_ nodes, usually called `left` and `right`.  The node that other classes have access to is usually called the `root` node.  See the starter code in the `working` branch for more information.

* `public void remove(T item) throws NullPointerException` -- Remove from the tree the _first occurrence_ of `item` in a breadth-first traversal of the tree.  Return
* `public boolean contains(T item)` -- Determines if `item` is in the tree.  Throws a `NullPointerException` if no nodes in the tree contain `item`.
* `public java.util.Iterator<T> breadthFirst()` -- Return an iterator over the tree in a breadth-first order, skipping `null` nodes.
* `public java.util.Iterator<T> depthFirst()` -- Return an iterator over the tree in a depth-first order, skipping `null` nodes.
* Any other methods you need in order to make the below classes work!

## `BinarySearchTree` class
A Binary Search Tree is a tree that is ordered (so it's contents `T` must be `Comparable`) such that any `Node n` satisfies the property: `n.left` and any of its children compare to smaller than `n`, and `n.right` and any of its children compare to larger than `n`.  Often, one requires that your tree is _balanced_, meaning you continually update the structure of the tree to have close to the same number of elements to the left of any node as to the right, but I won't require your BSTs be balanced. You may make `BinarySearchTree` a subclass of `BinaryTree` or have a `BinaryTree` field, the choice is yours.

Your `BinarySearchTree` class should contain:
* A no-args constructor
* `public boolean empty()` -- Test if this tree is empty.
* `public void clear()` -- Empty the tree.
* `public boolean add(T item)` -- Add `item` in a valid spot.  Returns whether `item` was successfully added (for now, always `true`).
* `public boolean remove(T item)` -- Remove from the tree _one occurrence_ of `item` in the tree,  _without_ removing anything else (Don't lop off entire limbs).
* `public boolean contains(T item)` -- Determines if `item` is in the tree.
* `public java.util.Iterator<T> sorted(boolean reversed)` -- Return an iterator over the tree in sorted order, possibly `reversed`.

## `Set` class
A set is a container that contains at most one of any element.  Thus, your contents `T` should have a valid `equals` method.  A `Set` should use a `BinarySearchTree` to perform its functionality.

Your `Set` class should contain:
* A no-args constructor
* `public boolean empty()` -- Test if this set is empty.
* `public void clear()` -- Empty the set.
* `public boolean add(T item)` -- Add `item`.  Returns whether `item` was successfully added, which is `false` precisely when another copy of `item` is already in the set.
* `public void remove(T item)` -- Remove `item` from the set.
* `public boolean contains(T item)` -- Determines if `item` is in the set.
* `public Set union(Set other)` -- performs the _union_ of `this` with `other`, _i.e._ the set containing all the elements of `this` or `other`.
* `public Set intersection(Set other)` -- performs the _intersection_ of `this` with `other`, _i.e._ the set containing all the elements present in **both** `this` and `other`.
* **Fun Aside**: Create a `main` method for `Set` that takes in the name of a text file via command-line argument and creates an ordered dictionary of words in the text, output as another text file with one word per line.

## `Heap` class
A _heap_ is a tree that satisfies the _heap_ property: every node `n` has the property that both `n.left` (and all its children) and `n.right` (and all its children) compare to being _less than_ `n` (This is sometimes referred to as the _max-heap_ property, and their are similarly _min-heaps_).  Note again that `T` must be `Comparable` to make this happen.

Your `Heap` class should contain:
* A no-args constructor
* `public boolean add(T item)` -- Add `item` to the heap in a valid spot.  Returns whether `item` was successfully added (always `true`).
* `public T	extractMax()` -- Returns the maximum object, then removes that object from the heap.  Note that the maximum object is the root, so this method should reset the `root`.
* `public T	max()` -- Returns the maximum object
* `public boolean contains(T item)` -- Determines if `item` is in the heap.
* `public boolean empty()` -- Test if this heap is empty.
*  `public java.util.Iterator<T> iterate()` -- Returns an iterator over its elements in order of largest to smallest.
* `public int size()` -- Returns the number of elements currently in the heap.
* `public void clear()` -- Empty the heap.

## `PriorityQueue` class
A Priority Queue is a queue (first-in, first-out, otherwise known as a line) where items are ordered by their natural comparisons, and instead of taking from the "front of the line" you take the highest priority element.  A `PriorityQueue` should use a `Heap` to perform its functionality.

* A no-args constructor
* `public boolean add(T item)` -- Add `item` to the "back" of the queue, then propagate the item to the proper place in the queue.  Returns whether `item` was successfully added (always `true`).
* `public T next()` -- Return the highest priority item from the queue, removing it in the process.
* `public T peekNext()` -- Return the highest priority item from the queue.
* `public boolean contains(T item)` -- Determines if `item` is in the queue.
* `public int size()` -- Returns the number of elements currently in the queue.

public class Heap<T> extends BinaryTree{

  public Heap(){

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

   public int size(){
     int stuff = 0;
     for(T i: iterate())
      stuff++;
    return stuff;
   }
//TODO
   public T extractMax(){

   }
   public boolean contains(T item){
     return this.contains(item, root);
   }

   public java.util.Iterator<T> iterate(){
     return new TreeIterable<T>(this, false);
   }
}

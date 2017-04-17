/**
 * A basic implementation of a LinkedList.  Note that the generic type `T`
 * is being used here.
 *
 * Author: Wilson Liang
 * Date: Jan 30, 2016
 * Course: CSC630 Data Structures and Algorithms
 */

public class LinkedList<T> {
    private T contents;
    private LinkedList<T> next;

    //sets initial value
    public LinkedList(T o){
      contents = o;
    }

    //empty contructor that sets first object to null
    public LinkedList(){}

    public boolean add(T o){
      //if initial object is null
      if(this.contents == null){
        this.contents = o;
        return true;
      }
      //if reached end of list
      if(next == null){
        next = new LinkedList<T>(o);
        next.contents = o;
        return true;
      }
      return next.add(o);
    }

    //replaces object at index with o, shifts subsequent objects
    public boolean add(int index, T o){
      if(index == 0){
        LinkedList<T> temp = new LinkedList<T>(this.contents);
        temp.next = this.next;
        this.contents = o;
        this.next = temp;
        return true;
      }
      if(index == 1){
        LinkedList<T> temp = new LinkedList<T>(o);
        temp.next = this.next;
        this.next = temp;
        return true;
      }
      return next.add(index - 1, o);
    }


    public T get(int index){
      if(index == 0)
        return contents;
      return next.get(index - 1);

    }

    public boolean contains(T o){
      if(this.next == null)
        return false;
      if(this.contents == o)
        return true;
      return next.contains(o);
    }

    public int indexOf(T p){
      if(this.contents == p)
        return 0;
      return next.indexOf(p) + 1;
    }

    public int size(){
      if(next == null)
        return 1;
      return next.size() + 1;
    }

    public T remove(int index){
      if(index == 1){
        T tempvalue = this.next.contents;
        this.next = this.next.next;
        return tempvalue;
      }
      return next.remove(index - 1);
    }

    public String toString(){
      if(next == null)
        return "" + this.contents+ ";";
      return "" + this.contents +", "+ next.toString();
    }

    public void clear(){
      this.next = null;
      this.contents = null;
    }

    public static void main(String[] args) {
      LinkedList<String> myList = new LinkedList<String>("a");
      assert myList.add("b");
      assert myList.add("c");
      assert myList.add("e");
      // System.out.println(myList.toString());

      assert myList.add(3, "d");
      // System.out.println(myList.toString());

      assert myList.contains("g") == false;
      assert myList.indexOf("d") == 3;
      assert myList.size() == 5;

      assert myList.remove(1) == "b";

      myList.clear();
      System.out.println(myList.toString());



    }
}

import static org.junit.Assert.*;
import org.junit.Test;

public class JUnit {

	@Test
	public void test()
	{
		      LinkedList<Integer> a = new LinkedList<Integer>();
		      for(int i = 0; i < 100; i++) {
		        a.add(i);
		        assertEquals((Integer)i,a.get(i));
		      }

		      a.add(50, 1000);

		      // Check number was correctly placed into LinkedList
		      for(int i = 0; i < 50; i++) {
		        assertEquals((Integer)i, a.get(i));
		      }
		      assertEquals((Integer)1000,a.get(50));
		      for(int i = 51; i < 101; i++) {
		        assertEquals((Integer)(i-1),a.get(i));
		      }
		      a = new LinkedList<Integer>();
		      for(int i = 0; i < 10; i++) a.add(i);
		      // Test add() edge cases
		      a.add(10, 12);
		      assertEquals((Integer)12,a.get(10));

		      LinkedList<Integer> test = new LinkedList<Integer>();
		      assertEquals(0,test.size());
		      for(int i = 0; i < 100; i++) {
		        test.add(i);
		        assertEquals(i,test.indexOf(i));
		        assertTrue(test.contains(i));
		        assertFalse(test.contains(-10));
		        assertEquals(i+1,test.size());
		      }
		      assertFalse(test.contains(1000));

		      // Test that remove works properly
					// you can use assertTrue this way as well
		      assertTrue(test.remove(2) == 2);
		      assertTrue(test.get(1) == 1);
		      assertTrue(test.get(2) == 3);
		      assertTrue(test.remove(0) == 0);
		      assertTrue(test.remove(test.size()-1) == 99);

		      test = new LinkedList<Integer>();
		      for(int i = 0; i < 20; i++) test.add(i);
		      assertEquals((Integer)10,test.remove(10));
		      assertEquals((Integer)11,test.remove(10));
		      assertEquals((Integer)9,test.get(9));
		      assertEquals((Integer)12,test.get(10));

		      // More testing with Strings
		      LinkedList<String> myList = new LinkedList<String>("a");
		      myList.add("b");
		      myList.add("c");
		      myList.add("e");
		      myList.add(3, "d");

		      assertEquals("b", myList.remove(1));
		      assertEquals("a, c, d, e", (myList + ""));

		      assertEquals(4,myList.size());
		      myList.clear();
		      assertEquals(0,myList.size());
		      assertEquals(null,myList.toString());

		      LinkedList<String> example = new LinkedList<String>("b");
		      assertEquals("b",example.get(0));
		      assertTrue(example.add(0, "a"));
		      assertTrue(example.contains("a"));
		      assertFalse(example.contains("z"));
		      assertEquals(1,example.indexOf("b"));

		      example.add("d");
		      example.add(2, "c");

		      assertEquals(-1,example.indexOf("2013"));
		      assertEquals("c",example.get(2));
		      assertEquals(2,example.indexOf("c"));
		      assertTrue(example.contains("d"));
		      assertEquals(4,example.size());

		      assertEquals("a",example.remove(0));
		      assertEquals("b",example.get(0));
		      assertFalse(example.contains("s"));
		      assertEquals("d",example.remove(example.size()-1));
		      assertEquals(-1,example.indexOf("z"));

		      // Check for IndexOutOfBoundsException
		      try {
		        example.add(1000, "a");
		        System.out.println("Expected IndexOutOfBoundsException");
		      } catch(IndexOutOfBoundsException e) {
		        }

		      try {
		        example.add(-2, "a");
		        System.out.println("Expected IndexOutOfBoundsException");
		      } catch(IndexOutOfBoundsException e) {
		      }

		      try {
		        example.remove(1000);
		        System.out.println("Expected IndexOutOfBoundsException");
		      } catch(IndexOutOfBoundsException e) {
		        }

		      try {
		        example.remove(-1);
		        System.out.println("Expected IndexOutOfBoundsException");
		      } catch(IndexOutOfBoundsException e) {
		        }
	}
}

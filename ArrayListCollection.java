

import java.util.ArrayList;
import java.util.Iterator;
/* Java ArrayList class uses dynamic way for storing elements.
 * we can add and remove elements.
 * much more flexible that regular array in java.
 * It does not have any size limit on creating elements.
 * ArrayList can have duplicate elements.
 * It is not synchronized.
 * Java ArrayList allows random access because array works at the index basis.
 * In ArrayList, manipulation is little bit slower than the LinkedList in Java because a lot of shifting needs to occur if any element is removed from the array list.
 * public class ArrayList<E> extends AbstractList<E> implements List<E>  
 */

public class ArrayListCollection {

	public static void main(String[] args) {
		ArrayList<String> animals = new ArrayList<String>();
		animals.add("cat");
		animals.add("dog");
		animals.add("mouse");
		animals.add("rat");
		animals.add("lion");
		System.out.println(animals.size());
		for(int s = 0 ; s <= animals.size()-1;s++) {
			
			System.out.println(animals.get(s));
			Iterator itr = animals.iterator();
			while(itr.hasNext()){  
				System.out.println(itr.next());  
				} 
			for(String a:animals) {
				System.out.println(a);
			}
		}
		

	}

}

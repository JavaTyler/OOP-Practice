package GenericArrayList;

import java.util.Iterator;

public class GenericArrayListTestApp {

	public static void main(String[] args) {
		
		// -- construct a list
		GenericArrayList<GenericNode<Integer>> ml = new GenericArrayList<GenericNode<Integer>>();
		
		System.out.println("isempty() test");
		System.out.println("is empty: " + ml.isEmpty());

		// -- add some nodes to it
		for (int i = 0; i < 5; ++i) {
			ml.add(new GenericNode<Integer>(i));
		}
		
		System.out.println("is empty: " + ml.isEmpty());

		// -- print the list
		System.out.println("get() test");
		System.out.println(ml.size() + " of " + ml.capacity());
		for (int i = 0; i < ml.size(); ++i) {
			System.out.println(ml.get(i));
		}
		
		// -- add a node to the back
		System.out.println("add() tests");
		ml.add(new GenericNode<Integer>(6));
		System.out.println(ml.size() + " of " + ml.capacity());
		for (int i = 0; i < ml.size(); ++i) {
			System.out.println(ml.get(i));
		}

		// -- try to add a node to the end (to the back)
		System.out.println("add(x, y) tests");
		try {
			ml.add(ml.size(), new GenericNode<Integer>(7));
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);	
		}
		System.out.println(ml.size() + " of " + ml.capacity());
		for (int i = 0; i < ml.size(); ++i) {
			System.out.println(ml.get(i));
		}

		// -- try to add a node beyond the end (to the back)
		try {
			ml.add(ml.size() + 5, new GenericNode<Integer>(99));
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
			
		}
		System.out.println(ml.size() + " of " + ml.capacity());
		for (int i = 0; i < ml.size(); ++i) {
			System.out.println(ml.get(i));
		}
		
		// -- test contains method
		System.out.println("contains() tests");
		System.out.println("contains: " + ml.contains(new GenericNode<Integer>(7)));
		System.out.println("contains: " + ml.contains(new GenericNode<Integer>(500)));
		
		// -- convert to a conventional array
		System.out.println("toArray() test");
		//Node<Integer> array[] = ml.toArray();
		Object array[] = ml.toArray();
		for (Object x : array) {
			if (x instanceof GenericNode<?>) {
				System.out.println("array " + (GenericNode<Integer>)x);
			}
		}
		array[0] = null;
		System.out.println(ml.get(0));

		// -- find the index of a specific node from the front
		System.out.println("indexOf(n) tests");
		System.out.println("index of " + ml.indexOf(new GenericNode<Integer>(4)));
		int index4 = ml.indexOf(new GenericNode<Integer>(4));
		
		// -- set the value of the node 
		System.out.println("set(x, y) test");
		ml.set(index4, new GenericNode<Integer>(44));
		System.out.println(ml.size() + " of " + ml.capacity());
		for (int i = 0; i < ml.size(); ++i) {
			System.out.println(ml.get(i));
		}
		
		// -- remove the node at an index
		System.out.println("remove(n) test");
		ml.remove(index4);
		System.out.println(ml.size() + " of " + ml.capacity());
		for (int i = 0; i < ml.size(); ++i) {
			System.out.println(ml.get(i));
		}
		
		// -- add a node inside the list
		System.out.println("add(x, y) test");
		System.out.println("index of " + ml.indexOf(new GenericNode<Integer>(4)));
		ml.add(4, new GenericNode<Integer>(44));
		System.out.println(ml.size() + " of " + ml.capacity());
		for (int i = 0; i < ml.size(); ++i) {
			System.out.println(ml.get(i));
		}
				
		// -- add a node to the end and inside and check their indices
		System.out.println("indexOf(e) and lastIndexOf(e) tests");
		ml.add(new GenericNode<Integer>(44));
		ml.add(3, new GenericNode<Integer>(44));
		ml.add(4, new GenericNode<Integer>(44));
		System.out.println(ml.size() + " of " + ml.capacity());
		for (int i = 0; i < ml.size(); ++i) {
			System.out.println(ml.get(i));
		}
		System.out.println(ml.indexOf(new GenericNode<Integer>(44)));
		System.out.println(ml.lastIndexOf(new GenericNode<Integer>(44)));
		
		// -- remove a specified node
		System.out.println("removeFirst(e) and removeLast(e) tests");
		ml.removeFirst(new GenericNode<Integer>(44));
		ml.removeLast(new GenericNode<Integer>(44));		
		System.out.println(ml.size() + " of " + ml.capacity());
		for (int i = 0; i < ml.size(); ++i) {
			System.out.println(ml.get(i));
		}

		
//		// -- iterate over the list
//		System.out.println("=========Iterator=========");
//		Iterator<Node> mlit = ml.iterator();
//		while (mlit.hasNext()) {
//			System.out.println(mlit.next());
//		}
//
//		// -- loop over the list
//		System.out.println("=========for each=========");
//		for (Node n : ml) {
//			System.out.println(n);
//		}
		
		// -- clear the list
		System.out.println("clear() test");
		ml.clear();
		System.out.println(ml.size() + " of " + ml.capacity());
		for (int i = 0; i < ml.size(); ++i) {
			System.out.println(ml.get(i));
		}
		
		
		// -- construct a list with a standard API type
		System.out.println("List<Double>() test");
		GenericArrayList<Double> doublel = new GenericArrayList<Double>();
		for(double i = 0; i < 3; ++i) {
			doublel.add(i + 0.1);
		}
		for (int i = 0; i < doublel.size(); ++i) {
			System.out.println(doublel.get(i));
		}
		
		System.out.println("ensureCapacity(c) tests");
		try {
			System.out.println("Capacity: " + doublel.capacity);
			doublel.ensureCapacity(doublel.size * 2);
			System.out.println("Capacity: " + doublel.capacity);
			doublel.ensureCapacity(doublel.size);
			System.out.println("Capacity: " + doublel.capacity);
			doublel.ensureCapacity(doublel.size - 1);
			System.out.println("Capacity: " + doublel.capacity);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
//		Iterator<Double> intlit = intl.iterator();
//		while (intlit.hasNext()) {
//			System.out.println(intlit.next());
//		}
		
		
	}

}



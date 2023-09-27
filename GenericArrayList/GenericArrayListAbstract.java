package GenericArrayList;

public abstract class GenericArrayListAbstract<T> {
	
	protected int capacity; // -- current number of elements that can be stored in list
	protected int size; // -- current number of elements in the list
	protected T data[];
	
	// -- Java does not allow instantiation of an array of
	//    generic type. You must instantiate an Object array
	//    then cast it to the generic type. This function does
	//    just that. Use it whenever you want to instantiate an
	//    array of the generic type T
	protected T[] makearray(int c)
	{
		// -- Java does not allow instantiation of generic types,
		//    must construct an Object and cast
		return (T[])new Object[c];
	}
	

}

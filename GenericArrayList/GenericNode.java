package GenericArrayList;


public class GenericNode<T> {
	private T data;

	public GenericNode(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	// -- to override the equals method of Object 
	//    you must match the argument type and cast
	//    otherwise you are merely overloading
	@Override
	public boolean equals(Object rhs)
	{
		if (rhs instanceof GenericNode) {
			return (this.data == ((GenericNode)rhs).data);
		}
		else {
			return false;
		}
	}	
	
	// -- a simple test program to demonstrate the use of 
	//    == and .equals()
	public static void main (String[] args)
	{
		{
			GenericNode<Integer> x = new GenericNode<Integer>(1); // auto-box 1 into new Integer(1)
			GenericNode<Integer> y = new GenericNode<Integer>(1);
			System.out.println(x);
			System.out.println(y);
			if (x.equals(y)) {
				System.out.println(x + " equals " + y);
			}
			else {
				System.out.println(x + " does not equal " + y);
			}
			if (x == y) {
				System.out.println(x + " == " + y);
			}
			else {
				System.out.println(x + " != " + y);
			}
		}
		//System.out.println(x.equals(new Integer(1)));
		
		System.out.println("String equality");
		String s0 = new String("hello");
		String s1 = new String("hello");
		
	
		System.out.println(s0 == s1);
		
		{
			GenericNode<String> x = new GenericNode<String>("x"); 
			GenericNode<String> y = new GenericNode<String>("x");
			System.out.println(x);
			System.out.println(y);
			if (x.equals(y)) {
				System.out.println(x + " equals " + y);
			}
			else {
				System.out.println(x + " does not equal " + y);
			}
			if (x == y) {
				System.out.println(x + " == " + y);
			}
			else {
				System.out.println(x + " != " + y);
			}
		}


		{
			GenericNode<Float> x = new GenericNode<Float>(1.0F); // auto-box 1 into new Float(1.0)
			GenericNode<Float> y = new GenericNode<Float>(1.0F);
			System.out.println(x);
			System.out.println(y);
			if (x.equals(y)) {
				System.out.println(x + " equals " + y);
			}
			else {
				System.out.println(x + " does not equal " + y);
			}
			if (x == y) {
				System.out.println(x + " == " + y);
			}
			else {
				System.out.println(x + " != " + y);
			}
		}
}

}

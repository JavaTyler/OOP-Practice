package SafeGenericArrayTesting;

public class MainApp {

	public static void main(String[] args) {
		// -- test the default constructor
		SafeGenericArray<Integer> sga = new SafeGenericArray<Integer>();
		
		// -- there is no convenient way to initialize the array objects within
		//    the constructor since a generic object cannot be instantiated. Thus
		//    objects will be initialized to null until the setValue() method is called.
		//    One way around this is to create a setArray(TYPE a) method that allows
		//    the array to be fully instantiated from the calling class
		// sia = new SafeGenericArray<Integer>(5);
		// Integer data[] = new Integer[5];
		// for (int i = 0; i < data.length; ++i) {
		// 	  data[i] = new Integer(0);
		// }
		// sia.setArray(data);
		System.out.println(sga);
		
		
		// -- test the setValue method
		for (int i = 0; i < sga.length(); ++i) {
			sga.setValue(i, i);
		}
		sga.setValue(sga.length() - 1,0);

		// -- test the toString method
		System.out.println(sga);

		// -- test the getValue method
		int sum = 0;
		for (int i = 0; i < sga.length(); ++i) {
			sum += sga.getValue(i);
		}
		System.out.println(sum);

		// -- test exception handling on getValue method
		try {
			Integer s = sga.getValue(-1);
		}
		catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("getValue array index out of bounds");
		}

		// -- test exception handling on setValue method
		try {
			sga.setValue(sga.length(), (int)10);
		}
		catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("setValue array index out of bounds");
		}
		
		// -- test the interface methods
		SafeGenericArrayInterface<Integer> siai = (SafeGenericArrayInterface<Integer>)sga;
		System.out.println("First 0 is at " + siai.searchFirst(0));
		System.out.println("Last 0 is at " + siai.searchLast(0));		
		siai.replaceFirst(0,  -1);
		siai.replaceLast(0,  -1);
		System.out.println(siai);
		siai.replaceAll(-1, -2);
		System.out.println(siai);
//		System.out.println(sia.sum());

		// -- test index bounds checking
		try {
			sga.setValue(100, (int)100);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid array index");
		}
		
		// -- test the overload constructor 
		sga = new SafeGenericArray<Integer>(5);
		Integer data[] = new Integer[5];
		for (int i = 0; i < data.length; ++i) {
			sga.setValue(i,  0);
		}
		
		// -- test abstract class usage
		SafeGenericArrayAbstract<Integer> sgaabs = sga;
		System.out.println(sgaabs);
		
		// -- test interface usage
		SafeGenericArrayInterface<Integer> sgainf = sga;
		System.out.println(sgainf);
		
		// -- test the equals method
		// -- the compiler will not allow the instantiation of a generic
		//    array so we must do it in a non-generic manner. The compiler
		//    will issue an "unchecked conversion" warning but we can safely
		//    ignore it since we know what we are doing.
		//    SafeGenericArray<Integer> siarray[] = new SafeGenericArray<Integer>[2];
		SafeGenericArray<Integer> siarray[] = new SafeGenericArray[2];
		
		siarray[0] = new SafeGenericArray<Integer>(5);
		siarray[1] = new SafeGenericArray<Integer>(5);
		for (int i = 0; i < siarray[0].length(); ++i) {
			siarray[0].setValue(i, (int)i);
			siarray[1].setValue(i, (int)i);
		}
		siarray[0].setValue(siarray[0].length() - 1, (int)0);
		siarray[1].setValue(siarray[1].length() - 1, (int)0);		
		System.out.println(siarray[0].equals(siarray[1]));

		siarray[1].setValue(siarray[1].length() - 1, (int)1);
		System.out.println(siarray[0].equals(siarray[1]));
		System.out.println();
		
		// -- to test the Object.equals() override
		//Object o = siarray[1];
		//System.out.println(siarray[0].equals(o));
		
		SafeGenericArray<Float> farray = new SafeGenericArray<Float>();
		for (int i = 0; i < farray.length(); ++i) {
			farray.setValue(i, (float)i);
		}
		
		for (int i = 0; i < farray.length(); ++i) {
			float f = farray.getValue(i);
			System.out.println(f);
		}
		System.out.println();

		System.out.println(siarray[0].equals(farray));
		System.out.println();
		
		SafeGenericArray<String> starray = new SafeGenericArray<String>(5);
		for (int i = 0; i < starray.length(); ++i) {
			starray.setValue(i, "String " + i);
		}
		
		for (int i = 0; i < starray.length(); ++i) {
			String s = starray.getValue(i);
			System.out.println(s);
		}
		
		
	}

}
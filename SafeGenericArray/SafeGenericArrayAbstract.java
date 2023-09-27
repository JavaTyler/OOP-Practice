package SafeGenericArrayTesting;

import SafeGenericArrayTesting.SafeGenericArrayAbstract;

public abstract class SafeGenericArrayAbstract<T> {

	// -- array to hold the data items
		protected T data[];

		// -- function to print out the array contents
		@Override
		public String toString() {
			String s = "[";
			for (int i = 0; i < data.length - 1; ++i) {
				s += data[i] + ", ";
			}
			s += data[data.length - 1] + "]";
			return s;
		}
		
		// -- returns true if the argument contents are equal to the this contents,
		//    false otherwise (including different lengths)
		public abstract boolean equals(SafeGenericArrayAbstract siaa);
		
		// -- returns the maximum capacity of the array
		public abstract int length();

		// -- returns the value at the given index, throws exception if index is out of bounds
		//    note that you must do the bounds checking by using an if statement and a throw
		//    instruction. Do not count on the JVM bounds checking mechanism.
		public abstract T getValue(int index) throws ArrayIndexOutOfBoundsException;

		// -- sets the value at the given index, throws exception if index is out of bounds
		//    note that you must do the bounds checking by using an if statement and a throw
		//    instruction. Do not count on the JVM bounds checking mechanism.
		public abstract void setValue(int index, T value) throws ArrayIndexOutOfBoundsException;

}
	


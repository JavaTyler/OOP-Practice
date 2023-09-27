package SafeGenericArrayTesting;

public interface SafeGenericArrayInterface<T> {
	
	// -- returns the index of the first occurrence of argument, -1 if not found
		abstract int searchFirst(T value);

		// -- returns the index of the last occurrence of argument, -1 if not found
		abstract int searchLast(T value);

		// -- replaces the first occurrence of value "in" with value "out"
		abstract void replaceFirst(T in, T out);
		
		// -- replaces the last occurrence of value "in" with value "out"
		abstract void replaceLast(T in, T out);
		
		// -- replaces all occurrences of value "in" with value "out"
		abstract void replaceAll(T in, T out);

		// -- returns the sum of all values
		abstract int sum();
	}


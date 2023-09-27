package SafeGenericArrayTesting;

import SafeArrayTesting.SafeIntArrayAbstract;

public class SafeGenericArray<T> extends SafeGenericArrayAbstract<T> implements SafeGenericArrayInterface<T> {


	public SafeGenericArray() {
		data = (T[]) new Object[10];
	}
	
	public SafeGenericArray(int capacity) {
		data = (T[]) new Object[capacity];
	}
	
	
	@Override
	public int searchFirst(T value) {

		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(value)) {
				return i;
			}
		}

		return -1;
	}

	@Override
	public int searchLast(T value) {
		
		for (int i = data.length - 1; i >= 0; i--) {
			if (data[i].equals(value)) {
				return i;
			}
		}

		return -1;
	}

	@Override
	public void replaceFirst(T in, T out) {
		
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(in)) {
				data[i] = out;
				break;
			}
		}

		
	}

	@Override
	public void replaceLast(T in, T out) {

		for (int i = data.length - 1; i >= 0; i--) {
			if (data[i].equals(in)) {
				data[i] = out;
				break;
			}
		}

		
	}

	@Override
	public void replaceAll(T in, T out) {
			
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(in)) {
				data[i] = out;
			}
		}
		
	}

	@Override
	public int sum() {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			try {
				
				sum += (Integer) data[i];
			
			}
			catch (Exception e) {
				
				return 0;
				
			}
		}
		return sum;
	}

	@Override
	public boolean equals(SafeGenericArrayAbstract siaa) {
		
		if (siaa == null || data.length != siaa.length()) {
			return false;
		}
		
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < siaa.data.length; k++) {
				if (data[i] != siaa.data[i]) {
					return false;
				}
			}
		}
		return true;
		
	}

	@Override
	public int length() {
		 return data.length;
	}

	@Override
	public T getValue(int index) throws ArrayIndexOutOfBoundsException {
		
		if ( index < 0 || index > data.length - 1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return data[index];
	}
	

	@Override
	public void setValue(int index, T value) throws ArrayIndexOutOfBoundsException {
		
		if ( index < 0 || index > data.length - 1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		data[index] = value;
		
	}
}
		
package GenericArrayList;

public class GenericArrayList<T> extends GenericArrayListAbstract<T> implements GenericArrayListInterface<T> {

	@Override
	public int capacity() {
		
		return capacity;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return size == 0;
		
	}

	@Override
	public boolean contains(Object e) {
		
		if(data == null)
            return false;

        for(int i = 0; i < data.length; i++)
        {
            if(data[i].equals(e))
                return true;
        }

        return false;

	}

	@Override
	public T[] toArray() {
		
		T[] result = makearray(size); 
		for (int i = 0; i < result.length; i++) {
			result[i] = data[i];
		}
		return result;
	}

	@Override
	public void ensureCapacity(int c) throws IllegalArgumentException {
		
		 if(c == size)
	            return;

	        if(c < size)
	            throw new IllegalArgumentException();

	        capacity = c;
	        T[] newArray = makearray(c);
	        for(int i = 0; i < size; i++)
	        {
	            newArray[i] = data[i];
	        }
	        data = newArray;

	}

	@Override
	public void add(T e) {
		
		if (size == capacity) {
			ensureCapacity(capacity + 1);
		}
		
		data[size++] = e;
		
	}

	@Override
	public void add(int index, T e) throws IndexOutOfBoundsException {
		
		  if(index < 0 || index > size)
	            throw new IndexOutOfBoundsException();

	        if(size == capacity)
	            ensureCapacity(capacity + 1);

	        for(int i = size; i >= index + 1; i--)
	        {
	            data[i] = data[i - 1];
	        }

	        size++;

	        data[index] = e;
		
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		
		   if(index < 0 || index >= size)
	            throw new IndexOutOfBoundsException();

	        T elementRemoved = data[index];

	        for(int i = index; i < size - 1; i++)
	        {
	            data[i] = data[i + 1];
	        }

	        size--;

	        return elementRemoved;

	}

	@Override
	public boolean removeFirst(Object e) {
		
		int firstIndex = indexOf(e);

	       if(firstIndex == -1)
	            return false;

	       remove(firstIndex);

	       return true;

	}

	@Override
	public boolean removeLast(Object e) {
		
		  int lastIndex = lastIndexOf(e);

	        if(lastIndex == -1)
	            return false;

	        remove(lastIndex);

	        return true;

	}

	@Override
	public void clear() {
		
		data = makearray(capacity);
		size = 0;
		
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		
		if(index < 0 || index >= size) {
			return null;
		}
		
		return data[index];
	}

	@Override
	public T set(int index, T e) throws IndexOutOfBoundsException {
		
		if(index < 0 || index >= size) 
			return null;
		
	    T replacedElement = data[index];
	    data[index] = e;
	    return replacedElement;

	}
		
	

	@Override
	public int indexOf(Object e) {
		
	     for(int i = 0; i < size; i++)
	        {
	            if(data[i].equals(e))
	                return i;
	        }

	        return -1;

	}

	@Override
	public int lastIndexOf(Object e) {
		
		for(int i = size - 1; i >= 0; i--)
            if(data[i].equals(e))
                return i;

        return -1;

	}

}

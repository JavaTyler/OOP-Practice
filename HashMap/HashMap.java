package HashMap;
import LinkedList.*; 

public class HashMap<KEYTYPE, DATATYPE> extends HashMapBase<KEYTYPE, DATATYPE> {
	
	public HashMap(int size) {
		
		N = size;
		hashmap = new SingleLinkedList[size];
		for (int i = 0; i < size; i++) {
			hashmap[i] = new SingleLinkedList<>();
			
		}
	}
	
	@Override
	protected int hash(KEYTYPE key)
	{
	    	String s = key.toString();
	    	int h = 0, high;
	    	for (int i = 0; i < s.length(); ++i) {
	           	h = ( h << 4 ) + s.charAt(i);
	           	if ((high = h & 0xF0000000) != 0) {
	                   	h ^= high >> 24;
	           	}
	           	h &= ~high;
	    	}
	    	return h % N;
	}


	@Override
	public void add(KEYTYPE key, DATATYPE e) {
		hashmap[hash(key)].add(new HashMapNode<KEYTYPE, DATATYPE>(key, e));
		
	}

	@Override
	public int[] getSizes() {
		int[] result = new int[N];
		for (int i = 0; i < hashmap.length; i++) {
			result[i] = hashmap[i].size();
		}
		return result;
	}

}

 public abstract class Hashtable {
	int capacity;
	MapElements[] hashtable;
	
	// Default Constructor
	public Hashtable() {
		hashtable = new MapElements[10];
	}
	// Signature Constructor
	public Hashtable(int size) { 
		hashtable = new MapElements[size];
	}
	
	// Compression the hashCode
	public int hashCompression(int hashcode, int capacity) {
		int hashIndex; 
		hashIndex = hashcode%capacity;
		return hashIndex;
	}
	 
	// Size
	abstract int size();
	
	// isEmpty
	abstract boolean isEmpty();
	
    // put(k)
    abstract void put(Integer k, Character v);
    
    // get(k)
    abstract Character get(Integer k);
    
    // remove(k)
    abstract Character remove(Integer k);
}

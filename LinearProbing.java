public class LinearProbing extends Hashtable {
	int capacity; // Number of elements that can be stored
	int numOfElements = 0; // Number of elements in the array

	// Default Constructor
	public LinearProbing() {
		this.capacity = 10;
	}

	// Signature Constructor
	public LinearProbing(int capacity) {
		this.capacity = capacity;
		hashtable = new MapElements[capacity];
	}

	// size
	public int size() {
		return numOfElements;
	}

	// isEmpty
	public boolean isEmpty() {
		return (numOfElements == 0);
	}

	// Put Method
	public void put(Integer key, Character value) {
		// Attributes
		int sizeBefore = numOfElements;
		int collisions = 0;
		char oldValue;
		int stopIndex;
		int hashcode;
		int newIndex;

		// Creates new entry, hashcode, hashCompression
		MapElements entry = new MapElements(key, value);
		hashcode = entry.hashCode();
		newIndex = hashCompression(hashcode, capacity);

		// If there is something in that position then do this
		if (occupied(newIndex)) {
			stopIndex = newIndex;

			// If first index is what we are looking for
			if (hashtable[newIndex].getKeys() == key) {
				oldValue = hashtable[newIndex].getValues();
				hashtable[newIndex].setValues(value);
				System.out.println(oldValue);
			}

			else {
				newIndex++;

				// Traverse until the stopping index
				while (occupied(newIndex) && newIndex != stopIndex) {
					collisions++;
					if (hashtable[newIndex].getKeys() == key) {
						oldValue = hashtable[newIndex].getValues();
						hashtable[newIndex].setValues(value);
						System.out.println(oldValue);
					}

					newIndex = (newIndex + 1) % hashtable.length;
				}

				if (!occupied(newIndex)) {
					hashtable[newIndex] = entry;
					numOfElements++;
				}
			}
		}

		// Is the position is empty then add new entry.
		else {
			hashtable[newIndex] = entry;
			numOfElements++;
		}

		System.out.println("Size of table: " + sizeBefore);
		System.out.println("Number of Elements after putting " + numOfElements);
		System.out.println("Number of probing attempts: " + collisions);
	}

	// Get
	public Character get(Integer k) {
		// Index of hashFunction
		int newIndex = findIndex(k);

		if (newIndex == -1) {
			return null;
		}

		return hashtable[newIndex].getValues();
	}

	// Remove
	public Character remove(Integer key) {
		// Attributes
		char oldValue;
		int newIndex = findIndex(key);

		if (newIndex == -1) {
			return null;
		}

		oldValue = hashtable[newIndex].getValues();
		hashtable[newIndex] = null;

		MapElements[] oldHashtable = hashtable;
		hashtable = new MapElements[oldHashtable.length];

		for (int i = 0; i < oldHashtable.length; i++) {
			if (oldHashtable[i] != null) {
				MapElements map = new MapElements(oldHashtable[i].getKeys(), oldHashtable[i].getValues());
				hashtable[i] = map;
			}
		}

		return oldValue;
	}

	// FindIndex : finds the key through linear probing
	private int findIndex(int key) {
		int newIndex = hashCompression(key, capacity);

		if (hashtable[newIndex] != null && hashtable[newIndex].getKeys() == key) {
			return newIndex;
		}

		int stopIndex = newIndex;
		if (newIndex == hashtable.length - 1) {
			newIndex = 0;
		} else {
			newIndex++;
		}

		while (newIndex != stopIndex && hashtable[newIndex] != null && !(hashtable[newIndex].getKeys() == key)) {
			newIndex = (newIndex + 1) % hashtable.length;
		}

		if (hashtable[newIndex] != null && hashtable[newIndex].getKeys() == key) {
			return newIndex;
		} else {
			return -1;
		}
	}

	// Check if the position is occupied or not
	private boolean occupied(int index) {
		return hashtable[index] != null;
	}

	// Prints out the hashtable
	public void printHashtable() {
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] == null) {
				System.out.println("Index is null");
			} else {
				System.out.println("Index " + i + ": " + hashtable[i].getValues());
			}
		}
	}
}

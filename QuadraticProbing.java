
public class QuadraticProbing extends Hashtable {
	int capacity;
	int numOfElements;

	// Default Constructor
	public QuadraticProbing() {
		this.capacity = 10;
	}

	// Signature Constructor
	public QuadraticProbing(int capacity) {
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
		int currentIndex;
		int hashcode;
		int newIndex;
		int index;
		int k = 0;

		// Creates new entry, hashcode, hashCompression
		MapElements entry = new MapElements(key, value);
		hashcode = entry.hashCode();
		newIndex = hashCompression(hashcode, capacity);
		index = newIndex;

		// If there is something in that position then do this
		if (occupied(newIndex)) {
			currentIndex = newIndex;

			if (hashtable[newIndex].getKeys() == key) {
				oldValue = hashtable[newIndex].getValues();
				hashtable[newIndex].setValues(value);
				System.out.println(oldValue);
			}

			else {
				k++;
				newIndex = (index + (k * k)) % hashtable.length;

				while (occupied(newIndex)) {
					collisions++;
					if (hashtable[newIndex].getKeys() == key) {
						oldValue = hashtable[newIndex].getValues();
						hashtable[newIndex].setValues(value);
						System.out.println(oldValue);
					}

					
					k++;
					newIndex = (index + (k * k)) % hashtable.length;


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

	// getMethod
	public Character get(Integer k) {
		int newIndex = findIndex(k);

		if (newIndex == -1) {
			return null;
		}

		return hashtable[newIndex].getValues();

	}

	private int findIndex(int key) {
		int k = 0;
		int newIndex = hashCompression(key, capacity);
		int index = newIndex;

		if (hashtable[newIndex] != null && hashtable[newIndex].getKeys() == key) {
			return newIndex;
		}

		if (newIndex == hashtable.length - 1) {
			newIndex = 0;
		}

		else {
			k += 1;
			newIndex = hashCompression((index + (k * k)), capacity);
		}

		while ((hashtable[newIndex] != null) && !(hashtable[newIndex].getKeys() == key)) {
			k += 1;
			newIndex = hashCompression((index + (k * k)), capacity);
		}

		if (hashtable[newIndex] != null && hashtable[newIndex].getKeys() == key) {
			return newIndex;
		}

		else {
			return -1;
		}

	}

	// Remove
	public Character remove(Integer key) {
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

	// Check if the position is occupied or not
	private boolean occupied(int index) {
		return hashtable[index] != null;
	}

	// Prints out the hashtable
	public void printHashtable() {
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] == null) {
				System.out.println("empty");
			} else {
				System.out.println("Position " + i + ": " + hashtable[i].getValues());
			}
		}
	}

}

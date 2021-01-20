import java.util.LinkedList;
import java.util.ListIterator;

public class SeparateChaining extends Hashtable {
	int capacity;
	int numOfElements = 0;

	public LinkedList<MapElements>[] hashtable;

	// Constructor
	public SeparateChaining() {
		hashtable = new LinkedList[10];
		capacity = hashtable.length;
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new LinkedList<MapElements>();
		}
	}
	
	// Signature Constructor
	public SeparateChaining(int capacity) {
		hashtable = new LinkedList[capacity];
		capacity = hashtable.length;
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new LinkedList<MapElements>();
		}
	}
	
	// Size
	public int size() {
		return numOfElements;
	}
	
	// IsEmpty
	public boolean isEmpty() { 
		return (numOfElements == 0);
	}
	

	// Put Function
	public void put(Integer key, Character value) {
		int sizeBefore = numOfElements;
		boolean hasKey = false;
		char oldValue;
		int newIndex = key%hashtable.length;
		ListIterator<MapElements> iterator = hashtable[newIndex].listIterator();
		MapElements map = null;

		while (iterator.hasNext()) {
			map = iterator.next();
			if (map.getKeys() == key) {
				oldValue = map.getValues();
				System.out.println("Old value = " + oldValue);
				map.setValues(value);
				hasKey = true;
			}
		}

		if (!hasKey) {
			hashtable[newIndex].add(new MapElements(key, value));
			numOfElements++;
		}
		
		System.out.println("Size of table: " + sizeBefore);
		System.out.println("Number of Elements after putting " + numOfElements);
		
	}
	
	// Remove Function
	public Character remove(Integer key) { 
		char oldValue;
		int i;
		int newIndex = key%hashtable.length;
		
		ListIterator<MapElements> iterator = hashtable[newIndex].listIterator();
		
		MapElements map = null;
		
		i = -1;
		
		while(iterator.hasNext()) {
			map = iterator.next();
			i++;
			if(map.getKeys() == key) { 
				oldValue = map.getValues();
				hashtable[newIndex].remove(i);
				numOfElements--;
				return oldValue;
			}
		}
		
		if(map.getKeys() == null) {
			return null;
		}
		
		else {
			MapElements maps = new MapElements();
			maps = hashtable[newIndex].get(i);
			oldValue = maps.getValues();
			
			hashtable[newIndex].remove(i);
			numOfElements--;
			return oldValue;
		}
		
		
	}
	
	
	
	// Get Function
	public Character get(Integer key) { 
		int newIndex = hashCompression(key, hashtable.length);
		
		ListIterator<MapElements> iterator = hashtable[newIndex].listIterator();
		
		MapElements map = null;
		
		while(iterator.hasNext()) { 
			map = iterator.next();
			if(map.getKeys() == key) {
				return map.getValues();
			}
		}
		
		
		
		return null;
		
	}

	// Print hashtable
	public void printHashtable() {
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i].isEmpty()) {
				System.out.println("Position " + i + ": empty");
			} else {
				System.out.print("Position " + i + ": ");
				ListIterator<MapElements> iterator = hashtable[i].listIterator();
				while (iterator.hasNext()) {
					System.out.print(iterator.next().getValues());
					System.out.print("->");
				}
				System.out.println("null");
			}
		}
	}
}

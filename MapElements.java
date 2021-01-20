import java.util.Random;
public class MapElements { 
	MapElements AVAILABLE;
	private Integer keys;
	private Character values;
	
	// Constructor
	public MapElements() {
		Random r = new Random();
		
		keys = r.nextInt(50) + 1;
		values = (char)(r.nextInt(26) + 'a');
	}
	
	// Signature Constructor
	public MapElements(Integer key, Character value) { 
		this.keys = key;
		this.values = value;
	}
	
	// Hashcode method
	public int hashCode() {
		return keys;
	}

	public Integer getKeys() {
		return keys;
	}

	public void setKeys(Integer keys) {
		this.keys = keys;
	}

	public Character getValues() {
		return values;
	}

	public void setValues(Character values) {
		this.values = values;
	}
}

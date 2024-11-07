
public class Pair<K, V> {
	private K key;
	private V value;
	
	public Pair(K key,V val) {
		this.key = key;
		this.value = val;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public void setValue(V value) {
		this.value = value;
	}

	
	
}
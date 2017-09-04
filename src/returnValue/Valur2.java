package returnValue;

import java.util.HashMap;
import java.util.Map;

public class Valur2 {

	public static void main(String[] args) {

		Valur2 v = new Valur2();

		System.out.println(v.iget("a"));

	}

	/**
	 * Integer
	 */
	Map<String, Integer> i = new HashMap<>();

	public void iset(String key, Integer value) {
		i.put(key, value);
	}

	public Integer iget(String key) {
		if (i.containsKey(key))
			return i.get(key);

		return null;
	}

	/**
	 * String
	 */
	Map<String, String> s = new HashMap<>();

	public void sset(String key, String value) {
		s.put(key, value);
	}

	public String sget(String key) {

		if (s.containsKey(key))
			return s.get(key);

		return null;
	}

}

package returnValue;

import java.util.HashMap;
import java.util.Map;

class Valur {

	/**
	 * main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		Valur ret = new Valur();
		ret.set("str", "STRING");
		ret.set("int",  123456);

		Valur ret2 = ret;
		System.out.println( ret2.get("str") + " : " +  (ret2.get("str")).getClass());
		System.out.println( ret2.get("int") + " : " +  (ret2.get("int")).getClass() );

	}

	// int以外対応
	Map<String, Object> obj = new HashMap<>();

	public Object get(String key) {

		if (obj.containsKey(key)) {
			return obj.get(key);
		}
		return null;
	}

	public void set(String key, Object value) {
		obj.put(key, value);
	}

}

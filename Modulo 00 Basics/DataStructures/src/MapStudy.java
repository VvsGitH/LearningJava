import java.util.HashMap;
import java.util.Set;

public class MapStudy {
	public static void hashMapTutorial() {
		HashMap<String, String> map = new HashMap<String, String>();

		// Adding key-value pairs
		map.put("name", "Vito");
		map.put("job", "Developer");
		map.put("tel", "333 44 555 66");

		// Replacing a value
		map.replace("name", "John");

		// Checking if a key exist
		if (map.containsKey("name")) {

			// Extracting the keys
			Set<String> keys = map.keySet();

			// Looping over the keys
			for (String key : keys) {
				System.out.print(key + " : ");
				System.out.println(map.get(key));
			}
		}
	}
}

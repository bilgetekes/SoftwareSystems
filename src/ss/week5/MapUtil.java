package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
	
	
	/*
	 * key in ilkinden ama valuenin bir sonrakinden baslayarak tum valuelari kontrol ediyor 
	 * hicbiriyle ayni olmamasi lazim dolayisiyla olursa false return
	 */
	/*
	 * should it return true when the map is empty?
	 */
	/*
	 * @ ensures \result == (\forall K x1,x2; map.containsKey(x1) &&
	 * map.containsKey(x2) && x1 != x2; map.get(x1) != map.get(x2)
	 */
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {  	
        // TODO: implement, see exercise P-5.1
    	if (map.isEmpty()) {
			return true;
		}
		for (int key = 0; key < map.keySet().size(); key++) {
			for (int i = key + 1; i <= map.keySet().size(); i++) {
				if (map.get(key) == map.get(i)) {
					return false;
				}
			}
		}
		return true;
        
    }
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        // TODO: implement, see exercise P-5.2
    	for (V value : range) {
			if (!(map.containsValue(value))) {
				return false;
			}
		}
		return true;
    }

	/*
	 * @ ensures \result == (\forall K x; h.map.get(x) ==
	 * g.map.get(f.map.get(x)))
	 */
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
    	// fonksiyonun tersi oldugu icin key -> value ve value-> key
    	// value kismi daha oncekinin codomaini yani key olucak 
    	Map<V, Set<K>> inversedMap = new HashMap<V, Set<K>>();
		Set<K> keySet = map.keySet();
		for (K key : keySet) {
			V value = map.get(key);
			// If the value is already is the inversed map we add the key to the
			// set belonging to this value
			if (inversedMap.containsKey(value)) {
				inversedMap.get(value).add(key);
			}
			// If not, we put the key in the map and add the key to the set of
			// keys belonging to this value
			else {
				inversedMap.put(value, new HashSet<K>());
				inversedMap.get(value).add(key);
			}
		}
		return inversedMap;
	}
    
    
    /*
	 * @ ensures \result == ((\forall K x1,x2; map.containsKey(x1) &&
	 * map.containsKey(x2) && x1 != x2; map.get(x1) != map.get(x2) && \forall K
	 * y; map.containsKey(y) && map.get(x) == y)
	 */
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
		// key -> value domain->codomain(range) and because to check if it is surjective we need range
		Set<V> range = new HashSet<V>();
		// Since a bijective map is both one on one and surjective
		if (isOneOnOne(map) || isSurjectiveOnRange(map, range)) {
			Map<V, K> invBij = new HashMap<V, K>();
			for (K key : map.keySet()) {
				invBij.put(map.get(key), key);
			}
			return invBij;
		}
		// Since it is no bijection, we can not return an inverse map
		return null;
	}
	/*
	 * tek tek tum ilk fonksiyonun valuelari ikincisinin 
	 */
	/*
	 * @ ensures \result == (\forall K x; g.map.containsKey(x) )
	 */	
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.4
		boolean compatible = true;
		Set<V> gkeySet = g.keySet();
		for (V value : f.values()) {
			// as soon as there is a value not linked to a value in g it is not
			// compatible
			if (!gkeySet.contains(value)) {
				compatible = false;
			}
		}
		return compatible;
		
	}
	/*
	 * @ ensures \result == (\forall K x; h.map.get(x) ==
	 * g.map.get(f.map.get(x)))
	 */
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
		if (compatible(f, g)) {
			Map<K, W> result = new HashMap<K, W>();
			Set<K> keys = f.keySet();
			for (K key : keys) {
				result.put(key, g.get(f.get(key)));
			}
			return result;
		}
		// Maps were not compatible, so they can not be composed

			return null;
	}
}

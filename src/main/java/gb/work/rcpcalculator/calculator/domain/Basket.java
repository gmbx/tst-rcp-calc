package gb.work.rcpcalculator.calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Just a container of bunch of {@link Item}s. It could contain more than 1 occurrence of each {@Item}.
 * 
 * @author giancarlo
 *
 */
public class Basket {

	private Map<Item, Integer> items = new HashMap<Item, Integer>();

	public void add(Item item) {
		Integer itemCount = items.get(item);
		if ( itemCount == null ) {
			items.put(item, 1);
		} else {
			items.put(item, ++itemCount);
		}
	}

	public Set<Item> getItems() {
		return items.keySet();
	}

	public Integer getItemCount(Item item) {
		return items.get(item);
	}
}

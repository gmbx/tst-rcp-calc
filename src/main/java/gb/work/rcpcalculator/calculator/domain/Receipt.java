package gb.work.rcpcalculator.calculator.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Receipt {

	private Map<Item, ReceiptEntry> entries = new HashMap<Item, ReceiptEntry>();
	private BigDecimal totalAmount = BigDecimal.ZERO;
	private BigDecimal salesTotalTaxes = BigDecimal.ZERO;
	
	
	/**
	 * It returns the total number of entries in this receipt.
	 * Please note that isn't the total number of items, as each entry could refer to more than 1 item of the same type.
	 * 
	 * @return
	 */
	public int getEntriesCount() {
		return entries.size();
	}

	/**
	 * It returns the {@link ReceiptEntry} on the specified {@link Item}, if exists.
	 * @param item
	 * @return
	 */
	public ReceiptEntry getEntryOn(Item item) {
		return entries.get(item);
	}
	
	public Collection<ReceiptEntry> getEntryList() {
		return entries.values();
	}

	public BigDecimal getSalesTotalTaxes() {
		return this.salesTotalTaxes;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void addEntry(ReceiptEntry receiptEntry) {
		this.entries.put(receiptEntry.getItem(), receiptEntry);
		this.totalAmount = totalAmount.add(receiptEntry.getShelfPrice());
		this.salesTotalTaxes = salesTotalTaxes.add(receiptEntry.getTaxes());
	}

}

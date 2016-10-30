package gb.work.rcpcalculator.calculator.domain;

import java.math.BigDecimal;

public class ReceiptEntry {

	private Item item;
	private int itemCount; // you could do it in case if you want to optimize
	private BigDecimal shelfPrice;
	private BigDecimal taxes;

	
	public ReceiptEntry(Item item, int itemCount, BigDecimal shelfPrice, BigDecimal totalTaxes) {
		super();
		this.item = item;
		this.itemCount = itemCount;
		this.shelfPrice = shelfPrice;
		this.taxes = totalTaxes;
	}


	public Item getItem() {
		return item;
	}


	public BigDecimal getShelfPrice() {
		return shelfPrice;
	}


	public BigDecimal getTaxes() {
		return taxes;
	}


	public int getItemCount() {
		return itemCount;
	}


}

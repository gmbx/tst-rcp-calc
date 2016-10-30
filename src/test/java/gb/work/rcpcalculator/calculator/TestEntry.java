package gb.work.rcpcalculator.calculator;

import java.math.BigDecimal;

import gb.work.rcpcalculator.calculator.domain.Item;

public class TestEntry {

	public Item item;
	public BigDecimal expectedShelfPrice;

	
	public TestEntry(Item item, BigDecimal expectedShelfPrice) {
		super();
		this.item = item;
		this.expectedShelfPrice = expectedShelfPrice;
	}
	
}

package gb.work.rcpcalculator.calculator.tax;

import java.math.BigDecimal;

import gb.work.rcpcalculator.calculator.domain.Item;


public interface TaxLawI {

	/**
	 * It calculates the tax amount to be paid on an item (see {@link Item}).
	 * 
	 * @param item
	 * @return
	 */
	BigDecimal calculateTaxAmount(Item item); 
	
}

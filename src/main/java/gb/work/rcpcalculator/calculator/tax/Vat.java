package gb.work.rcpcalculator.calculator.tax;

import java.math.BigDecimal;

import gb.work.rcpcalculator.calculator.domain.Item;


public class Vat implements TaxLawI {


	private static final BigDecimal DEFAULT_VAT = new BigDecimal("0.1");


	public BigDecimal calculateTaxAmount(Item item) {
		return TaxUtils.roundTaxAmount( item.getGrossPrice().multiply(getTaxRate(item)) );
	}


	private BigDecimal getTaxRate(Item item) {
		switch (item.getCategory() ) {
			case BOOK: ;
			case FOOD: ;
			case MEDICAL :
				return BigDecimal.ZERO;
			default : 
				return DEFAULT_VAT;
		}
	}

}

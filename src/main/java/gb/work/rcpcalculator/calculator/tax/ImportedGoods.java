package gb.work.rcpcalculator.calculator.tax;

import java.math.BigDecimal;

import gb.work.rcpcalculator.calculator.domain.Item;

public class ImportedGoods implements TaxLawI {


	private static final BigDecimal TAX_RATE = new BigDecimal("0.05");

	public BigDecimal calculateTaxAmount(Item item) {
		if ( item == null ) {
			return BigDecimal.ZERO;
		}
		if ( item.isImported() ) {
			return TaxUtils.roundTaxAmount(item.getGrossPrice().multiply(TAX_RATE));
		}

		return BigDecimal.ZERO;
	}

}

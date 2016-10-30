package gb.work.rcpcalculator.calculator.tax;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

abstract class TaxUtils {

	private static final MathContext DEFAULT_ROUND_LOGIC = new MathContext(2, RoundingMode.CEILING);
	private static final BigDecimal UNIT = new BigDecimal("0.05");


	private TaxUtils() {}
	
	/**
	 * Apply the rounding logic on a tax amount, logic defined by the current laws.
	 *  
	 * @param taxToRound
	 * @return
	 */
	public static BigDecimal roundTaxAmount(BigDecimal taxToRound) {
		return taxToRound.divide(UNIT, DEFAULT_ROUND_LOGIC).multiply(UNIT);
	}
	
	
}

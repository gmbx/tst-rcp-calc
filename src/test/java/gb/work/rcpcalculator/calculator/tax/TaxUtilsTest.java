package gb.work.rcpcalculator.calculator.tax;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

public class TaxUtilsTest {

	@Test
	public void test1() {
		Assert.assertEquals(new BigDecimal("14.5"), TaxUtils.roundTaxAmount(new BigDecimal("14.49")));
		Assert.assertEquals(new BigDecimal("14.5"), TaxUtils.roundTaxAmount(new BigDecimal("14.46")));
		Assert.assertNotSame(new BigDecimal("14.5"), TaxUtils.roundTaxAmount(new BigDecimal("14.51")));
		Assert.assertEquals(new BigDecimal("14.5"), TaxUtils.roundTaxAmount(new BigDecimal("14.5")));
	}
	
}

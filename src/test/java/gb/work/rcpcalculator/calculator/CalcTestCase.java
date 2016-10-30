package gb.work.rcpcalculator.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalcTestCase {

	public List<TestEntry> testEntries = new ArrayList<TestEntry>();
	public BigDecimal expectedSalesTaxes;
	public BigDecimal expectedTotal;
	
	public void add(TestEntry testEntry) {
		testEntries.add(testEntry);
	}

}

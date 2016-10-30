package gb.work.rcpcalculator.calculator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import gb.work.rcpcalculator.calculator.domain.Basket;
import gb.work.rcpcalculator.calculator.domain.GoodCategory;
import gb.work.rcpcalculator.calculator.domain.Item;
import gb.work.rcpcalculator.calculator.domain.Receipt;
import gb.work.rcpcalculator.calculator.domain.ReceiptEntry;


public class CalculatorTest {

	@Test
	public void calcTest() {
		// Making our test case ==========================
		CalcTestCase testCase = new CalcTestCase();
		testCase.add(new TestEntry(new Item("book", new BigDecimal("12.49"), GoodCategory.BOOK ), new BigDecimal(12.49)));
		testCase.add(new TestEntry(new Item("music CD", new BigDecimal("14.99"), GoodCategory.MUSIC ), new BigDecimal(16.49)));
		testCase.add(new TestEntry(new Item("chocolate bar", new BigDecimal("0.85"), GoodCategory.FOOD ), new BigDecimal(0.85)));
		testCase.expectedSalesTaxes = new BigDecimal("1.50");
		testCase.expectedTotal = new BigDecimal("29.83");
		
		testCalculationOnSingleTestCase(testCase);
		
		// Making our test case ==========================
		testCase = new CalcTestCase();
		testCase.add(new TestEntry(new Item("imported box of chocolates", new BigDecimal("10"), GoodCategory.FOOD, true ), new BigDecimal(12.49)));
		testCase.add(new TestEntry(new Item("imported bottle of perfume", new BigDecimal("47.5"), GoodCategory.GENERIC, true ), new BigDecimal(16.49)));
		testCase.expectedSalesTaxes = new BigDecimal("7.65");
		testCase.expectedTotal = new BigDecimal("65.15");
		
		testCalculationOnSingleTestCase(testCase);

		// Making our test case ==========================
		testCase = new CalcTestCase();
		testCase.add(new TestEntry(new Item("imported bottle of perfume", new BigDecimal("27.99"), GoodCategory.GENERIC, true ), new BigDecimal(16.49)));
		testCase.add(new TestEntry(new Item("bottle of perfume", new BigDecimal("18.99"), GoodCategory.GENERIC ), new BigDecimal(12.49)));
		testCase.add(new TestEntry(new Item("packet of headache pills", new BigDecimal("9.75"), GoodCategory.MEDICAL ), new BigDecimal(12.49)));
		testCase.add(new TestEntry(new Item("imported box of chocolates", new BigDecimal("11.25"), GoodCategory.FOOD, true ), new BigDecimal(12.49)));
		testCase.expectedSalesTaxes = new BigDecimal("6.70");
		testCase.expectedTotal = new BigDecimal("74.68");
		
		testCalculationOnSingleTestCase(testCase);

		// Making our test case : Doubling an entry from previous test case ==========================
		testCase = new CalcTestCase();
		testCase.add(new TestEntry(new Item("imported bottle of perfume", new BigDecimal("27.99"), GoodCategory.GENERIC, true ), new BigDecimal(16.49)));
		testCase.add(new TestEntry(new Item("imported bottle of perfume", new BigDecimal("27.99"), GoodCategory.GENERIC, true ), new BigDecimal(16.49)));
		testCase.add(new TestEntry(new Item("bottle of perfume", new BigDecimal("18.99"), GoodCategory.GENERIC ), new BigDecimal(12.49)));
		testCase.add(new TestEntry(new Item("packet of headache pills", new BigDecimal("9.75"), GoodCategory.MEDICAL ), new BigDecimal(12.49)));
		testCase.add(new TestEntry(new Item("imported box of chocolates", new BigDecimal("11.25"), GoodCategory.FOOD, true ), new BigDecimal(12.49)));
		testCase.expectedSalesTaxes = new BigDecimal("10.90");
		testCase.expectedTotal = new BigDecimal("106.87");
		
		testCalculationOnSingleTestCase(testCase);

	}

	private void testCalculationOnSingleTestCase(CalcTestCase testCase1) {
		Printer printer = new Printer();

		// Initializing our input by our test case ==========================
		Basket basket = new Basket();
		for (TestEntry testEntry : testCase1.testEntries) {
			basket.add(testEntry.item);
		}
		
		
		// Actually doing our calculation =============================
		ReceiptCalculator calc = new ReceiptCalculator();
		Receipt receipt = calc.produceRecept(basket);
		
		
		// Let's check the output =====================================
		Assert.assertEquals("Wrong number of entries in the receipt", basket.getItems().size(), receipt.getEntriesCount());

		for (TestEntry testCase : testCase1.testEntries) {
			Item currentItem = testCase.item;
			ReceiptEntry rcpEntry = receipt.getEntryOn(currentItem);
			Assert.assertNotNull("Not found a receipt's entry for an item of the basket " + currentItem.getName(), rcpEntry);
			
		}
		Assert.assertEquals("Wrong total taxes", testCase1.expectedSalesTaxes, receipt.getSalesTotalTaxes());
		Assert.assertEquals("Wrong total amount", testCase1.expectedTotal, receipt.getTotalAmount());

		System.out.println(printer.print(receipt));
	}

}

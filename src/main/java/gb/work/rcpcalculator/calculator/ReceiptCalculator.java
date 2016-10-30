package gb.work.rcpcalculator.calculator;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import gb.work.rcpcalculator.calculator.domain.Basket;
import gb.work.rcpcalculator.calculator.domain.Item;
import gb.work.rcpcalculator.calculator.domain.Receipt;
import gb.work.rcpcalculator.calculator.domain.ReceiptEntry;
import gb.work.rcpcalculator.calculator.tax.ImportedGoods;
import gb.work.rcpcalculator.calculator.tax.TaxLawI;
import gb.work.rcpcalculator.calculator.tax.Vat;

public class ReceiptCalculator {

	private Set<TaxLawI> taxRules = new HashSet<TaxLawI>();

	
	
	
	public ReceiptCalculator() {
		this.init();
	}

	private void init() {
		this.taxRules.add(new Vat());
		this.taxRules.add(new ImportedGoods());
	}


	public Receipt produceRecept(Basket basket) {
		Receipt receipt = new Receipt();
		for (Item item : basket.getItems()) {
			BigDecimal taxes = BigDecimal.ZERO;
			for (TaxLawI taxRule : taxRules) {
				taxes = taxes.add(taxRule.calculateTaxAmount(item));
			}
			BigDecimal shelfPrice = item.getGrossPrice().add(taxes);
			BigDecimal itemCount = new BigDecimal(basket.getItemCount(item));
			receipt.addEntry(new ReceiptEntry(item, itemCount.intValue(), shelfPrice.multiply(itemCount), taxes.multiply(itemCount)) );	
		}
		
		return receipt ;
	}

}

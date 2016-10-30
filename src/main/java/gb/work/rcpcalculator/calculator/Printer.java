package gb.work.rcpcalculator.calculator;

import gb.work.rcpcalculator.calculator.domain.Receipt;
import gb.work.rcpcalculator.calculator.domain.ReceiptEntry;

public class Printer {
	
	
	/**
	 * It returns a String representing the content of a {@link Receipt}. This class is currently encapsulating the layout logic.
	 * 
	 * @param receipt
	 * @return
	 */
	public String print(Receipt receipt) {
		StringBuilder txt = new StringBuilder();
		for (ReceiptEntry rcpEntry : receipt.getEntryList()) {
			txt.append("\n");
			txt.append(rcpEntry.getItemCount()).append(" ");
			txt.append(rcpEntry.getItem().getName()).append(" : ");
			txt.append(rcpEntry.getShelfPrice());
		}
		txt.append("\nSales Taxes : ").append(receipt.getSalesTotalTaxes());
		txt.append("\nTotal : ").append(receipt.getTotalAmount());
		return txt.toString();
	}

}

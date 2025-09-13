package edu.westga.cs1302.bill.view;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillCalculator;

import java.util.ArrayList;

/** Supports displaying the information contained in a Bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillView {

    /** Return a String containing the list of bill items and total for the bill.
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param bill the bill to be viewed
     * @return a String containing the list of bill items and total for the bill
     */
	public static String getText(Bill bill) {
	    BillItem[] items = bill.getItems().toArray(new BillItem[0]);

	    StringBuilder text = new StringBuilder("ITEMS" + System.lineSeparator());
	    for (BillItem item : items) {
	        if (item != null) {
	            text.append(item.getName())
	                .append(" - ")
	                .append(item.getAmount())
	                .append(System.lineSeparator());
	        }
	    }

	    double subtotal = BillCalculator.calculateSubtotal(items);
	    double tax = BillCalculator.calculateTax(items, Bill.TAX_RATE);
	    double tip = BillCalculator.calculateTip(items, Bill.TIP_RATE);
	    double total = BillCalculator.calculateTotal(items, Bill.TAX_RATE, Bill.TIP_RATE);

	    text.append(System.lineSeparator())
	        .append("SUBTOTAL - $").append(subtotal).append(System.lineSeparator())
	        .append("TAX - $").append(tax).append(System.lineSeparator())
	        .append("TIP - $").append(tip).append(System.lineSeparator())
	        .append("TOTAL - $").append(total);

	    return text.toString();
	}
}

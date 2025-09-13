package edu.westga.cs1302.bill.model;
/** 
 * gives static method to calculate bill total
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public final class BillCalculator {
	private BillCalculator() {
}
	/**
	 * Calculates the total of items
	 * 
	 * @param items the array of BillItem objects
	 * @return the subtotal
	 */
	public static double calculateTotal(BillItem[] items) {
		double total = 0.0;
		for (BillItem item : items) {
			if (item != null) {
				total += item.getAmount();
			}
		}
		return total;
	}
	/**
	 * calculates the tax amount
	 * 
	 * @param items the array of BillItem objects
	 * @param taxRate the tax rate
	 * @return the tax
	 */
	public static double calculateTax(BillItem[] items, double taxRate) {
		return calculateTotal(items) * taxRate;
	}
	

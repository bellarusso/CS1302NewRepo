package edu.westga.cs1302.bill.model;

/**
 * Provides static methods to calculate bill totals.
 *
 * @author CS 1302
 * @version Fall 2025
 */
public final class BillCalculator {

  private BillCalculator() {
  }

  /**
     * Calculates the subtotal of all items.
     *
     * @param items the array of BillItem objects (may contain nulls)
     * @return the subtotal
     */
  public static double calculateSubtotal(BillItem[] items) {
    double subtotal = 0.0;
    for (BillItem item : items) {
      if (item != null) {
        subtotal += item.getAmount();
      }
    }
    return subtotal;
  }

  /**
     * Calculates the tax amount.
     *
     * @param items the array of BillItem objects
     * @param taxRate the tax rate (e.g., 0.07 for 7%)
     * @return the tax
     */
  public static double calculateTax(BillItem[] items, double taxRate) {
    return calculateSubtotal(items) * taxRate;
  }

  /**
     * Calculates the tip amount.
     *
     * @param items the array of BillItem objects
     * @param tipRate the tip rate (e.g., 0.15 for 15%)
     * @return the tip
     */
  public static double calculateTip(BillItem[] items, double tipRate) {
    return calculateSubtotal(items) * tipRate;
  }

  /**
     * Calculates the total bill.
     *
     * @param items the array of BillItem objects
     * @param taxRate the tax rate
     * @param tipRate the tip rate
     * @return the total
     */
  public static double calculateTotal(BillItem[] items, double taxRate, double tipRate) {
    double subtotal = calculateSubtotal(items);
    double tax = subtotal * taxRate;
    double tip = subtotal * tipRate;
    return subtotal + tax + tip;
  }
}

/**
* <h1>Sales Worker Abstract Class</h1>
* Contains abstract methods that can be overriden 
* by the child classes
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a sales employee or supervisior */
public abstract class SalesWorker extends Worker{
  
  /** salary of the sales worker */
  private double salary;
  
  /** commission of the sales worker */
  private double commission;
  
  /** number of sales by the sales worker */
  private int numSales;
  
  /** creates a sales worker with the given specifications
    * @param firstName the worker's first name
    * @param lastName the worker's last name
    * @param number the worker's number
    * @param salary the worker's salary
    * @param commission the worker's commission
    */
  public SalesWorker(String firstName, String lastName, String number, double salary, double commission) {
    super(firstName, lastName, number);
    this.salary = salary;
    this.commission = commission;
  }
  
  /**
   * Returns the sales worker's salary
   * @return the sales worker's salary
   */
  public double getSalary() {
    return salary;
  }
  
  /** 
   * Sets the salary of the sales worker
   * @param salary the new salary
   */
  public void setSalary(double salary) {
    this.salary = salary;
  }
  
   /** 
   * Returns the commission of the sales worker
   * @return commission of the sales worker
   */
  public double getCommission() {
    return commission;
  }
  
  /** 
   * Sets the commission of the sales worker
   * @param rate the new commission
   */
  public void setCommission(double commission) {
    this.commission = commission;
  }
  
   /** 
   * Returns the number of sales by the sales worker
   * @return the number of sales by sales worker
   */
  public int getNumSales() {
    return numSales;
  }
  
  /** 
   * Sets the number of sales by the sales worker
   * @param numSales the new number of sales
   */
  public void setNumSales(int numSales) {
    this.numSales = numSales;
  }
  
  /**
   * Returns the amount earned by the sales worker
   * @return the amount earned by the sales worker
   */
  @Override
  public double getAmountEarned() {
    return (getSalary() + (getCommission() * getNumSales()) + getBonus());
  }
  
  /**
   * Changes the sales worker's salary based on the percentage
   * @param percentage the change in the sales worker's commission
   */
  @Override
  public void adjustPay(double percentage) {
    this.setCommission((((percentage / 100.0) * getCommission()) + getCommission()));
  }
  
  /** 
   * Overrides and returns a string representation
   * @return string representation of the sales worker
   */ 
 public abstract String toString();
}
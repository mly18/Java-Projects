/**
* <h1>Salary Worker Abstract Class</h1>
* Contains abstract methods that can be overriden 
* by the child classes
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a salary employee or supervisior */
public abstract class SalaryWorker extends Worker{
  
  /** commission of the worker */
  private double commission;
  
  /** number of sales by the worker */
  private int numSales;
  
  /** salary of the worker */
  private double salary;
  
  /** creates a sales employee with the given specifications
    * @param firstName the employee's first name
    * @param lastName the employee's last name
    * @param number the employee's number
    * @param salary the employee's salary
    * @param commission the employee's commission
    */
  public SalaryWorker(String firstName, String lastName, String number, double salary, double commission) {
    super(firstName, lastName, number);
    this.salary = salary;
    this.commission = commission;
  }
  
  /** 
   * Returns the commission of the worker
   * @return the commission of the worker
   */
  public double getCommission() {
    return commission;
  }
  
  /**
   * Sets the commission of the worker
   * @param commission the commission of the worker
   */
  public void setCommission(double commission) {
    this.commission = commission;
  }
  
  /**
   * Returns the number of sales by the worker
   * @return the number of sales by the worker
   */
  public int getNumSales() {
    return numSales;
  }
  
  /**
   * Sets the number of sales by the worker
   * @param numSales the number of sales by the worker
   */
  public void setNumSales(int numSales) {
    this.numSales = numSales;
  }
  
  /**
   * Returns the amount earned by the worker
   * @return the amount earned by the worker
   */
  @Override
  public double getAmountEarned() {
    return (getSalary() + (getCommission() * getNumSales()) + getBonus());
  }
  
  /**
   * Changes the percentage of the Sales employee's salary
   * @param percentage the change in the worker's commission
   */
  @Override
  public void adjustPay(double percentage) {
    commission = (((percentage / 100.0) * getCommission()) + getCommission());
  }
  
  /** 
   * Overrides and returns a string representation
   * @return string representation of the hourly worker
   */ 
  public abstract String toString();
}
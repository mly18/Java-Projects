/**
* <h1>Hourly Worker Abstract Class</h1>
* Contains abstract methods that can be overriden 
* by the child classes
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a hourly employee or supervisior */
public abstract class HourlyWorker extends Worker{
  /** hourly rate of the worker */
  private double hourlyRate;
  
  /** hours worked by the worker */
  private double hoursWorked;
  
  public HourlyWorker(String firstName, String lastName, String number, double hourlyRate) {
    super(firstName, lastName, number);
    this.hourlyRate = hourlyRate;
  }
  
  /** 
   * Returns the hourly rate of the worker
   * @return the hourly rate of the worker
   */
  public double getHourlyRate() {
    return hourlyRate;
  }
  
  /** 
   * Sets the hourly rate of the worker
   * @param rate the new hourly rate
   */
  public void setHourlyRate(double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }
  
  /** 
   * Returns the hours worked by the worker
   * @return the hours worked by the worker
   */
  public double getHoursWorked() {
    return hoursWorked;
  }
  
  /** 
   * Sets the hours worked by the worker
   * @param hoursWorked the new hours worked
   */
  public void setHoursWorked(double hoursWorked) {
    this.hoursWorked = hoursWorked;
  }
  
  /**
   * Returns the amount earned by the worker
   * @return the amount earned by the worker
   */
  @Override
  public double getAmountEarned() {
    return (getHoursWorked() * getHourlyRate()) + getBonus();
  }
    
  /**
   * Changes the worker's salary by the percentage
   * @param percentage the percentage change in the worker's hourly rate
   */
  @Override
  public void adjustPay(double percentage) {
    this.setHourlyRate(((percentage / 100.0) * getHourlyRate()) + getHourlyRate());
  }
  
  /** 
   * Overrides and returns a string representation
   * @return string representation of the hourly worker
   */ 
  public abstract String toString();
}
/**
* <h1>Salaried Worker Abstract Class</h1>
* Contains abstract methods that can be overriden 
* by the child classes
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a salaried employee or supervisior */
public abstract class SalariedWorker extends Worker{

  /** salary of the salaried worker */
  private double salary;
  
  /** creates a salaried worker with the given specifications
    * @param firstName the salaried worker's first name
    * @param lastName the salaried worker's last name
    * @param number the salaried worker's number
    * @param salary the salaried worker's salary
    */
  public SalariedWorker(String firstName, String lastName, String number, double salary) {
    super(firstName, lastName, number);
    this.salary = salary;
  }
  
  /**
   * Returns the salaried worker's salary
   * @return the salaried worker's salary
   */
  public double getSalary() {
    return salary;
  }
  
  /** 
   * Sets the salary of the salaried worker
   * @param salary the new salary
   */
  public void setSalary(double salary) {
    this.salary = salary;
  }
  
  /**
    * Returns the amount earned by the salaried worker
    * @return the amount earned by the salaried worker
    */
  @Override
  public double getAmountEarned() {
    return getSalary() + getBonus();
  }
  
  /**
   * Changes the salaried worker's salary by the percentage
   * @param percentage the percentage change in the salaried worker's salary
   */
  @Override
  public void adjustPay(double percentage) {
    this.setSalary(((percentage / 100.0) * getSalary()) + getSalary());
  }
  
  /** 
   * Overrides and returns a string representation
   * @return string representation of the salaried worker
   */ 
  public abstract String toString();
}
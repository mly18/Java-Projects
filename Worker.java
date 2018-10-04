/**
* <h1>Worker Abstract Class</h1>
* Contains abstract methods that can be overriden 
* by the child classes
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a unclassified worker */
public abstract class Worker {
  /** first name of the worker */
  private String firstName;
  
  /** last name of the worker */
  private String lastName;
  
  /** number of the worker */
  private String number;
  
  /** bonus of the worker */
  private double bonus;
  
  /** supervisor of the worker */
  private Worker supervisor;
  
  /** creates a worker with the given specifications
    * @param firstName the worker's first name
    * @param lastName the worker's last name
    * @param number the worker's number
    */
  public Worker(String firstName, String lastName, String number) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.number = number;
  }
  
  /** 
   * Returns the first name of the worker
   * @return the first name of the worker
   */
  public String getFirstName() {
    return firstName;
  }
  
  /** 
   * Returns the last name of the worker
   * @return the last name of the worker
   */
  public String getLastName() {
    return lastName;
  }
  
  /** 
   * Sets the first name of the worker
   * @param firstName the new first name
   * @param lastName the new last name
   */
  public void setName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  /** 
   * Returns the worker's number
   * @return the worker's number
   */
  public String getNumber() {
    return number;
  }
  
  /**
   * Returns the worker's bonus
   * @return the worker's bonus
   */
  public double getBonus() {
    return bonus;
  }
  
  /** 
   * Sets the worker's bonus
   * @param bonus the new bonus
   */
  public void setBonus(double bonus) {
    this.bonus = bonus;
  }
  
  /**
   * Returns the amount earned by the worker
   * @return the amount earned by the worker
   */
  public abstract double getAmountEarned();
  
  /**
   * Changes the worker's salary by the percentage
   * @param percentage change in the worker's salary
   */
  public abstract void adjustPay(double percentage);  
  
  /** 
   * Overrides and returns a string representation
   * @return string representation of the worker
   */ 
 public abstract String toString();
 
 /**
  * Returns a boolean on whether two employees have the same name and number
  * @param worker2 the name and number of the second worker
  */
 public boolean equals(Worker worker2) {
   if (this.getNumber().equals(worker2.getNumber()) == true && 
       this.getFirstName().equals(worker2.getFirstName()) == true && 
       this.getLastName().equals(worker2.getLastName()) == true)
         return true;
       else
         return false;
 }
 
 /**
  * Compares the names of two workers based on alphabetical order
  * @param worker2 the name of the second worker
  */
 public int compareByName (Worker worker2) {
   int firstCompare = this.getFirstName().compareToIgnoreCase(worker2.getFirstName());
   int lastCompare = this.getLastName().compareToIgnoreCase(worker2.getLastName());
   if (lastCompare != 0)
     return lastCompare;
   else
     return firstCompare;
 }
 
 /**
  * Compares the earnings of two workers based on earnings
  * @param worker2 the earnings of the second worker
  */
 public int compareByEarnings (Worker worker2) {
   return (int)this.getAmountEarned() - (int)worker2.getAmountEarned();
 }
 
 /** 
   * Sets a hourly supervisor to the worker
   * @param supervisor the assigned hourly supervisor
   */
  public void setSupervisor(HourlySupervisor supervisor) {
    this.supervisor = supervisor;
  }
  
  /** 
   * Sets a sales supervisor to the worker
   * @param supervisor the assigned sales supervisor
   */
  public void setSupervisor(SalesSupervisor supervisor) {
    this.supervisor = supervisor;
  }
  
  /** 
   * Sets a salaried supervisor to the worker
   * @param supervisor the assigned salaried supervisor
   */
  public void setSupervisor(SalariedSupervisor supervisor) {
    this.supervisor = supervisor;
  }
  
  /** 
   * Returns the supervisor of the worker
   * @return the supervisor of the worker
   */
  public Worker getSupervisor() {
    return supervisor;
  }
}
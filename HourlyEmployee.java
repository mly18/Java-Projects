/**
* <h1>Hourly Employee Class</h1>
* Worker classified as an employee that has  
* a salary based on an hourly rate
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a hourly employee */
public class HourlyEmployee extends HourlyWorker {
  
  /** creates a hourly employee with the given specifications
    * @param firstName the employee's first name
    * @param lastName the employee's last name
    * @param number the employee's number
    * @param hourlyrate the employee's hourly rate
    */
  public HourlyEmployee(String firstName, String lastName, String number, double hourlyRate) {
    super (firstName, lastName, number, hourlyRate);
  }
  
  /** 
    * Overrides and returns a string representation
    * @return string representation of the hourly employee
    */ 
  @Override
  public String toString() {
    return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", Hourly Employee";
  }
}
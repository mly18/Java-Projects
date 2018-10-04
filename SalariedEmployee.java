/**
* <h1>Salaried Employee Class</h1>
* Worker classified as an employee that has  
* a fixed salary
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a salaried employee */
public class SalariedEmployee extends SalariedWorker {
  /** creates a salaried employee with the given specifications
    * @param firstName the employee's first name
    * @param lastName the employee's last name
    * @param number the employee's number
    * @param salary the employee's salary
    */
  public SalariedEmployee(String firstName, String lastName, String number, double salary) {
    super(firstName, lastName, number, salary);
  }
  
  /** 
   * Overrides and returns a string representation
   * @return string representation of the salaried employee
   */ 
  @Override
  public String toString() {
    return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", Salaried Employee";
  }
}
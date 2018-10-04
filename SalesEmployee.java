/**
* <h1>Sales Employee Class</h1>
* Worker classified as an employee that has  
* a salary based on a small salary and commissions
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a sales employee */
public class SalesEmployee extends SalesWorker {
  
  /** creates a sales employee with the given specifications
    * @param firstName the employee's first name
    * @param lastName the employee's last name
    * @param number the employee's number
    * @param salary the employee's salary
    * @param commission the employee's commission
    */
  public SalesEmployee(String firstName, String lastName, String number, double salary, double commission) {
    super(firstName, lastName, number, salary, commission);
  }
  
  /** 
   * Overrides and returns a string representation
   * @return string representation of the sales employee
   */ 
  @Override
  public String toString() {
    return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", Sales Employee";
  }
}
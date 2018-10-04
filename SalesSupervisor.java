/**
* <h1>Sales Supervisor Class</h1>
* Worker classified as an supervisor that has  
* a salary based on a small salary and commissions
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a sales supervisior */
public class SalesSupervisor extends SalesWorker {
  
  /** creates a sales supervisior with the given specifications
    * @param firstName the supervisior's first name
    * @param lastName the supervisior's last name
    * @param number the supervisior's number
    * @param salary the supervisior's salary
    * @param commission the supervisior's commission
    */
  public SalesSupervisor(String firstName, String lastName, String number, double salary, double commission) {
    super(firstName, lastName, number, salary, commission);
  }
  
  /** 
   * Overrides and returns a string representation
   * @return string representation of the sales supervisor
   */ 
  @Override
  public String toString() {
    return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", Sales Supervisor";
  }
}
/**
* <h1>Salaried Supervior Class</h1>
* Worker classified as an supervisor that has  
* a fixed salary
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a salaried supervisor */
public class SalariedSupervisor extends SalariedWorker {
  /** creates a salaried supervisior with the given specifications
    * @param firstName the supervisior's first name
    * @param lastName the supervisior's last name
    * @param number the supervisior's number
    * @param salary the supervisior's salary
    */
  public SalariedSupervisor(String firstName, String lastName, String number, double salary) {
    super(firstName, lastName, number, salary);
  }
  
  /** 
   * Overrides and returns a string representation
   * @return string representation of the salaried supervisor
   */ 
  @Override
  public String toString() {
    return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", Salaried Supervisor";
  }
}
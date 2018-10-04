/**
* <h1>Hourly Supervisor Class</h1>
* Worker classified as an supervisor that has  
* a salary based on an hourly rate
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** Represents a hourly supervisor */
public class HourlySupervisor extends HourlyWorker {
  
  /** creates a hourly supervisor with the given specifications
    * @param firstName the supervisior's first name
    * @param lastName the supervisior's last name
    * @param number the supervisior's number
    * @param hourlyrate the supervisior's hourly rate
    */
  public HourlySupervisor(String firstName, String lastName, String number, double hourlyRate) {
    super (firstName, lastName, number, hourlyRate);
  }
  
  /** 
    * Overrides and returns a string representation
    * @return string representation of the hourly supervisior
    */ 
  @Override
  public String toString() {
    return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", Hourly Supervisor";
  }
}
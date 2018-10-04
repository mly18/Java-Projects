/**
* <h1>Employee Database Class</h1>
* Contains an array that contains the list
* of all the employees and supervisors
* <p>
*
* @author  Matthew Yoon
* @since   2018-03-22
*/

/** represents the employee database */
public class EmployeeDatabase {
  /** maximum number of workers in the database */
  private int maxNum;
  
  /** array that stores the database */
  private Worker[] list;
  
  /** the current number of workers in the database */
  private int currentNum = 0;
  
  /** determines if the same Worker is found in the database **/
  private boolean foundStatus = false;
  
  /** the total payroll amount */
  private double payrollAmount = 0.0;
  
  /** the intial amount earned by the first worker of the database */
  private Double intialEarned = 0.0;
  
  /** the greatest number of sales by a worker in the datavase */
  private int maxSales = 0;
  
  /** the least number of sales by a worker in the database */
  private int minSales = 0;
  
  /** the sales worker with the most amount of sales */
  private SalesWorker maxSalesWorker;
  
  /** the sales worker with the least amount of sales */
  private SalesWorker minSalesWorker;
  
  /** the greatest number of sales by a worker in the database */
  private double maxHours = 0.0;
  
  /** the sales worker with the most amount of sales */
  private HourlyWorker maxHourlyWorker;
  
  /** the greatest number of sales by a worker in the database */
  private double minHours = 0.0;
  
  /** the sales worker with the most amount of sales */
  private HourlyWorker minHourlyWorker;
  
  /** sales worker placeholder */
  private SalesEmployee nullSalesWorker = new SalesEmployee("", "", "", 0.0, 0.0);
  
  /** hourly worker placeholder */
  private HourlyEmployee nullHourlyWorker = new HourlyEmployee("", "", "", 0.0);
  
  /** creates a database with the given specifications
   * @param maxNum the maximum number of workers
   */
  public EmployeeDatabase(int maxNum) {
    this.maxNum = maxNum;
    this.list = new Worker[maxNum];
  }
  
  /** intializes each element in the database with a nullSalesWorker */
  public void intializeSales() {
    for (int i = 0; i < maxNum; i++) {
      list[i] = nullSalesWorker;
    }
  }
  
  /** intializes each element in the database with a nullHourlyWorker */
  public void intializeHourly() {
    for (int i = 0; i < maxNum; i++) {
      list[i] = nullHourlyWorker;
    }
  }
  
  /** 
   * adds a worker to the employee database
   * @param worker1 the worker being added to the database
   */
  public void add(Worker worker1) throws EmployeeDatabaseFull {
    list[currentNum] = worker1;
    if (maxNum == currentNum) 
      throw new EmployeeDatabaseFull();
    currentNum = currentNum + 1;
  }
  
  /** 
   * removes a worker from the employee database
   * @param firstName the worker's first name
   * @param lastName the worker's last name
   * @param number the worker's number 
   */
  public Worker remove(String firstName, String lastName, String number) throws NoSuchEmployee{
    for (int i = 0; i < maxNum; i++) {
      if (list[i].getFirstName().equals(firstName) &&
          list[i].getLastName().equals(lastName) &&
          list[i].getNumber().equals(number)) {
        Worker worker1 = list[i];
        list[i] = nullSalesWorker;
        foundStatus = true;
        return worker1;
      }
    }
    if (foundStatus == true)
      throw new NoSuchEmployee();
      return null;
  }
  
  /** 
   * finds a worker from the employee database
   * @param firstName the worker's first name
   * @param lastName the worker's last name
   * @param number the worker's number 
   */
  public Worker find(String firstName, String lastName, String number) throws NoSuchEmployee{
    for (int i = 0; i < maxNum; i++) {
      if (list[i].getFirstName().equals(firstName) &&
          list[i].getLastName().equals(lastName) &&
          list[i].getNumber().equals(number)) {
        Worker worker1 = list[i];
        return worker1;
      }
    }
    if (foundStatus == true)
      throw new NoSuchEmployee();
      return null;
  }
  
  /** 
   * Returns the total amount earned from the database
   * @return the total amount earned from the database
   */
  public double getPayrollAmount() {
    for (int i = 0; i < maxNum; i++) {
      double intialPayroll = 0.0;
      intialPayroll = list[i].getAmountEarned();
      payrollAmount = intialPayroll + payrollAmount;
    }
    return payrollAmount;
  }
  
  /** 
   * Returns the greatest amount earned from the database
   * @return the greatest amount earned from the database
   */
  public Double getMaximumEarned() {
    double maxEarned = 0.0;
    for (int i = 0; i < maxNum; i++) {
      intialEarned = list[i].getAmountEarned();
      if (intialEarned > maxEarned)
        maxEarned = intialEarned;
    }
    if (intialEarned == null)
      return null;
    else
      return maxEarned;
  }
  
  /** 
   * Returns the smallest amount earned from the database
   * @return the smallest amount earned from the database
   */
  public Double getMinimumEarned() {
    EmployeeDatabase database1 = new EmployeeDatabase(maxNum);
    double minEarned = 0.0;
    double currentEarned = 0.0;
    double currentMinEarned = database1.getMaximumEarned();
    for (int i = 0; i < maxNum; i++) {
      intialEarned = list[i].getAmountEarned();
      if (intialEarned > 0.0 && intialEarned < currentMinEarned) {
        currentMinEarned = intialEarned;
        minEarned = intialEarned;
      }
      else if (intialEarned == 0.0)
        intialEarned = 0.0;
    }
    if (intialEarned == null)
      return null;
    else
      return minEarned;
  }
  
  /** 
   * Returns the worker with the most amount of sales
   * @return the worker with the most amount of sales
   */
  public SalesWorker getMaxSales() throws NoSuchEmployee{
    for (int i = 0; i < maxNum; i++) {
      int currentSales = 0;
      if (list[i] instanceof SalesWorker)
        currentSales = ((SalesWorker)list[i]).getNumSales();
        if (currentSales > maxSales) {
          maxSales = currentSales;
          maxSalesWorker = ((SalesWorker)list[i]);
        }
    }
    if (maxSales == 0)
      throw new NoSuchEmployee();
    return maxSalesWorker;
  }
  
  /** 
   * Returns the worker with the least amount of sales
   * @return the worker with the least amount of sales
   */
  public SalesWorker getMinSales() throws NoSuchEmployee{
    for (int i = 0; i < maxNum; i++) {
      int currentSales = 0;
      if (list[i] instanceof SalesWorker)
        currentSales = ((SalesWorker)list[i]).getNumSales();
        if (currentSales < minSales)
          minSales = currentSales;
          minSalesWorker = ((SalesWorker)list[i]);
    }
    if (minSales == 0)
      throw new NoSuchEmployee();
    return minSalesWorker;
  }
  
  /** 
   * Returns the worker with the most amount of hours
   * @return the worker with the most amount of hours
   */
  public HourlyWorker getMaxHoursWorked() throws NoSuchEmployee{
    for (int i = 0; i < maxNum; i++) {
      double currentHours = 0;
      if (list[i] instanceof HourlyWorker)
        currentHours = ((HourlyWorker)list[i]).getHoursWorked();
        if (currentHours > maxHours) {
          maxHours = currentHours;
          maxHourlyWorker = ((HourlyWorker)list[i]);
        }
    }
    if (maxHours == 0.0)
      throw new NoSuchEmployee();
    return maxHourlyWorker;
  }
  
  /** 
   * Returns the worker with the least amount of hours
   * @return the worker with the least amount of hours
   */
  public HourlyWorker getMinHoursWorked() throws NoSuchEmployee{
    for (int i = 0; i < maxNum; i++) {
      double currentHours = 0;
      if (list[i] instanceof HourlyWorker)
        currentHours = ((HourlyWorker)list[i]).getHoursWorked();
        if (currentHours > minHours)
          minHours = currentHours;
          minHourlyWorker = ((HourlyWorker)list[i]);
    }
    if (minHours == 0.0)
      throw new NoSuchEmployee();
    return minHourlyWorker;
  }
  
  /** 
   * Returns the employees and supervisors that the supervisor supervises
   * @param supervisor1 the supervisor that is supervising the workers
   * @return the workers that the supervisor supervises
   */
  public Worker[] getSupervises(HourlySupervisor supervisor1) {
    int numSupervises = 0;
    for (int i = 0; i < maxNum; i++) {
      if (list[i].getSupervisor() == supervisor1)
        numSupervises = numSupervises + 1;
    }
    Worker[] supervisesList = new Worker[numSupervises];
    for (int i = 0; i < maxNum; i++) {
      if (list[i].getSupervisor() == supervisor1)
        supervisesList[i] = list[i];
    }
    return supervisesList;
  }
  
  /** 
   * Returns the employees and supervisors that the supervisor supervises
   * @param supervisor1 the supervisor that is supervising the workers
   * @return the workers that the supervisor supervises
   */
  public Worker[] getSupervises(SalariedSupervisor supervisor1) {
    int numSupervises = 0;
    for (int i = 0; i < maxNum; i++) {
      if (list[i].getSupervisor() == supervisor1)
        numSupervises = numSupervises + 1;
    }
    Worker[] supervisesList = new Worker[numSupervises];
    for (int i = 0; i < maxNum; i++) {
      if (list[i].getSupervisor() == supervisor1)
        supervisesList[i] = list[i];
    }
    return supervisesList;
  }
  
  /** 
   * Returns the employees and supervisors that the supervisor supervises
   * @param supervisor1 the supervisor that is supervising the workers
   * @return the workers that the supervisor supervises
   */
  public Worker[] getSupervises(SalesSupervisor supervisor1) {
    int numSupervises = 0;
    for (int i = 0; i < maxNum; i++) {
      if (list[i].getSupervisor() == supervisor1)
        numSupervises = numSupervises + 1;
    }
    Worker[] supervisesList = new Worker[numSupervises];
    for (int i = 0; i < maxNum; i++) {
      if (list[i].getSupervisor() == supervisor1)
        supervisesList[i] = list[i];
    }
    return supervisesList;
  }
}
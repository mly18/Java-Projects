/* Matthew Yoon
 * Programming Project 1
 * Purpose: Allows a buisness to create, award, and pay contracts
 */

/* Bid Class
 * Contains: contract, contractor, value 
 */

public class Bid {
  
  /* input for the contract */
  private Contract contract;
  
  /* input for the contractor */
  private Contractor contractor;
  
  /* number of the value*/
  private double value;
  
  /* constructor for the bid class that requires the contract, contractor, and value */
  public Bid (Contract contract, Contractor contractor, double value) {
    this.contract = contract;
    this.contractor = contractor;
    this.value = value;
  }
  
  /* retrives the contract */
  public Contract getContract () {
    return this.contract;
  }
  
  /* retrives the contractor */
  public Contractor getContractor () {
    return this.contractor;
  }
  
  /* retrives the value */
  public double getValue () {
    return this.value;
  }
}
/* Matthew Yoon
 * Programming Project 1
 * Purpose: Allows a buisness to create, award, and pay contracts
 */

/* Contract Class
 * Contains: identifying number, minimum value, maximum value, deadline, possible bonus, possible penalty,
 * indicator whether they are accepting bids, best bid, indicator of whether the contract has been completed 
 */

public class Contract {
  
  /* retrives the ID */
  private String ID;
  
  /* value of the minimum value */
  private double minvalue;
  
  /* value of the maximum value */
  private double maxvalue;
  
  /* value of the bonus */
  private double bonus;
  
  /* value of the penalty */
  private double penalty;
  
  /* date of the deadline */
  private Date deadline;
  
  /* status if contractor is accepting bids (true) or not (false) */
  private boolean bidstatus = true;
  
  /* status if contract is completed or not */
  private boolean status = false;
  
  /* date that the contract is completed */
  private Date datecomplete;
  
  /* current value of a new bid */
  private Bid newbid;
  
  /* value of the current best bid */
  private Bid bestbid;

  /* constructor that requires a ID, minimum value, maximum value, bonus, penalty, and deadline */
  public Contract (String ID, double minvalue, double maxvalue, double bonus, double penalty, Date deadline) {
    this.ID = ID;
    this.minvalue = minvalue;
    this.maxvalue = maxvalue;
    this.bonus = bonus;
    this.penalty = penalty;
    this.deadline = deadline;
  }
  
  /* retrives the value of the ID */
  public String getID() {
    return this.ID;
  }
  
  /* retrives the minimum value */
  public double getMinValue() {
    return this.minvalue;
  }
  
  /* sets the minimum value */
  public void setMinValue(double minvalue) {
    this.minvalue = minvalue;
  }
  
  /* retrives the maximum value */
  public double getMaxValue() {
    return this.maxvalue;
  }
  
  /* sets the maximum value */
  public void setMaxValue(double maxvalue) {
    this.maxvalue = maxvalue;
  }
  
  /* retrives the bonus value */
  public double getBonus() {
    return this.bonus;
  }
  
  /* sets the bonus value */
  public void setBonus(double bonus) {
    this.bonus = bonus;
  }
  
  /* retrives the penalty value */
  public double getPenalty() {
    return this.penalty;
  }
  
  /* sets the penalty value */
  public void setPenalty(double penalty) {
    this.penalty = penalty;
  }
  
  /* retrives the date of the deadline */
  public Date getDeadline() {
    return this.deadline;
  }
  
  /* sets the date of the deadline */
  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }
  
  /* overrides the inherited equals method and allows it to return a boolean value whether the ID of a contract equals the inputed contract */
  public boolean equals(Contract contract2) {
    return this.getID().equals(contract2.getID());
  }
  
  /* retrives if whether the the contractor is accepting bids (true) or not (false) */
  public boolean isAcceptingBids() {
    return bidstatus;
  }
  
  /* returns the best bid taken or null if no bid has been taken */
  public Bid getBestBid() {
    return bestbid;
  }
  
  /* returns the new bid that has just been made */
  public Bid getNewBid() {
    return newbid;
  }
  
  /* retrives the bid status of whether the contract is accepting bids or not */
  public boolean getBidStatus() {
    return bidstatus;
  }
  
  /* retrives the status of the contract if it is complete or not */
  public boolean getStatus() {
    return status;
  }
  
  /* takes a bid and returns true or false whether it accepts the bid based on requirements 
   * requirements: accepting bids, bid is greater than minimum value, bid is less than maximum value, bid is greater than previous bid */
  public boolean makeBid(Bid newbid) {
    this.bestbid = newbid;
    if (bidstatus == true && this.equals(newbid.getContract()) && newbid.getValue() >= minvalue && newbid.getValue() <= maxvalue && newbid.getValue() <= bestbid.getValue()) {
      this.bestbid = newbid;
      return true;
    }
    else
      return false;
  }
  
  /* contract is no longer accepting bids, highest bid has been taken */
  public void awardContract() {
    bidstatus = false;
  }
  
  /* returns true if the contract has accepted a bid or false if it hasn't */
  public boolean isComplete() {
    return status;
  }
  
  /*returns the date the contract was completed */
  public Date completeDate() {
    if (status = true)
      return datecomplete;
    else
      return null;
  }
  
  /* sets the complete date of the contract and pays the contractor the bid amount plus or minus and bonus or penalty */
  public void setComplete(Date datecomplete) {
    double payment; // stores the pament amount after the bonus and penalty that must be paid to the contractor
    status = true;
    this.datecomplete = datecomplete; 
    if (Date.difference(deadline, datecomplete) > 0)
      payment = bestbid.getValue() + (bonus * Date.difference(deadline, datecomplete));
    else
      payment = bestbid.getValue() + (penalty * Date.difference(deadline, datecomplete));
    if (payment > maxvalue)
      payment = maxvalue;
    else if (payment < 0)
      payment = 0;
    bestbid.getContractor().pay(payment);
  }
}
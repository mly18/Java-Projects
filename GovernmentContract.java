/* Matthew Yoon
 * Programming Project 1
 * Purpose: Allows a buisness to create, award, and pay contracts
 */

/* GovernmentContract Class
 * Contains: contract, contractor, value 
 */

/* a class that extends the contract class and has the methods and behaviours of the contract class */
public class GovernmentContract extends Contract {
  
  /* constructor that requires a ID, minimum value, maximum value, bonus, penalty, and deadline */
  public GovernmentContract (String ID, double minvalue, double maxvalue, double bonus, double penalty, Date deadline) {
    super (ID, minvalue, maxvalue, bonus, penalty, deadline);
  }
  
  /* overrides the makeBid method to add a requirement of the contractor being a government contractor */
  @Override
  public boolean makeBid(Bid newbid) {
    newbid = this.getBestBid();
    if (this.getBidStatus() == true && this.equals(newbid.getContract()) && newbid.getValue() >= this.getMinValue() && newbid.getValue() <= this.getMaxValue() && newbid.getValue() <= getBestBid().getValue() && this instanceof GovernmentContract)
      return true;
    else
      return false;
  }
}
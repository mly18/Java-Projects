/* Matthew Yoon
 * Programming Project 1
 * Purpose: Allows a buisness to create, award, and pay contracts
 */

/* Government Contractor Class
 * Contains: All the methods and behaviors of the contractor class with an updated toString method
 */

/* class that extends contractor class, parent type, and has the methods and behaviors of the contractor class */
public class GovernmentContractor extends Contractor {
  
  /* constructor for government contractor which extends contractor class */
  public GovernmentContractor (String name, String address, String contact){
    super(name, address, contact);
  }
  
  /* overrides the toString method to add the government contractor addition */
  @Override
  public String toString () {
    return getName() + ": " + getAddress() + ": " + "approved government contractor";
  }
}
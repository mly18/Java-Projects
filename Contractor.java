/* Matthew Yoon
 * Programming Project 1
 * Purpose: Allows a buisness to create, award, and pay contracts

/* Contractor Class
 * Contains: Name, Address, Contact Person and a Balance
 */

public class Contractor {
  
  /* name of the contractor */
  private String name;
  
  /* name of the address of the contractor */
  private String address;
  
  /* name of the contact person for the contractor */
  private String contact;
  
  /* amount the contractor is paid */
  private double paid = 0.0;
    
  /* amount the contractor needs to be paid */
  private double pay = 0.0;
  
  /* A constructor for the contractor that requires the name, address, and contact of the employee */
  public Contractor (String name, String address, String contact){
    this.name = name;
    this.address = address;
    this.contact = contact;
  }
  
  /* retrives the name of the contractor */
  public String getName() {
    return this.name;
  }
  
  /* sets the name of the contractor */
  public void setName(String name) {
    this.name = name;
  }
  
  /* gets the address of the contractor */
  public String getAddress() {
    return this.address;
  }
  
  /* sets the address of the contractor */
  public void setAddress(String address) {
    this.address = address;
  }
  
  /* gets the name of the contact for the contractor */
  public String getContact() {
    return this.contact;
  }
  
  /* sets the name of the contact for the contractor */
  public void setContact(String contact) {
    this.contact = contact;
  }
  
  /* returns the total amount that has been paid to the contractor */
  public Double getPaid() {
    return this.paid;
  }
  
  /* inputs amount to pay to the contractor */
  public void pay(double pay) {
    this.pay = pay;
    paid = paid + pay;
  }
  
  /* overrides toString method from object to return name: address */
  @Override
  public String toString() {
    return getName() + ": " + getAddress();
  }
}
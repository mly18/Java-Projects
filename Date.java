/* Matthew Yoon
 * Programming Project 1
 * Purpose: Allows a buisness to create, award, and pay contracts
 */

/* Date Class
 * Contains: Day, Month, Year 
 */

public class Date {
  
  /* number of the day */
  private int day;
  
  /* number of the month */
  private int month;
  
  /*number of the year */
  private int year;
  
  /* constructor for the date that requires the day, month, and year */
  public Date (int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  
  /* retrives the number of the day */
  public int getDay() {
    return this.day;
  }
  
  /* retrives the number of the month */
  public int getMonth() {
    return this.month;
  }
  
  /* retrives the number of the year */
  public int getYear() {
    return this.year;
  }
  
  /* Overrides the toString method inherited from the object class to return the month/day/year */
  @Override
  public String toString () {
    return month + "/" + day + "/" + year;
  }
  
  /* overrides the equals method inherited from the object class to find if this date is equal to the input date */
  public boolean equals (Date date2) {
    return this.getDay() == date2.getDay() && this.getMonth() == date2.getMonth() && this.getYear() == date2.getYear(); 
  }
  
  /* returns the number of days from Janurary 1st from the date that was inputed */
  public int daysfromJan1 () {
    if (this.month == 1)
      return this.day - 1;
    else if (this.month == 2)
      return this.day + 30;
    else if (this.month == 3)
      return this.day + 58;
    else if (this.month == 4)
      return this.day + 89;
    else if (this.month == 5)
      return this.day + 119;
    else if (this.month == 6)
      return this.day + 150;
    else if (this.month == 7)
      return this.day + 180;
    else if (this.month == 8)
      return this.day + 211;
    else if (this.month == 9)
      return this.day + 241;
    else if (this.month == 10)
      return this.day + 272;
    else if (this.month == 11)
      return this.day + 302;
    else
      return this.day + 333;
  }
  
  /* finds the difference between two inputed dates */
  public static int difference (Date date1, Date date2) {
    return (365 * (date1.getYear() - date2.getYear())) + (date1.daysfromJan1() - date2.daysfromJan1());
  }
}
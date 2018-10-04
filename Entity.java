import java.util.LinkedList;

/**
 * <h1>Entity Class</h1>
 * Contains an entity that exists inside of the social network
 * as well as a enum type of health that describes the entity's 
 * health status
 * <p>
 *
 * @author  Matthew Yoon
 * @since   2018-04-13
 */

/* Represents an unclassified entity */
public class Entity implements Comparable<Entity> {
  /* enum type that stores the fields for health status */
  enum Health {
    Uninfected, Infected, Inoculated, BeingInfected, BeingInoculated;
  }
  
  /* Name of the entity */
  private String name;
  
  /* Health status of the entity */
  private Health healthStatus;
  
  /* Relations of the entity */
  private LinkedList<Entity> relations;
    
  /*
   * Creates an entity with the given specifications 
   * @param name the name of the entity
   * @param empty linked list for the relations
   * @param the health status of the entity set as uninfected
   */
  public Entity(String name) {
    this.name = name;
    this.relations = new LinkedList<Entity>();
    this.healthStatus = Health.Uninfected;
  }
  
  /** 
   * Returns the name of the entity
   * @return the name of the entity 
   */
  public String getName() {
    return name;
  }
  
  /** 
   * Sets the name of the entity
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Returns the health status of the entity
   * @return the health status of the entity
   */
  public Health getHealthStatus() {
    return healthStatus;
  }
  
  /**
   * Sets the health status of the entity
   * @param healthStatus the new health status
   */
  public void setHealthStatus(Health healthStatus) {
    this.healthStatus = healthStatus;
  }
  
  /**
   * Returns the relations of the entity
   * @return the relations of the entity
   */
  public LinkedList<Entity> getRelations() {
    return relations;
  }
  
  /**
   * Overrides the compareTo method to compare the two Entity's names by alphabetical order
   * @return negative value if the specified entity is greater alphabetically than this entity
   * @return positive value if the specified entity is smaller alphabetically than this entity
   * @return zero if the specified entity is equal alphabetically than this entity
   */
  @Override
  public int compareTo(Entity entity1) {
    return this.getName().compareTo(entity1.getName());
  }
  
  /**
   * Overrides the equals method to see if two entitys are equal based on if they have the same name
   * @return true if the two entitys have the same name
   * @return false if the two entitys have different names
   */
  @Override
  public boolean equals(Object object1) {
    if (object1 instanceof Entity) {
      Entity entity1 = (Entity) object1;
      return this.getName().equals(entity1.getName());
    }
    else
      return false;
  }
  
  /**
   * Overrides the toString method to show the name and health of the entity
   * @return the name and health status of the entity
   */
  @Override
  public String toString() {
    return this.getName() + ": " + this.getHealthStatus();
  }
}
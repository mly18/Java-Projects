import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.io.File;
import java.io.IOException;

/**
 * <h1>PropagationStudy Class</h1>
 * Runs a simulation that contains the network of entities, 
 * infection rate, heal rate, and wear rate
 * <p>
 *
 * @author  Matthew Yoon
 * @since   2018-04-13
 */

/* Represents a unclassified Propagation study */
public class PropagationStudy implements Iterable<Entity> {
  /* the network of the study */
  private Network testedNetwork;
  
  /* the infection rate of the study */
  private double infectionRate;
   
  /* the heal rate of the study */
  private double healRate;
  
  /* the wear rate of the study */
  private double wearRate;
  
  /** 
   * the first node of the list, or null if the list is empty 
   */
  private LLNode<Entity> first;
  
  /** the nodeptr stores where we are in the list */
  private LLNode<Entity> nodeptr;
  
  /*
   * Creates a propagation study with the following specfifcations
   * @param network the network of the study
   * @param infectionRate the infection rate of the study
   * @param healRate the heal rate of the study
   * @param wearRate the wear rate of the study
   */
  public PropagationStudy(Network testedNetwork, double infectionRate, double healRate, double wearRate) {
    this.testedNetwork = testedNetwork;
    this.infectionRate = infectionRate;
    this.healRate = healRate;
    this.wearRate = wearRate;
  }
  
  /* 
   * Returns the network of the study
   * @return the network of the study
   */
  public Network getNetwork() {
    return testedNetwork;
  }
  
  /*
   * Sets the network of the study
   * @param testedNetwork the new network of the study
   */
  public void setNetwork(Network testedNetwork) {
    this.testedNetwork = testedNetwork;
  }
  
  /* 
   * Returns the infection rate of the study
   * @return the infection rate of the study
   */
  public double getInfectionRate() {
    return infectionRate;
  }
  
  /*
   * Sets the infection rate of the study
   * @param infectionRate the new infection rate of the study
   */
  public void setInfectionRate(double infectionRate) {
    this.infectionRate = infectionRate;
  }
  
  /* 
   * Returns the heal rate of the study
   * @return the heal rate of the study
   */
  public double getHealRate() {
    return healRate;
  }
  
  /*
   * Sets the heal rate of the study
   * @param healRate the new heal rate of the study
   */
  public void setHealRate(double healRate) {
    this.healRate = healRate;
  }
  
  /* 
   * Returns the wear rate of the study
   * @return the wear rate of the study
   */
  public double getWearRate() {
    return wearRate;
  }
  
  /*
   * Sets the wear rate of the study
   * @param wearRate the new wear rate of the study
   */
  public void setWearRate(double wearRate) {
    this.wearRate = wearRate;
  }
  
  /*
   * changes the entity parameter's health status to infected
   * @param entity1 the entity to be acted on
   */
  public void infect(Entity entity) {
    int counter = 0;                                                                         // keeps count if the entity parameter exists in the loop
    // Runs through every entity in network list
    for (Entity entitytest : this.getNetwork().getNetwork()) {  
      if (entitytest.equals(entity)) {
        entity.setHealthStatus(Entity.Health.Infected);
        counter = counter + 1;
      }
    }
    if (counter == 0)
      throw new NoSuchElementException();
  }
  
  /*
   * changes every entity in the network to infected through a probability 
   * set by the parameter
   * @param infectionChance the chance that the entities in the network have of being infected
   */
  public void infect(double infectionChance) throws NotWithinLimit{
    // Runs through every entity in network list
    for (Entity entitytest : this.getNetwork().getNetwork()) {
      if (infectionChance <= 1.0 && infectionChance >= 0.0) {
        if (Math.random() < infectionChance)
          entitytest.setHealthStatus(Entity.Health.Infected);
      }
    }
    if (infectionChance > 1.0)
      throw new NotWithinLimit();
  }
  
  /*
   * changes the entity parameter's health status to inoculated
   * @param entity1 the entity to be acted on
   */
  public void inoculate(Entity entity) throws NoSuchElementException {
    int counter = 0;                                                                         // Makes sure that the entity parameter exists in the network list
    // Runs through every entity in network list
    for (Entity entitytest : this.getNetwork().getNetwork()) {
      if (entitytest.equals(entity)) {
        entity.setHealthStatus(Entity.Health.Inoculated);
        counter = counter + 1;
      }
    }
    if (counter == 0)
      throw new NoSuchElementException();
  }
  
  /*
   * changes every entity in the network to inoculated through a probability 
   * set by the parameter
   * @param inoculatedChance the chance that the entities in the network have of being inoculated
   */
  public void inoculate(double inoculatedChance) throws NotWithinLimit {
    // Runs through every entity in network list
    for (Entity entitytest : this.getNetwork().getNetwork()) {
      if (inoculatedChance <= 1.0 && inoculatedChance >= 0.0) {
        if (Math.random() < inoculatedChance)
          entitytest.setHealthStatus(Entity.Health.Inoculated);
      }
    }
    if (inoculatedChance > 1.0)
      throw new NotWithinLimit();
  }    
  
  /*
   * returns the number of entities in the network that are uninfected
   * @return the number of entities in the network that are uninfected
   */
  public int getNumUninfected() {
    int counter = 0;                                                                              // Keeps count of the number of entities in the list
    // Runs through every entity in network list
    for (Entity entitytest : this.getNetwork().getNetwork()) {
      if (entitytest.getHealthStatus() == Entity.Health.Uninfected) {
        counter = counter + 1;
      }
    }
    return counter;
  }
  
  /*
   * returns the number of entities in the network that are inoculated
   * @return the number of entities in the network that are inoculated
   */
  public int getNumInoculated() {
    int counter = 0;                                                                              // Keeps count of the number of entities in the list
    // Runs through every entity in network list
    for (Entity entitytest : this.getNetwork().getNetwork()) {
      if (entitytest.getHealthStatus() == Entity.Health.Inoculated) {
        counter = counter + 1;
      }
    }
    return counter;
  }
  
  /*
   * returns the number of entities in the network that are infected
   * @return the number of entities in the network that are infected
   */
  public int getNumInfected() {
    int counter = 0;                                                                              // Keeps count of the number of entities in the list
    // Runs through every entity in network list
    for (Entity entitytest : this.getNetwork().getNetwork()) {
      if (entitytest.getHealthStatus() == Entity.Health.Infected) {
        counter = counter + 1;
      }
    }
    return counter;
  }
  
  /*
   * changes the health status of every entity in the network to uninfected
   */
  public void resetNetwork() {
    // Runs through every entity in network list
    for (Entity entitytest : this.getNetwork().getNetwork()) {
      entitytest.setHealthStatus(Entity.Health.Uninfected);
    }
  }
  
  /*
   * prints out every entity and it's respective health status from the network
   */
  public void printNetwork() {
    Collections.sort(this.getNetwork().getNetwork());
    // Runs through every entity in network list
    for (Entity entitytest : this.getNetwork().getNetwork()) {
      System.out.println(entitytest.getName());
      System.out.println(entitytest.getHealthStatus());
    }
  }
  
  /*
   * First goes through the relations of every entity that is infected and based on 
   * the infection rate the relations as infected
   * Second for every infected entity it checks if the heal rate allows it to be inoculated
   * Third change all inoculated entites to uninfected based on the wear rate
   * Fourth every entity being infected set the status to infected and for every entity being
   * inoculated set the status to inoculated
   */
  public void runPropagation() {
    // Runs through every entity in network list
    for (Entity entitytest : this.getNetwork().getNetwork()) {
      if (entitytest.getHealthStatus() == Entity.Health.Infected) {
        // Runs through every entity in the relations of the respective infected entity
        for (Entity entityinner : entitytest.getRelations()) {
          if (entityinner.getHealthStatus() == Entity.Health.Uninfected) {
            if (Math.random() < infectionRate)
              entityinner.setHealthStatus(Entity.Health.BeingInfected);
          }
        }
        if (Math.random() < healRate)
          entitytest.setHealthStatus(Entity.Health.BeingInoculated);
      }
    if (entitytest.getHealthStatus() == Entity.Health.Inoculated) {
      if (Math.random() < wearRate)
        entitytest.setHealthStatus(Entity.Health.Uninfected);
    }
    if (entitytest.getHealthStatus() == Entity.Health.BeingInfected) {
      entitytest.setHealthStatus(Entity.Health.Infected);
    }
    if (entitytest.getHealthStatus() == Entity.Health.BeingInoculated) {
      entitytest.setHealthStatus(Entity.Health.Inoculated);
    }
    }
  }
  
  /* 
   * Takes a int value that determines how many times the run propagation method is run through
   * @param repeater the number of times the run propagation will be ran through
   */
  public void runPropagation(int repeater) throws NotWithinLimit {
    int counter = repeater;                                                                // Sets the counter equal to the repeater to keep track of the amount of times its been run through
    // Runs through until the counter reaches zero
    while (counter > 0) {
      this.runPropagation();
      counter = counter - 1;
    }
    if (counter < 0)
      throw new NotWithinLimit();
  }
  
  // java nameofprogram hello world
  // arg[0] = hello
  // arg[1] = world
  
  private class NetworkIterator implements Iterator<Entity> {
  
    /** 
     * Create the iterator
     * @param firstNode  
     * the first node whose data is returned by the iterator
     */
    public NetworkIterator(LLNode<Entity> first) {
      nodeptr = first;
    }
  
    /**
     * Returns true if there is still more data in the list
     * @return true if more data
     */
    @Override
    public boolean hasNext() {
      return nodeptr != null;
    }
   
    /**
     * Returns the next element stored in the list and increments
     * @return the next element
     */
    @Override
    public Entity next() {
      if (hasNext()) {
        Entity element = nodeptr.getElement();
        nodeptr = nodeptr.getNext();
        return element;
      }
      else
        throw new NoSuchElementException();
    }
  }
  
  /**
   * Return an iterator for our linked list
   * @return the iterator
   */
  public Iterator<Entity> iterator() {
    return new NetworkIterator(first);
  }
  
  /*
   * Runs the program and starts a simulation based on the given argument inputs
   */
  public static void main(String[] args) {
    try {
      File fileName1 = new File(args[0]);
      Double infectionRate = Double.parseDouble(args[1]);
      Double healRate = Double.parseDouble(args[2]);
      Double wearRate = Double.parseDouble(args[3]);
      int rounds = Integer.parseInt(args[4]);
      File fileName2 = new File(args[5]);
      Network newNetwork = new Network();
      newNetwork.addRelations(fileName1);
      PropagationStudy study1 = new PropagationStudy(newNetwork, infectionRate, healRate, wearRate);
      study1.infect(infectionRate);
      study1.inoculate(healRate);
      study1.runPropagation(rounds);
      Network newNetwork2 = new Network();
      newNetwork2.addRelations(fileName2);
      PropagationStudy study2 = new PropagationStudy(newNetwork2, infectionRate, healRate, wearRate);
      study2.infect(1.0);
      System.out.println(study1.getNumUninfected());
      System.out.println(study1.getNumInfected());
      System.out.println(study1.getNumInoculated());
    }
    catch (IOException e) {
      System.out.println("File not found");
    }
    catch (NotWithinLimit e) {
      System.out.println("Not within the correct limit");
    }
  }
}
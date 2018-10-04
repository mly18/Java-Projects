import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.io.File;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.String;
import java.util.Collections;

/**
 * <h1>Network Class</h1>
 * Represents the social network of entities, implements the 
 * interable interface and contains a linked list that stores
 * all the entities of the network
 * <p>
 *
 * @author  Matthew Yoon
 * @since   2018-04-13
 */

/* Represents a unclassified network */
public class Network implements Iterable<Entity> { 
  /** 
   * the first node of the list, or null if the list is empty 
   */
  private LLNode<Entity> first;
  
  /** the nodeptr stores where we are in the list */
  private LLNode<Entity> nodeptr;
  
  /**
   * the linked list for the network that contains all the entities 
   */
  private LinkedList<Entity> networkList;
  
  /* constructor for network that intializes a new empty network */
  public Network() {
    this.networkList = new LinkedList<Entity>();
  }
  
  /* Retrives the linkedlist that stores the network */
  public LinkedList<Entity> getNetwork() {
    return networkList;
  }
  
  /*
   * Adds entities to the network based on if they are already in the network
   * linked list, also each entity is added to eachothers relation list
   * @param entity1 the first entity checked
   * @param entity2 the second entity checked
   */
  public void addRelation(Entity entity1, Entity entity2) {
    int counter = 0;                                            // Keeps count of either entity1 or entity2 to analyze if it is in the list
    // Run through every entity in the network list
    for (Entity entitytest : networkList) {
      if (entitytest == entity1) {
        counter = counter + 1;
      }
    }
    // Run through every entity in the network list
    for (Entity entitytest : networkList) {
      if (entitytest == entity2) {
        counter = counter + 2;
      }
    }
    if (counter == 0) {
      networkList.addLast(entity1);
      networkList.addLast(entity2);
    }
    else if (counter == 1) {
      networkList.addLast(entity2);
    }
    else if (counter == 2) {
      networkList.addLast(entity1);
    }
    entity1.getRelations().addLast(entity2);
    entity2.getRelations().addLast(entity1);
  }
  
  /**
   * Removes the two entities from eachother's relations list
   * @param entity1 the first entity 
   * @param entity2 the second entity
   */
  public void removeRelation(Entity entity1, Entity entity2) {
    entity1.getRelations().remove(entity2);
    entity2.getRelations().remove(entity1);
  }
  
  /**
   * Takes a file that contains pairs of entities that are in relation,
   * adds these pairs to the network
   * @param filePairs the file that ontains the pairs
   */
  public void addRelations(File filePairs) throws IOException, FileNotFoundException {
    try {
      FileReader reader = new FileReader(filePairs);
      BufferedReader fileReader = new BufferedReader(reader);
      String singleLine = fileReader.readLine();
      // Runs the loop until singeLine runs out of lines to read
      while (singleLine != null) {
        String[] parts = singleLine.split(", ");
        String part1 = parts[0];
        String part2 = parts[1];
        Entity entity1 = new Entity(part1);
        Entity entity2 = new Entity(part2);
        this.addRelation(entity1, entity2);
        singleLine = fileReader.readLine();
      }
    }
    catch(IOException e){
      System.out.println("File could not be read");
    }
  }
  
  /**
   * Takes an array that contains entities, each entity in 
   * the array will be added to the network and every pair preceding 
   * the first will be added as relations
   * @param array the array that contains the entities
   */
  public void addRelations(String[] array) throws NotEvenNumber {
    if((array.length%2)==0) {
      int counter = 0;                                                                    // Keeps count of how many entities are in the list
      int counterPair = 1;                                                                // Keeps count of how many entities are in the list 
      int end = array.length;                                                             // assigns end to the last number of the length
      // runs the loop until it reaches the end of the array
      while (counter < end) {
        String part1 = array[counter].toString();
        String part2 = array[counterPair].toString();
        Entity entity1 = new Entity(part1);
        Entity entity2 = new Entity(part2);
        this.addRelation(entity1, entity2);
        counter = counter + 2;
        counterPair = counterPair + 2;
      }
    }
    else
      throw new NotEvenNumber();
    }
  
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
}

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P09 Chugidex
// Course:   CS 300 Fall 2022
//
// Author:   Akshay Gona
// Email:    gona@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:   Rishit Patil
// Partner Email:   rpatil5@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:   none
// Online Sources:  (none
//
///////////////////////////////////////////////////////////////////////////////

public class Chugimon implements Comparable<Chugimon>{
  private final int FIRST_ID; // The first ID of the Chugimon
  private final double HEIGHT; // The height of the Chugimon in meters
  static final int MAX_ID = 151; // The maximum ID number
  static final int MIN_ID = 1; // The minimum ID number
  private final String NAME; // The name of the Chugimon
  private final ChugiType PRIMARY_TYPE; // The primary type of the Chugimon; cannot be null;
  // cannot be the same as the secondary type
  private final int SECOND_ID; // The second ID of the Chugimon
  private final ChugiType SECONDARY_TYPE; // The secondary type of the Chugimon; may be null;
  // cannot be the same as the primary type
  private final double WEIGHT; // The weight of the Chugimon in kilograms

  /**
   *  Creates a new Chugimon with specific first and second IDs and initializes all its
   *  data fields accordingly.
   *
   * @param firstID the first ID of the Chugimon, between 1-151
   * @param secondID the second ID of the Chugimon, between 1-151
   * @throws IllegalArgumentException if the first and second ID are out of bounds or equal to each
   * other.
   */
  public Chugimon(int firstID, int secondID) throws IllegalArgumentException{
    if (firstID < MIN_ID){
      throw new IllegalArgumentException("first ID is too small");
    }
    if (firstID > MAX_ID){
      throw new IllegalArgumentException("first ID is too big");
    }
    if (secondID < MIN_ID){
      throw new IllegalArgumentException("second ID is too small");
    }
    if (secondID > MAX_ID){
      throw new IllegalArgumentException("second ID is too big");
    }
    if (firstID == secondID){
      throw new IllegalArgumentException("the ID's are equal");
    }
    this.FIRST_ID = firstID;
    this.SECOND_ID = secondID;
    this.HEIGHT = ChugidexUtility.getChugimonHeight(FIRST_ID, SECOND_ID);
    this.NAME = ChugidexUtility.getChugimonName(FIRST_ID, SECOND_ID);
    this.PRIMARY_TYPE = ChugidexUtility.getChugimonTypes(FIRST_ID, SECOND_ID)[0];
    this.SECONDARY_TYPE = ChugidexUtility.getChugimonTypes(FIRST_ID, SECOND_ID)[1];
    this.WEIGHT = ChugidexUtility.getChugimonWeight(FIRST_ID, SECOND_ID);
  }

  /**
   * Gets the name of this Chugimon
   *
   * @return the name of the Chugimon
   */
  public String getName(){
    return NAME;
  }
  /**
   * Gets the first ID of this Chugimon
   *
   * @return first ID of this Chugimon
   */
  public int getFirstID(){
    return FIRST_ID;
  }
  /**
   * Gets the second ID of this Chugimon
   *
   * @return second ID of this Chugimon
   */
  public int getSecondID(){
    return SECOND_ID;
  }
  /**
   * Gets the primary type of this Chugimon
   *
   * @return the primary type of this Chugimon
   */
  public ChugiType getPrimaryType(){
    return PRIMARY_TYPE;
  }
  /**
   * Gets the secondary type of this Chugimon
   *
   * @return the secondary type of this Chugimon
   */
  public ChugiType getSecondaryType(){
    return SECONDARY_TYPE;
  }
  /**
   * Gets the height of this Chugimon
   *
   * @return the height of this Chugimon
   */
  public double getHeight(){
    return HEIGHT;
  }
  /**
   * Gets the weight of this Chugimon
   *
   * @return the weight of this Chugimon
   */
  public double getWeight(){
    return WEIGHT;
  }
  /**
   * Determines the ordering of Chugimon. Chugimon are ordered by: 1) name (alphabetical) 2) the
   * first ID (if name is equal). The one with the smaller first ID is less than the other. 3) the
   * second ID (if name and first ID are equal). The one with the smaller second ID is less than
   * the other. A Chugimon with identical #1-3 are considered equal.
   *
   * @param otherChugi the other Chugimon to compare this Chugimon to.
   * @return a negative int if this Chugimon is less than other, a positive int if this Chugimon
   * is greater than other, or 0 if this and the other Chugimon are equal.
   */
  @Override
  public int compareTo(Chugimon otherChugi){
    if (!getName().equals(otherChugi.getName())){
      return getName().compareTo(otherChugi.getName());
    } else if (getFirstID() != otherChugi.getFirstID()){
      return getFirstID() - otherChugi.getFirstID();
    } else if (getSecondID() != otherChugi.getSecondID()){
      return getSecondID() - otherChugi.getSecondID();
    } else {
      return 0;
    }
  }
  /**
   * A Chugimon's String representation is its name followed by "#FIRST_ID.SECOND_ID" --
   * Example: "Zapchu#145.25"
   *
   * @return a String representation of this Chugimon
   */
  @Override
  public String toString(){
    String chugiString = "";
    chugiString += getName();
    chugiString += "#" + FIRST_ID + "." + SECOND_ID;
    return chugiString;
  }
  /**
   * Equals method for Chugimon. This Chugimon equals another object if other is a
   * Chugimon with the exact same name, and their both first and second IDs match.
   *
   * @param other Object to determine equality against this Chugimon
   * @return true if this Chugimon and other Object are equal, false otherwise
   */
  @Override
  public boolean equals(Object other){
      if(!(other instanceof Chugimon)){
        return false;
    }
    if (compareTo((Chugimon) other) != 0){
      return false;
    }
    return true;
  }
}

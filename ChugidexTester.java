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
// Persons:   (none)
// Online Sources:  (none)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the Chugimon
 * and ChugiTree classes.
 *
 * @author Rishit Patil, Akshay Gona
 *
 */

public class ChugidexTester {


  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Chugimon class.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testChugimonCompareToEquals() {
    try {
      // chugimons are equal
      {
        Chugimon chugimon = new Chugimon(1,104);
        Chugimon chugimon1 = new Chugimon(1,104);
        //create new
        if (chugimon.compareTo(chugimon1) != 0){
          System.out.println("compareTo() doesn't work as expected when it should return 0");
          return false;
        }
        if (!chugimon.equals(chugimon1)){
          System.out.println("equals() doesn't work as expected when it should return true");
          return false;
        }
      }
      // chugimons are different
      {
        Chugimon chugimon = new Chugimon(1,104);
        Chugimon chugimon1 = new Chugimon(1,12);
        if (chugimon.compareTo(chugimon1) == 0){
          System.out.println("compareTo() doesn't work as expected when it should return 0");
          return false;
        }
        if (chugimon.equals(chugimon1)){
          System.out.println("equals() doesn't work as expected when it should return true");
          return false;
        }
      }
      // Chugimons with the same name but different id's
      {
        Chugimon chugimon = new Chugimon(1,21);
        Chugimon chugimon1 = new Chugimon(1,22);
        if (!(chugimon.compareTo(chugimon1) < 0)){
          System.out.println("compareTo() doesn't work as expected when two chugimons have the " +
              "same name but different id's");
          return false;
        }
        if (chugimon.equals(chugimon1)){
          System.out.println("equals() doesn't work as expected when two chugimons have the same" +
              "name but different id's");
          return false;
        }
      }
    } catch (Exception e) {
      System.out.println("An unexpected exception was thrown in testChugimonCompareToEquals");
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of the implementation of Chugimon.toString() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testChugimonToString() {
    try {
      // Standard toString() test
      {
        Chugimon chugimon = new Chugimon(145,25); // Zapchu
        if (!chugimon.toString().equals("Zapchu#145.25")){
          System.out.println("Chugimon.toString() doesn't work as expected");
          return false;
        }
      }
    } catch (Exception e){
      System.out.println("An unexpected exception was thrown in testChugimonToString");
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of the implementation of ChugiTree.isValidBSTHelper() method. This
   * tester should consider at least three scenarios. (1) An empty tree whose root is null should be
   * a valid BST. (2) Consider a valid BST whose height is at least 3. Create the tree using the
   * constructors of the BSTNode and its setters methods, (3) Consider a NON-valid BST where the
   * search order property is violated at at least one internal node.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIsValidBSTHelper() {
    try {
      // A tree with root null, should return true;
      {
        if (!ChugiTree.isValidBSTHelper(null)){
          System.out.println("A null root should return a Valid BST but it didn't");
          return false;
        }
      }
      // Valid BST where height is 3
      {
        BSTNode<Chugimon> ivywrath = new BSTNode<>(new Chugimon(2, 62)); // Ivywrath
        BSTNode<Chugimon> bulbther = new BSTNode<>(new Chugimon(1, 123)); // bulbther
        BSTNode<Chugimon> venuth = new BSTNode<>(new Chugimon(3, 52)); // venuth
        BSTNode<Chugimon> bulbdeen = new BSTNode<>(new Chugimon(1, 118)); // bulbdeen
        BSTNode<Chugimon> chardash = new BSTNode<>(new Chugimon(4, 78)); // chardash
        BSTNode<Chugimon> wigglychan = new BSTNode<>(new Chugimon(40, 107)); // wigglychan
        BSTNode<Chugimon> metabone = new BSTNode<>(new Chugimon(11, 104)); // metabone
        ivywrath.setLeft(bulbther);
        ivywrath.setRight(venuth);
        bulbther.setLeft(bulbdeen);
        bulbther.setRight(chardash);
        venuth.setRight(wigglychan);
        if (!ChugiTree.isValidBSTHelper(ivywrath)){
          System.out.println("isValidBST didn't work on a valid tree with a height of 3");
          return false;
        }
      }
      // Invalid BST with a height of 3
      {
        BSTNode<Chugimon> ivywrath = new BSTNode<>(new Chugimon(2, 62)); // Ivywrath
        BSTNode<Chugimon> bulbther = new BSTNode<>(new Chugimon(1, 123)); // bulbther
        BSTNode<Chugimon> venuth = new BSTNode<>(new Chugimon(3, 52)); // venuth
        BSTNode<Chugimon> bulbdeen = new BSTNode<>(new Chugimon(1, 118)); // bulbdeen
        BSTNode<Chugimon> chardash = new BSTNode<>(new Chugimon(4, 78)); // chardash
        BSTNode<Chugimon> wigglychan = new BSTNode<>(new Chugimon(40, 107)); // wigglychan
        BSTNode<Chugimon> metabone = new BSTNode<>(new Chugimon(11, 104)); // metabone
        ivywrath.setLeft(bulbther);
        ivywrath.setRight(venuth);
        bulbther.setLeft(bulbdeen);
        bulbther.setRight(chardash);
        venuth.setRight(metabone);
        venuth.setLeft(wigglychan);
        if (ChugiTree.isValidBSTHelper(ivywrath)){
          System.out.println("isValidBST didn't work on an invalid tree with a height of 3");
          return false;
        }
      }
    } catch (Exception e){
      System.out.println("An unexpected exception was thrown in testIsValidBSTHelper");
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of the implementation of both add() and toString() methods implemented
   * in the ChugiTree class. This unit test considers at least the following scenarios. (1) Create a
   * new empty ChugiTree, and check that its size is 0, it is empty, and that its string
   * representation is an empty string "". (2) try adding one Chugimon and then check that the add()
   * method call returns true, the tree is not empty, its size is 1, and the toString() called on
   * the tree returns the expected output. (3) Try adding another Chugimon which is less than the
   * Chugimon at the root, (4) Try adding a third Chugimon which is greater than the one at the
   * root, (5) Try adding at least two further Chugimons such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, that the ChugiTree is a valid BST, and that the toString() method returns the expected
   * string representation of the contents of the binary search tree in an increasing order from the
   * smallest to the greatest Chugimon. (6) Try adding a Chugimon already stored in the tree. Make
   * sure that the add() method call returned false, and that the size of the tree did not change.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddToStringSize() {
    try {
      // Empty tree
      {
        ChugiTree chugiTree = new ChugiTree();
        if (chugiTree.size() != 0){
          System.out.println("blank chugitree didn't return a size of 0");
          return false;
        }
        if (!chugiTree.isEmpty()){
          System.out.println("blank chugitree isEmpty wasn't true");
          return false;
        }
        if (!chugiTree.toString().equals("")){
          System.out.println("blank chugitree didn't return an empty string");
          return false;
        }
      }
      // Adding to an empty tree
      {
        ChugiTree chugiTree = new ChugiTree();
        if (!chugiTree.add(new Chugimon(2,62))){
          System.out.println("when adding to a blank tree, true wasn't returned");
          return false;
        }
        if (chugiTree.isEmpty()){
          System.out.println("isEmpty returned true when it's not empty");
          return false;
        }
        if (chugiTree.size() != 1){
          System.out.println("size should've been 1");
          return false;
        }
        if (!chugiTree.toString().equals("Ivywrath#2.62")){
          System.out.println("toString on a tree of size 1 was unexpected");
          return false;
        }
      }
      // Add to the left of a tree
      {
        ChugiTree chugiTree = new ChugiTree();
        chugiTree.add(new Chugimon(2,62));
        if (!chugiTree.add(new Chugimon(1,123))){
          System.out.println("when adding to a tree of size 1, true wasn't returned");
          return false;
        }
        if (chugiTree.isEmpty()){
          System.out.println("isEmpty returned true when it's not empty");
          return false;
        }
        if (chugiTree.size() != 2){
          System.out.println("size should've been 2");
          return false;
        }
        if (!chugiTree.toString().equals("Bulbther#1.123,Ivywrath#2.62")){
          System.out.println("toString on a tree of size 2 and added to left was unexpected");
          return false;
        }
      }
      // Add to the right side of a tree
      {
        ChugiTree chugiTree = new ChugiTree();
        chugiTree.add(new Chugimon(2,62));
        chugiTree.add(new Chugimon(1,123));
        if (!chugiTree.add(new Chugimon(3,52))){
          System.out.println("when adding to a tree of size 2, true wasn't returned");
          return false;
        }
        if (chugiTree.isEmpty()){
          System.out.println("isEmpty returned true when it's not empty");
          return false;
        }
        if (chugiTree.size() != 3){
          System.out.println("size should've been 3");
          return false;
        }
        if (!chugiTree.toString().equals("Bulbther#1.123,Ivywrath#2.62,Venuth#3.52")){
          System.out.println("toString on a tree of size 3 and added to right was unexpected");
          return false;
        }
      }
      // Adding two chugimons, one to left subtree and one to right subtree
      {
        ChugiTree chugiTree = new ChugiTree();
        chugiTree.add(new Chugimon(2,62));
        chugiTree.add(new Chugimon(1,123));
        chugiTree.add(new Chugimon(3,52));
        if (!(chugiTree.add(new Chugimon(4,78)) && chugiTree.add(new Chugimon(11,104)))){
          System.out.println("Error when adding to create a height of 3");
          return false;
        }
        if (chugiTree.isEmpty()){
          System.out.println("isEmpty returned true when it's not empty");
          return false;
        }
        if (chugiTree.size() != 5){
          System.out.println("size should've been 5");
          return false;
        }
        if (!chugiTree.toString().equals("Bulbther#1.123,Chardash#4.78,Ivywrath#2.62," +
            "Metabone#11.104,Venuth#3.52")){
          System.out.println("toString on a tree of size 5 and added to both left and right");
          return false;
        }
      }
      // Adding a chugimon that already exists in the string
      {
        ChugiTree chugiTree = new ChugiTree();
        chugiTree.add(new Chugimon(2,62));
        chugiTree.add(new Chugimon(1,123));
        chugiTree.add(new Chugimon(3,52));
        if (chugiTree.add(new Chugimon(3,52))){
          System.out.println("Add added when the chuigmon was already present");
          return false;
        }
        if (chugiTree.size() != 3){
          System.out.println("add() increased size when adding an already present chugimon");
          return false;
        }
        if (!chugiTree.toString().equals("Bulbther#1.123,Ivywrath#2.62,Venuth#3.52")){
          System.out.println("toString on a tree of size 3 adding incorrectly");
          return false;
        }
      }
    } catch (Exception e){
      System.out.println("testAddToStringSize threw an unexpected exception");
      return false;
    }
    return true;
  }

  /**
   * This method checks mainly for the correctness of the ChugiTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ChugiTree. Then, check that
   * calling the lookup() method on an empty ChugiTree returns false. (2) Consider a ChugiTree of
   * height 3 which contains at least 5 Chugimons. Then, try to call lookup() method to search for a
   * Chugimon having a match at the root of the tree. (3) Then, search for a Chugimon at the right
   * and left subtrees at different levels considering successful and unsuccessful search
   * operations. Make sure that the lookup() method returns the expected output for every method
   * call.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    try {
      // lookup on an empty chugitree
      {
        ChugiTree chugiTree = new ChugiTree();
        if (chugiTree.lookup(1,2) != null){
          System.out.println("lookup on an empty tree didn't return null");
          return false;
        }
      }
      // Searching a tree of height 3 for the root
      {
        ChugiTree chugiTree = new ChugiTree();
        chugiTree.add(new Chugimon(2,62));
        chugiTree.add(new Chugimon(1,123));
        chugiTree.add(new Chugimon(3,52));
        chugiTree.add(new Chugimon(6,23));
        chugiTree.add(new Chugimon(9,81));
        if (!chugiTree.lookup(2,62).equals(new Chugimon(2,62))){
          System.out.println("Searching a tree of height 3 for the root doesn't work");
          return false;
        }
      }
      // Searching for chugimons at different levels
      {
        ChugiTree chugiTree = new ChugiTree();
        chugiTree.add(new Chugimon(2,62));
        chugiTree.add(new Chugimon(1,123));
        chugiTree.add(new Chugimon(3,52));
        chugiTree.add(new Chugimon(6,23));
        chugiTree.add(new Chugimon(9,81));
        if (!chugiTree.lookup(1,123).equals(new Chugimon(1,123))){
          System.out.println("Searching a tree of height 3 for a value on the second level on " +
              "the left side");
          return false;
        }
        if (!chugiTree.lookup(3,52).equals(new Chugimon(3,52))){
          System.out.println("Searching a tree of height 3 for a value on the second level on" +
              " right side");
          return false;
        }
        if (!chugiTree.lookup(6,23).equals(new Chugimon(6,23))){
          System.out.println("Searching a tree of height 3 for a value on the third level on" +
              " left side");
          return false;
        }
        if (!chugiTree.lookup(9,81).equals(new Chugimon(9,81))){
          System.out.println("Searching a tree of height 3 for a value on the third level on" +
              " right side");
          return false;
        }
        if (chugiTree.lookup(69,124)!=null){
          System.out.println("Searching a tree of height 3 for nonexistent value doesn't work");
          return false;
        }
      }
    } catch (Exception e){
      System.out.println("testLookup threw an unexpected exception");
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.countType() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCountType() {
    try {
      BSTNode<Chugimon> ivywrath = new BSTNode<>(new Chugimon(2, 62)); // Ivywrath
      BSTNode<Chugimon> bulbther = new BSTNode<>(new Chugimon(1, 123)); // bulbther
      BSTNode<Chugimon> venuth = new BSTNode<>(new Chugimon(3, 52)); // venuth
      BSTNode<Chugimon> bulbdeen = new BSTNode<>(new Chugimon(1, 118)); // bulbdeen
      BSTNode<Chugimon> chardash = new BSTNode<>(new Chugimon(4, 78)); // chardash
      ChugiTree chugitree = new ChugiTree();
      chugitree.add(ivywrath.getData());
      chugitree.add(bulbther.getData());
      chugitree.add(venuth.getData());
      chugitree.add(bulbdeen.getData());
      chugitree.add(chardash.getData());
      // Grass appears 4 times
      if (chugitree.countType(ChugiType.GRASS) != 4){
        System.out.println("Count type didn't work when looking for repeating type");
        return false;
      }
      // Normal appears one time
      if (chugitree.countType(ChugiType.NORMAL) != 1){
        System.out.println("Count type didn't work when looking for type that exists once");
        return false;
      }
      // Flying doesn't appear
      if (chugitree.countType(ChugiType.FLYING) != 0){
        System.out.println("Count type didn't work when looking for nonexistent type");
        return false;
      }
    } catch (Exception e){
      System.out.println("testCountType threw an unexpected exception");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty Chugimon tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ChugiTree with four levels for instance, is 4.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    try {
      // Empty tree
      {
        ChugiTree chugiTree = new ChugiTree();
        if (chugiTree.height() != 0){
          System.out.println("Height doesn't work on an empty tree");
          return false;
        }
      }
      // Height of 1
      {
        ChugiTree chugiTree = new ChugiTree();
        chugiTree.add(new Chugimon(1,123));
        if (chugiTree.height() != 1){
          System.out.println("height doesn't work with one node");
          return false;
        }
      }
      // Height of 4
      {
        BSTNode<Chugimon> ivywrath = new BSTNode<>(new Chugimon(2, 62)); // Ivywrath
        BSTNode<Chugimon> bulbther = new BSTNode<>(new Chugimon(1, 123)); // bulbther
        BSTNode<Chugimon> venuth = new BSTNode<>(new Chugimon(3, 52)); // venuth
        BSTNode<Chugimon> bulbdeen = new BSTNode<>(new Chugimon(1, 118)); // bulbdeen
        BSTNode<Chugimon> chardash = new BSTNode<>(new Chugimon(4, 78)); // chardash
        BSTNode<Chugimon> arcadash = new BSTNode<>(new Chugimon(59, 78)); // Arcadash
        ChugiTree chugitree = new ChugiTree();
        chugitree.add(ivywrath.getData());
        chugitree.add(bulbther.getData());
        chugitree.add(venuth.getData());
        chugitree.add(bulbdeen.getData());
        chugitree.add(chardash.getData());
        chugitree.add(arcadash.getData());
        if (chugitree.height() != 4){
          System.out.println("Height doesn't work on a height of 4");
          return false;
        }
      }
    } catch (Exception e){
      System.out.println("testHeight threw an unexpected exception");
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.getFirst() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetFirst() {
    // Empty tree
    {
      ChugiTree chugiTree = new ChugiTree();
      if (chugiTree.getFirst() != null){
        System.out.println("Unexpected answer for getFirst on an empty tree");
        return false;
      }
    }
    // Tree of size 1
    {
      ChugiTree chugiTree = new ChugiTree();
      chugiTree.add(new Chugimon(12,30));
      if (!chugiTree.getFirst().equals(new Chugimon(12,30))){
        System.out.println("Unexpected answer for getFirst on a tree of size 1");
        return false;
      }
    }
    // Tree of height 3
    {
      BSTNode<Chugimon> ivywrath = new BSTNode<>(new Chugimon(2, 62)); // Ivywrath
      BSTNode<Chugimon> bulbther = new BSTNode<>(new Chugimon(1, 123)); // bulbther
      BSTNode<Chugimon> venuth = new BSTNode<>(new Chugimon(3, 52)); // venuth
      BSTNode<Chugimon> bulbdeen = new BSTNode<>(new Chugimon(1, 118)); // bulbdeen
      BSTNode<Chugimon> chardash = new BSTNode<>(new Chugimon(4, 78)); // chardash
      ChugiTree chugitree = new ChugiTree();
      chugitree.add(ivywrath.getData());
      chugitree.add(bulbther.getData());
      chugitree.add(venuth.getData());
      chugitree.add(bulbdeen.getData());
      chugitree.add(chardash.getData());
      if (!chugitree.getFirst().equals(bulbdeen.getData())){
        System.out.println("Unexpected answer for getFirst on a tree of height 3");
        return false;
      }
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.getLast() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetLast() {
    try {
      {
        ChugiTree chugiTree = new ChugiTree();
        if (chugiTree.getLast() != null){
          System.out.println("Unexpected answer for getLast on an empty tree");
          return false;
        }
      }
      // Tree of size 1
      {
        ChugiTree chugiTree = new ChugiTree();
        chugiTree.add(new Chugimon(12,30));
        if (!chugiTree.getLast().equals(new Chugimon(12,30))){
          System.out.println("Unexpected answer for getLast on a tree of size 1");
          return false;
        }
      }
      // Tree of height 3
      {
        BSTNode<Chugimon> ivywrath = new BSTNode<>(new Chugimon(2, 62)); // Ivywrath
        BSTNode<Chugimon> bulbther = new BSTNode<>(new Chugimon(1, 123)); // bulbther
        BSTNode<Chugimon> venuth = new BSTNode<>(new Chugimon(3, 52)); // venuth
        BSTNode<Chugimon> bulbdeen = new BSTNode<>(new Chugimon(1, 118)); // bulbdeen
        BSTNode<Chugimon> chardash = new BSTNode<>(new Chugimon(4, 78)); // chardash
        ChugiTree chugitree = new ChugiTree();
        chugitree.add(ivywrath.getData());
        chugitree.add(bulbther.getData());
        chugitree.add(venuth.getData());
        chugitree.add(bulbdeen.getData());
        chugitree.add(chardash.getData());
        if (!chugitree.getLast().equals(venuth.getData())){
          System.out.println("Unexpected answer for getLast on a tree of height 3");
          return false;
        }
      }
    } catch (Exception e) {
      System.out.println("testGetLast threw an unexpected exception");
    }
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.delete() method. This test must consider at least 3
   * test scenarios. (1) Remove a Chugimon that is at leaf node (2) Remove a Chugimon at non-leaf
   * node. For each of these scenarios, check that the size of the tree was decremented by one and
   * that the resulting ChugiTree is a valid BST, (3) ensures that the ChugiTree.delete() method
   * returns false when called on a Chugimon that is not present in the BST.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testDelete() {
    try {
      BSTNode<Chugimon> ivywrath = new BSTNode<>(new Chugimon(2, 62)); // Ivywrath
      BSTNode<Chugimon> bulbther = new BSTNode<>(new Chugimon(1, 123)); // bulbther
      BSTNode<Chugimon> venuth = new BSTNode<>(new Chugimon(3, 52)); // venuth
      BSTNode<Chugimon> bulbdeen = new BSTNode<>(new Chugimon(1, 118)); // bulbdeen
      BSTNode<Chugimon> chardash = new BSTNode<>(new Chugimon(4, 78)); // chardash
      ChugiTree ct = new ChugiTree();
      ct.add(ivywrath.getData());
      ct.add(bulbther.getData());
      ct.add(venuth.getData());
      ct.add(bulbdeen.getData());
      ct.add(chardash.getData());
      // Deleting a leaf node
      {
        ct.delete(chardash.getData());
        if (ct.size() != 4){
          System.out.println("Deleting leaf node from the tree improperly changed size");
          return false;
        }
        if (!ct.isValidBST()){
          System.out.println("when deleting a leaf node, the tree is no longer a valid BST");
          return false;
        }
      }
      // Deleting a non-leaf node
      {
        ct.add(chardash.getData());
        ct.delete(bulbther.getData());
        if (ct.size() != 4){
          System.out.println("when deleting a non-leaf node, the tree had an improperly changed size");
          return false;
        }
        if (!ct.isValidBST()){
          System.out.println("when deleting a non-leaf node, the tree is no longer a valid BST");
          return false;
        }
      }
      // Deleting a chugimon that isn't present in the tree
      {
        if (ct.delete(new Chugimon(23,92))){
          System.out.println("Delete deleted a nonexistent chugi");
          return false;
        }
        if (ct.size()!=4){
          System.out.println("Delete changed size when deleting a nonexistent chugi");
          return false;
        }
      }
    } catch (Exception e){
      System.out.println("testDelete threw an unexpected exception");
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.next() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testNext() {
    try {
      BSTNode<Chugimon> ivywrath = new BSTNode<>(new Chugimon(2, 62)); // Ivywrath
      BSTNode<Chugimon> bulbther = new BSTNode<>(new Chugimon(1, 123)); // bulbther
      BSTNode<Chugimon> venuth = new BSTNode<>(new Chugimon(3, 52)); // venuth
      BSTNode<Chugimon> bulbdeen = new BSTNode<>(new Chugimon(1, 118)); // bulbdeen
      BSTNode<Chugimon> chardash = new BSTNode<>(new Chugimon(4, 78)); // chardash
      ChugiTree chugiTree = new ChugiTree();
      chugiTree.add(ivywrath.getData());
      chugiTree.add(bulbther.getData());
      chugiTree.add(venuth.getData());
      chugiTree.add(bulbdeen.getData());
      chugiTree.add(chardash.getData());
      // Last chugi
      {
        try {
          chugiTree.next(venuth.getData());
          System.out.println("Next on the last chugi should've thrown an exception");
          return false;
        } catch (NoSuchElementException e){

        } catch (Exception e){
          System.out.println("Next on the last chugi should've thrown a NoSuchElement" +
              "exception instead");
          return false;
        }
      }
      // Middle chugi
      {
        if (!chugiTree.next(ivywrath.getData()).equals(venuth.getData())){
          System.out.println("Next on a middle chugi didn't work as expected");
          return false;
        }
      }
      // Last chugi
      {
        if (!chugiTree.next(bulbdeen.getData()).equals(bulbther.getData())){
          System.out.println("Next on the first chugi didn't work as expected");
          return false;
        }
      }
    } catch (Exception e) {
      System.out.println("testNext threw an unexpected exception");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.previous() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testPrevious() {
    try {
      BSTNode<Chugimon> ivywrath = new BSTNode<>(new Chugimon(2, 62)); // Ivywrath
      BSTNode<Chugimon> bulbther = new BSTNode<>(new Chugimon(1, 123)); // bulbther
      BSTNode<Chugimon> venuth = new BSTNode<>(new Chugimon(3, 52)); // venuth
      BSTNode<Chugimon> bulbdeen = new BSTNode<>(new Chugimon(1, 118)); // bulbdeen
      BSTNode<Chugimon> chardash = new BSTNode<>(new Chugimon(4, 78)); // chardash
      ChugiTree chugiTree = new ChugiTree();
      chugiTree.add(ivywrath.getData());
      chugiTree.add(bulbther.getData());
      chugiTree.add(venuth.getData());
      chugiTree.add(bulbdeen.getData());
      chugiTree.add(chardash.getData());
      // First chugi
      {
        try {
          chugiTree.previous(bulbdeen.getData());
          System.out.println("Previous on the first chugi should've thrown an exception");
          return false;
        } catch (NoSuchElementException e){

        } catch (Exception e){
          System.out.println("Previous on the first chugi should've thrown a NoSuchElement" +
              "exception instead");
          return false;
        }
      }
      // Middle chugi
      {
        if (!chugiTree.previous(ivywrath.getData()).equals(chardash.getData())){
          System.out.println("Previous on a middle chugi didn't work as expected");
          return false;
        }
      }
      // Last chugi
      {
        if (!chugiTree.previous(venuth.getData()).equals(ivywrath.getData())){
          System.out.println("Previous on the last chugi didn't work as expected");
          return false;
        }
      }
    } catch (Exception e){
      System.out.println("testPrevious threw an unexpected exception");
      return false;
    }
    return true;
  }

  /**
   * Calls the test methods
   *
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testChugimonCompareToEquals: " + testChugimonCompareToEquals());
    System.out.println("testChugimonToString(): " + testChugimonToString());
    System.out.println("testIsValidBSTHelper(): " + testIsValidBSTHelper());
    System.out.println("testAddToStringSize(): " + testAddToStringSize());
    System.out.println("testLookup(): " + testLookup());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testCountType(): " + testCountType());
    System.out.println("testGetFirst(): " + testGetFirst());
    System.out.println("testGetLast(): " + testGetLast());
    System.out.println("testDelete(): " + testDelete());
    System.out.println("testNext(): " + testNext());
    System.out.println("testPrevious(): " + testPrevious());
  }

}

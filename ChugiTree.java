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

import java.util.NoSuchElementException;

/**
 * This class implements a ChugidexStorage as a Binary Search Tree.
 *
 * Notes: 1) You may NOT use any arrays or Collections objects (ArrayLists, etc) in this class. 2)
 * You may NOT use any loops (for, while, etc) in this class. Recursive strategies only.
 */
public class ChugiTree implements ChugidexStorage {

  /**
   * The root of this ChugiTree. Set to null when tree is empty.
   */
  private BSTNode<Chugimon> root;

  /**
   * The size of this ChugiTree (total number of Chugimon stored in this BST)
   */
  private int size;

  /**
   * Constructor for Chugitree. Should set size to 0 and root to null.
   */
  public ChugiTree() {
    size = 0;
    root = null;
  }

  /**
   * Getter method for the Chugimon at the root of this BST.
   *
   * @return the root of the BST.
   */
  public Chugimon getRoot() {
    return root.getData(); // default return statement
  }

  /**
   * A method for determining whether this ChugiTree is a valid BST. In order to be a valid BST, the
   * following must be true: For every internal (non-leaf) node X of a binary tree, all the values
   * in the node's left subtree are less than the value in X, and all the values in the node's right
   * subtree are greater than the value in X.
   *
   * @return true if this ChugiTree is a valid BST, false otherwise
   */
  public boolean isValidBST() {
    return isValidBSTHelper(root);
  }

  /**
   * A helper method for determining whether this ChugiTree is a valid BST. In order to be a valid
   * BST, the following must be true: For every internal (non-leaf) node X of a binary tree, all the
   * values in the node's left subtree are less than the value in X, and all the values in the
   * node's right subtree are greater than the value in X.
   *
   * @param node The root of the BST.
   * @return true if the binary tree rooted at node is a BST, false otherwise
   */
  public static boolean isValidBSTHelper(BSTNode<Chugimon> node) {
    if (node == null) {
      return true;
    }
    // false if the max of the left is > than us
    if (node.getLeft() != null && max(node.getLeft()).compareTo(node.getData()) > 0) {
      return false;
    }
    // false if the min of the right is < than us
    if (node.getRight() != null && min(node.getRight()).compareTo(node.getData()) < 0) {
      return false;
    }
    //false if, recursively, the left or right is not a BST
    if (!isValidBSTHelper(node.getLeft()) || !isValidBSTHelper(node.getRight())) {
      return false;
    }

    // passing all that, it's a BST
    return true;
  }

  private static Chugimon max(BSTNode<Chugimon> node) {
    if (node == null) {
      return null;
    }
    Chugimon value = node.getData();
    Chugimon leftMax = node.getData();
    Chugimon rightMax = node.getData();
    //temp Chugimons initialized
    if (node.getLeft() != null) {
      leftMax = max(node.getLeft());
      // if left of node is not null, then re assign
    }
    if (node.getRight() != null) {
      rightMax = max(node.getRight());
      // if right of node is not null, then re assign
    }
    if (value.compareTo(leftMax) >= 0 && value.compareTo(rightMax) >= 0)
      return value;
      //return value left max or rightmax >=0
    else if (leftMax.compareTo(value) >= 0 && leftMax.compareTo(rightMax) >= 0)
      return leftMax;
    else
      return rightMax;
  }

  private static Chugimon min(BSTNode<Chugimon> node) {
    if (node == null) {
      return null;
    }
    Chugimon value = node.getData();
    Chugimon leftMin = node.getData();
    Chugimon rightMin = node.getData();
    // initialize new Chugis to find max
    if (node.getLeft() != null) {
      leftMin = min(node.getLeft());
      // check if node.getLeft is not null, and if so, find the smallest val to the left of it
    }
    if (node.getRight() != null) {
      rightMin = min(node.getRight());
      //check if node.getRIght is not null, and if so , find the biggest val to the right side
    }
    if (value.compareTo(leftMin) <= 0 && value.compareTo(rightMin) <= 0) {
      return value;
    } else if (leftMin.compareTo(value) <= 0 && leftMin.compareTo(rightMin) <= 0) {
      return leftMin;
    } else {
      return rightMin;
      //return the min
    }
  }

  /**
   * Checks whether this ChugiTree is empty or not
   *
   * @return true if this tree is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
    //check if size is 0, if it is, that means it is empty
  }

  /**
   * Gets the size of this ChugiTree
   *
   * @return the total number of Chugimons stored in this tree
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns a String representation of all the Chugimons stored within this ChugiTree in the
   * increasing order with respect to the result of Chugimon.compareTo() method. The string should
   * be a comma-separated list of all the Chugimon toString() values. No spaces are expected to be
   * in the resulting string. No comma should be at the end of the resulting string. For instance,
   *
   * "nameOne#12.25,nameTwo#12.56,nameTwo#89.27"
   *
   * @return a string containing all of the Chugimon, in the increasing order. Returns an empty
   * string "" if this BST is empty.
   */
  @Override
  public String toString() {
    String stringified = toStringHelper(root);
    // remove the last comma if the string has values
    if (stringified.length() > 0) {
      return stringified.substring(0, stringified.length() - 1);
    }
    return stringified;
  }

  /**
   * Recursive helper method which returns a String representation of the ChugiTree rooted at node.
   * An example of the String representation of the contents of a ChugiTree storing three Chugimons
   * is provided in the description of the above toString() method.
   *
   * @param node references the root of a subtree
   * @return a String representation of all the Chugimons stored in the sub-tree rooted at node in
   * increasing order. Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Chugimon> node) {
    if (node == null) {
      return "";
    }
    return toStringHelper(node.getLeft()) + node.getData() + "," + toStringHelper(node.getRight());
  }

  /**
   * Adds a new Chugimon to this ChugiTree. Duplicate Chugimons are NOT allowed.
   *
   * @param newChugimon Chugimon to add to this ChugiTree
   * @return true if if the newChugimon was successfully added to the ChugiTree, false if a match
   * with newChugimon is already present in the tree.
   * @throws IllegalArgumentException with a descriptive error message if newChugimon is null.
   */
  @Override
  public boolean add(Chugimon newChugimon) throws IllegalArgumentException {
    if (newChugimon == null) {
      throw new IllegalArgumentException("Chugimon to add is null");
      //exception if param input is null
    }
    if (root == null) {
      root = new BSTNode<>(newChugimon);
      //update root if its null and increase size
      size++;
      return true;
    } else {
      if (addHelper(newChugimon, root)) {
        size++;
        //use add helper and return true or false;
        return true;
      } else {
        return false;
      }
    }
  }

  /**
   * Recursive helper method to insert a new Chugimon to a Pokedex rooted at node.
   *
   * @param node        The "root" of the subtree we are inserting the new Chugimon into.
   * @param newChugimon The Chugimon to be added to a BST rooted at node. We assume that newChugimon
   *                    is NOT null.
   * @return true if the newChugimon was successfully added to the ChugiTree, false if a match with
   * newChugimon is already present in the subtree rooted at node.
   */
  protected static boolean addHelper(Chugimon newChugimon, BSTNode<Chugimon> node) {
    if (newChugimon.compareTo(node.getData()) < 0) {
      if (node.getLeft() == null) {
        node.setLeft(new BSTNode<>(newChugimon));
        //nested if to compare newChugimon to the data at a gien node and then if the node's left is null, return true
        return true;
      } else {
        return addHelper(newChugimon, node.getLeft());
        //recursively move and add
      }
    } else if (newChugimon.compareTo(node.getData()) > 0) {
      if (node.getRight() == null) {
        node.setRight(new BSTNode<>(newChugimon));
        return true;
        //nested if to do the same for the right side
      } else {
        return addHelper(newChugimon, node.getRight());
        //recursively move until you can add at the right place
      }
    }
    return false;
    //false if a match with newChugimon is already present in the subtree rooted at node.
  }

  /**
   * Searches a Chugimon given its first and second identifiers.
   *
   * @param firstId  First identifier of the Chugimon to find
   * @param secondId Second identifier of the Chugimon to find
   * @return the matching Chugimon if match found, null otherwise.
   */
  @Override
  public Chugimon lookup(int firstId, int secondId) {
    Chugimon search = new Chugimon(firstId, secondId);
    return lookupHelper(search, root);
    //declare local chugimon to use in lookup helper
  }

  /**
   * Recursive helper method to search and return a match with a given Chugimon in the subtree
   * rooted at node, if present.
   *
   * @param toFind a Chugimon to be searched in the BST rooted at node. We assume that toFind is NOT
   *               null.
   * @param node   "root" of the subtree we are checking whether it contains a match to target.
   * @return a reference to the matching Chugimon if found, null otherwise.
   */
  protected static Chugimon lookupHelper(Chugimon toFind, BSTNode<Chugimon> node) {
    if (node != null) {
      if (toFind.equals(node.getData()))
        return node.getData();
        //if toFind is identical to the node.getdata, return
      else if (toFind.compareTo(node.getData()) < 0)
        return lookupHelper(toFind, node.getLeft());
        //recursively move left
      else
        return lookupHelper(toFind, node.getRight());
      //recursively move right
    }
    return null;
  }

  /**
   * Computes and returns the height of this BST, counting the number of NODES from root to the
   * deepest leaf.
   *
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(root); // Default return statement
    //use heightHelper on root since you want height of the whole BST
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at node counting the
   * number of nodes and NOT the number of edges from node to the deepest leaf
   *
   * @param node root of a subtree
   * @return height of the subtree rooted at node
   */
  protected static int heightHelper(BSTNode<Chugimon> node) {
    if (node == null) {
      return 0;
      //if node is null means there is no root
    }
    int leftHeight = heightHelper(node.getLeft());
    int rightHeight = heightHelper(node.getRight());
    //left height and rightHeight new integers declare for recursive func
    if (leftHeight > rightHeight) {
      return leftHeight + 1;
      //if left is greater than right, return lefth +1
    } else {
      return rightHeight + 1;
      // otherwise do the same with righth
    }
  }

  /**
   * Recursive method to find and return the first Chugimon, in the increasing order, within this
   * ChugiTree (meaning the smallest element stored in the tree).
   *
   * @return the first element in the increasing order of this BST, and null if the tree is empty.
   */
  @Override
  public Chugimon getFirst() {
    return getFirstHelper(root); // default return statement
    //use it on root since it encompasses all nodes in the BST since it is the one ancestor for all of them
  }

  /**
   * Recursive helper method for getFirst().
   *
   * @param root the node from which to find the the minimum node
   * @return the minimum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getFirstHelper(BSTNode<Chugimon> root) {
    if (root == null) {
      return null;
      //if root is null, means there is no first, so return null
    }
    if (root.getLeft() == null) {
      return root.getData();
      //return root if the left is null, since there is nothing less than root
    }
    return getFirstHelper(root.getLeft()); // default return statement
    //recursively find left and see if the next left is null and if so, return node
  }

  /**
   * Recursive method to find and return the last Chugimon, in the increasing order, within this
   * ChugiTree (meaning the greatest element stored in the tree).
   *
   * @return the last element in the increasing order of this BST, and null if the tree is empty.
   */
  @Override
  public Chugimon getLast() {
    return getLastHelper(root); // default return statement
    //use on root since root is the ancestor and encompasses all nodes in the BST
  }

  /**
   * Recursive helper method for getLast().
   *
   * @param root the node from which to find the the maximum node
   * @return the maximum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getLastHelper(BSTNode<Chugimon> root) {
    if (root == null) {
      return null;
      //if root is null, means there is no BST, so return null
    }
    if (root.getRight() == null) {
      return root.getData();
      //return root.getData if there is nothing greater than the root
    }
    return getLastHelper(root.getRight()); // default return statement
    //recursively move right and check if the next right is null, and if so, return node.
  }

  /**
   * Recursive method to get the number of Chugimon with a primary or secondary type of the
   * specified type, stored in this ChugiTree.
   *
   * @param chugiType the type of Chugimons to count. We assume that chugiType is NOT null.
   * @return the number of all the Chugimon objects with a primary or secondary type of the
   * specified type stored in this ChugiTree.
   */
  public int countType(ChugiType chugiType) {
    return countTypeHelper(chugiType, root);
    //run on countType helper with the input and the root
  }

  protected static int countTypeHelper(ChugiType chugiType, BSTNode<Chugimon> node) {
    if (node == null) {
      return 0;
      //check if BST is empty, if it is , make return 0
    }
    if (node.getData().getPrimaryType().equals(chugiType)) {
      return 1 + countTypeHelper(chugiType, node.getLeft()) + countTypeHelper(chugiType,
          node.getRight());
      //return 1 + the recursive of the left and right countType helper
    } else if (node.getData().getSecondaryType() != null) {
      if (node.getData().getSecondaryType().equals(chugiType)) {
        return 1 + countTypeHelper(chugiType, node.getLeft()) + countTypeHelper(chugiType,
            node.getRight());
        //same for secondary type
      }
    }
    return countTypeHelper(chugiType, node.getLeft()) + countTypeHelper(chugiType, node.getRight());
    //return both the leftside and right side count
  }

  /**
   * Finds and returns the in-order successor of a specified Chugimon in this ChugiTree
   *
   * @param chugi the Chugimon to find its successor
   * @return the in-order successor of a specified Chugimon in this ChugiTree
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   * @throws NoSuchElementException   with a descriptive error message if the Chugimon provided as
   *                                  input has no in-order successor in this ChugiTree.
   */
  @Override
  public Chugimon next(Chugimon chugi) throws IllegalArgumentException, NoSuchElementException {
    if (chugi == null) {
      throw new IllegalArgumentException("chugi is null");
    }
    if (chugi.equals(getLast())) {
      throw new NoSuchElementException("This is the last chugi");
      //exception handle for if chugi is null or is the last, which means that there cannot be a next
    }
    return nextHelper(chugi, root, null);
    //run on the chugi, from root to null
  }

  /**
   * Recursive helper method to find and return the next Chugimon in the tree rooted at node.
   *
   * @param chugi a Chugimon to search its in-order successor. We assume that
   *              <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param next  a BSTNode which stores a potentional candidate for next node
   * @return the next Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the Chugimon provided as
   *                                input has no in-order successor in the subtree rooted at node.
   */
  protected static Chugimon nextHelper(Chugimon chugi, BSTNode<Chugimon> node, BSTNode next) {
    // Hint: you will need to use getFirstHelper in this method. Below are
    // additional hints.

    // base case: node is null
    if (node == null) {
      return (Chugimon) next.getData();
      //if node is null, return the next.getdata
    }
    // recursive cases:
    // (1) if chugi is found and if the right child is not null, use getFirstHelper
    // to find and
    // return the next chugimon. It should be the left most child of the right
    // subtree
    if (node.getData().equals(chugi)) {
      if (node.getRight() != null) {
        return getFirstHelper(node.getRight());
      }
    } else if (chugi.compareTo(node.getData()) < 0) {
      return nextHelper(chugi, node.getLeft(), node);
    } else if (chugi.compareTo(node.getData()) > 0){
      return nextHelper(chugi, node.getRight(), node);
    }
    // (2) if chugi is less than the Chugimon at node, set next as the root node and
    // search
    // recursively into the left subtree

    return (Chugimon) next.getData();
  }

  /**
   * Finds and returns the in-order predecessor of a specified Chugimon in this ChugiTree
   *
   * @param chugi the Chugimon to find its predecessor
   * @return the in-order predecessor of a specified Chugimon in this ChugiTree.
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   * @throws NoSuchElementException   if there is no Chugimon directly before the provided Chugimon
   */
  @Override
  public Chugimon previous(Chugimon chugi) throws IllegalArgumentException, NoSuchElementException{
    if (chugi == null) {
      throw new IllegalArgumentException("chugi is null");
      //check if chugi is null and if so, there is no previous
    }
    if (chugi.equals(getFirst())) {
      throw new NoSuchElementException("This is the first chugi");
      //if chugi is first then there is no previous
    }
    return previousHelper(chugi, root, null);
    //run previousHelper with chugi, root, and null
  }

  /**
   * Recursive helper method to find and return the previous Chugimon in the tree rooted at node.
   *
   * @param chugi a Chugimon to search its in-order predecessor. We assume that
   *              <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param prev  a BSTNode which stores a potentional candidate for previous node
   * @return the previous Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the Chugimon provided as
   *                                input has no in-order predecessor in the subtree rooted at
   *                                node.
   */
  protected static Chugimon previousHelper(Chugimon chugi, BSTNode<Chugimon> node,
      BSTNode<Chugimon> prev) {
    // Hint: you will need to use getLastHelper in this method. Below are more
    // hints.

    // base case: node is null
    if (node == null) {
      return prev.getData();
    }
    // base case

    // if a node with the desired value is found, the predecessor is the maximum
    // value node in its left subtree (if any)
    if (node.getData().equals(chugi)) {
      if (node.getLeft() != null) {
        return getLastHelper(node.getLeft());
      }
    }

    // if the given key is less than the root node, recur for the left subtree
    else if (chugi.compareTo(node.getData()) > 0) {
      return previousHelper(chugi, node.getRight(), node);
    }
    else if (chugi.compareTo(node.getData()) < 0) {
      return previousHelper(chugi, node.getLeft(), node);
    }
    return prev.getData();
    // recursive cases:
    // (1) if chugi is found and if the left child is not null, use getLastHelper to
    // find and return
    // the previous chugimon. It should be the right most child of the left subtree

    // (2) if chugi is greater than the Chugimon at node, set prev as the root node
    // and search
    // recursively into the right subtree

  }

  /**
   * Deletes a specific Chugimon from this ChugiTree.
   *
   * @param chugi the Chugimon to delete
   * @return true if the specific Chugimon is successfully deleted, false if no match found with any
   * Chugimon in this tree.
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   */
  @Override
  public boolean delete(Chugimon chugi) throws IllegalArgumentException{
    if (chugi == null) {
      throw new IllegalArgumentException("chugi is null");
      //cannot delete a chugi that is null
    }
    try {
      deleteChugimonHelper(chugi, root);
      size--;
      //use deletehelper to remove and decrement size
    } catch (NoSuchElementException e) {
      return false;
      //handle exception
    }
    return true;
  }

  /**
   * Recursive helper method to search and delete a specific Chugimon from the BST rooted at node
   *
   * @param target a reference to a Chugimon to delete from the BST rooted at node. We assume that
   *               target is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a match with the target
   *               Chugimon.
   * @return the new "root" of the subtree we are checking after trying to remove target
   * @throws NoSuchElementException with a descriptive error message if there is no Chugimon
   *                                matching target in the BST rooted at <b>node</b>
   */
  protected static BSTNode<Chugimon> deleteChugimonHelper(Chugimon target, BSTNode<Chugimon> node)
      throws NoSuchElementException {
    // hints are provided in the comments below
    // if node == null (empty subtree rooted at node), no match found, throw an
    // exception
    if (node == null) {
      throw new NoSuchElementException("node is null");
    }
    // Compare the target to the data at node and proceed accordingly
    // Recurse on the left or right subtree with respect to the comparison result
    // Make sure to use the output of the recursive call to appropriately set the
    // left or the right child of node accordingly
    if (target.compareTo(node.getData()) < 0) {
      node.setLeft(deleteChugimonHelper(target, node.getLeft()));
    } else if (target.compareTo(node.getData()) > 0) {
      node.setRight(deleteChugimonHelper(target, node.getRight()));
    }
    // if match with target found, three cases should be considered. Feel free to
    // organize the order of these cases at your choice.
    else if (target.equals(node.getData())) {
      // Case 1: node may be a leaf (has no children), set node to null.
      if (node.getLeft() == null && node.getRight() == null) {
        node = null;
      }
      // Case 2: node may have only one child, set node to that child (whether left or
      // right child)
      else if (node.getLeft() != null && node.getRight() == null) {
        node = node.getLeft();
      } else if (node.getLeft() == null && node.getRight() != null) {
        node = node.getRight();
      }
      // Case 3: node may have two children,
      // Replace node with a new BSTNode whose data field value is the successor of
      // target in the tree, and having the same left and right children as node.
      // Notice carefully that you cannot set the data of a BSTNode. Hint: The
      // successor is the smallest element at the right subtree of node
      //
      // Then, remove the successor from the right subtree. The successor must have up
      // to one child.
      else if (node.getLeft() != null && node.getRight() != null) {
        Chugimon successor = getFirstHelper(node.getRight());
        BSTNode<Chugimon> leftNode = node.getLeft();
        BSTNode<Chugimon> rightNode = node.getRight();
        node = new BSTNode<>(successor);
        node.setLeft(leftNode);
        node.setRight(rightNode);
        node.setRight(deleteChugimonHelper(node.getData(), node.getRight()));
      }
      // Make sure to return node (the new root to this subtree) at the end of each
      // case or at the end of the method.
    }
    return node;
  }

}

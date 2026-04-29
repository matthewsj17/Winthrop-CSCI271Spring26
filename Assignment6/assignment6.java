/*************************************************************************
* Project 6 for CSCI 271-001 Spring 2026
*
* Author: Jake Matthews
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: April 23rd, 2026
*
* Purpose
* This program reads a list of scores from an input file, counts how many
* scores there are in the list, and computes their sum and average.
*
*************************************************************************/

/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Jake Matthews
********************************************************************/



// Java Program to Implement a Generic Binary Tree

// Importing all input output classes
import java.io.*;
import java.util.Scanner;
import java.lang.Math; // we need this for max and min functions.

// BinaryTree Class: ( Generic BinaryTree class)
//                   T extends Comparable<T> to allow the use of compareTo() to compare element generically !!
class BinaryTree<T extends Comparable<T>> { 

  // Encapsulation: Node is a private nested class to hide implementation details.
  private static class Node<T> {
    T element;     // Data element to sore an item
    Node<T> left;  // a reference to the left subtree
    Node<T> right; // a reference to the right subtree

    // Parameterized constructor to assign a value
    Node(T item) {
      this.element = item; // "this" refers to current object itself
      this.right = null;
      this.left = null;
    }
  }

  // Generic Node instance in the Generic BinaryTree Class
  private Node<T> root;

  BinaryTree(){ // Default constructor
    this.root = null; // a reference to the root node
  } 

  // ********************************** isEmpty() **********************************
  public boolean isEmpty(){ // a method to check if the tree is empty
    return (this.root == null);
  }

  // ********************************** size() **********************************
  //
  // STUDENTS MUST IMPLEMENT THIS METHOD!!!!
  public int size(){ // a method to return the number of elements in the tree
    // System.out.println("BinaryTree.size() method has not been implemented yet!!!!");
    // return -1;
    return sizeRecursively(this.root); // call private one
  }
// this may be wrong i'm just spitballing here -Jake 1:36pm 4/21/26
// no way sweet it works. -Jake 1:43pm 4/21/26

// ADD THING

/*****************************sizeRecursively(Node<T> root)>****************************
 * Description: searches through the tree, and calculates the size of the tree. (# of nodes)
 *
 * Parameters: Node<T> root, the 'root' of the tree structure
 *
 * Pre: a tree must be created, and the root supplied to the function.
 *
 * Post: the tree's size will be calculated recursively and returned to the user.
 *
 * Returns: an int that is the size of the tree data structure.
 * 
 * Called by: size(), sizeRecursively()
 * Calls: sizeRecursively()
 ************************************************************************/
  private int sizeRecursively(Node<T> root){
    int size = 0; // initiallize a basic size value as 0
    if(root!=null){ // if the root isn't null, IE the tree exists, 
      size = sizeRecursively(root.left) + sizeRecursively(root.right) + 1; // we add one to the size of both children.
    }
    return size; // if we hit the bottom, we return the size back!
  }


  /*****************************getMax()****************************
 * Description: searches through the tree, and finds the maximum value present in it
 *
 * Parameters: N/A
 *
 * Pre: a tree must be created.
 *
 * Post: the tree's maximum value will be returned to the user
 *
 * Returns: a type T that is the maximum value in the tree data structure.
 * 
 * Called by: n/a
 * Calls: getMaxRecursively()
 ************************************************************************/
  public T getMax(){ // the 'public interface' of the recursive function
    return getMaxRecursively(this.root); // call the private function that can access the node class stuff.
   
  }


/*****************************getMaxRecursively(Node<T> root)>****************************
 * Description: searches through the tree, and finds the maximum value present in it
 *
 * Parameters: Node<T> root, the 'root' of the tree structure
 *
 * Pre: a tree must be created, and the root supplied to the function.
 *
 * Post: the tree's maximum value found recursively and returned to the user.
 *
 * Returns: a type T that is the maximum value in the tree data structure.
 * 
 * Called by: getMax(), getMaxRecursively()
 * Calls: getMaxRecursively()
 ************************************************************************/
  private T getMaxRecursively(Node<T> root){
    // since the highest value is stored in the bottom right of the tree, we just increment to it!
    if(root.right == null){  // there's nothing to the right, we're at the highest value
      return root.element; // assign it to the Max, and return it.
    }
    else{ // if there is an element to the right, we go to it recursively!
      return getMaxRecursively(root.right);
    }
  }

   /*****************************getMin()****************************
 * Description: searches through the tree, and finds the minimum value present in it
 *
 * Parameters: N/A
 *
 * Pre: a tree must be created.
 *
 * Post: the tree's minimum value will be returned to the user
 *
 * Returns: a type T that is the minimum value in the tree data structure.
 * 
 * Called by: n/a
 * Calls: getMinRecursivelyJake()
 ************************************************************************/
  public T getMin(){
    return getMinRecursivelyJake(this.root); // call private functions
   
  }

  /*****************************getMinRecursivelyJake()****************************
 * Description: searches through the tree, and finds the minimum value present in it
 *
 * Parameters: N/A
 *
 * Pre: a tree must be created.
 *
 * Post: the tree's minimum value will be returned to the user
 *
 * Returns: a type T that is the minimum value in the tree data structure.
 * 
 * Called by: getMin()
 * Calls: getMinRecursivelyJake()
 ************************************************************************/
// named because getMinRecursively was already defined below, 
// not sure if i needed to create my own or not so i did!
  private T getMinRecursivelyJake(Node<T> root){ 
    if(root.left == null){ // if there is no left child to the root, then we are at the lowest value!
      return root.element; // return it to the user!
    }
    else{ // otherwise, we move to the child on the left and compare again!
      return getMinRecursivelyJake(root.left);
    }
  }
  





  // ********************************** height() **********************************
  //
  // this is a public method that delegates the height calculation to a private, recursive method
  public int height(){
    return heightRecursively(this.root);
  }
 
  // a private method to recursively calculate the height 
  private int heightRecursively(Node<T> root){
    int h = -1;
    if(root!=null)
      h = Math.max(heightRecursively(root.left),heightRecursively(root.right)) + 1;
    return h;
  }

  // ********************************** insert() **********************************
  //
  // this is a public method that delegates the insertion process to a private, recursive method
  public void insert(T item){ 

    this.root = insertRecursively(this.root, item);
  }

  // a private method to recursively place the item in the tree
  private Node<T> insertRecursively(Node<T> root, T item){

    if(root == null){
      root = new Node<T>(item);
    }else{
      int r = item.compareTo(root.element);
      if(r < 0){
        root.left = insertRecursively(root.left, item);
      }else if(r > 0){
        root.right = insertRecursively(root.right, item);
      }else{
        System.out.print(item+" already exists in the tree, no duplicates allowed!!\n");
      }
    }
    return root;
  }

  // ********************************** displayAll() **********************************

  // this is a public method that delegates the display process to a private, recursive method
  public void displayAll(){ 
    System.out.println("displayAll():");
    if (this.isEmpty()){
      System.out.println("The tree is empty ...! ");
    }else{
      System.out.println("____________Tree of "+this.size()+" items________________");
      showInorder(this.root);
    }
    System.out.println();
  }

  // a private method to recursively display items in the tree inOrder
  private void showInorder(Node<T> root){
    if(root!=null){
      showInorder(root.left);
      System.out.print(root.element+" ");
      showInorder(root.right);
    }  
  }

  // ********************************** Find(T item) **********************************
  //
  // STUDENTS MUST IMPLEMENT THIS METHOD!!!!

  public boolean find(T item){
    // System.out.println("BinaryTree.find() method has not been implemented yet!!!!");
    // return false;
    return findRecursively(root, item); // call private function
  }

 /*****************************findRecursively()****************************
 * Description: searches through the tree, and attempts to find a value 
 * the user supplies
 * 
 * Parameters: Node<T> root, and T item
 *
 * Pre: a tree must be created, and a valid item must be supplied to find
 *
 * Post: a boolean of if the value is in the tree will be returned to the user
 *
 * Returns: a boolean, true if the item is in the tree, false if otherwise.
 * 
 * Called by: find()
 * Calls: findRecursively()
 ************************************************************************/
  private boolean findRecursively(Node<T> root, T item){
    boolean returnVal = false; // default to false.

    if(root == null) // if the root is null, then we didn't find the item in the tree.
      returnVal = false;
    else if(root.element == item){ // if the element is the item, we've found it!
      returnVal = true;;
    }
    else{
      int compareVal = item.compareTo(root.element); // compare the item to the element
      if(compareVal < 0){ // if its less than 0, we need to look left!
        returnVal = findRecursively(root.left, item);
      }
      else if(compareVal > 0){ // if its greater than 0, we need to look right!
        returnVal = findRecursively(root.right, item);
      }
      else{ // if its not the same, and not any smaller or larger, than its just not there.
        returnVal = false; // may be redundant?
      }
    }
    return returnVal; // return value to user.
  }

  // ********************************** delete(T item) **********************************

  // this is a public method that delegates the deletion process to a private, recursive method
  public void delete(T item){
    this.root = deleteRecursively(this.root, item);
  }

  // a private method to recursively delete item from the tree
  private Node<T> deleteRecursively(Node<T> root, T item){

    if(root!=null){
      int r = item.compareTo(root.element);

      if(r < 0)
        root.left = deleteRecursively(root.left, item);
      else if(r > 0)
        root.right = deleteRecursively(root.right, item);
      else{

        //case 1: the root node is a leaf node
        if(root.left==null && root.right==null){
          root = null; // delete the current node safely

        // case 2: the root node has one child (on left then on right)
        }else if(root.right==null)
          root = root.left;
        else if(root.left==null)
          root = root.right;
   
        // case 3: the root node has two children
        else {
          T minItem = getMinRecursively(root.right);
          root.element = minItem;
          root.right = deleteRecursively(root.right,minItem);
        }
        System.out.println(item+" was deleted form the tree.");
      }
    }
    return root;
  }

  private T getMinRecursively(Node<T> root){
    T item = null;
    if(root.left==null)
      item = root.element;
    else
      item = getMinRecursively(root.left);
    return item;
  }
}

// The class for the Main Program
public class assignment6 {

  public static void main(String[] args) { // The main() method

    BinaryTree<Integer> tree = new BinaryTree<>();
    Integer ch, item, index;
    boolean quit = false;

    Scanner sc = new Scanner(System.in);

    do{
  
      System.out.println( "____________Main Menu_____________________");
      System.out.println( "select option :");
      System.out.println( "1: insert item");
      System.out.println( "2: find item");
      System.out.println( "3: tree height");
      System.out.println( "4: display items");
      System.out.println( "5: delete item");
      System.out.println( "6: display max item");
      System.out.println( "7: display min item");
      System.out.println( "8: display tree size");
      System.out.println( "9: exit");
      ch = sc.nextInt();

      switch (ch) {
        case 1:
          System.out.println( "enter item to insert:");
          item = sc.nextInt(); // read in an integer
          tree.insert(item);
          break;
        case 2:
          System.out.println( "enter item to insert:");
          item = sc.nextInt(); // read in an integer
          if(tree.find(item))
            System.out.println(item+" is found in the tree!");
          else
            System.out.println("Sorry... "+item+" is NOT found in the tree!");
          break;
        case 3:
          System.out.println("The height of the tree is: "+tree.height());
          break;
        case 4:
          tree.displayAll();
          break;
        case 5:
          System.out.println( "enter item to delete:");
          item = sc.nextInt(); 
          tree.delete(item);
          break;
        case 9:
          quit = true;
          System.out.println( "Goodbye!!");
          break;

        // Case's I'm adding.
        case 6:
          System.out.println("The max value in the tree is: "+tree.getMax());
          break;
        case 7:
          System.out.println("The min value in the tree is: "+tree.getMin());
          break;
        case 8:
          System.out.println("The size of the tree is: "+tree.size());
          break;

        default:
          System.out.println( "invalid selection");
      }
    } while(!quit);
  }
}

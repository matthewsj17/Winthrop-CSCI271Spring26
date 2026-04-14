// Java Program to Implement Generic Linked List

// Importing all input output classes
import java.io.*;
import java.util.Scanner;

// Node Class: (Generic Node class for LinkedList)
class Node<T> {
  private T element; // Data element to sore an item
  private Node<T> next; // a reference to the next Node

  // Parameterized constructor to assign value
  Node(T item) {
    this.element = item; // "this" refers to current object itself
    this.next = null;
  }

  void setNext(Node<T> n){ // set the private memeber
    this.next = n;
  }

  Node<T> getNext(){ //get the private member
    return this.next;
  }

  void setElement(T item){ // set the private memeber
    this.element = item;
  }

  T getElement(){ //get the private member
    return this.element;
  }

  public void displayRecursively(){ // display Node recursively
    System.out.print(this.getElement());
    if (this.next != null){
      System.out.print(" , ");
      this.next.displayRecursively();
    } else {
      System.out.println("] ");
    }
  }
}

// List Class: ( Generic LinkedList class)
class List<T extends Comparable<? super T>> {

  // Generic Node instance
  private Node<T> head;
  private int size; // store the size of the list

  List(){ // Default constructor
    this.head = null; // a reference ot the head node
    this.size = 0;    // maintain the size of the list
  } 

  // ********************************** isEmpty() **********************************
  boolean isEmpty(){ // a method to check if the List is empty
    return (this.head == null);
  }

  // ********************************** addLast() **********************************
  void addLast(T item) { // add a Node containing item at the end of List
    Node<T> newNode = new Node<>(item); // create a new Node with the given item

    if(this.head == null){ // Check if the head 
      head = newNode;
    } else {
      Node<T> temp = this.head; // create a temporary reference to the first node in the list

      while (temp.getNext() != null) { // move the reference to the last node
        temp = temp.getNext();
      }
      temp.setNext(newNode); // link the last node to the new node referenced by newNode 
    }
    this.size++; // update the size of the list
  }

  // ********************************** addFront() **********************************
  void addFront(T item){ //a method to add an item at the front of the list
    Node<T> newNode = new Node<>(item); // create a new Node with the given item
    newNode.setNext(this.head);
    this.head = newNode;
    this.size++;
    System.out.println("new node added at front !");
  }

  // ********************************** addAt() **********************************
  void addAt (int index, T item) { // add item in a new Node at index position

    // Checking if position is valid
    if (index < 0 || index >= this.size ) {
      System.out.println("index is out of bound !");
    } else {
      Node<T> newNode = new Node<>(item); // create a new Node with the given item

      int count = 0;  // start a counter
      Node<T> temp = head; // create a temporary Node reference
      while(temp != null && count < index-1){ // move to index position
        count++;
        temp = temp.getNext();
      }
      if(index >0){
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
      }else if( index == 0) {
        newNode.setNext(this.head);
        this.head = newNode;
      }
      System.out.println("new node added at index "+ index);
    }
  }

  // ********************************** size() **********************************
  public int size(){ // a method to return the number of elements in the lsit
    return this.size;
  }

  // ********************************** displayAll() **********************************
  public void displayAll(){ // Method to display the LinkedList

    System.out.println("displayAll():");
    System.out.println("____________List of "+this.size+" items________________");

    if (this.isEmpty()){
      System.out.println("The list is empty ...! ");
    } else {
      Node<T> temp = this.head;
      System.out.print("[ ");
      while(temp != null){
        System.out.print(temp.getElement());
        if(temp.getNext() == null)
          System.out.println("] ");
        else
          System.out.print(" , ");
        temp = temp.getNext();
      }
    }  
    System.out.println();
  }

  // ********************************** displayRecursively() **********************************
  public void displayRecursively(){
    System.out.println("displayRecursively():");
    System.out.println("____________List of "+this.size+" items________________");
    if (this.isEmpty()){
      System.out.println("The list is empty ...! ");
    } else {
      System.out.print("[ ");
      this.head.displayRecursively();
    }
    System.out.println();
  }

  // ********************************** removeLast() **********************************
  public void removeLast(){
    if(this.isEmpty()){
      System.out.println("The list is empty !");
    } else if(this.head.getNext() == null){
      this.head = null;
      this.size--;    // update the size
      System.out.println("last item removed");
    } else {
      Node<T> temp = this.head;
      
      while((temp.getNext() != null) && (temp.getNext().getNext() != null)){
        temp = temp.getNext();
      }
      temp.setNext(null);
      temp = null;
      this.size--;        // update teh size
      System.out.println("last item removed");
    }
  }

  // ********************************** removeAt() **********************************
  public void removeAt(int index){
    if(this.isEmpty()){ // check the empty list
      System.out.println("The list is empty !");
    } else if(index >= this.size || index < 0){ // check index is valid
      System.out.println("index is out of bound !");
    } else if (index == 0){ // remove the first Node
      this.head = this.head.getNext();
      this.size--;
      System.out.println("item is removed at index "+index);
    } else{ // remove other than the first node
      int count = 0;
      Node<T> temp = this.head;

      while(count < index-1){ // search for the node at position index
        count++;
        temp = temp.getNext();
      }

      Node<T> pNode = temp.getNext(); // hold on to that node temporarily 
      temp.setNext(pNode.getNext());  // hold on to that node temporarily 
      pNode.setNext(null);            // disconnect that node form the list
      this.size--;                    // update the size
      System.out.println("item is removed at index "+index);
    }
  }

  // ********************************** removeFront() **********************************
  public void removeFront(){
    if(this.isEmpty()){
      System.out.println("The list is empty !");
    }else{
      Node<T> temp = this.head;
      this.head = this.head.getNext();
      temp.setNext(null);
      System.out.println("front item removed");
    }
  }

  // ********************************** getAt() **********************************
  T getAt(int index){
    T res = null;
    if (this.isEmpty()){
      System.out.println("The list is empty !");
    } else if (index >= this.size || index < 0){
      System.out.println("index is out of bound !");
    } else if (index == 0) {
      res = this.head.getElement();
    } else {
      int count = 0;
      Node<T> temp = this.head;

      while(count++ != index){ // search for the node at position index
        temp = temp.getNext();
      }
      res = temp.getElement();
    }
    return res;
  }

  // CODE THAT I AM ADDING, 


  /*****************************<splitAt()>****************************
  * Description: takes a list, and splits it into two seperate list
  *
  * Parameters: and integer index is supplied
  *
  * Pre: a list is created and an index is supplied.
  *
  * Post: the list is split into two, and the second portion is returned to the user
  *
  * Returns: returns the second list, and alters the first in place.
  *
  * Called by: InsertionSort()
  * Calls: isEmpty(), getNext(), setNext()
  ************************************************************************/
  public List<T> splitAt(int index){
    // Add some sort of size checking??

    // If empty, say that!
    if(this.isEmpty()){
      System.out.println("The list is empty ...! ");
      return null;
    }
    // If index out of bounds, say that!
    if(index > this.size()-1 || index < 0){
      System.out.println("Index out of bounds!! ");
      return null;
    }
  
    Node<T> curr = this.head; // set curr to head of list
    
    // Increment to position in list.
    for(int i = 0; i < index-1; i++){
      curr = curr.getNext();
    }

    // Assign the next value to the head of a new list.
    List<T> NL = new List<T>(); // create new list
    NL.head = curr.getNext(); // assign the beginning of the new list to the node after the split point

    // Kill the old list at the value, effectively splitting it.
    curr.setNext(null); // curr->next (Original List) is now null, removing the tail that is now NL from the original list.

    Node<T> newCurr = NL.head; // create a 2nd curr with the new list
    Node<T> temp = this.head; // create a temp value for the old list so we save curr.

    // find the list's new size.
    int count = 0; 
    // increment temp to the end of the list,
    while(temp != null){
      count++; // incrementing count every time 
      temp = temp.getNext();
    }
    this.size = count; // set the size to the new size.
    // find the NL size.

    // find L2's size
    count = 0; // reset count

    // increment newCurr until the end of the list
    while(newCurr != null){
      count++; // incrementing count every time
      newCurr = newCurr.getNext(); 
    }
    NL.size = count; // set this to the size!
    
    return NL; // return the new list to the user!
  }
    

  /*****************************<insertSorted()>****************************
  * Description: takes a list and sorts it in ascending order
  *
  * Parameters: item, of type T.
  *
  * Pre: a list must be created, and already in sorted order.
  *
  * Post: the item is inserted into the list in ascending order.
  *
  * Returns: returns nothing, but alters the list in place
  *
  * Called by: InsertionSort()
  * Calls: addFront(), getElement(), Node(), setNext(), getNext()
  ************************************************************************/
  void insertSorted(T item) { 

      // [11,22,33,44,55,66,77,88]

    // if the list is empty, we just insert at the front. 
    if(head == null){
      addFront(item);
    }

    // otherwise...
    else{
      // add item in a new Node at sorted position
      Node<T> nodeToSort = new Node<>(item); // create new node
      T sortVal = nodeToSort.getElement(); // isolate the value for easier access

      Node<T> curr = this.head; // create curr to increment through the list.
      Node<T> temp = curr; // create temp to hold addresses
      boolean quit = false; // use a boolean variable to keep turn loops on and off.
       
      // continually loop
      while(!quit){
         
        // use a switch to compare the sortVal to the current value!
        switch(sortVal.compareTo(curr.getElement())){ 
        
          case -1: // the item is smaller than the curr, IE we need to insert here!

            // if curr points to the head, we just add to the front.
            if(curr == this.head){
              addFront(item);
            }
            // otherwise,
            else{
            nodeToSort.setNext(curr); // set the next of the node to curr
            temp.setNext(nodeToSort); // set the next of the temp pointer (a tail of sorts) to the nodes.
            }
            quit = true; // either case will result in node insertion, so we can stop looping
            break;
        
          case 0: // the item is equal to the curr, so we insert here!

            // if curr points to the head, we just add to the front.
            if(curr == this.head){
              addFront(item);
            }
            // otherwise,

            else{
            nodeToSort.setNext(curr); // set the next of the node to curr
            temp.setNext(nodeToSort); // set the next of the temp pointer (a tail of sorts) to the nodes
            }
            quit = true; // either case will result in node insertion, so we can stop looping
            break;

          case 1: // the item is less than curr, so we increment!

            if(curr.getNext() == null){ // if its the last item, we insert the nodeToSort last.
              nodeToSort.setNext(curr.getNext()); // set the next to curr's next, or null
              curr.setNext(nodeToSort); // set the final nodes next pointer to the new node.
              quit = true; // we can quit now!
            }
            // otherwise
            else{
              temp = curr; // move temp one, 
              curr = curr.getNext();} // move curr one.
              // otherwise we increment.
            break;
          
          default: // this should never be called, as compareTo returns -1, 0, or 1 ONLY.
            // something broke!
            break;
          }
        }
      } 
    }
  
  /*****************************<InsertionSort()>****************************
  * Description: takes a list and sorts it in ascending order
  *
  * Parameters: none
  *
  * Pre: a list must be created, of at least one element or greater.
  *
  * Post: the list is sorted and altered inplace
  *
  * Returns: returns nothing, but alters the list in place
  *
  * Called by: InsertionSort()
  * Calls: insertSorted(), size(), splitAt(), InsertionSort(), getElement(), getNext()
  ************************************************************************/
    void InsertionSort(){

      if(this.size() == 1){
        // we've done all the recursion we need!
        return;
      }
      else{
        // Splits L in the middle element by calling L.plitAt(index(=(N/2) 
        // where N is the number of elements in L (+1 for odd N). 
        // The first half will be in L1 and the second in L2. 

        // Finding Index Value
        int index = this.size(); // allocate index to list size.
        if((this.size() % 2) == 1){ // if list size is odd,
          index = (this.size() / 2) + 1; // we find the index and add one to it.
        }
        else{index = this.size() / 2;} // if the list size is even, we find the midpoint.
        
        // Create second list.
        List<T> L2 = new List<>();
        L2 = this.splitAt(index); // split the current list and assign the second half to L2

        // Recursively calls insertionSort(L1)
        this.InsertionSort();
        // Recursively calls insertionSort(L2)
        L2.InsertionSort();

        // Then combines L1 and L2 by inserting all the elements of L2 into L1 using your method 
        // insertSorted() from question 2. 

        // insert every item of L2 into L1.
        Node<T> currL2 = L2.head; // create a second curr pointer to the second list.
        while(currL2 != null){ // while this is a valid pointer, 
        this.insertSorted(currL2.getElement()); // we insert items in sorted order from L2 into 'this' list.
        currL2 = currL2.getNext(); // then we increment currL2 to the next node!
        }
    }
  }
  }

  // 56, 35, 42, 29
  
  

// The class for the Main Program
public class assignment5 {

  public static void main(String[] args) { // The main() method

    List<Integer> list = new List<>();
    Integer ch, item, index;
    boolean quit = false;

    Scanner sc = new Scanner(System.in);

    do{
  
      System.out.println( "____________Main Menu_____________________");
      System.out.println( "select option :");
      System.out.println( "1: insert back");
      System.out.println( "2: insert front");
      System.out.println( "3: insert at index");
      System.out.println( "4: display items");
      System.out.println( "5: get item at index");
      System.out.println( "6: delete back");
      System.out.println( "7: delete front");
      System.out.println( "8: delete at index");
      System.out.println( "9: exit");

      // New Options
      System.out.println( "11: insert sorted");
      System.out.println( "88: split at index");
      System.out.println( "99: insertion sort!");

      ch = sc.nextInt();

      switch (ch) {
        case 1:
          System.out.println( "enter item to insert:");
          item = sc.nextInt(); // read in an integer
          list.addLast(item);
          break;
        case 2:
          System.out.println( "enter item to insert:");
          item = sc.nextInt(); // read in an integer
          list.addFront(item);
          break;
        case 3:
          System.out.println( "enter item to insert:");
          item = sc.nextInt(); // read in an integer
          System.out.println( "enter index:");
          index = sc.nextInt(); // read in an integer
          list.addAt(index, item);
          break;
        case 4:
          list.displayAll();
          list.displayRecursively();
          break;
        case 5:
          System.out.println( "enter index:");
          index = sc.nextInt();
          System.out.println( "item at index:"+index+" is: "+list.getAt(index));
          break;
        case 6:
          list.removeLast();
          break;
        case 7:
          list.removeFront();
          break;
        case 8:
          System.out.println( "enter index:");
          index = sc.nextInt();
          list.removeAt(index);
          break;
        case 9:
          quit = true;
          break;
        
        case 11:
          System.out.println( "enter item to insert:");
          item = sc.nextInt();
          list.insertSorted(item);
          break;
        case 88: // not sure if this is how you wanted it!
          System.out.println( "enter index:");
          index = sc.nextInt();
          System.out.println( "Original List");
          list.displayAll();
          List<Integer> NL = new List<>();
          NL = list.splitAt(index);
          System.out.println( "Modified List: ");
          list.displayAll();
          System.out.println( "Newly Created List: ");
          NL.displayAll();

          break;
        
        case 99:
          if(!list.isEmpty()){
            list.InsertionSort();
          }
          else{
            System.out.println( "The list is empty and cannot be sorted!");
          }
          break;

        default:
          System.out.println( "invalid selection");
      }
    } while(!quit);
  }
}



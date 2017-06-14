import java.util.*;
import java.util.LinkedList;
import java.text.*;
import java.io.*;
/*@author Jerrad Vitatoe
* @version 2013.12.5.13  
* Program 4 Binary Search Tree
* 
* This program will process a text file and determine the words
* in the file and their frequency of occurrence in the file.
*
* Methods:
*
* insert()- If the list is empty it will make the first string
*  the root of the tree. If the list has more then one node in it
*  insert is called recursivly to add the next string either to
* 
* traversal()- If our root node doesnt equal null. We call traversal
*  recursivly which will walk through the BST and gives the string 
*  values back inorder alphabeticly.
*
* createFile()- Builds the header for the outFile including the file name
*  the outFile name, the programmers name and what kind of tree was used. 
*  
* createPage()- Steps through the ArrayList of string values and prints 
*  50 words per page in the outFile. this includes the word, the row #, 
*  and the frequency of duplicate words in the file.
*
* loadFile()- Asks the user to input a file name. If the file exists
*  that file will be loaded. If file cannot be found the program will
*  ask for another input. After not finding the file three times program
*  will exit.
*/

   
public class BST{

   private BSTNode head;
   
   public static void main(String[] args) throws Exception{
      //file name being read from.
      String fileName = "words";
      //name of the file created.
      String outFileName = "BSTTreeOut";
      PrintWriter outFile = new PrintWriter("BSTTreeOut");
      Scanner inFile = new Scanner(new FileReader(fileName));
      Scanner keyboard = new Scanner(System.in);
      BST tree = new BST();
      //used to read in the String values from the file.
      String words;
      //counts the page numbers
      int page = 1;
      //count for the nodes frequency
      int count = 1;
      //count for getting the inFile.
      int tries = 0;
      //read the story from the file and insert 
      //inorder into the tree
      tree.loadFile(fileName);   
      while(inFile.hasNext()){
         words = inFile.next();
         System.out.print(" " + words);
         tree.insert(words, count);
         count++;
      } 
      tree.createFile(outFile, fileName, outFileName, page);
      //returns the contents ArrayList
      ArrayList<BSTNode> result = tree.traversal();
      tree.createPage(outFile, result, page);
      outFile.println("The Number of distinct word processed is"
                          + " " + result.size() + "\n " + 
                      "The total number of words processed is" + 
                      " " + count);
      outFile.close();
   }
  //****************************************************  
   public void insert(String data, 
                      int count) {  
      if(head == null) {
         head = new BSTNode(data);
      } 
      else {//recursive call
         insert(head, data, count);
      }
   }
   
   public void insert(BSTNode node, 
                      String data, 
                      int count) {
      
      if(node.getData().equals(data)){
         node.setCount(node.getCount() +1);
         node.addLineNumber(count);
         return;
      }
      if(node.getData().compareTo(data) > 0) {
         if(node.getLeft() == null) {
            BSTNode entry = new BSTNode(data);
            entry.addLineNumber(count);
            node.setLeft(entry);
         }
         else {
            insert(node.getLeft(), data, count);
         }
      } 
      else {
         if(node.getRight() == null) {
            BSTNode entry = new BSTNode(data);
            entry.addLineNumber(count);
            node.setRight(entry);
         } 
         else {
            insert(node.getRight(), data, count);
         }
      }
   }
   //**************************************************** 
   public ArrayList<BSTNode> traversal(){
   //Contents will be stored in the ArrayList
      ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
      if(head != null){//recursive call
         traversal(head,nodes);
      }
      return nodes;    
   }

   private void traversal(BSTNode node, 
                          ArrayList<BSTNode> nodes){
      if(node.getLeft() != null){
         traversal(node.getLeft(),nodes);
      }
      // prints to screen to show that the traversal
      // is in order.
      System.out.println(node);
      // adds the inorder String value to the ArrayList.
      nodes.add(node);
      if(node.getRight() != null){
         traversal(node.getRight(), nodes);
      }
   }
   //**************************************************** 
   public void createFile(PrintWriter outFile, 
                          String inFileName, 
                          String outFileName,
                          int pageNumber){
      
      outFile.println(" " + " " + "-------BSTTreeList-------");
      outFile.println("The file name is"+ " " +  inFileName + " "+ 
                    "\n" + "The out file name is"+ " " + outFileName);              
      outFile.println("\n" + "Jerrad Vitatoe" + "\n "+ " " 
                    + "\n" + "A Binary Search Tree is used:" );
      outFile.println("Page # " + " " + pageNumber);
      outFile.println("\n");
      outFile.println("ROW" +" "+ "WORDS" + " " + "COUNT " );
   }
   //**************************************************** 
   public void createPage(PrintWriter outFile, 
                          ArrayList<BSTNode> nodes, 
                          int pageNumbers) throws Exception{
      int index = 0;
      // holds the size of the ArrayList. 
      int count = nodes.size();
      while(index < count){
         for(index = 0; index < nodes.size(); index++){
            if(index < 50){
               outFile.println(index +1 + "  " + nodes.get(index));
            }
            else if(index == 50){
               //"form feed" allows a new page to be written
               outFile.print('\f');
               pageNumbers++;
               outFile.println("\n");
               outFile.println(" " + " " + "-------BSTTreeList-------");
               outFile.println("Page # " + " " + pageNumbers);
               outFile.println("\n");
               outFile.println(index +1 + "  " + nodes.get(index));
            }
            else if(index >= 50){
               outFile.println(index +1 + "  " + nodes.get(index));
            }
         }
      }
   }
  //****************************************************  
   public void loadFile(String fileName)throws IOException{  
   
      int tries = 1;
      //for user input    
      Scanner keyboard = new Scanner(System.in);
   
      System.out.print("Input file name? ");
      // hold the input from user.
      String str = keyboard.nextLine();
      File afile;
      
      for(afile = new File(str); !afile.exists(); afile = new File(str)){  
         if(tries <= 3){
            System.out.println( "File does not exist!");
            tries++;
         	//Make sure the file give you another prompt if the file is not found/
            System.out.print("Input File name? ");
            str = keyboard.nextLine();
            tries++;
         }
         else{
            System.out.println("Sorry no files were found." + " " + "\n" 
                           + "Good Bye!!");
            System.exit(0);
         }
      }
   }   
}
   
   
  

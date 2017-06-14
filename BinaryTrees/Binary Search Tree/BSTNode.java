import java.util.ArrayList;

public class BSTNode{
   
   private final String data;
   private BSTNode left;
   private BSTNode right;
   private int count = 1;
   private int lineCount = 1;
   private final ArrayList<Integer> list = new ArrayList<Integer>();
   
   public BSTNode(String data) {
      this.data = data;   
   }

   public BSTNode getLeft() {
      return left;
   }

   public void setLeft(BSTNode left) {
      this.left = left;
   }

   public BSTNode getRight() {
      return right;
   }

   public void setRight(BSTNode right) {
      this.right = right;
   }

   public String getData() {
      return data;
   }
   
   public int getCount(){
      return count;
   }
   
   public void setCount(int count){
      this.count = count;
   }
   
   public String toString(){
      return ( " " + data + "  " + "  " + count + "  " );
   }  
   
   public void addLineNumber(int line){
      list.add(line);
   
   }
}




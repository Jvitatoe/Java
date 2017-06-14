public class BinaryTree<T> extends Comparable {

    TreeNode<T> head;
    
    public void traversal(){
      if(head == null){
         System.out.println("Tree is empty");
      }else{
         traversal(head);
      }
    
    }

    private void traversal(TreeNode<T> treeNode){
     if(treeNode.getLeft() != null){
      traversal(treeNode.getLeft());
      }
      System.out.println(treeNode.getData());
     if(treeNode.getRight() != null){
      traversal(treeNode.getRight());
     }
    }
    
    

    public void insert(T data) {
        if(head == null) {
            head = new TreeNode<T>(data);
        } else {
            insert(head, data);
        }
    }

    private void insert(TreeNode<T> node, T data) {
        if(node.getData().compareTo(data) > 0) {
            if(node.getLeft() == null) {
                node.setLeft(new TreeNode<T>(data));
            } else {
                insert(node.getLeft(), data);
            }
        } else {
            if(node.getRight() == null) {
                node.setRight(new TreeNode<T>(data));
            } else {
                insert(node.getRight(), data);
            }
        }
    }



    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(7);
        tree.insert(4);
        tree.insert(6);
        tree.insert(10);
        tree.traversal();
        
        System.out.println("Breakpoint!");
    }


    private static final class TreeNode<T> {
        private final T data;
        private TreeNode<T> left;
        private TreeNode<T> right;

        private TreeNode(T data) {
            this.data = data;
        }

        private TreeNode<T> getLeft() {
            return left;
        }

        private void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        private TreeNode<T> getRight() {
            return right;
        }

        private void setRight(TreeNode<T> right) {
            this.right = right;
        }

        private T getData() {
            return data;
        }
    }
}

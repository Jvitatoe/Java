import java.util.*;
import java.util.LinkedList;

public class BinaryTree2<T extends Comparable<T>> {

    TreeNode<T> head;

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

    public boolean find(T candidate) {
        return head != null && find(candidate, head);
    }

    private boolean find(T candidate, TreeNode<T> node) {
        if(node.getData().compareTo(candidate) == 0) {
            return true;
        } else if(node.getLeft() != null) {
            return find(candidate, node.getLeft());
        } else if(node.getRight() != null) {
            return find(candidate, node.getRight());
        } else {
            return false; // Failure condition
        }
    }

    public void depthFirstTraversal() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            LinkedList <TreeNode<T>> queue = new LinkedList<T>();
            queue.add(head);
            depthFirstTraversal(queue);
        }
    }

    public void breadthFirstTraversal() {
        if(head == null) {
            System.out.println("Empty tree");
        } else {
            Stack <TreeNode<T>> stack = new Stack<T>();
            stack.push(head);
            breadthFirstTraversal(stack);
        }
    }

    private void breadthFirstTraversal(Stack<TreeNode<T>> stack) {
        while(!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            System.out.print(node.getData());
            if(node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if(node.getRight() != null) {
                stack.push(node.getRight());
            }
            System.out.println();
        }
    }

    private void depthFirstTraversal(Queue<TreeNode<T>> queue) {
        while(!queue.isEmpty()) {
            TreeNode<T> node = queue.remove();
            System.out.print(node.getData());
            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.add(node.getRight());
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<T>();
        List<Integer> data = new ArrayList<T>();
        for(int i = 0; i < 100; i++) {
            data.add(i);
        }
        Collections.shuffle(data);
        for(Integer i : data) {
            tree.insert(i);
        }
        System.out.println(tree.find(16));
        System.out.println(tree.find(100));
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

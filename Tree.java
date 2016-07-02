import java.util.*;

class Node{
    int value;
    Node left;
    Node right;
    
    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }
}

class Tree{
    
    Node root;
    
    public Tree(){}
    
    public Tree(Node root){
        this.root = root;
    }
    
    public void insert(int value){
        if(root == null){
            root = new Node(value);
            return;
        }
        insert(value,root);
    }
    
    public Node insert(int value, Node root){
        if (root == null){ 
            root = new Node(value);
            return root;
        }
        if (value < root.value){ 
            root.left = insert(value, root.left);
        }
        if (value > root.value){
            root.right = insert(value, root.right);
        }
        
        return root;
    }
    
    public void traverseBreadth(){
        traverseBreadth(root);
    }
    
    private void traverseBreadth(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        
        if(root == null){
            return;
        }
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.value);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
    
    public void traverseDepth(){
        traverseDepth(root);
    }
    
    private void traverseDepth(Node root){
        
        if(root == null) return;

        if(root.left != null){
            traverseDepth(root.left);
        }
        
        System.out.println(root.value);
        
        if(root.right != null){
            traverseDepth(root.right);
        }
    }
}

public class HelloWorld{

     public static void main(String []args){
        Tree tree = new Tree();
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(15);
        tree.insert(3);
        
        //tree.traverseDepth();
        tree.traverseBreadth();
     }
}

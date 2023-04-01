import java.util.*;
public class AvL_Tree {
    // Node 
 static class Node{
    int data, height;
    Node left,right;
    Node(int data){
        this.data=data;
        // intialinze the height of node 1.
        height=1;
    }
 }

// height of node make function for null.
 public static int height(Node root){
    if(root==null)return 0;
    return root.height;
 }

 // taking balaced_factor
 public static int balaced_factor(Node root){
    if(root==null)return 0;
    return height(root.left)-height(root.right);
 }

// right rotation
 public static Node  rightRotate(Node root1){
    Node b=root1.left;
    Node c=b.right;

    b.right=root1;
    root1.left=c;
   
    root1.height=Math.max(height(root1.left),height(root1.right))+1;
    b.height=Math.max(height(b.left),height(b.right))+1;

    return b;
 }

// right rotation
 public static Node  leftRotate(Node root1){
    //set the child of Avl tree.
    /*
     *             root                                        b
     *           /      \                                    /   \
     *          a        b                =>               root   w
     *       /   \      /  \                               /  \
     *      x    y     c    w                             a   c
     *                                                    /\
     *                                                   x  y
       */                                                   
    Node b=root1.right;
    Node c=b.left;

    b.left=root1;
    root1.right=c;
   
    root1.height=Math.max(height(root1.left),height(root1.right))+1;
    b.height=Math.max(height(b.left),height(b.right))+1;

    return b;
 }


//  Insertion in avl tree.
 public static Node insert(Node root,int key){
    if(root==null){
        return new Node(key);
    }
    else if(key <root.data){
        root.left=insert(root.left,key);
    }
    else if(key >root.data){
        root.right=insert(root.right,key);
    }
 
    // Upgrad height of each node in AVL tree
    root.height=1+Math.max(height( root.left),height( root.right));
    
    int bf=balaced_factor(root);

// left left Case
    if(bf>1 && key<root.left.data)
      return rightRotate(root);

 // Right Right Case 
      if (bf <-1 && key> root.right.data) 
         return leftRotate(root);

// Left Right Case

    if (bf> 1 && key> root. left.data) { 
        root.left =leftRotate(root.left); 
        return rightRotate(root);
     }

//right left case
     if (bf<-1 && key< root.right.data) { 
        root.right =rightRotate(root.right); 
        return leftRotate(root);
     }

       return root;
 }


 public static void preorder(Node root){
    if(root==null)return ;
    System.out.print(root.data +" ");
    preorder(root.left);
    preorder(root.right);
 }
    public static void main(String[]args){
        Node root=null;
        int a[]={10,20,30,40,50,25};
        for(int i=0;i<a.length;i++){
            root=insert(root,a[i]);
        }



preorder(root);
    }
}

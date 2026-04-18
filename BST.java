/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaoopp;

/**
 *
 * @author hp
 */

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data=data;
        this.left=null;
        this.right=null;
    }
    
}
public class BST {
    Node root;
    
    public void insertion(int data){
        Node newNode=new Node(data);
        
        if(root==null){
            root=newNode;
            return;
        }
        
        Node current=root;
        Node parent=null;
        
        while(current!=null){
            parent=current;
            
            if(data<current.data) current=current.left;
            else if(data>current.data) current=current.right;
            else return;
        } 
        if (data<parent.data) parent.left=newNode;
        else if(data>parent.data) parent.right=newNode;
        
    }
    public boolean search(int value){
        if(root==null) return false;
        
        Node current=root;
        while(current!=null){
            if(value==current.data) return true;
            else if(value<current.data) current=current.left;
            else current=current.right;
           
        }
        return false;
    }
    
    public void delete(int value){
        Node current=root;
        Node parent=null;
        
        while(current!=null&&current.data!=value){
            parent=current;
            if(value<current.data) current=current.left;
            else current=current.right;
        }
         
        if (current==null) return;
        
        // case 1 : no children
        if(current.left==null&&current.right==null){
            if(current==root)root=null;
            else if(parent.left==current)parent.left=null;
            else parent.right=null;
        }
        
        // case 2 : one child                         
        else if(current.left==null || current.right==null){ 
            Node child;
            if(current.left!=null)
                child=current.left;
            else
                child=current.right;
           
            if(current==root)root=child;
            else if(parent.left==current)parent.left=child;
            else parent.right=child;
        }   
        else{  // case 3 : 2 child
            Node successor=current.right;
            Node successorParent=current;
            while (successor.left!=null){
                successorParent=successor;
                successor=successor.left;
            }
            current.data=successor.data;
            
            if(successorParent.left==successor) successorParent.left=successor.right;
            else successorParent.right=successor.right;
        }   
    }

    // 3 Traversal by recursion
    public void inOrderTraversal(){ 
        System.out.println("");
        inOrderTraversalHelper(root);
    }
    private void inOrderTraversalHelper(Node root){
        if(root==null) return;
        inOrderTraversalHelper(root.left);
        System.out.print(root.data+" ");
        inOrderTraversalHelper(root.right);
    }
    public void PreOrderTraversal(){
        System.out.println("");
        PreOrderTraversalHelper(root);
    }
    private void PreOrderTraversalHelper(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        PreOrderTraversalHelper(root.left);
        PreOrderTraversalHelper(root.right);
    }
    public void PostOrderTraversal(){
        System.out.println("");
        PostOrderTraversalHelper(root);
    }
    private void PostOrderTraversalHelper(Node root){
        if(root==null) return;
        PostOrderTraversalHelper(root.left);
        PostOrderTraversalHelper(root.right);
        System.out.print(root.data+" ");
    }
    public int findmin(){
        Node current=root;
        if(current.left==null&&current.right==null) return root.data;
        while(current.left!=null){
            current=current.left;
        }
        return current.data;
    }
    public int findMax(){
        Node current=root;
        if(current.right==null&&current.left==null) return root.data;
        while(current.right!=null){
            current=current.right;
        }
        return current.data;
    }
}

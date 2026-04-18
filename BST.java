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
        
        if(root==null){   //حاله انها لسه اول نود  
            root=newNode;
            return;
        }
        
        Node current=root; // بوينتر يمشي ع العناصر
        Node parent=null;   // بوينتر اخر يقف عند العنصر اللي هتضيف بعده
        
        while(current!=null){
            parent=current;
            
            if(data<current.data) current=current.left;
            else if(data>current.data) current=current.right;
            else return;
        } // بعد ما تخرج من اللوب كده البوينتر بيرنت واقف عند النود اللي هتضيف بعدها 
        if (data<parent.data) parent.left=newNode;
        else if(data>parent.data) parent.right=newNode;
        
    }
    public boolean search(int value){
        if(root==null) return false; // empty
        
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
        // اللوب دي عشان نلاقي النود اللي هتتمسح
        while(current!=null&&current.data!=value){
            parent=current;
            if(value<current.data) current=current.left;
            else current=current.right;
        }
        //عنصر م موجود لأن البوينتر وصل للاخر 
        if (current==null) return;
        
        // case 1 : no children
        if(current.left==null&&current.right==null){
            if(current==root)root=null;
            else if(parent.left==current)parent.left=null;
            else parent.right=null;
        }
        
        // case 2 : one child                          // الشرط داا عشان تعرف ان مفيش اطفال تاني
        else if(current.left==null || current.right==null){ //   غير دا لأن الكرنت بعد البيرنت  
            Node child;
            // عشان نحدد الطفل 
            if(current.left!=null)
                child=current.left;
            else
                child=current.right;
           
            // هنا هتمسح
            if(current==root)root=child;
            else if(parent.left==current)parent.left=child;
            else parent.right=child;
        }   
        else{  // case 3 : 2 child
            Node successor=current.right;
            Node successorParent=current;
            // اصغر قيمه في اليمين
            while (successor.left!=null){
                successorParent=successor;
                successor=successor.left;
            }
            // نبدل 
            current.data=successor.data;
            
            // نمسح ال successor
            if(successorParent.left==successor) successorParent.left=successor.right;
            else successorParent.right=successor.right;
        }   
    }
    public void display(){ // by recursion
        displayhelper(root);
    }
    private void displayhelper(Node root){
        if(root==null) return;
        displayhelper(root.left);
        System.out.println(root.data+"");
        displayhelper(root.right);
    }
}

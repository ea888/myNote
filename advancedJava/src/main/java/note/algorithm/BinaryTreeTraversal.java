package note.algorithm;

import java.util.Queue;
import java.util.Stack;
 
public class BinaryTreeTraversal {
 
    //recursively traverse the tree with
    //a stack of nodes (LIFO)
    public static void depthFirstSearch(Stack<Node2> stack){
 
        if (stack.isEmpty()) return;
 
        Node2 node = (Node2)stack.pop();
 
        System.out.println ("popping node: " + node);
 
        if (node.right!=null) stack.push(node.right);
 
        if (node.left!=null) stack.push(node.left);
 
        depthFirstSearch (stack);
    }
 
    //Recursively traverse the tree with
    //a queue of nodes (FIFO)
    public static void breadthFirstSearch (Queue<Node2> queue){
 
        if (queue.isEmpty()) return;
 
        Node2 node = (Node2)queue.poll();
 
        System.out.println ("polling node: " + node);
 
        if (node.right!=null) queue.offer(node.right);
 
        if (node.left!=null) queue.offer(node.left);
 
        breadthFirstSearch (queue);
    }
 
    public static void main (String args[]) {
 
        //nodeA needs to be final to be accessed by
        //the anonymous inner classes below
 
            final Node2 nodeA = new Node2 ("A");
 
            Node2 nodeB = new Node2 ("B");
 
            Node2 nodeC = new Node2 ("C");
 
            Node2 nodeD = new Node2 ("D");
 
            Node2 nodeE = new Node2 ("E");
 
            Node2 nodeF = new Node2 ("F");
 
            Node2 nodeG = new Node2 ("G");
 
        //build the tree
 
            nodeD.left = nodeE;
 
            nodeB.left = nodeC;
 
            nodeB.right = nodeD;
 
            nodeF.right = nodeG;
 
            nodeA.left = nodeB;
 
            nodeA.right = nodeF;
 
        //Do breadth first search
 
            System.out.println ("***  Breadth First search *** ");
 
            Queue<Node2> queue =  new java.util.LinkedList<Node2>();
            queue.offer(nodeA);
 
            breadthFirstSearch(queue ) ;
 
        //Do depth first search
 
            System.out.println ("***  Depth First search *** ");
 
            Stack<Node2>  stack = new Stack<Node2>  ();
            stack.push(nodeA);
 
            depthFirstSearch(stack ) ;
    }
 
}
 
class Node2 {
 
    Node2 (String value ) {
    	this.value = value;
    }
 
    Node2 right;
 
    Node2 left;
 
    String value;
 
    public String toString () {
        return value ;
    }
}
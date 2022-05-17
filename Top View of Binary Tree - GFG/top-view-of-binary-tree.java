// { Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    static class Pair{
        Node node;int np;
        Pair(){}
        Pair(Node node,int np){
            this.node = node;
            this.np = np;
        }
    }
    
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> retVal = new ArrayList<>();
        
        if(root == null){
            return retVal;
        }
        
        
        int lp,rp;
        lp=rp=0;
        
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root,0));
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,root.data);
        
        while(qu.size()>0){
            int lvlSize = qu.size();
            
            for(int i=1;i<=lvlSize;i++){
                Pair remPair = qu.remove();
                Node node = remPair.node;
                int np = remPair.np;
                
                if(node.left != null){
                    qu.add(new Pair(node.left,np-1));
                    
                }
                if(node.right != null){
                    qu.add(new Pair(node.right,np+1));
                    
                }
                
                if(np < lp){
                    lp = np;
                    hm.put(lp,node.data);
                }
                if(rp < np){
                    rp = np;
                    hm.put(rp,node.data);
                }
            }
            // System.out.println("left: "+lp+", right: "+rp);
        }
        
        // System.out.println(hm);
        for(int i=lp; i<=rp; i++){
            retVal.add(hm.get(i));
        }
        
        
        return retVal;
    }
}
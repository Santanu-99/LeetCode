// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        //your code here
        
        HashMap<Integer,Integer> lvl = new HashMap<>();
        for(int i=0;i<level.length;i++){
            lvl.put(level[i],i);
        }
        Node root = treeConstructor(inord,0, inord.length-1, lvl);
    
        return root;
    }
    
    Node treeConstructor(int inord[],int inSt,int inEnd,HashMap<Integer,Integer> lvl){
        if(inSt > inEnd){
            return null;
        }
        
        int lvlMinIdx=inord.length;
        int inIdx = inSt-1;
        for(int i=inSt; i<=inEnd; i++){
            int lvlIdx = lvl.get(inord[i]);
            if( lvlIdx < lvlMinIdx){
                inIdx = i;
                lvlMinIdx = lvlIdx;
            }
        }
        Node root = new Node(inord[inIdx]);
        
        root.left = treeConstructor(inord,inSt,inIdx-1,lvl);
        root.right = treeConstructor(inord,inIdx+1,inEnd,lvl);
        
        return root;
    }
   
}



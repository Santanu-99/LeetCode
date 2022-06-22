// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int v =0;v<V;v++){
            hm.put(v,0);
        }
        
        // calculating and putting in-degree of each vertex into hashmap
        for(int i=0;i<V;i++){
            for(int nbr : adj.get(i)){
                hm.put(nbr , hm.get(nbr)+1);
            }
        }
        
        
        Queue<Integer> qu = new LinkedList<>();
        for(int v=0; v< V;v++){
            if(hm.get(v) == 0){
                qu.add(v);
            }
        }
        
        int[] ans = new int[V];
        int idx=0;
            
        while(qu.size()>0){
            int rem = qu.remove();
            ans[idx] = rem;
            idx++;
            for(int nbr : adj.get(rem)){
                
                int inDeg = hm.get(nbr);
                if(inDeg == 1){
                    hm.put(nbr,0);
                    qu.add(nbr);
                }else if(inDeg>1){
                    hm.put(nbr,inDeg-1);
                }
            }
            
        }
        
        
        
        return ans;
    }
}

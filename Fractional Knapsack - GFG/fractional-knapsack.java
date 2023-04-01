//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    class Record{
        int boxValue , boxWt ;
        double  cost;
        Record(){
            
        }

        Record(int boxValue ,int boxWt ,double cost){
            this.boxValue = boxValue;
            this.boxWt = boxWt;
            this.cost = cost;
        }
        public String toString(){
            return boxValue+" - "+boxWt+" - "+cost ;
        }
    }
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Record[] rec = new Record[n];
        for(int i=0;i<n;i++){
            rec[i] = new Record(arr[i].value ,arr[i].weight,arr[i].value*1.0 / arr[i].weight);
        }

        Arrays.sort(rec, (a,b)->{
            return Double.compare(b.cost, a.cost  );
        });

        // System.out.println(Arrays.toString(rec));
        
       int left = W;
       double totVal = 0;
        for(int i=0;i<n;i++){
            int itemWt = rec[i].boxWt;
            int itemVal = rec[i].boxValue;
            
            // System.out.println(itemWt + " - "+left);
            
            if(itemWt <= left ){
                totVal += itemVal;
                left = left - itemWt;
            }
            else{
                totVal += left * (itemVal *1.0 /itemWt) ;
                break;
            }
        }

        return totVal;
    }
}
// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution
{
    int[] parent;
    
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        
        //creating DSU
        parent = new int[101];
        int[] details = new int[2];
        
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        
        // sorting jobs on the basis of profit
        Arrays.sort(arr, (a,b)->{
            return b.profit - a.profit;
        });
        
        
        // scheduling jobs on the basis of profit and calculating maximum possible profit
        int totProfit=0;
        int count=0;
        for(int i=0; i<n; i++){
            
            Job j = arr[i];
            int deadline = j.deadline;
            int profit = j.profit;
            
            // find lead of deadline and check if the job can be done
            int wDay = find(deadline);
            
            // if have time to do the job
            if(wDay != 0){
                
                // (place the job at the lead)
                count++;
                // make the immediate left idx's lead as lead 
                parent[wDay] = find(wDay-1);
                
                
                // add job profit
                totProfit += profit;
            }
        
        }
        
        details[0] = count;
        details[1] = totProfit;
        return details;
    }
    
    
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/


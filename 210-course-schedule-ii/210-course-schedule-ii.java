class Solution {
    public void reverse(int[] arr){
        int i=0;
        int j=arr.length-1;
        
        while(i<=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        }
    }
    
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // Declaring a graph
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int v=0;v<numCourses;v++){
            graph[v]= new ArrayList<>();
        }
        
        // Initializing the graph
        for(int i = 0; i<prerequisites.length ; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            graph[u].add(v);
        }
        
        // Doing topological sort
        int[] tsort = new int[numCourses];
        
        // calculating and storing inDegree of each vertex
        int[] inDeg = new int[numCourses];
        for(int v=0;v<numCourses;v++){
            for(int nbr : graph[v]){
                inDeg[nbr]++;
            }
        }
        
        // Enqueuing all the vertices that initially didn't has any dependent 
        Queue<Integer> qu = new LinkedList<>();
        for(int v=0;v<numCourses;v++){
            if(inDeg[v] == 0){
                qu.add(v);
            }
        }
        
        // kahn's algo
        int idx = 0;
        while(qu.size() > 0){
            int rem = qu.remove();
            for(int nbr : graph[rem]){
                if(inDeg[nbr] == 1){
                    inDeg[nbr] = 0;
                    qu.add(nbr);
                }else if(inDeg[nbr] > 1){
                    inDeg[nbr]--;
                }
            }
            
            tsort[idx] = rem;
            idx++;
        }
        
        // if this condition is true then there is a cycle in dependency
        if(idx+1 < numCourses){
            return new int[0];
        }
        
        // returning vertices dependency wise
        reverse(tsort);
        return tsort;
        
    }
}
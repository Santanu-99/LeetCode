class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        for(int i=0;i<n;i++){
            arr1[i] = (int)(1e8);
            arr2[i] = (int)1e8;
        }
        
        arr1[src] = 0;
        arr2[src] = 0;
        
        for(int i=1; i<=k+1; i++){
            
            
            for(int[] flight : flights){
                int from = flight[0];
                int to = flight[1];
                int fcost = flight[2];
                
                arr2[to] = Math.min(arr1[from]+fcost , arr2[to]);
            }
            
            for(int j=0;j<n;j++){
                arr1[j] = arr2[j];
            }
        }
        
        if(arr2[dst] != (int)1e8){
            return arr2[dst];
        }
        else{
            return -1;
        }
        
    }
}
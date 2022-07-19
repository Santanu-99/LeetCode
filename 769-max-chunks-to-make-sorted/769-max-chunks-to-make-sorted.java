class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        
        int chunkCount = 0;
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            
            if(max < arr[i]){
                max = arr[i];
            }
            
            if(max==i){
                chunkCount++;
            }
        }
        
        return chunkCount;
    }
}
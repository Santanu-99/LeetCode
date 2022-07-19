class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] minfr = new int[arr.length];
        int min = Integer.MAX_VALUE;
        for(int i=arr.length-1; i >= 0;i--){
            if(arr[i] < min){
                min = arr[i];
            }
            minfr[i] = min;
        }
        
        int max = Integer.MIN_VALUE;
        int chunkCount = 1;
        for(int i=0;i<arr.length-1;i++){
            if(max < arr[i]){
                max = arr[i];
            }
            
            if( max <= minfr[i+1] ){
                chunkCount++;
            }
        }
        
        return chunkCount;
    }
}
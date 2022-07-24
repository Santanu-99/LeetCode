class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int k = 60;
        int[] freqMap = new int[k];
        
        for(int i = 0; i<time.length;i++){
            int r = time[i] % k;
            freqMap[r] += 1;
        }
        
        
        long pairCount = 0;
        for(int rem=0;rem<=k/2;rem++){
            int n = freqMap[rem];
            
            if(rem == 0 || rem == (k - rem)){
                pairCount += ((long)n*(n-1)) / 2;
            }
            else{
                pairCount += n * freqMap[k-rem];
            }
        }
        
        
        return (int)pairCount;
    }
}
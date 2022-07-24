class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int k = 60;
        int[] freqMap = new int[k];
        
        for(int i = 0; i<time.length;i++){
            int r = time[i] % k;
            freqMap[r] += 1;
        }
        
        
        long pairCount = 0;
        
        // looping till k/2 because numbers with remainders greater than k/2 has already been considered while froming pairs for numbers with remainder lesser than k/2
        
        // so to avoid repetation of same pair two times we looped till k/2 
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
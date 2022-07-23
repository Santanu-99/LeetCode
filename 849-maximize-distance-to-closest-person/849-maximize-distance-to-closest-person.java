class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev,curr;
        prev = curr = 0;
        int maxD = -1;
        
        while(curr < seats.length){
            if(seats[curr] == 0){
                curr++;
            }
            else{
                if(seats[prev] == 0){
                    int d = curr - prev;
                    maxD = d;
                }
                else{
                    int gap = curr - prev;
                    int d = gap / 2;
                    if(maxD < d){
                        maxD = d;
                    }
                }
                prev = curr;
                curr++;
            }
        }
        curr = curr-1;
        int rightMost = curr - prev;
        
        maxD = Math.max(maxD , rightMost);
        
        return maxD;
    }
}
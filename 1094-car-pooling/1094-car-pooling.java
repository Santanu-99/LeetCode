class Solution {
    
    class Pair implements Comparable<Pair>{
        int time,load;
        Pair(){}
        Pair(int time , int load){
            this.time = time;
            this.load = load;
        }
        
        public int compareTo(Pair other){
            // if loading and unloading time becomes same then first unload and then load
            // concept used: 
            // if thisPair.time has (+)ve load then swap it backwards
            // else if thisPair.time (-)ve load then keep it in the front
            if(this.time == other.time){
                return this.load;
            }
            
            // other wise process the one with lowest time first
            return this.time - other.time;
        }
    }
    
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int[] trip : trips){
            int l = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            pq.add(new Pair(from , l));
            pq.add(new Pair(to, -l));
        }
        
        int currLoad = 0;
        while(pq.size() > 0){
            currLoad = currLoad + pq.remove().load;
            if(currLoad > capacity){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        
        HashMap<Integer,ArrayList<Integer>> s2bMap = new HashMap<>();
        
        for(int bus=0; bus < routes.length; bus++){
            for(int stop : routes[bus]){
                if(s2bMap.containsKey(stop) == false){
                    s2bMap.put(stop,new ArrayList<>());
                }
                
                s2bMap.get(stop).add(bus);
                
                // s2bMap.put(routes[bus][stop] , s2bMap.getOrDefault(routes[bus][stop] , new ArrayList<Integer>()).add(bus));
            }
        }
    // System.out.println(s2bMap);
        int[] visitedBus = new int[routes.length];

        
        Queue<Integer> qu = new LinkedList<>();
        
        for(int bus : s2bMap.get(source)){
            qu.add(bus);
            visitedBus[bus] = 1;
        }
        
        int count=1;
        
        while(qu.size() > 0){
            int tempSize = qu.size();
            
            while(tempSize-- > 0){
                
                // remove
                int remBus = qu.remove();
                
                // work
                for(int stop : routes[remBus]){
                    if(stop == target){
                       return count; 
                    }
                }
                
                
                for(int stop : routes[remBus]){
                    for(int bus : s2bMap.get(stop)){
                        if(visitedBus[bus] == 0){
                            // add
                            qu.add(bus);
                            // mark
                            visitedBus[bus] = 1;
                        }
                    }
                }
                
            }
            
            count++;
            
        }
        
        return -1;
        
        
    }
}
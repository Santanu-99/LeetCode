class Solution {
    class Pair{
        int start , end;
        Pair(){}
        Pair(int start , int end){
            this.start = start;
            this.end = end;
        }
        public String toString(){
            return start+" - "+end;
        }
    }
    public int subarrayGCD(int[] nums, int k) {
        int count =0;        
        // // Brute force      
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i;j<nums.length;j++){
        //         int g = calculateSubarrayGCD(nums,i,j);
        //         // System.out.println(i+"-"+j+" gcd: "+g);
        //         if(g==k){
        //             count+=1;
        //         }
        //     }
        // }
        
        
//         slight greedy
        Queue<Pair> qu = new LinkedList<>();
        
        int i=0,j=0;
        while(j<=nums.length){
            if(j<nums.length && nums[j] % k == 0){
               j++; 
            }
            else if(i<j){
                qu.add(new Pair(i,j-1));
                j++;
                i=j;
            }
            else{
                i++;
                j++;
            } 
        }
        
        // System.out.println(qu);
        while(qu.size() != 0){
            Pair rem = qu.remove();    
            int st = rem.start;
            int en = rem.end;
            for( i=st;i<=en;i++){
                for( j=i;j<=en;j++){
                    int g = calculateSubarrayGCD(nums,i,j);
                    // System.out.println(i+"-"+j+" gcd: "+g);
                    if(g==k){
                        count+=1;
                    }
                }
            }
        }
        
        return count;
    }
    
    int calculateSubarrayGCD(int[] nums , int i , int j){
        int g = nums[i];
        for(int k=i+1;k<=j;k++){
            g = gcd(Math.min(g,nums[k]) , Math.max(g,nums[k])); 
        }
        return g;
    }
    
    int gcd(int a , int b){
        if(b%a == 0){
            return a;
        }
        int na = b % a;
        int nb = a;
        return gcd(na , nb);
    }
}
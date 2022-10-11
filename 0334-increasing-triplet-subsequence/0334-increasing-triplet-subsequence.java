class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int k=3;
        
        int[] nsel= new int[nums.length];
        Arrays.fill(nsel , -1);
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=nums.length - 1; i>=0 ; i--){
            while(st.size() != 0 && nums[st.peek()] > nums[i]){
                nsel[st.pop()] = i;
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(nsel));

        for(int i=nums.length - 1; i>=0 ; i--){
            
            int temp=i;
            for(int j=1; j<k ;j++){
                if(temp != -1){
                    temp = nsel[temp];

                }
            }  
            if(temp != -1){
                return true;
            }
        }
        
        
        int[] nger= new int[nums.length];
        Arrays.fill(nger , -1);
        
        st = new Stack<>();
        
        for(int i=0; i< nums.length ; i++){
            while(st.size() != 0 && nums[st.peek()] < nums[i]){
                nger[st.pop()] = i;
            }
            st.push(i);
        }
        
        for(int i= 0 ; i < nums.length ; i++){
            
            if(nsel[i] >= 0 && nger[i]>=0){
                return true;
            }
        }
        
        
        return false;
    }
}
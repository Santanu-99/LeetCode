class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        
        int i1=m-1;
        int i2=n-1;
        int k=(m+n)-1;
        while(0<=i1 && 0<=i2){
            if(nums1[i1] > nums2[i2]){
                nums1[k] = nums1[i1];
                i1--;
            }
            else{
                nums1[k] = nums2[i2];
                i2--;
            }
            
            k--;
        }
        
        while(0<=i1){
            nums1[k] = nums1[i1];
            i1--;
            k--;
        }
        while(0<=i2){
            nums1[k] = nums2[i2];
            i2--;
            k--;
        } 
        
    }
}
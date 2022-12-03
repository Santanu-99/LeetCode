class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int m1 = nums1.length - n;
        int temp[] = new int[m1];
        for(int i=0;i<m1;i++){
            temp[i] = nums1[i];
        }
        
        int i1=0;
        int i2=0;
        int k=0;
        for(;i1<m1 && i2<n;k++){
            if(temp[i1] <= nums2[i2]){
                nums1[k] = temp[i1];
                i1++;
            }
            else{
                nums1[k] = nums2[i2];
                i2++;
            }
        }
        
        while(i1<m1){
            nums1[k] = temp[i1];
            i1++;
            k++;
        }
        while(i2<n){
            nums1[k] = nums2[i2];
            i2++;
            k++;
        } 
        
    }
}
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        
        int maxArea = -1;
        while(i != j){
            int width = j - i;
            int area = 0 ;
            if(height[i] <= height[j]){
                area = height[i] * width;
                i++;
            }
            else if(height[i] > height[j]){
                area = height[j] * width;
                j--;
            }
            
            if(area > maxArea){
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}
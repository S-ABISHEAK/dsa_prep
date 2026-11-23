public class TrappingRainwater {
    public int trappedwater(int[] height){
        int water = 0;
        int left = 0 , right = height.length - 1;
        int leftMax = 0 , rightMax = 0;

        while(left <= right){
            if(height[left] <= height[right]){
                if(leftMax < height[left]){
                    leftMax = height[left];
                }
                else{
                    water += leftMax - height[left];
                }
                left++;
            }
            else{
                if(rightMax < height[right]){
                    rightMax = height[right];
                }
                else{
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainwater obj = new TrappingRainwater();
        System.out.println(obj.trappedwater(height));
    }
}


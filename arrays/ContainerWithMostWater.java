public class ContainerWithMostWater {
    public int mostwater(int[] height){
        int ans = 0;
        int low = 0, high = height.length - 1;
        //int leftmax = 0 , rightmax = 0;
        while(low < high){
            // if(height[low] <= height[high]){
            //     if(leftmax < height[low]){
            //         leftmax = low;
            //     }
            //     else{
            //         low++;
            //     }
            // }
            // else{
            //     if(rightmax < height[high]){
            //         rightmax = high;
            //     }
            //     else{
            //         high++;
            //     }

            int cont_height= Math.min(height[low] , height[high]);
            int breadth = high - low;
            int new_area = cont_height * breadth;

            ans = Math.max(ans , new_area);

            if(height[low] < height[high]){
                low++;
            }
            else{
                high--;
            }

            }
            //int min_val = Math.max(height[leftmax] , height[rightmax]);
            //ans = Math.max(ans , min_val * min_val);
            return ans;
        }
        
    
    public static void main(String[]args){
        int height[] = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater obj = new ContainerWithMostWater();
        System.out.println(obj.mostwater(height));
    }

}

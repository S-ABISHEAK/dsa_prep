import java.util.Arrays;

public class TwoSum2 {
    public int[] twosum(int[] nums, int target){
        int low = 0 , high = nums.length - 1;
        //int ans[] = new int[2];
        while(low < high){
            int curr_ans = nums[low] + nums[high];
            if(curr_ans == target){
                return new int[]{low + 1 , high + 1};
            }
            if(curr_ans < target){
                low++;
            }
            else{
                high--;
            }

        }
        return new int[]{};
    }
    public static void main(String[]args){
        int numbers[] = {2, 7, 11, 15};
        int target = 9;
        TwoSum2 obj = new TwoSum2();
        System.out.println(Arrays.toString(obj.twosum(numbers, target)));
    }
}

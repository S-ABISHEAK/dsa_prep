import java.util.Arrays;

class MissingNumber {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;  // this is the max val of n distince numbers
        int total_sum = n * (n + 1) / 2;
        int actual_sum = Arrays.stream(nums).sum();
        return total_sum - actual_sum;        
    }

    public static void main(String[]args){

        int[] nums = new int[]{3, 0, 1, 2};
        MissingNumber obj = new MissingNumber();
        System.out.println(obj.missingNumber(nums));
    }
}
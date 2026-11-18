class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        // prefix base case, get all the left elements product
        prefix[0] = 1;
        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // same way set the base case for the suffix array
        suffix[n - 1] = 1;
        for(int i = n - 2 ; i >= 0 ; i--){
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Both the prefix(left elements sum) and suffix(right elements sum) preped up
        // multiply them : gices us all elements multiplication except that element of the array

        for(int i = 0 ; i < n ; i++){
            ans[i] = prefix[i] * suffix[i];
        }
        
        return ans;
    }
}  

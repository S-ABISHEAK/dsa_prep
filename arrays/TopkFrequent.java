import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopkFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        // [frequency , actual array value] stored in priority queue
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry_obj : mp.entrySet()) {
            heap.offer(new int[]{entry_obj.getValue(), entry_obj.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            //get the actual value from the priority queue
            ans[i] = heap.poll()[1];
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 3, 3, 3};
        int k = 2;

        TopkFrequent obj = new TopkFrequent();
        int answer[] = obj.topKFrequent(nums, k);

        System.out.println("The top " + k + " frequent values are " + Arrays.toString(answer));
    }
}

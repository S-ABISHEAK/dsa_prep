import java.util.ArrayList;
import java.util.Arrays;

public class LargestSumCycle {
      public int largestSumCycle(int[] edge) {

    // Initialize the needed variables first
    int n = edge.length;

    // state : 0 -> notvisited 1 -> current cycle visited(ongoing) 2 -> already
    // visiten (not current)
    int state[] = new int[n];

    // position of a node in current cycle finding iteration
    int position[] = new int[n];

    // consider none of the nodes were considered for cycle so fill as -1
    // it will hold the node's position in sysle like 1st 2nd and so on

    Arrays.fill(position, -1);

    int maxSum = -1;

    for (int i = 0; i < n; i++) {

      // if state already visited in some sort ( 1 or 2 )...
      if (state[i] != 0) {
        continue;
      }

      ArrayList<Integer> path =
          new ArrayList<>(); // holds the nodes of a current cycle

      int curr_node = i; // mentions the current node we gonna process

      // Traverse until we reach an node already present in the cycle (status = 1) or already visited (status = 2)
      while (curr_node != -1 && state[curr_node] == 0) {

        // if not visited
        state[curr_node] = 1;              // visited in current cycle
        position[curr_node] = path.size(); // no. of nodes in current cycle gives position in cycle
        path.add(curr_node);
        curr_node = edge[curr_node]; // move to the node pointed by the curr-node (next node)
      }

      // cycle exists i.e we got state as 1...
      if (curr_node != -1 && state[curr_node] == 1) {

        int sum = 0;

        // find the starting of cycle i.e the node on which we got state as 1
        int start = position[curr_node];

        // get the sum of nodes present within the path , gives the cycle

        for (int j = start; j < path.size(); j++) {
          
            sum += path.get(j);
        }

          maxSum = Math.max(maxSum, sum); // get the maximum possible sum among the cycles present
        }

        // if cycle not found or found and calculations done , mark them as visited already (state : 2)
        for (int node : path) {
          state[node] = 2;
          position[node] = -1;
        }
      }
    
    return maxSum;
  }
    public static void main(String[] args) {
        int edge[] = {1, 2, 0, -1};
        LargestSumCycle obj = new LargestSumCycle();
        System.out.println(obj.largestSumCycle(edge));
    }
}

import java.util.Arrays;

public class NearestMeetingCell {


    public int nearestMeetingCell(int[] edges, int C1, int C2) {

        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        // Initially, all nodes are unreachable
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        // Calculate distances from both starting nodes
        calculateDistance(edges, C1, dist1);
        calculateDistance(edges, C2, dist2);

        int minDistance = Integer.MAX_VALUE;
        int answer = -1;

        // Find the nearest common reachable node
        for (int i = 0; i < n; i++) {

            if (dist1[i] != -1 && dist2[i] != -1) {

                int maxDist = Math.max(dist1[i], dist2[i]);

                if (maxDist < minDistance) {
                    minDistance = maxDist;
                    answer = i;
                }
            }
        }

        return answer;
    }

    // Calculate distance from a starting node
    private void calculateDistance(int[] edges, int start, int[] dist) {

        int curr = start;
        int d = 0;

        while (curr != -1 && dist[curr] == -1) {

            dist[curr] = d++;

            curr = edges[curr];
        }
    
    }
    public static void main(String[] args) {
        int edges[] = {1, 2, 3, 4, -1, 4, 5};
        int C1 = 0;
        int C2 = 6;
        NearestMeetingCell obj = new NearestMeetingCell();
        System.out.println(obj.nearestMeetingCell(edges, C1, C2));
    }
}

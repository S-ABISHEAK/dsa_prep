/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;

    public int goodNodes(TreeNode root) {
        count_good(root, Integer.MIN_VALUE);
        return ans;
    }

    public void count_good(TreeNode node, int maxSoFar) {
        if (node == null) {
            return;
        }

        if (node.val >= maxSoFar) {
            ans++;
        }

        maxSoFar = Math.max(maxSoFar, node.val);

        count_good(node.left, maxSoFar);
        count_good(node.right, maxSoFar);
    }
}
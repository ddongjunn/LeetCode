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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            while(size-- > 0) {
                TreeNode node = q.poll();
                if(node.left != null && node.right != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            
            level++;
            if(level % 2 == 1 && !q.isEmpty()) {
                int i = 0;
                int[] nums = new int[q.size()];
                for(TreeNode node : q) {
                    nums[i++] = node.val;
                }
                
                int j = q.size() - 1;
                for(TreeNode node : q) {
                    node.val = nums[j--];
                }
            }
        }
        
        return root;
    }
}
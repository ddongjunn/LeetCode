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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafOne = findLeafValues(root1);
        List<Integer> leafTwo = findLeafValues(root2);
        
        return leafOne.equals(leafTwo);
    }
    
    private List<Integer> findLeafValues(TreeNode root){
        List<Integer> leaf = new ArrayList<Integer>();
        findLeafValue(root, leaf);
        return leaf;
    }
    
    private void findLeafValue(TreeNode root, List<Integer> leaf){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            leaf.add(root.val);
            return;
        }
        
        findLeafValue(root.left, leaf);
        findLeafValue(root.right, leaf);
    }
}
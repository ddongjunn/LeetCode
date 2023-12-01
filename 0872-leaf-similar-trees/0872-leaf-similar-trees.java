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
        List<Integer> leafOne = new ArrayList<Integer>();
        List<Integer> leafTwo = new ArrayList<Integer>(); 
        
        findLeaf(root1, leafOne);
        findLeaf(root2, leafTwo);
        
        if(leafOne.size() != leafTwo.size()){
            return false;
        }
        
        for(int i = 0; i < leafOne.size(); i++){
            int one = leafOne.get(i);
            int two = leafTwo.get(i);
            if(one != two){
                return false;
            }
        }
        
        return true;
    }
    
    public void findLeaf(TreeNode root, List<Integer> leaf){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            leaf.add(root.val);
            return;
        }
        
        findLeaf(root.left, leaf);
        findLeaf(root.right, leaf);
    }
    
}
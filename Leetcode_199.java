//way1
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
 //BFS
 //Travel level by level using queue.size
 //Store last element
 //TC: O(n);
 //SC:O(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!(queue.isEmpty())){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(i==size-1){
                    ans.add(curr.val);
                }

                if(curr.left!=null){
                    queue.add(curr.left);
                }

                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
        }

        return ans;
        
    }
}

//way2
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
 //DFS
 //Travel all nodes 
 //At every level add the node to ans
 //By end - we will be left with right view of ans
 //TC: O(n)
 //SC: O(h)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        helper(root,0,ans);
        return ans;
    }

    private void helper(TreeNode root,int level, List<Integer> ans){
        if(root==null){
            return;
        }

        if(ans.size()==level){
            ans.add(root.val);
        }else{
            ans.set(level,root.val);
        }

        helper(root.left,level+1,ans);
        helper(root.right,level+1,ans);
    }
}

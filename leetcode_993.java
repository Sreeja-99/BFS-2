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
 //Store root in queue
 //Travel till the size of queue is met - level order traversal
 //For every node check whether it's both left and right are equal to x and y --> if yes, siblings. Not cousion. Return false
 //For every level check whether both x and y are found or not. As we have already checked and they are not siblings. So, they are cousins. Return true
 //Once queue elements are processed but still x and y are not found in one level - return false
 //TC: O(n)
 //SC: O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!(queue.isEmpty())){
            int size=queue.size();
            boolean xFound=false,yFound=false;
           
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
            
                if(curr.left!=null && curr.right!=null){

                    if((curr.left.val==x && curr.right.val==y) || (curr.left.val==y && curr.right.val==x)){
                        return false;
                    }
                }

                if(curr.val==x){
                    xFound=true;
                }

                 if(curr.val==y){
                    yFound=true;
                }

                if(curr.left!=null){
                    queue.add(curr.left);
                }

                if(curr.right!=null){
                    queue.add(curr.right);
                }
            
            }

            if(xFound==true && yFound==true){
                return true;
            }
           
        }

        return false;
        
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
 //Travel every node
 //At every node check it's children are equal to x and y. If yes, siblings and make result false
 //Else, check if node.val is x or y. if yes, mark it's levels
 //At recurssion, if levels are matching, return result
 //if levels are not matching, return false;
 //TC:O(n);
 //SC:O(h)
class Solution {
    int xlevel=-1;
    int ylevel=-1;
    boolean result=true;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,0);

        if(xlevel==ylevel) return result;
        return false;
        
    }
    private void helper(TreeNode root, int x, int y, int level){
        //
        if(root==null){
            return;
        }

        if(root.val==x){
            xlevel=level;
        }

        if(root.val==y){
            ylevel=level;
        }

        if(root.left!=null && root.right!=null){
            if((root.left.val==x && root.right.val==y) || 
            (root.left.val==y && root.right.val==x)){
                result=false;
            }
        }

        helper(root.left,x,y,level+1);
        helper(root.right,x,y,level+1);
    }
}

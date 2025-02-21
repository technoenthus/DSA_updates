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
class FindElements {

  TreeNode root;
    HashSet<Integer> a = new HashSet<>();
    public FindElements(TreeNode root) {
        this.root=root;
        root.val=0;
        a.add(0);
        recover(root);
    }
    
    public void recover(TreeNode root)
    {
        if(root==null)
        {
            return;
        }

        if(root.left!=null)
        {
            root.left.val=(2*root.val)+1;
            a.add(root.left.val);
            recover(root.left);
        }
        if(root.right!=null)
        {
            root.right.val=(2*root.val)+2;
            a.add(root.right.val);
            recover(root.right);
        }
    }
    public boolean find(int target) {
        if(a.contains(target))
        {
            return true;
        }

        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
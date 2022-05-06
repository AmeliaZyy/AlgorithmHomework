
class SumTree {
    int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return root;
        }
        convertBST(root.right);
        root.val += pre;
        pre = root.val;
        convertBST(root.left);
        return root;
    }
}
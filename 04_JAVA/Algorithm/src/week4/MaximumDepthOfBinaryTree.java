package week4;


import javax.swing.tree.TreeCellRenderer;

public class MaximumDepthOfBinaryTree {
    static int maxDepth=0;
    public static void main(String[] args) {
//        TreeNode root=new TreeNode(3);
//        root.left=new TreeNode(9);
//        root.right=new TreeNode(20);
//        root.right.left=new TreeNode(15);
//        root.right.right=new TreeNode(7);

        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {

        dfs(root, 1);
        return maxDepth;
    }
    public static void dfs(TreeNode root, int depth){
        if(root==null) return;
        maxDepth=Math.max(maxDepth, depth);
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
//        System.out.println("node:" +root.val+"depth: "+depth);
    }

}

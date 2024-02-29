package org.r7d.tree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static int res = 0;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low,high);
        return res;
    }

    public static void dfs (TreeNode root, int low, int high) {
        if(root==null) return ;
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);
        if(root.val>=low && root.val<=high) {
            System.out.println("Val  -- " + root.val);
            res+=root.val;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3, null, null),
                        new TreeNode(7, null, null)
                        ),
                new TreeNode(15,
                        null,
                        new TreeNode(18, null, null)
                )
        );

        System.out.println("Result -- " + rangeSumBST(treeNode, 7, 15));

    }
}
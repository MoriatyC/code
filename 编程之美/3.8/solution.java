int findLongestDistance(TreeNode root, int[] max) {
        int left;
        int right;
        if (root.left == null) {
            left = 0;
        } else {
            left = dfs(root.left, max) + 1;
        }
        if (root.right == null) {
            right = 0;
        } else {
            right = dfs(root.right, max) + 1;
        }
        max[0] = Math.max(max[0], left + right);
        return left > right ? left : right;
    }
class Solution {
    static class Node {
        Node left, right;
        int val;
        int leftSum = 0;
        int count = 0;
        public Node (int val) {
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ret;
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        Node root = new Node(nums[nums.length - 1]);
        ret = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] = insert(root, nums[i]);
        }
        return Arrays.asList(ret);
    }       
    public int insert(Node node, int num) {
        int sum = 0;//sum是这一路上比num小的数字的总和,在插入遍历的过程中，已经在树中的节点说明在原数组中出现在当前数字之后
        while (num != node.val) {
            if (num > node.val) {
                if (node.right == null) {
                    node.right = new Node(num);
                }
                sum += node.count + node.leftSum;
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new Node(num);
                }
                node.leftSum++;
                node = node.left;
            }
        }
        node.count++;
        return sum + node.leftSum;
    }
}
package LeetCode.Daily.BinaryTreeZigzagLevelOrderTraversal;


import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int lvl = 0;
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            lvl++;
            LinkedList<Integer> lvlValues = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (lvl % 2 == 0) lvlValues.addFirst(cur.val);
                else lvlValues.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            ans.add(lvlValues);
        }
        return ans;
    }

}
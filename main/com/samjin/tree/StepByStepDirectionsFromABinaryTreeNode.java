package com.samjin.tree;

public class StepByStepDirectionsFromABinaryTreeNode {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Step 1: Find paths from root to startValue and destValue
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);

        // Step 2: Remove common prefix
        int i = 0;
        while (i < pathToStart.length() && i < pathToDest.length() && pathToStart.charAt(i) == pathToDest.charAt(i)) {
            i++;
        }

        // Step 3: Compute the final path
        StringBuilder result = new StringBuilder();

        // Move up to the common ancestor
        for (int j = i; j < pathToStart.length(); j++) {
            result.append('U');
        }

        // Move down to the destination
        result.append(pathToDest.substring(i));

        return result.toString();
    }

    private boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }

        path.append('L');
        if (findPath(root.left, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(root.right, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}

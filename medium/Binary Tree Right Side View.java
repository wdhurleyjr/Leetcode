/*
Time Complexity: O(n)
Space Complexity: O(n)

This solution performs a level order traversal (Breadth-First Search) of a binary tree
and collects the rightmost node's value at each level to form the right-side view.

Algorithm:
1. Create a list to store the result.
2. Use a queue to process nodes level by level:
   - If the tree is empty (`root == null`), return the empty list.
   - Add the root node to the queue initially.
3. While the queue is not empty:
   - Determine the size of the current level.
   - Iterate through the nodes at this level:
       - Dequeue a node, add its value to a temporary level list.
       - Enqueue its left and right children if they exist.
   - After processing all nodes at this level, add the last value in the level list
     (the rightmost node) to the result list.
4. Return the list containing the rightmost values of all levels.
*/


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) {
            return list;
        }
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                level.add(current.val);
                if(current.left != null) {
                    q.offer(current.left);
                }
                if(current.right != null) {
                    q.offer(current.right);
                }
            }
            list.add(level.get(level.size()- 1));
        }
        return list;
    }
}

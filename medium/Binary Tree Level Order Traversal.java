/*
Time Complexity: O(n)
Space Complexity: O(n)

This solution performs a level order traversal (Breadth-First Search) of a binary tree,
collecting node values at each level into separate lists.

Algorithm:
1. Create a list to store the result of each level.
2. If the tree is empty, return the empty list.
3. Use a queue to process nodes level by level:
   - Add the root node to the queue initially.
4. While the queue is not empty:
   - Determine the size of the current level.
   - Create a new list to store values for the current level.
   - Iterate through the nodes at this level:
       - Dequeue a node, add its value to the current level's list.
       - Enqueue its left and right children if they exist.
   - Add the current level's list to the result.
5. Return the list containing values grouped by level.
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> innerList = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                innerList.add(node.val);
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            list.add(innerList);
        }
        return list;
    }
}

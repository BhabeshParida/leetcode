# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        
        def dfs(node, curr):
            if not node:
                return 0
            
            # Build binary number
            curr = curr * 2 + node.val
            
            # If leaf node, return the number formed
            if not node.left and not node.right:
                return curr
            
            # Otherwise return sum of left and right
            return dfs(node.left, curr) + dfs(node.right, curr)
        
        return dfs(root, 0)
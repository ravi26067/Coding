/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func bstFromPreorder(preorder []int) *TreeNode {
    var root *TreeNode
    
    for _,val:= range preorder{
        root = insert(root,val)
    }
    
    return root
}

/**
* We have root and we are iterating over the slice and inserting the value at appropriate position in BST.
*/

func insert(root *TreeNode,val int) *TreeNode{
    
    if root==nil{
        return &TreeNode{Val:val,Left:nil,Right:nil}
    }
    
    if root.Val > val{
        root.Left = insert(root.Left,val)
    }else {
        root.Right = insert(root.Right,val)
    }
    return root
}

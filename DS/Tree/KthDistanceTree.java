import java.util.*;

/**
 * Here we are maintaining one map to keep track of parent nodes. We are having one visited set to keep track of visited nodes.
 * We will be traversing the tree in BFS manner and will increase distance after every level and mark the node visited so same node
 * will not repeated again. When our dis will be equal to k we will exit the loop and add all remaining items of queue to result.
 */
class KthDistanceTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        fillMap(parentMap,root);

        queue.add(target);
        queue.add(null);
        int dist = 0;
        if(K==0){
            result.add(target.val);
            return result;
        }

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            visited.add(node);
            if(node==null){
                dist++;
                if(dist==K){
                    break;
                }
                queue.add(null);
            }
            else{
                if(node.left!=null && !visited.contains(node.left)){
                    queue.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    queue.add(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    queue.add(parentMap.get(node));
                }
            }
        }

        while (!queue.isEmpty()){
            TreeNode resNode = queue.poll();
            result.add(resNode.val);
        }

        return result;
    }

    public void fillMap(Map<TreeNode,TreeNode> parentMap, TreeNode root){
        if(root==null)
            return;
        if(root.left!=null)
            parentMap.put(root.left,root);
        if(root.right!=null)
            parentMap.put(root.right,root);

        fillMap(parentMap,root.left);
        fillMap(parentMap,root.right);

    }
}

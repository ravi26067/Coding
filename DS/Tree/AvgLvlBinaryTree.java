
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgLvlBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
			left = null;
			right= null;
		}
	}
	
	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> ans = new LinkedList<>();
		
		if(root!=null)
		{
			TreeNode curr = root;
			double levelAvg = 0;
			double cnt = 0;
			Queue<TreeNode> q1 = new LinkedList<>();
			q1.add(curr);
			q1.add(null);
			
			while(!q1.isEmpty()) {
				
				curr = q1.remove();
				
				if(curr==null) {
					
					ans.add(levelAvg/cnt);
					
					levelAvg = 0;
					cnt = 0;
					if(q1.isEmpty())
						break;
					
					q1.add(null);
					
				}
				else {
					
					if(curr.left!=null)
						q1.add(curr.left);
					if(curr.right!=null)
						q1.add(curr.right);
					levelAvg += curr.val;
					cnt++;
					
				}
				
			}
			
			
		}
		
		return ans;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<Double> ans = averageOfLevels(root);
		System.out.println(ans);
	}

}

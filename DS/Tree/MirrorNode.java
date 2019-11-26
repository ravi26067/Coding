
public class MirrorNode {
	
	
	static class Node {
        int data;
        Node left,right;
        
        public Node(int value){
            data = value;
            left = right =null;
        }
    }
	
	static int recFindMirror(Node left,Node right,int val) {
		
		if(left==null && right == null)
			return 0;
		
		if(left.data==val)
			return right.data;
		if(right.data == val)
			return left.data;
		
		int mirrorVal = recFindMirror(left.left, right.right, val);
		
		if(mirrorVal>0)
			return mirrorVal;
		
		return recFindMirror(left.right, right.left, val);
		
		
	}
	
	static int mirrorNode(Node root,int val) {
		
		if(root == null)
			return 0;
		
		if(root.data==val)
			return root.data;
		
		return recFindMirror(root.left, root.right, val);
		
		
	}
	
	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.right.left = new Node(6);
		System.out.println(mirrorNode(root1, 2));
		
	}

}

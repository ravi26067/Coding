public class TreeNodeDistance {
    
    Node root;
    
    static class Node {
        int data;
        Node left,right;
        
        public Node(int value){
            data = value;
            left = right =null;
        }
    }
    
    
    int level(Node root,int key ,int level){
        if(root==null)
            return -1;
        if(root.data==key)
            return level;
        int l = level(root.left,key,level+1);
        if(l!=-1)
            return l;
            
        return level(root.right,key,level+1);
        
    }
    
    Node LCA(Node root,int n1,int n2){
        if(root == null)
            return root;
        if(root.data == n1 || root.data == n2)
            return root;
        
        Node leftLca = LCA(root.left,n1,n2);
        Node rightLca = LCA(root.right,n1,n2);
        
        if(leftLca!=null && rightLca!=null)
            return root;
        
        if(leftLca!=null)
            return leftLca;
        else
            return rightLca;
    }
    
    Node findLca(int n1,int n2){
        return LCA(root,n1,n2);
    }
    
    int findLevel(int key){
        return level(root,key,0);
    }
    
    
    public void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    
    public void inorderTrv(){
        inorder(root);
        System.out.println();
    }
    
    int distance(int n1,int n2){
        return (findLevel(n1)+findLevel(n2)) - (2* findLevel(findLca(n1,n2).data));
    }
    
    int distanceBW(Node root,int n1,int n2) {
    	return distanceOfNode(root, n1)+ distanceOfNode(root, n2) - 2*(distanceOfNode(root, findLca(n1, n2).data));
    }
    
    static int distanceOfNode(Node root,int x) {
    	if(root==null)
    		return -1;
    	
    	int dist = -1;
    	
    	if(root.data == x ||
    			(dist= distanceOfNode(root.left, x))>=0 ||
    			(dist= distanceOfNode(root.right, x))>=0) 
    		return dist + 1;
    	
    	return dist;
    }
    
	public static void main (String[] args) {
		TreeNodeDistance tree = new TreeNodeDistance();
		tree.root = new Node(3);
		tree.root.left = new Node(6);
		tree.root.right = new Node(8);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(15);
		tree.root.left.right.left = new Node(12);
		tree.root.left.right.right = new Node(9);
		tree.root.right.right = new Node(13);
		tree.root.right.right.left = new Node(7);
		tree.inorderTrv();
		System.out.println("Level :"+tree.findLevel(9));
		Node lca = tree.findLca(12,9);
		System.out.println("LCA for given nodes:"+lca.data);
		System.out.println("Distance between two nodes: "+ tree.distance(2,7));
		System.out.println("Distance between two nodes using new method: "+ tree.distanceBW(tree.root, 2, 7));
	}
}
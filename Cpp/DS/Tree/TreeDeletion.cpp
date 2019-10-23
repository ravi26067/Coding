#include <iostream>
using namespace std;

class Node{
    
    public:
    int data;
    Node *left;
    Node *right;
    
    Node(int val){
        data = val;
        left = NULL;
        right = NULL;
    }
    
};

void deleteTree(Node * root){
    if(root == NULL)
        return;
    
    deleteTree(root->left);
    deleteTree(root->right);
    
    cout<<"Deleting the node:"<<root->data<<endl;
    free(root);
}



int main() {
	Node *root = new Node(1);
	root->left = new Node(5);
	root->left->left = new Node(8);
	root->left->right = new Node(4);
	root->right = new Node(9);
	root->right->right = new Node(7);
	deleteTree(root);
	root = NULL;
	cout<<"Tree deleted!"<<endl;
	return 0;
}
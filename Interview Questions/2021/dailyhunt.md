# Dailyhunt(Bangalore)

## Round 1 Coding

**Q.Given an array,print kth largest element with repeated items.**
``` java
package xyz;

import java.util.*;



public class Solution1 {


    static List<Integer> kLargestNumbers(int arr[],int k){
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i:arr){
            if(mp.containsKey(i)){
                mp.put(i,mp.get(i)+1);
            }else {
                mp.put(i,1);
            }
        }

        for(Map.Entry et:mp.entrySet()){
            System.out.println(et.getKey() + " : " + et.getValue());
        }


        List<Integer> res = new ArrayList<>();
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(mp.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue()==o2.getValue())
                    return o2.getKey()-o1.getKey();
                return o2.getValue()-o1.getValue();
            }
        });

        int cnt = 0;

        for(int i=0;i<k;i++){
            res.add(list.get(i).getKey());
        }

        return res;

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1,2,4,5,1,2,5,6,5,1};
        int k = 2;

        List<Integer> res = kLargestNumbers(arr,k);
        res.forEach(x->System.out.println(x));
    }
}

```
## Round 2 Coding + LLD

**Q1.LLD for social media platform.**

``` java

User{
	firstname;
	lastname;
	Address
}

Guest extends user{
	register()
}

Account extends user{
	userid;
	password;
	List<Account> followers;
	List<Account> following;
	List<Post> post;

	login();

	List<Post> getPosts(){

	}

	List<Post> getFeedInfo(){

	}
	void accept(id){

	}
	String follow(id){

	}

	boolean createPost(Post post){

	}

	boolean addLikeToPost(String postId){
		Like like = new Like();

	}

	boolean addCommentsToPost(String postId){
		Comment comment = new Comment();
		
	}

	boolean sharePost(String postId){
		Post newPost = following.getPost(postID);
		this.post.add(newPost);
	}


}

Post{
	id;
	title;
	description;
	image;
	Account postedBy;
	Date commentTime;
	List<Like> likes;
	List<Comments> comment;
	List<Share> shares;


	boolean addComment(Comment comment){
	}

	boolean hitLike(Like like){
	}

	boolean sharePost(Share share){

	}

}

Comments{
	List<Like> likes;
	Date commentTime;

	boolean hitLike(Like like){
	}
}

Likes{
	Account likedBy;
}

Share{
	Account sharedBy;
}

SocialMedia{
	UserService userservice;

	
}

```

**Q2.Write a code for LRU Cache.**

``` java
class LRUCache{

	class Node{
		int key;
		int val;
		Node prev;
		Node next;

		Node(int key,int val){
			this.key = key;
			this.val = val;
		}
	}



	Map<Integer,Node> items;
	Integer capacity;
	Node head;
	Node tail;  

	LRUCache(){
		items = new HashMap();
		head.next = tail;
		tail.prev = head;
	}

	void put(Integer i,Node val){

		if(items.size()>=capacity){

			Node node = tail.prev;

			Node prev = node.prev;
			Node next = node.next;

			prev.next = next;
			next.pev = prev;
		}

		Node node = new Node(i,val);
		if(head.next = tail){
			head.next = node;
			node.prev = head;
			node.next = tail;
			tail.prev = node;
		}else{
			Node nextNode = head.next;
			head.next = node;
			node.prev = head;
			node.next = nextNode;
			nextNode.prev = node;
		}

	}

	Integer get(Integer i){
		Node node = items.get(i);

		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.pev = prev;

		Node nextNode = head.next;
		head.next = node;
		node.prev = head;
		node.next = nextNode;
		nextNode.prev = node;

		return 
	}

}

```
**Q3.Quesitons based on java.**
* What is String pool?
* What is executor service? Difference between submit() and execute() method?
* Comparator vs Comparble?
* Memories in java?
* Garbage collector funtionality?
* Wrapper class in java?

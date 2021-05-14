# Heap
* [Introduction](#Introduction)
* [1. Complete Binary Tree](#complete-Binary-Tree)
* [2. Heap Property](#heap-property)
* [2.1 Max Heap Property:](#max-Heap-property)
* [2.2 Min Heap Property:](#min-Heap-property)
* [3. Heap Representation in Arrays](#Heap-Representation-in-Arrays)
* [4. Heap Implementation](#Heap-implementation)
* [4.1 Explanation](#explanation)
* [4.2 Complexity](#Complexity)
## What is a Heap
A brief introduction to Heaps and their uses. We will also look at Heap Property and how a Heap is represented on an array.
## Introduction #
**Heaps** are a data structure primarily used for efficiently finding the smallest or largest element in an array. Heaps are advanced data structures based on Binary Trees, which is why they are commonly known as **Binary Heaps**.

Heaps are implemented through Arrays, where each element of the array corresponds to a node in the binary tree and the value inside the node is called a “key”. Heaps can also be implemented using trees with a node class and pointers, but it’s usually easier and more space efficient to use an array.

All the nodes are ordered according to the rules listed below:

A Heap tree must be a Complete Binary Tree.
The nodes must be ordered according to the Heap Property.

### **Common Misconception** ###
There is also a common misconception that the elements of a Heap are sorted. They are not at all sorted; in fact, the only key feature of a Heap is that the largest or smallest element is always placed at the top (parent node) depending on what kind of Heap we are using.

Moreover, this Data Structure Heap has nothing to do with the dynamic memory allocations on a Heap in various languages like C/C++ and Pascal.


## Complete Binary Tree #
As discussed in the previous chapter, a Complete Binary Tree is a tree where each node has a max. of two children and nodes at all levels are completely filled (except the leaf nodes). But the nodes at the last level must be structured in such a way that the left side is never empty. This is the only condition that differentiates Complete Binary Trees from other trees.

The new elements are inserted from left to right. When you add a new node, you must make sure that the left child of that intermediate parent node is filled. If it’s not, add a node at the left and insert the new element there.

A Heap uses Complete Binary Trees to avoid holes in the array. See the figure below to see the difference between that and an Incomplete Binary Tree:


<p align=center>
  <img width=700 height=300 src="https://github.com/ravi26067/Coding/blob/master/DS/Heap/source/completeBT.png">
</p>


## Implementation #
Heaps are implemented through Arrays, where each element of the array corresponds to a node in the binary tree and the value inside the node is called a “key”. Heaps can also be implemented using trees with a node class and pointers, but it’s usually easier and more space efficient to use an array.

All the nodes are ordered according to the rules listed below:

* A Heap tree must be a Complete Binary Tree.
* The nodes must be ordered according to the Heap Property.

##  Heap property #
A heap is built, based on the Heap property, by comparing the parent node key with its child node keys. This comparison is done based on the heap property. The two heap structures that we are going to cover in this chapter are:

* Min Heap
* Max Heap

Min Heap is built on the Min Heap property, and Max Heap is implemented on the Max Heap property. Let’s see how they are different.

##  Max Heap property #
This property states that all the parent node keys must be greater than or equal to their child node keys. So the root node, in this case, will always contain the largest element present in the Heap. If Node A has a child node B, then,

<p align=center>
  key(A) >= key(B)
</p>

<p align=center>
  <img width=550 height=300 src="https://github.com/ravi26067/Coding/blob/master/DS/Heap/source/maxHeap.png">
</p>

##  Min Heap property #
In Min Heap, all the parent node keys are less than or equal to their child node keys. This goes without saying that the rule will apply to all children of the node. So the root node, in this case, will always contain the smallest element present in the Heap. If Node A has a child node B, then,

<p align=center>
  key(A)<=key(B)
</p>
  
<p align=center>
  <img width=500 height=300 src="https://github.com/ravi26067/Coding/blob/master/DS/Heap/source/minnHeap.png">
</p>

## Operations #
Following operations can be performed on a heap:

* Insertion: It has O(log(n))O(log(n)) time complexity.
* Remove min/max: It has O(1)O(1) time complexity.

In each of the following lessons, you will tackle problems involving binary heaps. Check the implementation approach used in the lesson and write your solution accordingly.

##  Heap Representation in Arrays
The lesson elaborates how to Use Arrays for the Implementation of Heaps.

Heaps can be implemented using Arrays. The contents of a heap with n nodes are stored in such a way that all the parent nodes occur in the first half of array (n/2), while the leaves are present at the last n/2 positions. So the last parent will be at the n/2th position.

The node at the kth position will have its children placed as follows:
* The Left child at 2k+1.
* The Right child at 2k+2.

See the figure below to see how nodes are mapped on the array:

<p align=center>
  <img width=700 height=600 src="https://github.com/ravi26067/Coding/blob/220911eea0b914e5bcebc61233b81b19d0615604/DS/Heap/source/HeapRepresentation.png">
</p>

In the figure above, you can see that all of the parent nodes are present in the first half of the array, with the last parent at the n/2th position (i.e. 4th index), whereas the children nodes appear on the second half. The following properties also hold:

<p align=center>
  LeftChild=2k+1
</p>
<p align=center>
  RightChild=2k+2
</p>



In the next chapter, we will take a detailed look at Max Heap and see how it is different from Min Heap.

## Heap Implementation #
Now that we have discussed the important Max Heap functions, let’s move on to implementing them in Java.

``` java
import java.util.Arrays;

class Heap {
 
	private void maxHeapify(int[] heapArray, int index, int heapSize){
		int largest = index;
		while (largest < heapSize / 2){      // check parent nodes only     
			int left = (2 * index) + 1;       //left child
			int right = (2 * index) + 2;      //right child
      
			if (left < heapSize && heapArray[left] > heapArray[index]){
				largest = left; 			
      		}
			if (right < heapSize && heapArray[right] > heapArray[largest]){
				largest = right;
			}
			if (largest != index){ // swap parent with largest child 
				int temp = heapArray[index];
				heapArray[index] = heapArray[largest];
				heapArray[largest] = temp;
				index = largest;
			}
      		else 
				break; // if heap property is satisfied 
		} //end of while
	} 
	public void buildMaxHeap(int[] heapArray, int heapSize) 
  	{
   	// swap largest child to parent node 
		for (int i = (heapSize - 1) / 2; i >= 0; i--){
			maxHeapify(heapArray, i, heapSize);
		}
	}
	
	public static void main(String[] args) {
		int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
		
		System.out.println("Before heapify: "+Arrays.toString(heapArray));		
		new Heap().buildMaxHeap(heapArray, heapArray.length);
		System.out.println("After heapify: "+Arrays.toString(heapArray));		
	}
}
```

## Explanation #
This code covers all the cases that we discussed in the previous chapter. Let’s look at each function one by one and see what’s going on:

**BuildHeap()**: It takes the array and starts from the last child node at the last level, then passes it to MaxHeapify for comparison.

**MaxHeapify()**: This function takes the node value and compares it with the key at the parent node, and swaps them if the condition below stands true.

<p align=center>
  ChildNode>=ParentNode
</p> 

The while loop makes sure that the nodes keep swapping until the Heap property is satisfied, so we basically call MaxHeapify(); at each small level to achieve Max Heap.

### If this Code had a Face #
<p align=center>
  <img width=800 height=550 src="https://github.com/ravi26067/Coding/blob/master/DS/Heap/source/output_GueqZG.gif">
</p>

## Time Complexity #
The worst-case time complexity of maxHeapify() is O(lgn)O(lgn) because we start with the rightmost leaf node in the heap, then move left and then up until we reach the root node.

In buildMaxHeap(), the heapify function is called O(n)O(n) times. Therefore, the overall time complexity of building a Heap seems to be O(n(lgn))O(n(lgn)), but this is a very loose upper bound. A more accurate and tight upper-bound for the build heap operation is O(n)O(n). Let me explain how we can calculate this.

The heapify function has different time complexity at each level of the tree i.e it will be O(1)O(1) at the leaf node and O(lg(n))O(lg(n)) at the root. So, the worst-case time complexity of heapify at each node is O(h)O(h) where hh is the height of the node in the heap. The number of nodes for any binary given tree with height h is given by {n}/{2^h + 1}.
According to these measures, the total complexity can be calculated by the following expression:

<p align=center>
  <img width=200 height=200 src="https://github.com/ravi26067/Coding/blob/master/DS/Heap/source/heap_equation.png">
</p>

When the above summation approaches \infty∞, it converges to 22. The expression thus becomes:

<p align=center>
  ⇒O(n×2)
</p> 
<p align=center>
  ⇒O(n)
</p> 

Hence, the time complexity of building a heap is O(n)O(n)

You see, just with the help of two simple functions, we have implemented a whole data structure.

And now that we have covered Max Heap, implementing a Min Heap will not be a problem. So, that’s what we are going to study in the next lesson. See you!

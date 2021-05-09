# Heap
## Introduction #
**Heaps** are a data structure primarily used for efficiently finding the smallest or largest element in an array. Heaps are advanced data structures based on Binary Trees, which is why they are commonly known as **Binary Heaps**.

## Implementation #
Heaps are implemented through Arrays, where each element of the array corresponds to a node in the binary tree and the value inside the node is called a “key”. Heaps can also be implemented using trees with a node class and pointers, but it’s usually easier and more space efficient to use an array.

All the nodes are ordered according to the rules listed below:

* A Heap tree must be a Complete Binary Tree.
* The nodes must be ordered according to the Heap Property.

## Heap property #
A heap is built, based on the Heap property, by comparing the parent node key with its child node keys. This comparison is done based on the heap property. The two heap structures that we are going to cover in this chapter are:

* Min Heap
* Max Heap

Min Heap is built on the Min Heap property, and Max Heap is implemented on the Max Heap property. Let’s see how they are different.

## Max Heap property #
This property states that all the parent node keys must be greater than or equal to their child node keys. So the root node, in this case, will always contain the largest element present in the Heap. If Node A has a child node B, then,

<p align=center>
  key(A) >= key(B)key(A)>=key(B)
</p>


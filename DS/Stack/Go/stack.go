package main

import "fmt"

// Stack struct for creating a stack data structure
type Stack struct {
	data []int
	top  int
}

// NewStack will create a new stack with a given capacity
func NewStack(capacity int) *Stack {
	return &Stack{
		data: make([]int, capacity),
		top:  -1,
	}
}

// Push will push the element to the stack
func (s *Stack) Push(element int) {
	if s.top == len(s.data)+1 {
		fmt.Println("Stack overflow")
		return
	}
	s.top++
	s.data[s.top] = element

}

// Pop will return the top element of stack
func (s *Stack) Pop() int {
	if s.isEmpty() {
		fmt.Println("Stack underflow")
		return -1
	}
	element := s.data[s.top]
	s.top--
	return element
}

func (s *Stack) isEmpty() bool {
	return s.top == -1
}

// Peek will return the top element in the stack
func (s *Stack) Peek() int {
	if s.isEmpty() {
		fmt.Println("Stack underflow")
		return -1
	}
	return s.data[s.top]
}

func (s *Stack) size() int {
	return s.top + 1
}

// PrintStack will print the stack elements
func (s *Stack) PrintStack() {
	if s.isEmpty() {
		return
	}
	fmt.Println("Stack:")
	fmt.Println("---")
	for i := s.top; i >= 0; i-- {
		fmt.Println(s.data[i])
	}
	fmt.Println("---")
}

func main() {
	s := NewStack(10)
	s.Push(4)
	s.Push(5)
	s.PrintStack()
	fmt.Println("Top", s.Peek())
	fmt.Println("Pop", s.Pop())
	fmt.Println("Top", s.Peek())
	s.PrintStack()
	s.Pop() //will pop the top element 4
	//underflow condition
	s.Pop()
}

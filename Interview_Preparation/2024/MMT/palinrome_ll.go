/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
import "fmt"

func isPalindrome(head *ListNode) bool {

    fstptr:=head
    slwptr:=head

    if head==nil{
        return false
    }

    for  fstptr!=nil && fstptr.Next!=nil && slwptr!=nil{
        slwptr = slwptr.Next
        fstptr = fstptr.Next.Next
    }

    var prev *ListNode 
    for slwptr!=nil{
        tmp:=slwptr.Next
        slwptr.Next = prev
        prev = slwptr
        slwptr = tmp
    }

    for prev!=nil{
        if head.Val!=prev.Val{
            return false
        }
        head = head.Next
        prev = prev.Next
    }

    return true
    
}

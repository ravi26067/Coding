import java.io.*;

public class LinkedListPalindrome {
    
    ListNode head;
    ListNode secondhf, fastptr, slowptr,prevptr;
    
    static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    }
    
    public void reverse(){
        ListNode curr = secondhf;
        ListNode prev = null;
        ListNode next = null;;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondhf = prev;
    }
    
    
    public boolean compare(ListNode head , ListNode secondhf){
        while(head!=null && secondhf != null){
            if(head.val != secondhf.val)
                return false;
            head = head.next;
            secondhf = secondhf.next;
        }
        if(head != null && secondhf!=null)
            return false;
        
        return true;
    }
    
    public boolean isPalindrome(ListNode head) {        
        
        if(head!=null&&head.next!=null){
            fastptr = head;
            slowptr = head;
            prevptr = null;
            while(fastptr!=null && fastptr.next!=null){
                prevptr = slowptr;
                slowptr = slowptr.next;
                fastptr = fastptr.next.next;
            }
            if(fastptr!=null){
                secondhf = slowptr.next;
                slowptr = null;
            }
            else{
                secondhf = slowptr;
                prevptr.next = null;
            }
            reverse();
        }
        return compare(head,secondhf);
        
    }
    
    public static void main(String[] args) 
	{ 
		LinkedListPalindrome llist = new LinkedListPalindrome(); 
		llist.head = new ListNode(1);
		llist.head.next = new ListNode(3);
		llist.head.next.next = new ListNode(5);
		llist.head.next.next.next = new ListNode(3);
		llist.head.next.next.next.next = new ListNode(1);
		if(llist.isPalindrome(llist.head))
		    System.out.println("Current list linked is palindrome.");
		else
		    System.out.println("Current list linked is not palindrome.");
	} 
}
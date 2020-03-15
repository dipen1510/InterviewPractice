package come.linkedlist.example;

public class ReverseList {
	
	public static Node reverse(Node head) {
		if(head == null || head.next == null)
			return head;
		
		Node prev = null;
		Node cur = head;
		Node next;
		
		while(cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		head = prev;
		
		return head;
	}

}

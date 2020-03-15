package come.linkedlist.example;

public class DeleteAlt {
	
public static Node deleteAlternate(Node head) {
		
		Node prev = head;
		Node now = head.next;
		
		
		while(prev.next != null && now.next != null) {
			prev.next = now.next;
			
			now = null;
			
			prev = prev.next;
			if(prev != null) {
				now = prev.next;
			}
		}
		
		return head;
	}

}

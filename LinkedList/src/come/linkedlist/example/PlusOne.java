package come.linkedlist.example;

public class PlusOne {
	
	public static Node plusOne(Node head) {
		Node rev = ReverseList.reverse(head);
		Node ans = rev;
		while(rev != null) {
			if(rev.val+1 <=9) {
				rev.val += 1;
				break;
			}else {
				rev.val = 0;
				if(rev.next == null) {
					rev.next = new Node(1);
					break;
				}
				rev = rev.next;
			}
		}
		
		
		return ReverseList.reverse(ans);
	}

}

package come.linkedlist.example;

public class TwoSum {
	
public static Node twoSum(Node node1, Node node2) {
		
		Node ans = new Node(0);
		int carry = 0, sum = 0;
		Node cur = ans;
		while(node1 != null || node2 != null) {
			
			sum = carry + (node1 != null ? node1.val : 0) +
				  (node2 != null ? node2.val : 0);
			
			carry = sum/10;
			
			ans.next = new Node(sum%10);
			ans = ans.next;
			
			if(node1 != null)
				node1 = node1.next;
			if(node2 != null)
				node2 = node2.next;
			
			if(carry>0) {
				ans.next = new Node(carry);
			}
				
		}
		return cur.next;
	}

}

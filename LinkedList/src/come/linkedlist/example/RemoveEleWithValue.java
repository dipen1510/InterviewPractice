package come.linkedlist.example;

public class RemoveEleWithValue {
	
	public static Node RemoveEle(Node node, int val) {
		
		
		Node ans = new Node(0);
		ans.next = node;
		Node cur = ans;
		
		while(cur.next != null) {
			System.out.println(cur.val);
			if(cur.next.val == val) {
				Node next = cur.next;
				cur.next = next.next;
			}else
				cur = cur.next;
		}
		
		return ans.next;
	}

}

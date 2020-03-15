package come.linkedlist.example;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node node1 = new Node(1);
		node1.next = new Node(2);
		node1.next.next = new Node(3);
		node1.next.next.next = new Node(4);
		node1.next.next.next.next = new Node(5);
		
		Node node2 = new Node(7);
		node2.next = new Node(9);
		node2.next.next = new Node(8);
		
		Node node3 = new Node(9);
		node3.next = new Node(9);
		node3.next.next = new Node(9);
		
		Node head = node1;
		
		//Node ans = TwoSum.twoSum(node1,node2);
		
		//Node ans = DeleteAlt.deleteAlternate(head);
		
		//Node ans = ReverseList.reverse(head);
		
		//Node ans = PlusOne.plusOne(node3);
		
		Node ans = RemoveEleWithValue.RemoveEle(node1,5);
		
		while(ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
		
		

	}
	
	
	
	
	

}

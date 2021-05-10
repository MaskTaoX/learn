public class nc78 {
    public ListNode ReverseList(ListNode head){
        if(head==null){
            return null;
        }
        ListNode pre,p,next;
        pre=null;
        p=next=head;
        while(p!=null){
            next=p.next;
            p.next=pre;
            pre=p;
            p=next;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
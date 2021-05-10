import java.util.HashSet;
import java.util.Set;

public class nc4 {
    //集合方式
    public boolean hasCycle(ListNode head) {
        //set集合不存相同元素
        Set<ListNode> set = new HashSet<ListNode>();
        while(head!=null){
            if(set.contains(head)) {
                return true;
            }else{
                set.add(head);
                head=head.next;
            }
        }
        return false;
    }
}

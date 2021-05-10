package javaTest2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路:
 * 我们使用一个来帮助我们得到前序历，需要保证节点就是我们当前历到的节点。
 * 我们首先根节点入，为节点是前中的我们用后我们从取个节点是v1,v2,v3，
 * 那么推入栈的顺序应当为v3,v2,v1，这样就保证了下一个遍历到的节点(即u的第一个子节点v1)出现在栈顶的位置。
 */

/**
 * class Solution {
 *     List<Integer> res = new ArrayList<Integer>();
 *     public List<Integer> preorder(Node root) {
 *         //递归版
 *
 *         if(root == null)
 *             return res;
 *         res.add(root.val);
 *         for(Node child:root.children)
 *         {
 *             preorder(child);
 *         }
 *
 *         return res;
 *     }
 * }
 */
public class tree03 {
    public List<Integer> preorder(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root==null){
            return output;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            output.add(node.val);
            //子节点倒叙入栈
            Collections.reverse(node.children);
            for(Node item : node.children){
                stack.add(item);
            }
        }
        return output;
    }
}
class Node{
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }
}
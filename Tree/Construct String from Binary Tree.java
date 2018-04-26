Problem: 
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.


Thought:递归
Complexy:
Time complexity : O(n). The preorder traversal is done over the n nodes of the given Binary Tree.

Space complexity : O(n). The depth of the recursion tree can go upto n in case of a skewed tree.

class Solution {
    public String tree2str(TreeNode t) {
        if(t == null){
          return "";
        } 
       StringBuilder s = new StringBuilder();
       s.append(t.val);
       if(t.left == null && t.right == null){
		 return s.toString();
       }
       if( t.right == null){
		 return s.append("(").append(tree2str(t.left)).append(")").toString();
       }
       
        return s.append("(").append(tree2str(t.left)).append(")(").append(tree2str(t.right)).append(")").toString();
    }
}


Complexity Analysis

Time complexity : O(n). n nodes are pushed and popped in a stack.

Space complexity : O(n). stackstack size can grow upto n.
public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set < TreeNode > visited = new HashSet < > ();//已经写在字符串里的节点（写了"("+node.val）,所以要补上")"
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)//先push right ，因为要先访问 left
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);//最后的结果，最外面多了一层（），所以要substring
    }
}

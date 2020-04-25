class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> record = new ArrayList<String>();
        Node root = new Node(n, n);//根节点，左右括号各剩n个
        root.str = "";
        LinkedList<Node> frontier = new LinkedList<Node>();
        Node temp;
        int len;
        frontier.add(root);//队列记录前一层的node
        while (frontier.size() != 0) {//遍历这一层所有的数
            temp = frontier.remove();
            if (temp.leftcount > 0) {//插入左节点
                temp.left = new Node(temp.leftcount - 1, temp.rightcount);
                temp.left.str = temp.str + "(";
                frontier.add(temp.left);
            }
            if (temp.rightcount > temp.leftcount) {//插入右节点
                temp.right = new Node(temp.leftcount, temp.rightcount - 1);
                temp.right.str = temp.str + ")";
                frontier.add(temp.right);
            }
        }
        //深度优先遍历
        frontier.add(root);//堆栈记录该路径上的所有节点
        while (frontier.size() != 0) {
            temp = frontier.remove(frontier.size() - 1);//删除栈顶元素
            if (temp.left != null) {
                frontier.add(temp.left);
            }
            if (temp.right != null) {
                frontier.add(temp.right);
            }
            if (temp.left == null && temp.right == null) {//根节点
                record.add(temp.str);
            }
        }
        return record;
    }
}

public class Node {
    Node left;//左子树
    Node right;//右子树
    int leftcount;//左括号剩余数
    int rightcount;//右括号剩余数
    String str;

    public Node(int l, int r) {
        this.leftcount = l;
        this.rightcount = r;
    }
}
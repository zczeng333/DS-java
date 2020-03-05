public class TreeOperation {
    private TreeNode root;  /*root of the tree*/
    private TreeNode temp;  /*temporal variable for building threaded tree*/

    public TreeOperation(int[] args) {
        /**
         * @description build up a bst based on input args
         * @param args int array
         * @return
         * @author zczeng
         * @date 2020/3/5 23:14
         */
        if (args.length > 0) {
            int size = args.length;
            TreeNode top = new TreeNode(null, null, args[0]);/*root of binary search tree*/
            TreeNode temp = top;
            for (int i = 1; i < size; i++) {
                TreeNode node = new TreeNode(null, null, args[i]);
                while (true) {  /*find the proper place to add the node*/
                    if (temp.value > node.value) {  /*add node to left branch if applicable*/
                        if (temp.left == null) {    /*check whether left branch is empty*/
                            temp.left = node;
                            break;
                        } else {
                            temp = temp.left;   /*otherwise, keep going left*/
                        }
                    } else {    /*add node to right branch if applicable*/
                        if (temp.right == null) {   /*check whether right branch is empty*/
                            temp.right = node;
                            break;
                        } else {
                            temp = temp.right;  /*otherwise, keep going right*/
                        }
                    }
                }
                temp = top;
            }
            this.root = top;
        }
    }

    public void pre_order(TreeNode p) {
        /**
         * @description Pre-order tree traversal
         * @param p root of subtree
         * @return void
         * @author zczeng
         * @date 2020/3/2 16:12
         */
        if (p == null) {
            System.out.println("Empty Tree");
        } else {
            System.out.printf("%d ", p.value);
            if (p.left != null) {
                pre_order(p.left);
            }
            if (p.right != null) {
                pre_order(p.right);
            }
        }
    }

    public void post_order(TreeNode p) {
        /**
         * @description Post-order tree traversal
         * @param p root of subtree
         * @return void
         * @author zczeng
         * @date 2020/3/2 16:13
         */
        if (p == null) {
            System.out.println("Empty Tree");
        } else {
            if (p.left != null) {
                post_order(p.left);
            }
            if (p.right != null) {
                post_order(p.right);
            }
            System.out.printf("%d ", p.value);
        }
    }

    public void in_order(TreeNode p) {
        /**
         * @description In-order tree traversal
         * @param p root of subtree
         * @return void
         * @author zczeng
         * @date 2020/3/2 16:14
         */
        if (p == null) {
            System.out.println("Empty Tree");
        } else {
            if (p.left != null) {
                in_order(p.left);
            }
            System.out.printf("%d ", p.value);
            if (p.right != null) {
                in_order(p.right);
            }
        }
    }

    public TreeNode get_root() {
        return this.root;
    }
}
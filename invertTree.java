import java.util.LinkedList;
import java.util.Queue;

class TreeNode
{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value)
    {
        this.value = value;
        left = null;
        right = null;
    }
}


class BinaryTree {
    public TreeNode invertTree(TreeNode root)
    {
        if (root == null)
        {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;


        //Recursively invert the left and right subtree
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}


public class invertTree {

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right  = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5) ;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7) ;
        
        System.out.println("Original Tree");
        printTreeFormat(root);

        tree.invertTree(root);
        System.out.println("Inverted Tree");
        printTreeFormat(root);

    }

    public static void printTree(TreeNode node)
    {
        if(node == null)
        {
            return;
        }

        System.out.print(node.value + " ");
        printTreeFormat(node.left);
        printTree(node.right);
        System.out.println( " ");
    }
    
    public static void printTreeFormat(TreeNode root)
    {

        if(root == null)
        {
            return ;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size()   ;

            for(int i=0; i< levelSize; i++)
            {
                TreeNode current = queue.poll();
                System.out.print(current.value + " ");
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }

            System.out.println(" ");
            
        }
    }
}

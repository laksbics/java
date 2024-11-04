// Find the next larger element of a given node in a binary search tree


class TreeeNode {
    int val;
    TreeeNode left;
    TreeeNode right;

    public TreeeNode(int val)
    {
        this.val= val;
    }
}

public class BSTSuccessorFinder {
    

public TreeeNode findInOrderSuccessor(TreeeNode root, TreeeNode p)
{
    TreeeNode successor = null;

    while (root != null) {
        if(p.val < root.val)
        {
            successor = root;
            root = root.left;
        }
        else{
            root = root.right;
        }
    }

    return successor;
}


public static void main(String[] args)
{
    TreeeNode root = new TreeeNode(20);
    root.left = new TreeeNode(10);
    root.right = new TreeeNode(30);
    root.left.right = new TreeeNode(15);
    root.left.right.left = new TreeeNode(11);


    BSTSuccessorFinder finder = new BSTSuccessorFinder();
    TreeeNode successor = finder.findInOrderSuccessor(root, root.left.right.left);


    if(successor != null)
    {
        System.out.println("In order successor is" + successor.val);
    }
    else{
        System.out.println("No in order successor found");
    }
}
}






/****
 * 
 * 
 * If the node has a right subtree:
            The next larger element will be the leftmost node in the right subtree of the given node. So, move to the right child and then keep going to the left until you reach a leaf.
            
   If the node does not have a right subtree:
        We need to move up the tree to find an ancestor node that is larger than the given node.
        To do this, we start from the root and use a pointer (successor) to keep track of the last node for which the given node is in its left subtree.
        If we go to the left child of a node, we set this node as the potential successor. If we go to the right, we ignore it since the in-order successor will be larger than the current node.
 * 
 * 
 */
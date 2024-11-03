// Define a Node class for the binary tree
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// BinaryTree class to calculate the level of each node
class BinaryTreee {
    Node root;

    // Method to calculate the level of each node
    void calculateTreeLevel(Node node, int level) {
        if (node == null) {
            return; // Base case: if node is null, return
        }

        // Print the level of the current node
        System.out.println("Node data: " + node.data + " at level: " + level);

        // Recursively calculate the level for left and right child nodes
        calculateTreeLevel(node.left, level + 1);
        calculateTreeLevel(node.right, level + 1);
    }

    public static void main(String[] args) {
        BinaryTreee tree = new BinaryTreee();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Levels of nodes:");
        tree.calculateTreeLevel(tree.root, 1);  // Start from level 1
    }
}


// class Node {
//     int value;
//     Node left;
//     Node right;

//     public Node(int data)
//     {
//         this.value = data;
//         this.left = null;
//         this.right = null;
//     }
// }

// class BinaryTree {
//     public Node root;

//     void calculateTreeLevel(Node node, int level)
//     {
//         if(node == null)
//         {
//             return;
//         }

//         System.out.println("Node data:" + node.value + "at level" + level);

//         calculateTreeLevel(node.left, level+1);
//         calculateTreeLevel(node.right, level+1);
//     }
// }


// public class TreeLevel {
//     public static void main(String[] args)
//     {
//         BinaryTree tree = new BinaryTree();
//         tree.root = new Node(1);
//         tree.root.left = new Node(2);
//         tree.root.right = new Node(3);
//         tree.root.left.left = new Node(4);
//         tree.root.left.right = new Node(5);
//         System.out.println("Levels of nodes:");
//         tree.calculateTreeLevel(tree.root, 1); 
//     }
// }

package TreeStringConverter;


class TreeNode{
    int value;
    TreeNode left, right;

    TreeNode(int val)
    {
        this.value = val;
    }
}


public class TreeStringConverter {
    

    public String treeToString(TreeNode root)
    {
        if(root == null)
        {
            return "";
        }

        String result = Integer.toString(root.value);
        
        if(root.left != null || root.right != null)
        {
            result += "(" + treeToString(root.left) + ")";
        }

        if(root.right != null)
        {
            result += "(" + treeToString(root.right) + ")";
        }
        
        
        return result;
    }

    public String postOrderString(TreeNode root)
    {
        String result = "";

        
        if(root.left != null || root.right != null)
        {
            result += "("+ postOrderString(root.left) +")";
        }

        if(root.right != null)
        {
            result += "(" + postOrderString(root.right) + ")";
        }

        result+= Integer.toString(root.value);

        return result;
    }


    public String inOrderString(TreeNode root)
    {
        String result = "";

        
        if(root.left != null || root.right != null)
        {
            result += "("+ postOrderString(root.left) +")";
        }

        result+= Integer.toString(root.value);

        if(root.right != null)
        {
            result += "(" + postOrderString(root.right) + ")";
        }

        return result;
    }


    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeStringConverter converter = new TreeStringConverter();
        String result = converter.treeToString(root);
        System.out.println(" Pre Order Result =" + result);
        System.out.println(" Post Order Result =" + converter.postOrderString(root));
        System.out.println(" In Order Result =" + converter.inOrderString(root));
    }
}

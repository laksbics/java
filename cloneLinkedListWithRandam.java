 

class Nodee {
    int val;
    Nodee next;
    Nodee random;

    public Nodee(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class cloneLinkedListWithRandam {
    public Nodee copyRandomList(Nodee head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create new nodes and interleave them with the original nodes
        Nodee current = head;
        while (current != null) {
            Nodee newNode = new Nodee(current.val);
            newNode.random = current.random;
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Step 2: Assign random pointers to the cloned nodes
        // current = head;
        // while (current != null) {
        //     if (current.random != null) {
        //         current.next.random = current.random.next;
        //     }
        //     current = current.next.next;
        // }

        // Step 3: Separate the cloned list from the original list
        Nodee original = head;
        Nodee copy = head.next;
        Nodee copyHead = copy;

        while (original != null) {
            original.next = original.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }

    // Helper function to print the list (for testing purposes)
    public static void printList(Nodee head) {
        Nodee current = head;
        while (current != null) {
            int randomVal = (current.random != null) ? current.random.val : -1;
            System.out.println("Node val: " + current.val + ", Random val: " + randomVal);
            current = current.next;
        }
    }

    // Example usage
    public static void main(String[] args) {
        cloneLinkedListWithRandam solution = new cloneLinkedListWithRandam();
        
        // Create a test case with nodes and random pointers
        Nodee head = new Nodee(1);
        head.next = new Nodee(2);
        head.next.next = new Nodee(3);
        head.random = head.next.next; // 1's random points to 3
        head.next.random = head;      // 2's random points to 1

        System.out.println("Original list:");
        printList(head);
        
        Nodee clonedHead = solution.copyRandomList(head);
        
        System.out.println("Cloned list:");
        printList(clonedHead);
    }
}

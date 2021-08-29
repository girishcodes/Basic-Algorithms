import java.util.LinkedList;

public class BST {

    public static class Node {
        Node left = null;
        Node right = null;
        int data;
        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            //return "{" + "left=" + left + ", right=" + right + ", data=" + data + '}';
            return "{" +"data=" + data + '}';
        }
    }
    public static void insert(int val) {
        Node newNode = new Node(val);
        if(root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        while (current != null) {
            if(current.data > val) {
                if(current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                if(current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    public static void printInorder(Node n){
        if(n != null) {
            printInorder(n.left);
            System.out.print(n.data + " ");
            printInorder(n.right);
        }
    }

    public static Node search(int num) {
        Node current = root;
        while (current != null) {
            if(current.data == num) return current;
            else if(current.data > num) current = current.left;
            else current = current.right;
        }
        return null;
    }

    public static Node min(Node node) {
        Node ancestor = node;
        Node current = node;
        while (current != null) {
            ancestor = current;
            current = current.left;
        }
        return ancestor;
    }

    public static Node max(Node node) {
        Node ancestor = node;
        Node current = node;
        while (current != null) {
            ancestor = current;
            current = current.right;
        }
        return ancestor;
    }

    public static Node successor(Node root, Node node) {
        if(root == null) return null;
        // if a node has right node it's successor will be the minimum in the right node.
        if(node.right != null) return min(node.right);
        // in a chain of left children, the successor of the leaf node is the first right parent.
        // 8->>16->12->13->14. successor of 14 is 16, the first right parent.
        // 8->5->4->3->2->1. successor of 1 is 2, the left parent above it.
        Node current = root;
        Node ancestor = null;
        while (current != null && current.data != node.data) {
            if(current.data > node.data){
                ancestor = current;
                current = current.left;
            }
            else current = current.right;
        }
        return ancestor;
    }

    public static Node predecessor(Node root, Node node) {
        if(root == null) return null;
        // if a node has left node it's predecessor will be the maximum in the right node.
        if(node.left != null) return max(node.left);
        // in a chain of right children, the predecessor of the leaf node is the right parent above it.
        // 8->>15->>18->>20->>24. The predecessor of 24 is 20
        Node current = root;
        Node ancestor = null;
        while (current != null && current.data != node.data) {
            if(current.data < node.data){
                ancestor = current;
                current = current.right;
            }
            else current = current.left;
        }
        return ancestor;
    }

    public static LinkedList<LinkedList<Integer>> bfs(Node root) {
        LinkedList<LinkedList<Integer>> results = new LinkedList<>();
        LinkedList<Node> q = new LinkedList<>();
        if(root == null) return null;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> result = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                result.add(current.data);
                if(current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            results.add(result);
        }
        return results;
    }

    private static Node root = null;
    public static void main(String[] args) {
        int nums[] = {8, 5, 15, 12,13, 14, 18, 20, 24, 6, 7, 4, 3,2, 1, 17, 16};
        for (int num: nums) {
            insert(num);
        }
        printInorder(root);
        System.out.println();
        
        LinkedList<LinkedList<Integer>> results = bfs(root);
        System.out.println(results);

        for (int num: nums) {
            Node node = search(num);
            System.out.println(node);
            Node minNode = min(node);
            Node maxNode = max(node);
            Node previousNode = predecessor(root,node);
            Node nextNode = successor(root, node);
            System.out.print(((previousNode == null)? "null" : previousNode.data) + " is predecessor of " + node.data);
            System.out.println(" and it's successor is " + ((nextNode == null)? "null" : nextNode.data));

            System.out.println("Min Node : " + minNode+ "  "+ "Max Node : " + maxNode);
        }
    }
}
